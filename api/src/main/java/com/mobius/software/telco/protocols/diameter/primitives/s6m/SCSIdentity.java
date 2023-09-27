package com.mobius.software.telco.protocols.diameter.primitives.s6m;
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
	6.4.4	SCS-Identity
	The SCS-Identity AVP is of type OctetString and it shall contain the identity of the SCS or UE which originated the service request towards the MTC-IWF, over the Tsp reference point.
	The encoding of the SCS-Identity AVP is defined per SCS service.
	For the device triggering service, the SCS-Identity AVP shall contain the ISDN number of the SCS in international ISDN number format as described in ITU-T Rec E.164 [41]. It shall be encoded as a TBCD-string. See 3GPP TS 29.002 [24] for encoding of TBCD-strings. This AVP shall not include leading indicators for the nature of address and the numbering plan. 
 */
@DiameterAvpDefinition(code = 3104L, vendorId = KnownVendorIDs.TGPP_ID, name = "SCS-Identity")
public interface SCSIdentity extends DiameterOctetString
{
}