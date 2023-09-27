package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.8	MBMS‑Bearer‑Result AVP
	The MBMS‑Bearer‑Result AVP (AVP code 3506) is of type Unsigned32 and it shall contain a bit mask with values as defined table 6.4.8-1. Several bits indicating errors may be set in combination. Bit 0 and Bit 13 may be set together to indicate that the request for bearer activation was successfully handled but the actual bearer activation is still ongoing.
	Table 6.4.8-1: MBMS‑ Bearer‑Result AVP

	Bit Name
	Description

	0 Success
	The requested bearer activation, modification or deactivation was successful; or the request for bearer activation was successfully handled if bit 13 is set.

	1 Authorization rejected
	The requested bearer activation, modification or deactivation failed because the BM‑SC did not authorize it.

	2 Resources exceeded
	The requested bearer activation, modification or deactivation failed because the BM‑SC could not provide sufficient resources.

	3 Unknown TMGI
	The requested bearer activation, modification or deactivation failed because the BM‑SC did not know the requested TMGI or the TMGI expired.

	4 TMGI not in use
	The requested bearer modification or deactivation failed because the requested TMGI was not related to an active MBMS bearer.

	5 Overlapping MBMS‑Service‑Area
 	The requested bearer modification failed because the requested Service area was overlapping with a service area already in use for the requested TMGI.

	6 Unknown Flow Identifier
	The requested bearer modification or deactivation failed because the BM‑SC did not know the requested Flow Identifier.

	7 QoS Authorization Rejected
	The requested bearer activation or modification failed because the BM‑SC did not authorize the requested QoS.

	8 Unknown MBMS‑Service‑Area
	The requested bearer activation or modification failed because the BM‑SC did not know the requested MBMS‑Service‑Area
	
	9 MBMS‑Service‑Area Authorization Rejected
	The requested bearer activation or modification failed because the BM‑SC did not authorize the requested MBMS‑Service‑Area

	10 MBMS‑Start‑Time
	The requested bearer activation failed because the MBMS‑Start‑Time contained an inappropriate value.

	11 Invalid AVP combination
	The requested bearer activation, modification or deactivation failed because the provided AVP combination within the corresponding MBMS‑Bearer‑Request AVP was not allowed (e.g. because some mandatory AVPs for a given MBMS‑StartStop‑Indication value were missing).

	12 System error
	The requested procedure (e.g. bearer activation/modification) failed due to internal system error in the BM-SC.

	13 Activation ongoing
	The requested bearer activation is still ongoing.
 */
@DiameterAvpDefinition(code = 3506L, vendorId = KnownVendorIDs.TGPP_ID, name = "MBMS‑Bearer‑Result")
public interface MBMSBearerResult extends DiameterUnsigned32
{
}