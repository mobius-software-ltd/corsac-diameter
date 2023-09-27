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
import com.mobius.software.telco.protocols.diameter.primitives.mm10.RecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ResultRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.RouteingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SequenceNumber;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1106L, vendorId = KnownVendorIDs.TGPP_ID)
public class ResultRecipientAddressImpl extends DiameterGroupedAvpImpl implements ResultRecipientAddress
{
	private SequenceNumber sequenceNumber;
	
	private RecipientAddress recipientAddress;
	
	private RouteingAddress routeingAddress;
	
	private SenderAddress senderAddress;
	
	protected ResultRecipientAddressImpl() 
	{
	}
	
	public ResultRecipientAddressImpl(Long sequenceNumber,String recipientAddress)
	{
		if(sequenceNumber==null)
			throw new IllegalArgumentException("Sequence-Number is required");
		
		this.sequenceNumber = new SequenceNumberImpl(sequenceNumber, null, null);		
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
			this.recipientAddress = null;
		else
			this.recipientAddress = new RecipientAddressImpl(value, null, null);			
	}
	
	public String getRouteingAddress()
	{
		if(routeingAddress==null)
			return null;
		
		return routeingAddress.getString();
	}
	
	public void setRouteingAddress(String value)
	{
		if(value==null)
			this.routeingAddress = null;
		else
			this.routeingAddress = new RouteingAddressImpl(value, null, null);			
	}
	
	public String getSenderAddress()
	{
		if(senderAddress==null)
			return null;
		
		return senderAddress.getString();
	}
	
	public void setSenderAddress(String value)
	{
		if(value==null)
			this.senderAddress = null;
		else
			this.senderAddress = new SenderAddressImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(sequenceNumber==null)
			return "Sequence-Number is required";
		
		return null;
	}
}