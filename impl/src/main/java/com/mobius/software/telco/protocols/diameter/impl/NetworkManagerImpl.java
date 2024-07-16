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
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

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
	private ConcurrentHashMap<String, NetworkListener> genericListeners = new ConcurrentHashMap<String, NetworkListener>();
	private DiameterStack stack;
	private Long idleTimeout, responseTimeout, reconnectTimeout;
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
	}

	@Override
	public void removeLink(String linkId) throws DiameterException
	{
		DiameterLink link = links.remove(linkId);
		if(link != null)
			link.stop(true);
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
		// TODO Auto-generated method stub		
	}

	@Override
	public void sendAnswer(DiameterAnswer message, String destinationHost, String destinationRealm, AsyncCallback callback)
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void registerApplication(String linkId, List<VendorSpecificApplicationId> vendorApplicationIds, List<Long> authApplicationIds, List<Long> acctApplicationIds, Package packageName) throws DiameterException
	{
		DiameterLink link = this.links.get(linkId);
		if(link==null)
			throw new DiameterException("Link with such id doesnt exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link.registerApplication(vendorApplicationIds, authApplicationIds, acctApplicationIds , packageName);
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
}