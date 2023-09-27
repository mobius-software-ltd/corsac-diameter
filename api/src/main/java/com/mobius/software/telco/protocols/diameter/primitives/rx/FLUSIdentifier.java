package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.63	FLUS-Identifier AVP
	The FLUS-Identifier AVP (AVP code 566) is of type OctetString, and it indicates that a media component is used for FLUS media.
	It is derived from the media level attribute "a=label:" (see IETF RFC 4574 [68]) obtained from the SDP body. It contains the string after "a=label:" starting with "flus" and may be followed by more characters as described in 3GPP TS 26.238 [69].
 */
@DiameterAvpDefinition(code = 566L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "FLUS-Identifier")
public interface FLUSIdentifier extends DiameterOctetString
{
}