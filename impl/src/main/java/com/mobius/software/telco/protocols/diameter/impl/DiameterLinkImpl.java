package com.mobius.software.telco.protocols.diameter.impl;
/*
 * Mobius Software LTD
 * Copyright 2023, Mobius Software LTD and individual contributors
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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restcomm.protocols.api.Association;
import org.restcomm.protocols.api.AssociationListener;
import org.restcomm.protocols.api.AssociationType;
import org.restcomm.protocols.api.IpChannelType;
import org.restcomm.protocols.api.Management;
import org.restcomm.protocols.api.PayloadData;
import org.restcomm.protocols.api.Server;

import com.mobius.software.common.dal.timers.Task;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.PeerStateEnum;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterErrorAnswer;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.VendorSpecificAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.VendorSpecificRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerWithSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.CapabilitiesExchangeRequestmpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class DiameterLinkImpl implements DiameterLink,AssociationListener
{
	public static Logger logger=LogManager.getLogger(DiameterLinkImpl.class);
	
	public static final Integer DIAMETER_SCTP_PROTOCOL_IDENTIFIER=46;
	
	private DiameterParser parser=new DiameterParser(Arrays.asList(new Class<?>[] { DiameterErrorAnswerImpl.class , DiameterErrorAnswerWithSessionImpl.class }),Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));;
	
	private Management management;
	private Association association;
	private Server server;
	private AtomicReference<PeerStateEnum> peerState = new AtomicReference<PeerStateEnum>(PeerStateEnum.IDLE);
	
	private String localHost;
	private String localRealm;
	private String destinationHost;
	private String destinationRealm;
	private InetAddress remoteAddress;
	private InetAddress localAddress;
	
	private AtomicInteger wheel=new AtomicInteger(0);
	private Integer maxStreams = 1;
	
	private List<VendorSpecificApplicationId> applicationIds = new ArrayList<VendorSpecificApplicationId>();
	private List<Long> authApplicationIds = new ArrayList<Long>();
	private List<Long> acctApplicationIds = new ArrayList<Long>();
	
	private List<VendorSpecificApplicationId> remoteApplicationIds=null;
	private List<Long> remoteAuthApplicationIds=null;
	private List<Long> remoteAcctApplicationIds=null;
	
	private ConcurrentHashMap<Long,Package> authApplicationPackages = new ConcurrentHashMap<Long,Package>();
	private ConcurrentHashMap<Long,Package> acctApplicationPackages = new ConcurrentHashMap<Long,Package>();
	
	private DiameterStack stack;
	private Boolean rejectUnmandatoryAvps;
	
	public DiameterLinkImpl(DiameterStack stack, Management management, String linkId, InetAddress remoteAddress, Integer remotePort, InetAddress localAddress, Integer localPort, Boolean isServer, Boolean isSctp, String localHost, String localRealm, String destinationHost, String destinationRealm, Boolean rejectUnmandatoryAvps) throws DiameterException
	{
		if(remoteAddress==null)
			throw new DiameterException("The remote address can not be null", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		if(localAddress==null)
			throw new DiameterException("The local address can not be null", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		IpChannelType channelType=IpChannelType.SCTP;
		if(isSctp==null || !isSctp)
			channelType = IpChannelType.TCP;
		
		this.management = management;
		this.localHost = localHost;
		this.localRealm = localRealm;
		this.destinationHost = destinationHost;
		this.destinationRealm = destinationRealm;
		this.localAddress = localAddress;
		this.remoteAddress = remoteAddress;
		
		if(isServer!=null && isServer)
		{			
			if(localPort==null || localPort<1)
				throw new DiameterException("The local port can not be null and should be positive", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
			
			if(remotePort!=null && remotePort<1)
				throw new DiameterException("The remote port should be positive or null", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
			
			for(Server server:management.getServers())
			{
				if(server.getIpChannelType().equals(channelType) && server.getHostAddress().equals(localAddress.getHostAddress()) && localPort.equals(server.getHostport()))
				{
					this.server = server;
					break;
				}
			}
			
			if(server == null)
			{
				StringBuilder serverNameBuilder = new StringBuilder();
				serverNameBuilder.append(channelType.name()).append("://").append(localAddress.getHostAddress()).append(":").append(localPort);
				String serverName = serverNameBuilder.toString();
				try
				{
					server = management.addServer(serverName, localAddress.getHostAddress(), localPort, channelType, null);
					management.startServer(serverName);
					this.association = management.addServerAssociation(remoteAddress.getHostAddress(), remotePort, serverName, linkId, channelType);
				}
				catch(Exception ex)
				{
					throw new DiameterException("An error occured while establishing a peer", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
				}								
			}			
		}
		else
		{
			if(localPort==null || localPort<0)
				throw new DiameterException("The local port can not be null and should be zero or positive", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
			
			if(remotePort==null || remotePort<1)
				throw new DiameterException("The remote port can not be null and should be positive", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
			
			try
			{
				association = management.addAssociation(localAddress.getHostAddress(), localPort, remoteAddress.getHostAddress(), remotePort, linkId, channelType, null);
			}
			catch(Exception ex)
			{
				throw new DiameterException("An error occured while establishing a peer", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
			}
		}
		
		//registering common
		@SuppressWarnings("unused")
		Class<?> clazz = CapabilitiesExchangeRequestmpl.class;
		@SuppressWarnings("unused")
		Class<?> avpClass = AcctApplicationIdImpl.class;
		
		parser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.common"));
		
		this.stack = stack;
		this.rejectUnmandatoryAvps = rejectUnmandatoryAvps;
	}

	@Override
	public void stop(Boolean remove) throws DiameterException
	{
		try
		{
			if(isStarted())
				this.management.stopAssociation(association.getName());
			
			if(remove)
				this.management.removeAssociation(association.getName());			
		}
		catch(Exception ex)
		{
			throw new DiameterException(ex.getMessage(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
		}
	}

	@Override
	public void start() throws DiameterException
	{
		try
		{
			this.management.startAssociation(association.getName());
		}
		catch(Exception ex)
		{
			throw new DiameterException(ex.getMessage(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null);
		}
	}

	@Override
	public boolean isStarted()
	{
		return association.isStarted();
	}

	@Override
	public boolean isConnected()
	{
		return association.isConnected() && peerState.get().equals(PeerStateEnum.OPEN);
	}

	@Override
	public boolean isUp()
	{
		return association.isUp();
	}

	@Override
	public InetAddress getRemoteAddress()
	{
		return remoteAddress;
	}

	@Override
	public Integer getRemotePort()
	{
		return association.getPeerPort();
	}

	@Override
	public InetAddress getLocalAddress()
	{
		return localAddress;
	}

	@Override
	public Integer getLocalPort()
	{
		return association.getHostPort();
	}

	@Override
	public Boolean isServer()
	{
		return association.getAssociationType()!=AssociationType.CLIENT;
	}

	@Override
	public Boolean isSctp()
	{
		return association.getIpChannelType()==IpChannelType.SCTP;
	}

	@Override
	public String getLocalHost()
	{
		return localHost;
	}

	@Override
	public String getLocalRealm()
	{
		return localRealm;
	}

	@Override
	public String getDestinationHost()
	{
		return destinationHost;
	}

	@Override
	public String getDestinationRealm()
	{
		return destinationRealm;
	}

	@Override
	public void onCommunicationUp(Association association, int maxInboundStreams, int maxOutboundStreams)
	{
		this.maxStreams = maxOutboundStreams;
				
		if(!isServer())
			sendCER();
	}

	@Override
	public void onCommunicationShutdown(Association association)
	{
		logger.info("Association ," + association + " shutdown");
		peerState.set(PeerStateEnum.IDLE);
	}

	@Override
	public void onCommunicationLost(Association association)
	{
		logger.info("Association ," + association + " communication lost");
		peerState.set(PeerStateEnum.IDLE);
	}

	@Override
	public void onCommunicationRestart(Association association)
	{
		logger.info("Association ," + association + " communication restart");
		peerState.set(PeerStateEnum.IDLE);
	}

	@Override
	public void inValidStreamId(PayloadData payloadData)
	{		
		logger.info("Association ," + association + " invalid stream id");
	}

	public void sendMessage(DiameterMessage message, AsyncCallback callback)
	{
		if(!peerState.get().equals(PeerStateEnum.OPEN))
		{
			callback.onError(new DiameterException("Invalid state for peer while sending message , current state " + peerState.get(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}	
		
		DiameterCommandDefinition commandDefintion = DiameterParser.getCommandDefinition(message.getClass());
		if(commandDefintion == null)
		{
			callback.onError(new DiameterException("Command not registered in parser for class " + message.getClass().getCanonicalName(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}	
		
		if(message instanceof AccountingRequest || message instanceof AccountingAnswer)
		{
			Boolean found=false;
			if(remoteAcctApplicationIds!=null)
			{
				for(Long currApplicationId:remoteAcctApplicationIds)
				{
					if(currApplicationId.equals(commandDefintion.applicationId()))
					{
						found = true;
					}
				}				
			}
			
			if(!found)
			{
				callback.onError(new DiameterException("Application id is not supported by peer, " + commandDefintion.applicationId(), null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null));
				return;
			}
		}		
		else if(message instanceof VendorSpecificRequest || message instanceof VendorSpecificAnswer)
		{
			VendorSpecificApplicationId appId = null;
			if(message instanceof VendorSpecificRequest)
				appId = ((VendorSpecificRequest)message).getVendorSpecificApplicationId();
			else
				appId = ((VendorSpecificAnswer)message).getVendorSpecificApplicationId();
			
			Boolean found=false;
			if(remoteApplicationIds!=null && appId!=null)
			{
				for(VendorSpecificApplicationId currApplicationId:remoteApplicationIds)
				{
					if(sameVendorSpecificApplicationId(appId, currApplicationId))
					{
						found = true;
						break;
					}
				}
			}
			
			if(!found)
			{
				callback.onError(new DiameterException("Application id is not supported by peer, " + commandDefintion.applicationId(), null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null));
				return;
			}
			
			if(appId.getAcctApplicationId()!=null)
			{
				found=false;
				if(remoteAcctApplicationIds!=null)
				{
					for(Long currApplicationId:remoteAcctApplicationIds)
					{
						if(currApplicationId.equals(appId.getAcctApplicationId()))
						{
							found = true;
						}
					}				
				}
				
				if(!found)
				{
					callback.onError(new DiameterException("Application id is not supported by peer, " + commandDefintion.applicationId(), null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null));
					return;
				}
			}
			
			if(appId.getAuthApplicationId()!=null)
			{
				found=false;
				if(remoteAuthApplicationIds!=null)
				{
					for(Long currApplicationId:remoteAuthApplicationIds)
					{
						if(currApplicationId.equals(appId.getAuthApplicationId()))
						{
							found = true;
						}
					}				
				}
				
				if(!found)
				{
					callback.onError(new DiameterException("Application id is not supported by peer, " + commandDefintion.applicationId(), null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null));
					return;
				}
			}
		}
		else
		{
			Boolean found=false;
			if(remoteAuthApplicationIds!=null)
			{
				for(Long currApplicationId:remoteAuthApplicationIds)
				{
					if(currApplicationId.equals(commandDefintion.applicationId()))
					{
						found = true;
					}
				}				
			}
			
			if(!found)
			{
				callback.onError(new DiameterException("Application id is not supported by peer, " + commandDefintion.applicationId(), null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null));
				return;
			}
		}
		
		sendMessageInternally(message, callback);
	}
	
	private void sendMessageInternally(DiameterMessage message, AsyncCallback callback)
	{
		if(message.getOriginHost()==null)
		{
			try
			{
				message.setOriginHost(localHost);
			}
			catch(MissingAvpException ex)
			{
				//will not happen value is set
			}
		}
		
		if(message.getOriginRealm()==null)
		{
			try
			{
				message.setOriginRealm(localRealm);
			}
			catch(MissingAvpException ex)
			{
				//will not happen value is set
			}
		}
		
		if(message instanceof DiameterRequest)
		{
			DiameterRequest request = (DiameterRequest)message;			
			try
			{
				if(request.getDestinationHost()==null)
					request.setDestinationHost(destinationHost);
			}
			catch(DiameterException ex)
			{
				//may be not supported
			}	
			
			try
			{
				if(request.getDestinationRealm()==null)
					request.setDestinationRealm(destinationRealm);
			}
			catch(DiameterException ex)
			{
				//may be not supported
			}
		}
		
		PayloadData payloadData = null;
		try
		{
			ByteBuf buffer = parser.encode(message);
			payloadData = new PayloadData(buffer.readableBytes(), buffer, true, false, DIAMETER_SCTP_PROTOCOL_IDENTIFIER, wheel.incrementAndGet()%maxStreams);
		}		
		catch(DiameterException ex)
		{
			callback.onError(ex);
			return;
		}
		
		try
		{
			association.send(payloadData);
		}
		catch(Exception ex)
		{
			callback.onError(new DiameterException(ex.getMessage(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
		}
	}

	@Override
	public void onPayload(Association association, PayloadData payloadData)
	{		
		ByteBuf buffer = payloadData.getByteBuf();
		while(buffer.readableBytes()>0)
		{
			Integer preMessageIndex = buffer.readerIndex();
			
			try
			{
				DiameterMessage message = parser.decode(buffer, rejectUnmandatoryAvps);
				stack.getWorkerPool().getQueue().offerLast(new MessageProcessingTask(message));
			}
			catch(DiameterException ex)
			{
				logger.warn("An error occured while parsing incoming message " + ex.getMessage() + " from " + association, ex);
				if(ex.getPartialMessage()!=null && ex.getPartialMessage() instanceof DiameterRequest)
				{
					try
					{
						sendError(ex);
					}
					catch(DiameterException ex2)
					{
						logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
					}
				}
			}
			
			Integer currMessageIndex = buffer.readerIndex();
			if(currMessageIndex.equals(preMessageIndex))
			{
				//we will loop if we will continue , lets drop the packet remainings
				return;
			}
		}
	}

	public void registerApplication(List<VendorSpecificApplicationId> vendorApplicationIds, List<Long> authApplicationIds,List<Long> acctApplicationIds, Package packageName) throws DiameterException
	{
		for(VendorSpecificApplicationId vendorApplicationId:vendorApplicationIds)
		{
			addApplication(vendorApplicationId);
			if(vendorApplicationId.getAcctApplicationId()!=null)
				acctApplicationPackages.put(vendorApplicationId.getAcctApplicationId(), packageName);
			
			if(vendorApplicationId.getAuthApplicationId()!=null)
				authApplicationPackages.put(vendorApplicationId.getAuthApplicationId(), packageName);
		}
		
		for(Long applicationId:authApplicationIds)
		{
			addAuthApplication(applicationId);
			authApplicationPackages.put(applicationId, packageName);
		}
		
		for(Long applicationId:acctApplicationIds)
		{
			addAcctApplication(applicationId);
			acctApplicationPackages.put(applicationId, packageName);
		}
		
		parser.registerApplication(packageName);
	}

	private Boolean sameVendorSpecificApplicationId(VendorSpecificApplicationId oldId, VendorSpecificApplicationId applicationId)
	{
		Boolean sameInterface = true;
		if(oldId.getVendorId()==null)
		{
			if(applicationId.getVendorId()!=null)
				sameInterface = false;
		}
		else if(!oldId.getVendorId().equals(applicationId.getVendorId()))
			sameInterface = false;
		
		if(oldId.getAuthApplicationId()==null)
		{
			if(applicationId.getAuthApplicationId()!=null)
				sameInterface = false;
		}
		else if(!oldId.getAuthApplicationId().equals(applicationId.getAuthApplicationId()))
			sameInterface = false;
		
		if(oldId.getAcctApplicationId()==null)
		{
			if(applicationId.getAcctApplicationId()!=null)
				sameInterface = false;
		}
		else if(!oldId.getAcctApplicationId().equals(applicationId.getAcctApplicationId()))
			sameInterface = false;
		
		return sameInterface;
	}
	
	private void addApplication(VendorSpecificApplicationId applicationId) throws DiameterException
	{
		for(VendorSpecificApplicationId oldId:applicationIds)
		{
			Boolean sameInterface = sameVendorSpecificApplicationId(oldId, applicationId);
			if(sameInterface)
				throw new DiameterException("Application is already registred for this peer", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null);
		}
		
		if(applicationId.getAuthApplicationId()!=null)
		{
			for(Long oldId:authApplicationIds)
			{
				if(oldId.equals(applicationId.getAuthApplicationId()))
					throw new DiameterException("Application is already registred for this peer", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null);
			}
		}
		
		if(applicationId.getAcctApplicationId()!=null)
		{
			for(Long oldId:acctApplicationIds)
			{
				if(oldId.equals(applicationId.getAuthApplicationId()))
					throw new DiameterException("Application is already registred for this peer", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null);
			}
		}
		
		applicationIds.add(applicationId);
		
		if(applicationId.getAuthApplicationId()!=null)
			authApplicationIds.add(applicationId.getAuthApplicationId());
		
		if(applicationId.getAcctApplicationId()!=null)
			acctApplicationIds.add(applicationId.getAcctApplicationId());
	}

	private void addAuthApplication(Long applicationId) throws DiameterException
	{
		for(Long oldId:authApplicationIds)
		{
			if(oldId.equals(applicationId))
				throw new DiameterException("Application is already registred for this peer", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null);
		}
		
		authApplicationIds.add(applicationId);
	}

	private void addAcctApplication(Long applicationId) throws DiameterException
	{
		for(Long oldId:acctApplicationIds)
		{
			if(oldId.equals(applicationId))
				throw new DiameterException("Application is already registred for this peer", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null);
		}
		
		acctApplicationIds.add(applicationId);
	}
	
	private void sendCER()
	{
		List<InetAddress> addresses = Arrays.asList(new InetAddress[] { localAddress });
		CapabilitiesExchangeRequest cer = null;
		try
		{
			cer = new CapabilitiesExchangeRequestmpl(localHost, localRealm, false, addresses, stack.getVendorID(), stack.getProductName());
			Long hopIdentifier = stack.getNextHopByHopIdentifier();
			cer.setHopByHopIdentifier(hopIdentifier);
			cer.setEndToEndIdentifier(hopIdentifier);
			cer.setOriginStateId(stack.getOriginalStateId());
			cer.setFirmwareRevision(stack.getFirmwareRevision());
			
			List<VendorSpecificApplicationId> vaiToSend=new ArrayList<VendorSpecificApplicationId>();
			List<Long> acctToSend=new ArrayList<Long>();
			List<Long> authToSend=new ArrayList<Long>();
			List<Long> vendorsToSend=new ArrayList<Long>();
			
			for(VendorSpecificApplicationId vai:applicationIds)
			{
				if(vai.getVendorId()==null)
					vaiToSend.add(vai);
				else
				{
					Boolean found=false;
					for(Long currVendor:vendorsToSend)
						if(currVendor.equals(vai.getVendorId()))
						{
							found=true;
							break;
						}
					
					if(!found)
						vendorsToSend.add(vai.getVendorId());
					
					if(vai.getAuthApplicationId()!=null)
						authToSend.add(vai.getAuthApplicationId());
					
					if(vai.getAcctApplicationId()!=null)
						acctToSend.add(vai.getAcctApplicationId());
				}
			}
			
			for(Long acct:acctApplicationIds)
			{
				Boolean isNonVendor=true;
				for(VendorSpecificApplicationId vai:applicationIds)
					if(vai.getAcctApplicationId().equals(acct))
					{
						isNonVendor = false;
						break;
					}
				
				if(isNonVendor)
					acctToSend.add(acct);
			}
			
			for(Long auth:authApplicationIds)
			{
				Boolean isNonVendor=true;
				for(VendorSpecificApplicationId vai:applicationIds)
					if(vai.getAuthApplicationId().equals(auth))
					{
						isNonVendor = false;
						break;
					}
				
				if(isNonVendor)
					authToSend.add(auth);
			}
			
			if(vaiToSend.size()>0)
				cer.setVendorSpecificApplicationIds(vaiToSend);
			
			if(authToSend.size()>0)
				cer.setAuthApplicationIds(authToSend);
			
			if(acctToSend.size()>0)
				cer.setAcctApplicationIds(acctToSend);
			
			if(vendorsToSend.size()>0)
				cer.setSupportedVendorIds(vendorsToSend);
			
			peerState.set(PeerStateEnum.CER_SENT);
			sendMessageInternally(cer, new AsyncCallback()
			{
				@Override
				public void onSuccess()
				{									
					//waiting for CEA
				}
				
				@Override
				public void onError(DiameterException ex)
				{
					logger.warn("An error occured while sending CER to " + association + " " + ex.getMessage(),ex);
					peerState.set(PeerStateEnum.IDLE);
				}
			});
		}
		catch(Exception ex)
		{
			logger.warn("An error occured while sending CER to " + association + " " + ex.getMessage(),ex);
		}
	}
	
	private void sendError(DiameterException ex) throws MissingAvpException, AvpNotSupportedException
	{
		DiameterErrorAnswer answer;
		String sessionId = null;
		try
		{
			sessionId = ex.getPartialMessage().getSessionId();
		}
		catch(DiameterException ex2)
		{
			//may be without session
		}
		
		if(sessionId == null)
			answer = new DiameterErrorAnswerImpl(ex.getApplicationID(), ex.getCommandCode(), sessionId, sessionId, false, ex.getErrorCode());
		else
			answer = new DiameterErrorAnswerWithSessionImpl(ex.getApplicationID(), ex.getCommandCode(), sessionId, sessionId, false, ex.getErrorCode(), sessionId);
		
		answer.setErrorMessage(ex.getMessage());
		answer.setErrorReportingHost(localHost);
		answer.setEndToEndIdentifier(ex.getPartialMessage().getEndToEndIdentifier());
		answer.setHopByHopIdentifier(ex.getPartialMessage().getHopByHopIdentifier());
		
		sendMessageInternally(answer, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
				
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.warn("An error occured while sending error answer " + ex.getMessage() + " from " + association, ex);							
			}
		});
	}
	
	private class MessageProcessingTask implements Task
	{
		private DiameterMessage message;
		private Long startTime = System.currentTimeMillis();
		
		public MessageProcessingTask(DiameterMessage message)
		{
			this.message = message;
		}

		@Override
		public void execute()
		{
			if(message instanceof CapabilitiesExchangeRequest)
			{
				switch(peerState.get())
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
								for(Long localApplicationId: authApplicationIds)
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
								for(Long localApplicationId: acctApplicationIds)
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
								for(VendorSpecificApplicationId localApplicationId: applicationIds)
								{
									if(sameVendorSpecificApplicationId(localApplicationId, currApplicationId))
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
								sendError(new DiameterException("No common applications found", null, ResultCodes.DIAMETER_NO_COMMON_APPLICATION, null));
							}
							catch(DiameterException ex2)
							{
								logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
							}
						}
						else
						{
							remoteAcctApplicationIds = matchedAcctApplicationIds;
							remoteAuthApplicationIds = matchedAuthApplicationIds;
							remoteApplicationIds = matchedVendorSpecificApplicationIds;
							peerState.set(PeerStateEnum.OPEN);
						}
						break;
					case CER_SENT:
					case DPR_SENT:
					default:
						try
						{
							sendError(new DiameterException("Invalid state for peer while handling CER , current state " + peerState.get(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
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
				switch(peerState.get())
				{
					case CER_SENT:
						CapabilitiesExchangeAnswer answer = (CapabilitiesExchangeAnswer)message;
						if(answer.getIsError()!=null && answer.getIsError())
						{
							peerState.set(PeerStateEnum.IDLE);
							logger.warn("CER Failed with error " + answer.getResultCode() + " from " + association);
						}
						else
						{
							peerState.set(PeerStateEnum.OPEN);
							logger.warn("Peer is up for " + association);
							remoteAcctApplicationIds = answer.getAcctApplicationIds();
							remoteAuthApplicationIds = answer.getAuthApplicationIds();
							remoteApplicationIds = answer.getVendorSpecificApplicationIds();
						}
						break;
					case OPEN:
					case DPR_SENT:
					case IDLE:
					default:
						try
						{
							sendError(new DiameterException("Invalid state for peer while handling CEA , current state " + peerState.get(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
						}
						catch(DiameterException ex2)
						{
							logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
						}
						break;
				
				}
			}
			else if(message instanceof DeviceWatchdogRequest)
			{
				switch(peerState.get())
				{
					case OPEN:
						//TODO:send DWA + Update the timer
						break;
					case CER_SENT:
					case DPR_SENT:
					case IDLE:
					default:
						try
						{
							sendError(new DiameterException("Invalid state for peer while handling DWR , current state " + peerState.get(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
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
				switch(peerState.get())
				{
					case OPEN:
						//TODO: Update the timer
						break;
					case CER_SENT:
					case DPR_SENT:
					case IDLE:
					default:
						try
						{
							sendError(new DiameterException("Invalid state for peer while handling DWA , current state " + peerState.get(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
						}
						catch(DiameterException ex2)
						{
							logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
						}
						break;				
				}
			}
			else if(message instanceof DisconnectPeerRequest)
			{
				switch(peerState.get())
				{
					case OPEN:
						//TODO: send DPA
						break;
					case CER_SENT:
					case DPR_SENT:
					case IDLE:
					default:
						try
						{
							sendError(new DiameterException("Invalid state for peer while handling DPR , current state " + peerState.get(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
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
				switch(peerState.get())
				{
					case OPEN:
						//TODO: disconnect completely + notify listener , so will be able to stop
						break;
					case CER_SENT:
					case DPR_SENT:
					case IDLE:
					default:
						try
						{
							sendError(new DiameterException("Invalid state for peer while handling DPA , current state " + peerState.get(), null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
						}
						catch(DiameterException ex2)
						{
							logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
						}
						break;				
				}
			}
			else
			{
				DiameterCommandDefinition commandDef = DiameterParser.getCommandDefinition(message.getClass());
				if(commandDef==null)
				{
					//should not happen , just in case 
					logger.warn("Can find the command definition for " + message.getClass());
					return;
				}
				
				Package packageName;
				if((message instanceof AccountingRequest) || (message instanceof AccountingAnswer))
					packageName = acctApplicationPackages.get(commandDef.applicationId());
				else 
					packageName = authApplicationPackages.get(commandDef.applicationId());
				
				if(packageName == null)
				{
					try
					{
						sendError(new DiameterException("Application has not been found locally", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null));
					}
					catch(DiameterException ex2)
					{
						logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
					}
				}
				
				DiameterProvider<?, ?, ?, ?, ?> provider = stack.getProvider(commandDef.applicationId(), packageName);
				if(provider == null)
				{
					try
					{
						sendError(new DiameterException("Application has not been found locally", null, ResultCodes.DIAMETER_APPLICATION_UNSUPPORTED, null));
					}
					catch(DiameterException ex2)
					{
						logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
					}
				}	
				
				provider.onMessage(message, new AsyncCallback()
				{
					@Override
					public void onSuccess()
					{
						
					}
					
					@Override
					public void onError(DiameterException ex)
					{
						if(ex.getPartialMessage()==null)
							ex.setPartialMessage(message);
						
						try
						{
							sendError(ex);
						}
						catch(DiameterException ex2)
						{
							logger.warn("An error occured while sending error for incoming message " + ex2.getMessage() + " from " + association, ex2);						
						}
					}
				});
			} 			
		}

		@Override
		public long getStartTime()
		{
			return startTime;
		}
	}		
}