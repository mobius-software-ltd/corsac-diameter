package com.mobius.software.telco.protocols.diameter.impl.primitives.nta;

/*
 * Mobius Software LTD
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
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfigurationState;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfigurationStatus;
import com.mobius.software.telco.protocols.diameter.primitives.nta.ExtendedSCEFReferenceID;

public class EventConfigurationStatusImpl extends DiameterGroupedAvpImpl implements EventConfigurationStatus
{
	private EventConfigurationState eventConfigurationState;
	
	private ExtendedSCEFReferenceID extendedSCEFReferenceID;
	
	public EventConfigurationStatusImpl()
	{
		
	}
	
	public EventConfigurationStatusImpl(Long extendedSCEFReferenceID, Long eventConfigurationState) throws MissingAvpException
	{
		setEventConfigurationState(eventConfigurationState);
		
		setExtendedSCEFReferenceID(extendedSCEFReferenceID);
	}
	

	@Override
	public Long getEventConfigurationState()
	{
		if( eventConfigurationState == null)
			return null;
		
		return eventConfigurationState.getUnsigned();
	}
	 
	@Override
	public void setEventConfigurationState(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("EventConfigurationState is required", Arrays.asList(new DiameterAvp[] { new EventConfigurationStateImpl() }));
			
		this.eventConfigurationState = new EventConfigurationStateImpl(value, null, null);
	}
	
	@Override
	public Long getExtendedSCEFReferenceID()
	{
		if( extendedSCEFReferenceID == null)
			return null;
		
		return extendedSCEFReferenceID.getLong();
	}
	 
	@Override
	public void setExtendedSCEFReferenceID(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("ExtendedSCEFReferenceID is required", Arrays.asList(new DiameterAvp[] { new ExtendedSCEFReferenceIDImpl() }));
			
		this.extendedSCEFReferenceID = new ExtendedSCEFReferenceIDImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(eventConfigurationState==null)
			return new MissingAvpException("EventConfigurationState is required", Arrays.asList(new DiameterAvp[] { new EventConfigurationStateImpl() }));
		
		if(extendedSCEFReferenceID==null)
			return new MissingAvpException("ExtendedSCEFReferenceID is required", Arrays.asList(new DiameterAvp[] { new ExtendedSCEFReferenceIDImpl() }));
		
		return null;
	}


	
}