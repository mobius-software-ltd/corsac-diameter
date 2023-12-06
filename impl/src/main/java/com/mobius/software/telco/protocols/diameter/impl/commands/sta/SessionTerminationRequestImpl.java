package com.mobius.software.telco.protocols.diameter.impl.commands.sta;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sta.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

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
@DiameterCommandImplementation(applicationId = 16777250, commandCode = 275, request = true)
public class SessionTerminationRequestImpl extends StaRequestImpl implements SessionTerminationRequest
{
	private TerminationCause terminationCause;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	protected SessionTerminationRequestImpl() 
	{
		super();
	}
		
	public SessionTerminationRequestImpl(String originHost,String originRealm, String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, TerminationCauseEnum terminationCause)
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setTerminationCause(terminationCause);
	}
	
	@Override
	public TerminationCauseEnum getTerminationCause()
	{
		if(terminationCause==null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}
	
	@Override
	public void setTerminationCause(TerminationCauseEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("Termination-Cause is required");	
		
		this.terminationCause = new TerminationCauseImpl(value, null, null);
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
		if(terminationCause==null)
			return "Termination-Cause is required";
		
		return super.validate();
	}
}