package com.mobius.software.telco.protocols.diameter.impl.primitives.tsp;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ApplicationPortIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.Payload;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndication;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.TriggerData;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3003L, vendorId = KnownVendorIDs.TGPP_ID)
public class TriggerDataImpl extends DiameterGroupedAvpImpl implements TriggerData
{
	private Payload payload;
	
	private PriorityIndication priorityIndication;
	
	private ApplicationPortIdentifier applicationPortIdentifier;
	
	protected TriggerDataImpl()
	{
		super();
	}
	
	public TriggerDataImpl(ByteBuf payload)
	{
		if(payload == null)
			throw new IllegalArgumentException("Payload is required");
		
		this.payload = new PayloadImpl(payload, null, null);
	}
	
	public ByteBuf getPayload()
	{
		if(payload==null)
			return null;
		
		return payload.getValue();
	}
	
	public void setPayload(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Payload is required");
		
		this.payload = new PayloadImpl(value, null, null);
	}
	
	public PriorityIndicationEnum getPriorityIndication()
	{
		if(priorityIndication==null)
			return null;
		
		return priorityIndication.getEnumerated(PriorityIndicationEnum.class);
	}
	
	public void setPriorityIndication(PriorityIndicationEnum value)
	{
		if(value==null)
			this.priorityIndication = null;
		else
			this.priorityIndication = new PriorityIndicationImpl(value, null, null);
	}
	
	public Long getApplicationPortIdentifier()
	{
		if(applicationPortIdentifier==null)
			return null;
		
		return applicationPortIdentifier.getUnsigned();
	}
	
	public void setApplicationPortIdentifier(Long value)
	{
		if(value==null)
			this.applicationPortIdentifier = null;
		else
			this.applicationPortIdentifier = new ApplicationPortIdentifierImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(payload == null)
			return "Payload is required";
		
		return null;
	}	
}