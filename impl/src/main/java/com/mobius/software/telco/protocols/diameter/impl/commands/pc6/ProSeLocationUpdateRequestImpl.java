package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeLocationUpdateRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LocationEstimateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetedEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocationEstimate;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetedEPUID;

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
@DiameterCommandImplementation(applicationId = 16777340, commandCode = 8388673, request = true)
public class ProSeLocationUpdateRequestImpl extends Pc6RequestImpl implements ProSeLocationUpdateRequest
{
	private TargetedEPUID targetedEPUID;
	
	private LocationEstimate locationEstimate;
	
	protected ProSeLocationUpdateRequestImpl() 
	{
		super();
	}
	
	public ProSeLocationUpdateRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,String targetedEPUID,ByteBuf locationEstimate)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setLocationEstimate(locationEstimate);
		
		setTargetedEPUID(targetedEPUID);
	}
	
	@Override	
	public String getTargetedEPUID()
	{
		if(targetedEPUID == null)
			return null;
		
		return targetedEPUID.getString();
	}
	
	@Override	
	public void setTargetedEPUID(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Targeted-EPUID is required");
		
		this.targetedEPUID = new TargetedEPUIDImpl(value, null, null);
	}
	
	@Override	
	public ByteBuf getLocationEstimate()
	{
		if(locationEstimate == null)
			return null;
		
		return locationEstimate.getValue();
	}
	 
	@Override	
	public void setLocationEstimate(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Location-Estimate is required");
		
		this.locationEstimate = new LocationEstimateImpl(value, null, null);
	}
		
	@DiameterValidate
	public String validate()
	{
		if(targetedEPUID == null)
			return "Targeted-EPUID is required";
		
		if(locationEstimate == null)
			return "Location-Estimate is required";
		
		return super.validate();
	}	
}