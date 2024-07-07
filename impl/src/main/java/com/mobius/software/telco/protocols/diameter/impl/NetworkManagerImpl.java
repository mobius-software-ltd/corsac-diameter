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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.restcomm.protocols.api.Management;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterLink;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkManager;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

/**
*
* @author yulian oifa
*
*/
public class NetworkManagerImpl implements NetworkManager
{
	private Management transportManagement;
	private ConcurrentHashMap<String, DiameterLink> links = new ConcurrentHashMap<String, DiameterLink>();
	private DiameterStack stack;
	
	public NetworkManagerImpl(DiameterStack stack, Management transportManagement)
	{
		this.transportManagement = transportManagement;
		this.stack = stack;
	}

	@Override
	public void addLink(String linkId, InetAddress remoteAddress, Integer remotePort, InetAddress localAddress, Integer localPort, Boolean isServer, Boolean isSctp, String localHost, String localRealm, String destinationHost, String destinationRealm, Boolean rejectUnmandatoryAvps) throws DiameterException
	{
		DiameterLink link = this.links.get(linkId);
		if(link!=null)
			throw new DiameterException("Link with such id already exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link = new DiameterLinkImpl(stack, transportManagement, linkId, remoteAddress, remotePort, localAddress, localPort, isServer, isSctp, localHost, localRealm, destinationHost, destinationRealm, rejectUnmandatoryAvps);
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
	public void stopLink(String linkId) throws DiameterException
	{
		DiameterLink link = this.links.get(linkId);
		if(link==null)
			throw new DiameterException("Link with such id doesnt exist", null, ResultCodes.DIAMETER_UNKNOWN_PEER, null);
		
		link.stop(false);
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
}