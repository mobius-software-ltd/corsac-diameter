package com.mobius.software.telco.protocols.diameter.impl.commands.swm;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swm.AARequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.AARFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.swm.AARFlags;

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
@DiameterCommandImplementation(applicationId = 16777264, commandCode = 265, request = true)
public class AARequestImpl extends SwmRequestImpl implements AARequest
{
	private AuthRequestType authRequestType;
	
	private OCSupportedFeatures ocSupportedFeatures;	 
	
	private AARFlags aarFlags;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	protected AARequestImpl() 
	{
		super();
	}
	
	public AARequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setAuthRequestType(authRequestType);
	}

	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");	
		
		this.authRequestType = new AuthRequestTypeImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public Long getAARFlags()
	{
		if(aarFlags==null)
			return null;
		
		return this.aarFlags.getUnsigned();
	}
	
	@Override
	public void setAARFlags(Long value) 
	{
		if(value==null)
			this.aarFlags = null;
		else
			this.aarFlags = new AARFlagsImpl(value, null, null);
	}
	
	@Override
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return this.ueLocalIPAddress.getAddress();
	}
	
	@Override
	public void setUELocalIPAddress(InetAddress value) 
	{
		if(value==null)
			this.ueLocalIPAddress = null;
		else
			this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authRequestType);
		result.add(username);
		result.add(ocSupportedFeatures);				
		result.add(aarFlags);
		result.add(ueLocalIPAddress);
		
		if(optionalAvps!=null)
        {
        	for(List<DiameterAvp> curr:optionalAvps.values())
        		result.addAll(curr);
        }
		
		return result;
	}
}