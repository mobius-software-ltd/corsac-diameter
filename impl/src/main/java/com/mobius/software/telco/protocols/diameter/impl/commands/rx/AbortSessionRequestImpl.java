package com.mobius.software.telco.protocols.diameter.impl.commands.rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rx.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AbortCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;

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
public class AbortSessionRequestImpl extends RxRequestImpl implements AbortSessionRequest
{
	private AbortCause abortCause;
	
	protected AbortSessionRequestImpl() 
	{
		super();
		setUsernameAllowed(false);
	}
		
	public AbortSessionRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID,AbortCauseEnum abortCause) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID);
		setUsernameAllowed(false);
		
		setAbortCause(abortCause);
	}

	@Override
	public AbortCauseEnum getAbortCause() 
	{
		if(abortCause == null)
			return null;
		
		return abortCause.getEnumerated(AbortCauseEnum.class);
	}

	@Override
	public void setAbortCause(AbortCauseEnum value) throws MissingAvpException 
	{
		if(value == null)
			throw new MissingAvpException("Abort-Cause is required", Arrays.asList(new DiameterAvp[] { new AbortCauseImpl() }));	
		
		this.abortCause = new AbortCauseImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(abortCause==null)
			return new MissingAvpException("Abort-Cause is required", Arrays.asList(new DiameterAvp[] { new AbortCauseImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authApplicationId);
		result.add(ocSupportedFeatures);
		result.add(abortCause);
		result.add(originStateId);
		
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