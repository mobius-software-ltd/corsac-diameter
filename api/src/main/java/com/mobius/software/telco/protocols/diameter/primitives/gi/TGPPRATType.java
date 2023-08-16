package com.mobius.software.telco.protocols.diameter.primitives.gi;
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
	21 - 3GPP-RAT-Type
	The 3GPP-RAT-Type sub-attribute indicates which Radio Access Technology is currently serving the UE.
	RAT field: Radio Access Technology type values. RAT field is Octet String type. For GGSN, it shall be coded as
	specified in 3GPP TS 29.060 [24]. For P-GW, it shall be coded as follows:
	0-6 As specified in 3GPP TS 29.274 [81]
	7-100 Reserved for future use
	101 IEEE 802.16e
	102 3GPP2 eHRPD
	103 3GPP2 HRPD
	104 3GPP2 1xRTT
	105-255 Reserved for future use 
 */
@DiameterAvpDefinition(code = 21L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-RAT-Type")
public interface TGPPRATType extends DiameterOctetString
{
}