package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6a.AuthenticationInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RequestedEUTRANAuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RequestedUTRANGERANAuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;

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
public class AuthenticationInformationRequestImpl extends S6aRequestImpl implements AuthenticationInformationRequest
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private RequestedEUTRANAuthenticationInfo requestedEUTRANAuthenticationInfo;
	
	private RequestedUTRANGERANAuthenticationInfo requestedUTRANGERANAuthenticationInfo;
	
	private AIRFlags airFlags;
	
	private VisitedPLMNId visitedPLMNId;
	
	protected AuthenticationInformationRequestImpl() 
	{
		super();
	}
	
	public AuthenticationInformationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,ByteBuf visitedPLMNId) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setVisitedPLMNId(visitedPLMNId);
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
	public RequestedEUTRANAuthenticationInfo getRequestedEUTRANAuthenticationInfo()
	{
		return this.requestedEUTRANAuthenticationInfo;
	}
	 
	@Override
	public void setRequestedEUTRANAuthenticationInfo(RequestedEUTRANAuthenticationInfo value)
	{
		this.requestedEUTRANAuthenticationInfo = value;
	}
	
	@Override
	public RequestedUTRANGERANAuthenticationInfo getRequestedUTRANGERANAuthenticationInfo()
	{
		return this.requestedUTRANGERANAuthenticationInfo;
	}
	 
	@Override
	public void setRequestedUTRANGERANAuthenticationInfo(RequestedUTRANGERANAuthenticationInfo value)
	{
		this.requestedUTRANGERANAuthenticationInfo = value;
	}
	
	@Override
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	 
	@Override
	public void setVisitedPLMNId(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Visited-PLMN-Id is required", Arrays.asList(new DiameterAvp[] { new VisitedPLMNIdImpl() }));
		
		this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);
	}
	
	@Override
	public AIRFlags getAIRFlags()
	{
		return airFlags;
	}
	
	@Override
	public void setAIRFlags(AIRFlags value)
	{
		if(value == null)
			this.airFlags = null;
		else
			this.airFlags = value;
	}		
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(visitedPLMNId == null)
			return new MissingAvpException("Visited-PLMN-Id is required", Arrays.asList(new DiameterAvp[] { new VisitedPLMNIdImpl() }));
		
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
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(requestedEUTRANAuthenticationInfo);
		result.add(requestedUTRANGERANAuthenticationInfo);
		result.add(visitedPLMNId);
		result.add(airFlags);
		
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