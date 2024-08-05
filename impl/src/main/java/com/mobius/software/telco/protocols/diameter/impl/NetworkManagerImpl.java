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
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restcomm.protocols.api.Association;
import org.restcomm.protocols.api.Management;
import org.restcomm.protocols.api.Server;
import org.restcomm.protocols.sctp.SctpManagementImpl;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkListener;
import com.mobius.software.telco.protocols.diameter.NetworkManager;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class NetworkManagerImpl implements NetworkManager
{
	public static Logger logger=LogManager.getLogger(NetworkManagerImpl.class);
	
	private Management transportManagement;
	private ConcurrentHashMap<String, DiameterLink> links = new ConcurrentHashMap<String, DiameterLink>();
	private ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>>> hostsMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>>>();
	private ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>> realmsMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>>();
	
	private ConcurrentHashMap<String, NetworkListener> genericListeners = new ConcurrentHashMap<String, NetworkListener>();
	private DiameterStack stack;
	private Long idleTimeout, responseTimeout, reconnectTimeout;
	
	private AtomicInteger wheel=new AtomicInteger(0);
	
	public NetworkManagerImpl(DiameterStack stack, Integer workerThreads, Long idleTimeout, Long responseTimeout, Long reconnectTimeout) throws Exception
	{
		this.transportManagement = new SctpManagementImpl(stack.getProductName(), workerThreads, workerThreads, workerThreads);
		this.transportManagement.start();
		this.transportManagement.setConnectDelay(reconnectTimeout.intValue());
		
		this.stack = stack;
		this.idleTimeout = idleTimeout;
		this.reconnectTimeout = reconnectTimeout;
		this.responseTimeout = responseTimeout;
	}

	public void stop()
	{
		logger.warn("Stopping all links");
		if(links.size()>0)
		{
			Semaphore semaphore = new Semaphore(1 - links.size());	
			Iterator<Entry<String,DiameterLink>> iterator = links.entrySet().iterator();
			while(iterator.hasNext())
			{
				Entry<String,DiameterLink> currEntry=iterator.next();
				try
				{
					stopLink(currEntry.getKey(), new AsyncCallback()
					{
						@Override
						public void onSuccess()
						{
							semaphore.release();
						}
						
						@Override
						public void onError(DiameterException ex)
						{
							semaphore.release();
						}
					});
				}
				catch(DiameterException ex)
				{
					semaphore.release();
				}
			}
			
			try
			{
				semaphore.acquire();
			}
			catch(InterruptedException ex)
			{
				
			}
		}
		
		try
		{
			for(Association association:transportManagement.getAssociations().values())
				transportManagement.stopAssociation(association.getName());
			
			for(Server server:transportManagement.getServers())
				transportManagement.stopServer(server.getName());
			
			
			transportManagement.stop();
		}
		catch(Exception ex)
		{
			logger.warn("An error occured while stopping transport," + ex.getMessage(),ex);
		}
		
		logger.warn("Completed");
	}
	
	@Override
	public void addLink(String linkId, InetAddress remoteAddress, Integer remotePort, InetAddress localAddress, Integer localPort, Boolean isServer, Boolean isSctp, String localHost, String localRealm, String destinationHost, String destinationRealm, Boolean rejectUnmandatoryAvps) throws DiameterException
	{
		DiameterLink link = this.links.get(linkId);
		if(link!=null)
			throw new DiameterException("Link with such id already exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link = new DiameterLinkImpl(stack, transportManagement, genericListeners, linkId, remoteAddress, remotePort, localAddress, localPort, isServer, isSctp, localHost, localRealm, destinationHost, destinationRealm, rejectUnmandatoryAvps,idleTimeout, responseTimeout, reconnectTimeout);
		DiameterLink oldLink = this.links.putIfAbsent(linkId, link);
		if(oldLink!=null)
			throw new DiameterException("Link with such id already exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);	
		
		ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>> realmMap = hostsMap.get(destinationRealm);
		if(realmMap==null)
		{
			realmMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>>();
			ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>> oldMap = hostsMap.putIfAbsent(destinationRealm, realmMap);
			if(oldMap!=null)
				realmMap = oldMap;
		}
		
		ConcurrentHashMap<String, DiameterLink> hostMap = realmMap.get(destinationHost);
		if(hostMap==null)
		{
			hostMap = new ConcurrentHashMap<String, DiameterLink>();
			ConcurrentHashMap<String, DiameterLink> oldMap = realmMap.putIfAbsent(destinationHost, hostMap);
			if(oldMap!=null)
				hostMap = oldMap;
		}
		
		hostMap.put(linkId, link);
		
		hostMap = realmsMap.get(destinationRealm);
		if(hostMap==null)
		{
			hostMap = new ConcurrentHashMap<String, DiameterLink>();
			ConcurrentHashMap<String, DiameterLink> oldMap = realmsMap.putIfAbsent(destinationRealm, hostMap);
			if(oldMap!=null)
				hostMap = oldMap;
		}
		
		hostMap.put(linkId, link);
	}

	@Override
	public void removeLink(String linkId) throws DiameterException
	{
		DiameterLink link = links.remove(linkId);
		if(link != null)
		{
			hostsMap.get(link.getDestinationRealm()).get(link.getDestinationHost()).remove(linkId);		
			realmsMap.get(link.getDestinationRealm()).remove(linkId);
			link.stop(true);
		}
	}

	@Override
	public void startLink(String linkId) throws DiameterException
	{
		DiameterLink link = this.links.get(linkId);
		if(link==null)
			throw new DiameterException("Link with such id doesnt exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link.start();
	}

	@Override
	public void stopLink(String linkId, AsyncCallback callback) throws DiameterException
	{
		final DiameterLink link = this.links.get(linkId);
		if(link==null)
			throw new DiameterException("Link with such id doesnt exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link.sendDPR(DisconnectCauseEnum.REBOOTING, new AsyncCallback()
		{
			@Override
			public void onSuccess()
			{
				logger.info("The link " + linkId + " has stopped succesfully");
				try
				{
					link.stop(false);
				}
				catch(DiameterException ex)
				{
					logger.warn("An error occured while disconnecting," + ex.getMessage());
				}
				
				if(callback!=null)
					callback.onSuccess();
			}
			
			@Override
			public void onError(DiameterException ex)
			{
				logger.warn("An error occured while disconnecting," + ex.getMessage());
				
				try
				{
					link.stop(false);
				}
				catch(DiameterException ex2)
				{
					logger.warn("An error occured while disconnecting," + ex2.getMessage());
				}
				
				if(callback!=null)
					callback.onError(ex);
			}
		});
	}

	@Override
	public void sendMessage(String linkId, DiameterMessage message, AsyncCallback callback) throws DiameterException
	{
		DiameterLink link = this.links.get(linkId);
		if(link==null)
			throw new DiameterException("Link with such id doesnt exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		if(!link.isConnected())
			throw new DiameterException("Link is not connected", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link.sendMessage(message, callback);
	}

	@Override
	public void sendRequest(DiameterRequest request, AsyncCallback callback)
	{
		String destinationHost = request.getDestinationHost();
		if(request.getHopByHopIdentifier()==null)
		{
			Long hopIdentifier = stack.getNextHopByHopIdentifier();
			request.setHopByHopIdentifier(hopIdentifier);			
		}
		
		if(request.getEndToEndIdentifier()==null)
			request.setEndToEndIdentifier(request.getHopByHopIdentifier());
		
		sendMessage(request, destinationHost, request.getDestinationRealm(), callback);		
	}

	@Override
	public void sendAnswer(DiameterAnswer answer, String destinationHost, String destinationRealm, AsyncCallback callback)
	{
		ByteBuf buffer = sendMessage(answer, destinationHost, destinationRealm, callback);
		if(buffer!=null)
			stack.getRequestsStorage().answerSent(destinationHost, answer, buffer);		
	}
	
	private ByteBuf sendMessage(DiameterMessage message, String destinationHost, String destinationRealm, AsyncCallback callback)
	{
		if(destinationRealm==null)
			callback.onError(new DiameterException("Can not route message without realm defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null));
		else if(destinationHost==null)
		{
			ConcurrentHashMap<String, DiameterLink> innerMap = realmsMap.get(destinationRealm);
			if(innerMap==null || innerMap.size()==0)
				callback.onError(new DiameterException("Can not route message for realm " + destinationRealm + ", no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null));
			else
			{
				DiameterLink resultLink = null;
				try
				{
					resultLink = chooseRandomLink(message, innerMap, destinationRealm);
				}
				catch (DiameterException e) 
				{
					callback.onError(e);
					return null;
				}
				
				if(resultLink!=null)
					resultLink.sendMessage(message, callback);
				else
					callback.onError(new DiameterException("Can not route message for realm " + destinationRealm + ", no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null));
			}
		}
		else
		{
			ConcurrentHashMap<String, ConcurrentHashMap<String, DiameterLink>> realmMap = hostsMap.get(destinationRealm);
			if(realmMap==null || realmMap.size()==0)
				callback.onError(new DiameterException("Can not route message for realm " + destinationRealm + ", no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null));
			else
			{
				ConcurrentHashMap<String, DiameterLink> innerMap = realmMap.get(destinationHost);
				if(innerMap==null || innerMap.size()==0)
					callback.onError(new DiameterException("Can not route message for realm " + destinationRealm + ", host , no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null));
				else
				{
					DiameterLink resultLink = null;
					try
					{
						resultLink = chooseRandomLink(message, innerMap, destinationRealm);
					}
					catch (DiameterException e) 
					{
						callback.onError(e);
						return null;
					}
					
					if(resultLink!=null)
						return resultLink.sendMessage(message, callback);
					else
						callback.onError(new DiameterException("Can not route message for realm " + destinationRealm + ", no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null));
				}			
			}
		}
		
		return null;
	}

	@Override
	public void registerApplication(String linkId, List<VendorSpecificApplicationId> vendorApplicationIds, List<Long> authApplicationIds, List<Long> acctApplicationIds, Package providerPackageName, Package packageName) throws DiameterException
	{
		DiameterLink link = this.links.get(linkId);
		if(link==null)
			throw new DiameterException("Link with such id doesnt exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link.registerApplication(vendorApplicationIds, authApplicationIds, acctApplicationIds , providerPackageName, packageName);
	}

	@Override
	public DiameterLink getLink(String linkId)
	{
		return this.links.get(linkId);
	}

	@Override
	public void addNetworkListener(String listenerId, NetworkListener listener)
	{
		genericListeners.put(listenerId, listener);
	}

	@Override
	public void removeNetworkListener(String listenerId)
	{
		genericListeners.remove(listenerId);
	}
	
	private DiameterLink chooseRandomLink(DiameterMessage message, ConcurrentHashMap<String,DiameterLink> links, String destinationRealm) throws DiameterException
	{
		if(links.size()==0)
    		throw new DiameterException("Can not route message for realm " + destinationRealm + ", no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
    	
    	Iterator<DiameterLink> iterator=links.values().iterator();
    	int startEntry=wheel.incrementAndGet()%links.size();
    	while(startEntry>0)
    	{
    		if(iterator.hasNext())
    		{
    			iterator.next();
    			startEntry--;
    		}
    		else
    		{
    			if(links.size()==0)
            		throw new DiameterException("Can not route message for realm " + destinationRealm + ", no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
            	
            	iterator=links.values().iterator();
            	
    		}
    	}
    	
    	int retries=links.size();
    	while(retries>0)
    	{
    		if(iterator.hasNext())
    		{
    			DiameterLink currLink=iterator.next();
    			if (currLink != null && currLink.isConnected() && currLink.canSendMessage(message))
    				return currLink;
	            else
	            	retries--;	            
    		}
    		else
    		{
    			if(links.size()==0)
            		throw new DiameterException("Can not route message for realm " + destinationRealm + ", no links defined", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
            	
            	iterator=links.values().iterator();
    		}
    	}
    	
    	return null;
	}

	@Override
	public List<DiameterLink> getAllLinks()
	{
		return new ArrayList<DiameterLink>(links.values());
	}
}