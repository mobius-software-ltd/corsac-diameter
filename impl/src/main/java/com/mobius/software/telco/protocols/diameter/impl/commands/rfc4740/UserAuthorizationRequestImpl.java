package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.SIPAORImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPUserAuthorizationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPVisitedNetworkIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.SIPAOR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserAuthorizationType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserAuthorizationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPVisitedNetworkId;

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
public class UserAuthorizationRequestImpl extends Rfc4740RequestImpl implements UserAuthorizationRequest
{

	private SIPAOR sipAOR;
	
	private SIPVisitedNetworkId sipVisitedNetworkId;
	
	private SIPUserAuthorizationType sipUserAuthorizationType;
	
	protected UserAuthorizationRequestImpl() 
	{
		super();
	}
	
	public UserAuthorizationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState,String sipAOR) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, authSessionState);
		
		setSIPAOR(sipAOR);
	}

	@Override
	public String getSIPAOR()
	{
		if(sipAOR == null)
			return null;
		
		return sipAOR.getString();
	}
	
	@Override
	public void setSIPAOR(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SIP-AOR is required is required", Arrays.asList(new DiameterAvp[] { new SIPAORImpl() }));
		
		this.sipAOR = new SIPAORImpl(value, null, null);
	}
	
	@Override
	public String getSIPVisitedNetworkId()
	{
		if(sipVisitedNetworkId == null)
			return null;
		
		return sipVisitedNetworkId.getString();
	}
	
	@Override
	public void setSIPVisitedNetworkId(String value)
	{
		if(value == null)
			this.sipVisitedNetworkId = null;
		else
			this.sipVisitedNetworkId = new SIPVisitedNetworkIdImpl(value, null, null);
	}
	
	@Override
	public SIPUserAuthorizationTypeEnum getSIPUserAuthorizationType()
	{
		if(sipUserAuthorizationType == null)
			return null;
		
		return sipUserAuthorizationType.getEnumerated(SIPUserAuthorizationTypeEnum.class);
	}
	
	@Override
	public void setSIPUserAuthorizationType(SIPUserAuthorizationTypeEnum value)
	{
		if(value == null)
			this.sipUserAuthorizationType = null;
		else
			this.sipUserAuthorizationType = new SIPUserAuthorizationTypeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		
		if(sipAOR == null)
			return new MissingAvpException("SIP-AOR is required is required", Arrays.asList(new DiameterAvp[] { new SIPAORImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(sipAOR);
		result.add(destinationHost);
		result.add(username);
		result.add(sipVisitedNetworkId);
		result.add(sipUserAuthorizationType);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}