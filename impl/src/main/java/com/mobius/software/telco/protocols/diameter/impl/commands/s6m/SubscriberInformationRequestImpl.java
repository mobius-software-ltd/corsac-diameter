package com.mobius.software.telco.protocols.diameter.impl.commands.s6m;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6m.SubscriberInformationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.SCSIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.SIRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ServiceIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.SCSIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.SIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceIDEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceParameters;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777310, commandCode = 8388641, request = true)
public class SubscriberInformationRequestImpl extends S6mRequestImpl implements SubscriberInformationRequest
{
	private UserIdentifier userIdentifier;
	
	private ServiceID serviceID;
	
	private SCSIdentity scsIdentity;
	
	private ServiceParameters serviceParameters;
	
	private SIRFlags sirFlags;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	protected SubscriberInformationRequestImpl() 
	{
		super();
	}
	
	public SubscriberInformationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier,Long sirFlags)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
		
		setSIRFlags(sirFlags);
	}
	
	@Override
	public UserIdentifier getUserIdentifier()
	{
		if(userIdentifier == null)
			return null;
		
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			throw new IllegalArgumentException("User-Identifier is required");
		
		this.userIdentifier = value;
	}	
	
	@Override
	public ServiceIDEnum getServiceID()
	{
		if(serviceID == null)
			return null;
		
		return serviceID.getEnumerated(ServiceIDEnum.class);
	}
	
	@Override
	public void setServiceID(ServiceIDEnum value)
	{
		if(value == null)
			this.serviceID = null;
		else
			this.serviceID = new ServiceIDImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getSCSIdentity()
	{
		if(scsIdentity == null)
			return null;
		
		return scsIdentity.getValue();
	}
	 
	@Override
	public void setSCSIdentity(ByteBuf value)
	{
		if(value == null)
			this.scsIdentity = null;
		else
			this.scsIdentity = new SCSIdentityImpl(value, null, null);
	}
	
	@Override
	public ServiceParameters getServiceParameters()
	{
		return this.serviceParameters;
	}
	
	@Override
	public void setServiceParameters(ServiceParameters value)
	{
		this.serviceParameters = value;
	}
	
	@Override
	public Long getSIRFlags()
	{
		if(sirFlags == null)
			return null;
		
		return sirFlags.getUnsigned();
	}
	
	@Override
	public void setSIRFlags(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("SIR-Flags is required");
		
		this.sirFlags = new SIRFlagsImpl(value, null, null);
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
	
	@DiameterValidate
	public String validate()
	{
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		if(sirFlags == null)
			return "SIR-Flags is required";
		
		return super.validate();
	}		
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(userIdentifier);
		result.add(username);
		result.add(serviceID);
		result.add(scsIdentity);
		result.add(serviceParameters);
		result.add(sirFlags);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}