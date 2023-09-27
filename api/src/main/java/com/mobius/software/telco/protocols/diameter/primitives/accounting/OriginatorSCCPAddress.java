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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAddress;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.128 Originator-SCCP-Address
	The Originator-SCCP-Address AVP (AVP code 2008) is of type Address. It is the "SCCP calling address" used by the
	messaging node when receiving a message. This is usually the address of the MSC or SGSN/Serving Node that was
	serving the UE when it submitted the message. It contains either a Point Code (ISPC) or a Global Title, where Global
	Title represents an E.164 number. The Address Type discriminator in RFC 6733 [401] is set to value 8, E.164, and the
	address information is UTF8 encoded.
 */
@DiameterAvpDefinition(code = 2008L, vendorId = KnownVendorIDs.TGPP_ID, name = "Originator-SCCP-Address")
public interface OriginatorSCCPAddress extends DiameterAddress
{
}