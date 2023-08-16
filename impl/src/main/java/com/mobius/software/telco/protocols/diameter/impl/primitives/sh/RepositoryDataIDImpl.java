package com.mobius.software.telco.protocols.diameter.impl.primitives.sh;
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
import com.mobius.software.telco.protocols.diameter.primitives.sh.RepositoryDataID;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ServiceIndication;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 715L, vendorId = KnownVendorIDs.TGPP_ID)
public class RepositoryDataIDImpl extends DiameterGroupedAvpImpl implements RepositoryDataID
{
	private ServiceIndication serviceIndication;
	
	private SequenceNumber sequenceNumber;
	
	protected RepositoryDataIDImpl() 
	{
		super();
	}
	
	public RepositoryDataIDImpl(ByteBuf serviceIndication, Long sequenceNumber)
	{
		if(serviceIndication == null)
			throw new IllegalArgumentException("Service-Indication is required");
		
		if(sequenceNumber == null)
			throw new IllegalArgumentException("Sequence-Number is required");
		
		this.serviceIndication = new ServiceIndicationImpl(serviceIndication, null, null);
		
		this.sequenceNumber = new SequenceNumberImpl(sequenceNumber, null, null);
	}
	
	public ByteBuf getServiceIndication()
	{
		if(serviceIndication==null)
			return null;
		
		return serviceIndication.getValue();
	}
	
	public void setServiceIndication(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Service-Indication is required");
		
		this.serviceIndication = new ServiceIndicationImpl(value, null, null);		
	}
	
	public Long getSequenceNumber()
	{
		if(sequenceNumber==null)
			return null;
		
		return sequenceNumber.getUnsigned();
	}
	
	public void setSequenceNumber(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Sequence-Number is required");
		
		this.sequenceNumber = new SequenceNumberImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(serviceIndication == null)
			return "Service-Indication is required";
		
		if(sequenceNumber == null)
			return "Sequence-Number is required";
		
		return null;
	}
}