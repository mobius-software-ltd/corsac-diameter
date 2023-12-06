package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4590.SIPAORImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4590.SIPAOR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;

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
@DiameterCommandImplementation(applicationId = 6, commandCode = 287, request = true)
public class RegistrationTerminationRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostBase implements RegistrationTerminationRequest
{
	private AuthSessionState authSessionState;
	
	private SIPDeregistrationReason sipDeregistrationReason;
	
	private List<SIPAOR> sipAOR;
	
	protected RegistrationTerminationRequestImpl() 
	{
		super();
	}
	
	public RegistrationTerminationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState,SIPDeregistrationReason sipDeregistrationReason)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setAuthSessionState(authSessionState);
		
		setSIPDeregistrationReason(sipDeregistrationReason);
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
	public SIPDeregistrationReason getSIPDeregistrationReason()
	{
		return sipDeregistrationReason;
	}
	
	@Override
	public void setSIPDeregistrationReason(SIPDeregistrationReason value)
	{
		if(value == null)
			throw new IllegalArgumentException("SIP-Deregistration-Reason is required");
		
		this.sipDeregistrationReason = value;
	}
	
	@Override
	public List<String> getSIPAOR()
	{
		if(sipAOR==null)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(SIPAOR curr:sipAOR)
			result.add(curr.getString());
		
		return result;
	}
	
	@Override
	public void setSIPAOR(List<String> value)
	{
		if(value==null || value.size()==0)
			this.sipAOR = null;
		else
		{
			this.sipAOR = new ArrayList<SIPAOR>();
			for(String curr:value)
				this.sipAOR.add(new SIPAORImpl(curr, null, null));			
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authSessionState == null)
			return "Auth-Session-State is required";
		
		if(sipDeregistrationReason == null)
			return "SIP-Deregistration-Reason is required";
		
		return super.validate();
	}
}