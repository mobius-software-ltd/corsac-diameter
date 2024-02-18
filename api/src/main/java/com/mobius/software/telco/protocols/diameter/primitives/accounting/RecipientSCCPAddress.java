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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.170 Recipient-SCCP-Address
	The Recipient-SCCP-Address AVP (AVP code 2010) is of type Address. It is the "SCCP called address" used by the
	messaging node when delivering the message. This is usually the address of the MSC or SGSN/Serving Node that is
	serving the UE when it delivers the message. It contains a Global Title, where Global Title represents an E.164 number,
	and possibly a Point Code (ISPC). The AddressType discriminator in RFC 6733 [401] is set to value 8, E.164, and the
	address information is UTF8 encoded. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RECIPIENT_SCCP_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "Recipient-SCCP-Address")
public interface RecipientSCCPAddress extends DiameterAddress
{
}