package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DestinationInterface;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientReceivedAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RecipientSCCPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMProtocolId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class RecipientInfoImpl extends DiameterAvpImpl implements RecipientInfo
{
	private DestinationInterface destinationInterface;
	private List<RecipientAddress> recipientAddress;
	private List<RecipientReceivedAddress> recipientReceivedAddress;
	private RecipientSCCPAddress recipientSCCPAddress;
	private SMProtocolId smProtocolID;
			   		
	public RecipientInfoImpl()
	{
	
	}
	
	public DestinationInterface getDestinationInterface()
	{
		return this.destinationInterface;
	}
	
	public void setDestinationInterface(DestinationInterface value)
	{
		this.destinationInterface = value;
	}
	
	public List<RecipientAddress> getRecipientAddress()
	{
		return this.recipientAddress;
	}
	
	public void setRecipientAddress(List<RecipientAddress> value)
	{
		this.recipientAddress = value;
	}
	
	public List<RecipientReceivedAddress> getRecipientReceivedAddress()
	{
		return this.recipientReceivedAddress;
	}
	
	public void setRecipientReceivedAddress(List<RecipientReceivedAddress> value)
	{
		this.recipientReceivedAddress = value;
	}
	
	public String getRecipientSCCPAddress()
	{
		if(recipientSCCPAddress==null)
			return null;
		
		return recipientSCCPAddress.getE164();
	}
	
	public void setRecipientSCCPAddress(String value)
	{
		if(value==null)
			this.recipientSCCPAddress = null;
		else
			this.recipientSCCPAddress = new RecipientSCCPAddressImpl(value, null, null);			
	}
	
	public ByteBuf getSMProtocolId()
	{
		if(smProtocolID==null)
			return null;
		
		return smProtocolID.getValue();
	}
	
	public void setSMProtocolId(ByteBuf value)
	{
		if(value==null)
			this.smProtocolID = null;
		else
			this.smProtocolID = new SMProtocolIdImpl(value, null, null);			
	}
}