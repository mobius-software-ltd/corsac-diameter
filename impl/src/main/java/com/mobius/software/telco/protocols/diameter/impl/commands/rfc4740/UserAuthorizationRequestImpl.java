package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.SIPAORImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPUserAuthorizationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPVisitedNetworkIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
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
@DiameterCommandImplementation(applicationId = 6, commandCode = 283, request = true)
public class UserAuthorizationRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostBase implements UserAuthorizationRequest
{
	private AuthSessionState authSessionState;
	
	private SIPAOR sipAOR;
	
	private SIPVisitedNetworkId sipVisitedNetworkId;
	
	private SIPUserAuthorizationType sipUserAuthorizationType;
	
	protected UserAuthorizationRequestImpl() 
	{
		super();
	}
	
	public UserAuthorizationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState,String sipAOR)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setAuthSessionState(authSessionState);
		
		setSIPAOR(sipAOR);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState == null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Auth-Session-State is required");
		
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	@Override
	public String getSIPAOR()
	{
		if(sipAOR == null)
			return null;
		
		return sipAOR.getString();
	}
	
	@Override
	public void setSIPAOR(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("SIP-AOR is required");
		
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
	public String validate()
	{
		if(authSessionState == null)
			return "Auth-Session-State is required";
		
		if(sipAOR == null)
			return "SIP-AOR is required";
		
		return super.validate();
	}
}