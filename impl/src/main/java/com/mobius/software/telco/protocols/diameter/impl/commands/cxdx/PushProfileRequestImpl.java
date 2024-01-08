package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.PushProfileRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AllowedWAFWWSFIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserData;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 305, request = true)
public class PushProfileRequestImpl extends CxDxRequestWithHostBase implements PushProfileRequest
{
	private UserData sipUserData;
	
	private ChargingInformation chargingInformation;
	
	private SIPAuthDataItem sipAuthDataItem;
	
	private AllowedWAFWWSFIdentities allowedWAFWWSFIdentities;
	 
	protected PushProfileRequestImpl() 
	{
		super();
	}
	
	public PushProfileRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, String username)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUsername(username);
	}
	
	@Override
	public void setUsername(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Username is required");
		
		try
		{
			super.setUsername(value);
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
	}
	
	@Override
	public UserData getUserData()
	{
		return sipUserData;
	}
	
	@Override
	public void setUserData(UserData value)
	{
		this.sipUserData = value;
	}
	
	public ChargingInformation getChargingInformation()
	{
		return this.chargingInformation;
	}
	 
	public void setChargingInformation(ChargingInformation value)
	{
		this.chargingInformation = value;
	}
	
	@Override
	public SIPAuthDataItem getSIPAuthDataItem()
	{
		return this.sipAuthDataItem;
	}
	
	@Override
	public void setSIPAuthDataItem(SIPAuthDataItem value)
	{
		this.sipAuthDataItem = value;
	}
	
	public AllowedWAFWWSFIdentities getAllowedWAFWWSFIdentities()
	{
		return this.allowedWAFWWSFIdentities;
	}
	 
	public void setAllowedWAFWWSFIdentities(AllowedWAFWWSFIdentities value)
	{
		this.allowedWAFWWSFIdentities = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		try
		{
			if(getUsername() == null)
				return "Username is required";
		}
		catch(AvpNotSupportedException ex)
		{
			
		}
		
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
		result.add(username);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
				
		result.add(sipUserData);
		result.add(chargingInformation);
		result.add(sipAuthDataItem);
		result.add(allowedWAFWWSFIdentities);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}