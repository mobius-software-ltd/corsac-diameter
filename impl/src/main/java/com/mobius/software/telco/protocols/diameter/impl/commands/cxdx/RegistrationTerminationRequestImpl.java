package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.RTRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RTRFlags;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 304, request = true)
public class RegistrationTerminationRequestImpl extends CxDxRequestImpl implements RegistrationTerminationRequest
{
	private AssociatedIdentities associatedIdentities;
	
	private List<PublicIdentity> publicIdentity;
	
	private DeregistrationReason deregistrationReason;
	
	private RTRFlags rtrFlags;
	
	protected RegistrationTerminationRequestImpl() 
	{
		super();
	}
	
	public RegistrationTerminationRequestImpl(String originHost,String originRealm,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, String username, DeregistrationReason deregistrationReason)
	{
		super(originHost, originRealm, destinationRealm, isRetransmit, sessionID, authSessionState);

		setUsername(username);
		setDeregistrationReason(deregistrationReason);
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

	public AssociatedIdentities getAssociatedIdentities()
	{
		return this.associatedIdentities;
	}
	 
	public void setAssociatedIdentities(AssociatedIdentities value)
	{
		this.associatedIdentities = value;
	}
	
	public List<String> getPublicIdentity()
	{
		if(publicIdentity==null || publicIdentity.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(PublicIdentity curr:publicIdentity)
			result.add(curr.getString());
		
		return result;
	}
			
	public void setPublicIdentity(List<String> value)
	{
		if(value==null || value.size()==0)
			this.publicIdentity = null;
		
		this.publicIdentity = new ArrayList<PublicIdentity>();
		for(String curr:value)
			this.publicIdentity.add(new PublicIdentityImpl(curr, null, null));
	}
					
	@Override
	public DeregistrationReason getDeregistrationReason()
	{
		return deregistrationReason;
	}
	
	@Override
	public void setDeregistrationReason(DeregistrationReason value)
	{
		if(value == null)
			throw new IllegalArgumentException("Deregistration-Reason is required");
		
		this.deregistrationReason = value;
	}
	
	public Long getRTRFlags()
	{
		if(rtrFlags==null)
			return null;
		
		return rtrFlags.getUnsigned();
	}
	
	public void setRTRFlags(Long value)
	{
		if(value == null)
			this.rtrFlags = null;
		else
			this.rtrFlags = new RTRFlagsImpl(value, null, null);		
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
		
		if(deregistrationReason == null)
			return "Deregistration-Reason is required";
		
		return super.validate();
	}
}