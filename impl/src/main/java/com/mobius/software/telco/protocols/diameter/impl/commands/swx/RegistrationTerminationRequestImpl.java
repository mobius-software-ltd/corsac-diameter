package com.mobius.software.telco.protocols.diameter.impl.commands.swx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swx.RegistrationTerminationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.DeregistrationReasonImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;

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
public class RegistrationTerminationRequestImpl extends SwxRequestImpl implements RegistrationTerminationRequest
{
	private DeregistrationReason deregistrationReason;
	
	protected RegistrationTerminationRequestImpl() 
	{
		super();
	}
	
	public RegistrationTerminationRequestImpl(String originHost,String originRealm, String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, String username, DeregistrationReason deregistrationReason) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);

		setUsername(username);
		
		setDeregistrationReason(deregistrationReason);
	}
	
	@Override
	public void setUsername(String value) throws MissingAvpException, AvpNotSupportedException
	{
		if(value==null)
			throw new MissingAvpException("Username is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		super.setUsername(value);		
	}
					
	@Override
	public DeregistrationReason getDeregistrationReason()
	{
		return deregistrationReason;
	}
	
	@Override
	public void setDeregistrationReason(DeregistrationReason value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Deregistration-Reason is required is required", Arrays.asList(new DiameterAvp[] { new DeregistrationReasonImpl() }));
		
		this.deregistrationReason = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(username == null)
			return new MissingAvpException("Username is required is required", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));
		
		if(deregistrationReason == null)
			return new MissingAvpException("Deregistration-Reason is required is required", Arrays.asList(new DiameterAvp[] { new DeregistrationReasonImpl() }));
		
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
		result.add(deregistrationReason);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}				
		
		return result;
	}
}