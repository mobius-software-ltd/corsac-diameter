package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

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
@DiameterAvpDefinition(code = TgppAvpCodes.RECIPIENT_INFO, vendorId = VendorIDs.TGPP_ID, name = "Recipient-Info")
public interface RecipientInfo extends DiameterAvp
{
	DestinationInterface getDestinationInterface();
	
	void setDestinationInterface(DestinationInterface value);
	
	List<RecipientAddress> getRecipientAddress();
	
	void setRecipientAddress(List<RecipientAddress> value);
	
	List<RecipientReceivedAddress> getRecipientReceivedAddress();
	
	void setRecipientReceivedAddress(List<RecipientReceivedAddress> value);
	
	String getRecipientSCCPAddress();
	
	void setRecipientSCCPAddress(String value);
	
	ByteBuf getSMProtocolId();
	
	void setSMProtocolId(ByteBuf value);
}