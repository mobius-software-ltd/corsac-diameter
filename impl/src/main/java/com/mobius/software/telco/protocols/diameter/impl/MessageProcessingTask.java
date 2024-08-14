package com.mobius.software.telco.protocols.diameter.impl;
/*
 * Mobius Software LTD
 * Copyright 2019 - 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restcomm.protocols.api.Association;

import com.mobius.software.common.dal.timers.Task;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterAnswerData;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.PeerStateEnum;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.CapabilitiesExchangeAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.CapabilitiesExchangeRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.DeviceWatchdogAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.DeviceWatchdogRequest;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.DisconnectPeerRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

/**
*
* @author yulian oifa
*
*/
public class MessageProcessingTask implements Task
{
	public static Logger logger=LogManager.getLogger(DiameterLinkImpl.class);
	
	private DiameterMessage message;
	private DiameterStack stack;
	private DiameterLink link;	
	private Association association;
	private AtomicReference<List<VendorSpecificApplicationId>> remoteApplicationIds;
	private AtomicReference<List<Long>> remoteAuthApplicationIds;
	private AtomicReference<List<Long>> remoteAcctApplicationIds;
	private AtomicLong lastActivity;
	private AtomicBoolean waitingForDWA;
	private Long startTime = System.currentTimeMillis();
	private ConcurrentHashMap<String, NetworkListener> genericListeners;
	
	private AsyncCallback dummyCallback = new AsyncCallback()
	{
		@Override
		public void onSuccess()
		{
		}
		
		@Override
		public void onError(DiameterException ex)
		{
		}
	};
	
	public MessageProcessingTask(DiameterStack stack,DiameterLink link,ConcurrentHashMap<String, NetworkListener> genericListeners,AtomicLong lastActivity,AtomicBoolean waitingForDWA,Association association,DiameterMessage message,AtomicReference<List<VendorSpecificApplicationId>> remoteApplicationIds,AtomicReference<List<Long>> remoteAuthApplicationIds,AtomicReference<List<Long>> remoteAcctApplicationIds)
	{
		this.stack = stack;
		this.message = message;		
		this.link = link;		
		this.genericListeners=genericListeners;
		this.lastActivity = lastActivity;
		this.waitingForDWA = waitingForDWA;
		this.association = association;
		this.remoteApplicationIds = remoteApplicationIds;
		this.remoteAuthApplicationIds = remoteAuthApplicationIds;
		this.remoteAcctApplicationIds = remoteAcctApplicationIds;
	}

