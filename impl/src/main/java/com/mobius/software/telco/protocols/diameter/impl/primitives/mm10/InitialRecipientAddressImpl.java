package com.mobius.software.telco.protocols.diameter.impl.primitives.mm10;
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
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.RecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SequenceNumber;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1105L, vendorId = KnownVendorIDs.TGPP_ID)
public class InitialRecipientAddressImpl extends DiameterGroupedAvpImpl implements InitialRecipientAddress
{
	private SequenceNumber sequenceNumber;
	
	private RecipientAddress recipientAddress;
	
	protected InitialRecipientAddressImpl() 
	{
	}
	
	public InitialRecipientAddressImpl(Long sequenceNumber,String recipientAddress)
	{
		if(sequenceNumber==null)
			throw new IllegalArgumentException("Sequence-Number is required");
		
		if(recipientAddress==null)
			throw new IllegalArgumentException("Recipient-Address is required");
		
		this.sequenceNumber = new SequenceNumberImpl(sequenceNumber, null, null);				
		
		this.recipientAddress = new RecipientAddressImpl(recipientAddress, null, null);
	}
	
	public Long getSequenceNumber()
	{
		if(sequenceNumber==null)
			return null;
		
		return sequenceNumber.getUnsigned();
	}
	
	public void setSequenceNumber(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Sequence-Number is required");
		
		this.sequenceNumber = new SequenceNumberImpl(value, null, null);						
	}
	
	public String getRecipientAddress()
	{
		if(recipientAddress==null)
			return null;
		
		return recipientAddress.getString();
	}
	
	public void setRecipientAddress(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Recipient-Address is required");
		
		this.recipientAddress = new RecipientAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(sequenceNumber==null)
			return "Sequence-Number is required";
		
		if(recipientAddress==null)
			return "Recipient-Address is required";
		
		return null;
	}
}