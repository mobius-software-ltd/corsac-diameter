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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
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

/*
 * 	7.2.168	Recipient-Info AVP
	The Recipient-Info AVP (AVP code 2026) is of type Grouped. Its purpose is to group information associated with a recipient. and contains the list of Recipient addresses of the message.
	It has the following ABNF grammar:
               
	Recipient-Info :: = 	< AVP Header: 2026 >
   			[ Destination-Interface ]
		* 	[ Recipient-Address ]
		* 	[ Recipient-Received-Address ]
		   	[ Recipient-SCCP-Address ]
		   	[ SM-Protocol-ID ]

	NOTE 1: This Recipient-Info AVP allows charging for messages with multiple recipients by repeating this AVP for every recipient. The Recipient-Info AVP unambigiously associates the grouped information to one specific recipient. 
	
	NOTE 2: The SM-Protocol-ID AVP only relates to the recipient when charging MT SMS messages as specified in TS 23.040 [216].
 */
@DiameterAvpImplementation(code = 2026L, vendorId = KnownVendorIDs.TGPP_ID)
public class RecipientInfoImpl implements RecipientInfo
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