	@Override
	public void execute()
	{
		lastActivity.set(System.currentTimeMillis());
		stack.messageReceived(message, link.getID());
		
		if(message instanceof CapabilitiesExchangeRequest)
		{
			switch(link.getPeerState())
			{
				case OPEN:
				case IDLE:
					CapabilitiesExchangeRequest request = (CapabilitiesExchangeRequest)message;
					List<Long> matchedAuthApplicationIds = new ArrayList<Long>();
					List<Long> matchedAcctApplicationIds = new ArrayList<Long>();
					List<VendorSpecificApplicationId> matchedVendorSpecificApplicationIds = new ArrayList<VendorSpecificApplicationId>();
					
					List<Long> realAuthApplicationIds = request.getAuthApplicationIds();
					List<Long> realAcctApplicationIds = request.getAuthApplicationIds();
					List<VendorSpecificApplicationId> realVendorSpecificApplicationIds = request.getVendorSpecificApplicationIds();
					
					if(realAuthApplicationIds!=null)
					{
						for(Long currApplicationId:realAuthApplicationIds)
						{
							for(Long localApplicationId: link.getAuthApplicationIds())
							{
								if(currApplicationId.equals(localApplicationId))
								{
									matchedAuthApplicationIds.add(currApplicationId);
									break;
								}
							}
						}				
					}
					
					if(realAcctApplicationIds!=null)
					{
						for(Long currApplicationId:realAcctApplicationIds)
						{
							for(Long localApplicationId: link.getAcctApplicationIds())
							{
								if(currApplicationId.equals(localApplicationId))
								{
									matchedAcctApplicationIds.add(currApplicationId);
									break;
								}
							}
						}				
					}
					
					if(realVendorSpecificApplicationIds!=null)
					{
						for(VendorSpecificApplicationId currApplicationId:realVendorSpecificApplicationIds)
						{
							for(VendorSpecificApplicationId localApplicationId: link.getVendorSpecificApplicationIds())
							{
								if(DiameterLinkImpl.sameVendorSpecificApplicationId(localApplicationId, currApplicationId))
								{
									matchedVendorSpecificApplicationIds.add(currApplicationId);
									break;
								}
							}
						}				
					}
					
					if(matchedAuthApplicationIds.size() == 0 && matchedAcctApplicationIds.size() == 0 && matchedVendorSpecificApplicationIds.size() == 0)
					{
						try
						{
							DiameterException exception = new DiameterException("No common applications found", null, ResultCodes.DIAMETER_NO_COMMON_APPLICATION, null);
							exception.setPartialMessage(request);
							link.sendError(exception);
						}
						catch(DiameterException ex2)
						{
							logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
						}
					}
					else
					{
						remoteAcctApplicationIds.set(matchedAcctApplicationIds);
						remoteAuthApplicationIds.set(matchedAuthApplicationIds);
						remoteApplicationIds.set(matchedVendorSpecificApplicationIds);
						link.setPeerState(PeerStateEnum.OPEN);
						link.sendCEA(request);
					}
					break;
				case CER_SENT:
				case DPR_SENT:
				default:
					try
					{
						DiameterException exception = new DiameterException("Invalid state for peer while handling CER , current state " + link.getPeerState(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
						exception.setPartialMessage(message);
						link.sendError(exception);
					}
					catch(DiameterException ex2)
					{
						logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
					}
					break;
			
			}
		}
		else if(message instanceof CapabilitiesExchangeAnswer)
		{
			switch(link.getPeerState())
			{
				case CER_SENT:
					CapabilitiesExchangeAnswer answer = (CapabilitiesExchangeAnswer)message;
					if(answer.getIsError()!=null && answer.getIsError())
					{
						link.setPeerState(PeerStateEnum.IDLE);
						link.resetReconnectTimer();
						logger.warn("CER Failed with error " + answer.getResultCode() + " from " + association);
					}
					else
					{
						logger.info("Peer is up for " + association);
						remoteAcctApplicationIds.set(answer.getAcctApplicationIds());
						remoteAuthApplicationIds.set(answer.getAuthApplicationIds());
						remoteApplicationIds.set(answer.getVendorSpecificApplicationIds());
						link.setPeerState(PeerStateEnum.OPEN);
						link.resetInactivityTimer();
					}
					break;
				case OPEN:
				case DPR_SENT:
				case IDLE:
				default:
					logger.warn("Invalid state for peer while handling CEA , current state " + link.getPeerState(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
					break;
			
			}
		}
		else if(message instanceof DeviceWatchdogRequest)
		{
			switch(link.getPeerState())
			{
				case OPEN:
					link.sendDWA((DeviceWatchdogRequest)message,ResultCodes.DIAMETER_SUCCESS);
					break;
				case CER_SENT:
				case DPR_SENT:
				case IDLE:
				default:
					try
					{
						DiameterException exception = new DiameterException("Invalid state for peer while handling DWR , current state " + link.getPeerState(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
						exception.setPartialMessage(message);
						link.sendError(exception);
					}
					catch(DiameterException ex2)
					{
						logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
					}
					break;
			
			}
		}
		else if(message instanceof DeviceWatchdogAnswer)
		{
			switch(link.getPeerState())
			{
				case OPEN:
					waitingForDWA.set(false);
					break;
				case CER_SENT:
				case DPR_SENT:
				case IDLE:
				default:
					logger.warn("Invalid state for peer while handling DWA , current state " + link.getPeerState());
					break;				
			}
		}
		else if(message instanceof DisconnectPeerRequest)
		{
			switch(link.getPeerState())
			{
				case OPEN:
					link.sendDPA((DisconnectPeerRequest)message, ResultCodes.DIAMETER_SUCCESS);
					link.setPeerState(PeerStateEnum.IDLE);
					link.resetReconnectTimer();
					break;
				case CER_SENT:
				case DPR_SENT:
				case IDLE:
				default:
					try
					{
						DiameterException exception = new DiameterException("Invalid state for peer while handling DPR , current state " + link.getPeerState(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
						exception.setPartialMessage(message);
						link.sendError(exception);
					}
					catch(DiameterException ex2)
					{
						logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
					}
					break;				
			}
		}
		else if(message instanceof DisconnectPeerAnswer)
		{
			switch(link.getPeerState())
			{
				case DPR_SENT:
					link.disconnectOperationCompleted();
					break;
				case OPEN:
				case CER_SENT:
				case IDLE:
				default:
					logger.warn("Invalid state for peer while handling DPA , current state " + link.getPeerState());
					break;				
			}
		}
		else
		{
			if(stack.isSessionLess()==null || !stack.isSessionLess())
			{
				DiameterCommandDefinition commandDef = DiameterParser.getCommandDefinition(message.getClass());
				if(commandDef==null)
					//should not happen , just in case 
					logger.warn("Can find the command definition for " + message.getClass());
				else
				{
					Package packageName;
					if((message instanceof AccountingRequest) || (message instanceof AccountingAnswer))
						packageName = link.getPackage(commandDef.applicationId(), false);
					else 
						packageName = link.getPackage(commandDef.applicationId(), true);
					
					if(packageName == null)
					{
						try
						{
							DiameterException exception  = new DiameterException("Application has not been found locally", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null);
							exception.setPartialMessage(message);
							link.sendError(exception);
						}
						catch(DiameterException ex2)
						{
							logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
						}
					}
					
					if(message instanceof DiameterRequest)
					{
						DiameterRequest request = (DiameterRequest)message;
						DiameterAnswerData answerData = stack.getRequestsStorage().incomingMessageReceived(request);
						if(answerData!=null)
						{
							if(answerData.getBuffer()!=null)
							{
								link.sendEncodedMessage(answerData.getBuffer(), new AsyncCallback()
								{
									@Override
									public void onSuccess()
									{									
									}
									
									@Override
									public void onError(DiameterException ex)
									{
										logger.warn("An error occured while sending repeated answer," + ex.getMessage(),ex);
									}
								});
							}
							return;
						}
					}
					
					DiameterProvider<?, ?, ?, ?, ?> provider = stack.getProvider(commandDef.applicationId(), packageName);
					if(provider == null)
					{
						try
						{
							DiameterException exception = new DiameterException("Application has not been found locally", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null);
							exception.setPartialMessage(message);
							link.sendError(exception);
						}
						catch(DiameterException ex2)
						{
							logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
						}								
					}	
					
					if(provider!=null)
					{
						provider.onMessage(message, link.getID(), new AsyncCallback()
						{
							@Override
							public void onSuccess()
							{
								
							}
							
							@Override
							public void onError(DiameterException ex)
							{
								logger.warn("An error occured while delivering incoming message " + ex.getMessage() + " from " + association, ex);
								
								if(ex.getPartialMessage()==null)
									ex.setPartialMessage(message);
								
								try
								{
									link.sendError(ex);
								}
								catch(DiameterException ex2)
								{
									logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
								}
							}
						});
					}
				}
			}
		}
		
		try
		{
			Iterator<Entry<String,NetworkListener>> iterator = genericListeners.entrySet().iterator();
			while(iterator.hasNext())
			{
				Entry<String,NetworkListener> currEntry = iterator.next();
				currEntry.getValue().onMessage(message, link.getID(), dummyCallback);
			}
		}
		catch(Exception ex)
		{
			logger.warn("An error occured while delivering incoming message " + ex.getMessage() + " from " + association, ex);
		}
	}

	@Override
	public long getStartTime()
	{
		return startTime;
	}
}	