package com.mobius.software.telco.protocols.diameter.primitives.mm10;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.9	Result-Recipient-Address AVP
	The Result-Recipient-Address AVP (AVP code 1106) is of type Grouped. It contains recipient address information as returned from the MSCF.

	Result-Recipient-Address ::= <AVP header: 1106 10415>
		 {Sequence-Number}
		 [Recipient-Address]
		 [Routeing-Address]
		 [Sender-Address]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RESULT_RECIPIENT_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "Result-Recipient-Address")
public interface ResultRecipientAddress extends DiameterGroupedAvp
{
	Long getSequenceNumber();
	
	void setSequenceNumber(Long value) throws MissingAvpException;	
	
	String getRecipientAddress();
	
	void setRecipientAddress(String value);
	
	String getRouteingAddress();
	
	void setRouteingAddress(String value);
	
	String getSenderAddress();
	
	void setSenderAddress(String value);
}