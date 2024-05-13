package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeDiscoveryRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.DiscoveryAuthRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.DiscoveryEntryIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryEntryID;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public class ProSeDiscoveryRequestImpl extends Pc6RequestImpl implements ProSeDiscoveryRequest
{
	private DiscoveryAuthRequest discoveryAuthRequest;
	
	private DiscoveryEntryID discoveryEntryID;
	
	protected ProSeDiscoveryRequestImpl() 
	{
		super();
	}
	
	public ProSeDiscoveryRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,DiscoveryAuthRequest discoveryAuthRequest) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setDiscoveryAuthRequest(discoveryAuthRequest);
	}
	
	@Override	
	public DiscoveryAuthRequest getDiscoveryAuthRequest()
	{
		return discoveryAuthRequest;
	}
	 
	@Override	
	public void setDiscoveryAuthRequest(DiscoveryAuthRequest value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Discovery-Auth-Request is required is required", Arrays.asList(new DiameterAvp[] { new DiscoveryAuthRequestImpl() }));
			
		this.discoveryAuthRequest = value;
	}
	
	@Override	
	public Long getDiscoveryEntryID()
	{
		if(discoveryEntryID == null)
			return null;
		
		return discoveryEntryID.getUnsigned();
	}
	
	@Override	
	public void setDiscoveryEntryID(Long value)
	{
		if(value == null)
			this.discoveryEntryID = null;
		else
			this.discoveryEntryID = new DiscoveryEntryIDImpl(value, null, null);
	}
		
	@DiameterValidate
	public DiameterException validate()
	{
		if(discoveryAuthRequest == null)
			return new MissingAvpException("Discovery-Auth-Request is required is required", Arrays.asList(new DiameterAvp[] { new DiscoveryAuthRequestImpl() }));
		
		return super.validate();
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(ocSupportedFeatures);
		result.add(discoveryAuthRequest);
		result.add(discoveryEntryID);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}	
}