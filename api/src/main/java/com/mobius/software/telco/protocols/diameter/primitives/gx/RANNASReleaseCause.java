package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.106 RAN-NAS-Release-Cause AVP (3GPP-EPS and Non-3GPP-EPS access type)
	The RAN-NAS-Release-Cause AVP (AVP code 2819) is of type OctetString, and indicates the RAN or NAS release
	cause code information in 3GPP-EPS access type, or indicates the TWAN or untrusted WLAN release cause code
	information in Non-3GPP-EPS access type. The AVP shall be coded as per the RAN/NAS Cause in clause 8.103 of
	3GPP TS 29.274 [22], starting with Octet 5. 
 */
@DiameterAvpDefinition(code = 2819L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "RAN-NAS-Release-Cause")
public interface RANNASReleaseCause extends DiameterOctetString
{
}