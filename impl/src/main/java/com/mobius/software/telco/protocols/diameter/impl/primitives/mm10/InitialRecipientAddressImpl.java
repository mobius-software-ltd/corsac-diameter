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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.RecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SequenceNumber;

/**
*
* @author yulian oifa
*
*/
public class InitialRecipientAddressImpl extends DiameterGroupedAvpImpl implements InitialRecipientAddress
{
	private SequenceNumber sequenceNumber;
	
	private RecipientAddress recipientAddress;
	
	public InitialRecipientAddressImpl() 
	{
	}
	
	public InitialRecipientAddressImpl(Long sequenceNumber,String recipientAddress) throws MissingAvpException
	{
		setSequenceNumber(sequenceNumber);
		
		setRecipientAddress(recipientAddress);
	}
	
	public Long getSequenceNumber()
	{
		if(sequenceNumber==null)
			return null;
		
		return sequenceNumber.getUnsigned();
	}
	
	public void setSequenceNumber(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Sequence-Number is required", Arrays.asList(new DiameterAvp[] { new SequenceNumberImpl() }));
			
		this.sequenceNumber = new SequenceNumberImpl(value, null, null);						
	}
	
	public String getRecipientAddress()
	{
		if(recipientAddress==null)
			return null;
		
		return recipientAddress.getString();
	}
	
	public void setRecipientAddress(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Recipient-Address is required", Arrays.asList(new DiameterAvp[] { new RecipientAddressImpl() }));
			
		this.recipientAddress = new RecipientAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(sequenceNumber==null)
			return new MissingAvpException("Sequence-Number is required", Arrays.asList(new DiameterAvp[] { new SequenceNumberImpl() }));
		
		if(recipientAddress==null)
			return new MissingAvpException("Recipient-Address is required", Arrays.asList(new DiameterAvp[] { new RecipientAddressImpl() }));
		
		return null;
	}
}