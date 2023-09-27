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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.35B Civic-Address-Information AVP
	The Civic-Address-Information AVP (AVP code 1305) is of type OctetString and holds the Civic Address of the Access
	Point to which the UE is attached when served under a trusted or untrusted WLAN, as specified for Location-Data in
	TS 29.273 [237]. 
 */
@DiameterAvpDefinition(code = 1305L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Civic-Address-Information")
public interface CivicAddressInformation extends DiameterOctetString
{
}