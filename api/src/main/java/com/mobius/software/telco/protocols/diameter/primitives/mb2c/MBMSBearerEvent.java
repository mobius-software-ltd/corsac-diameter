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
	6.4.4	MBMS‑Bearer‑Event AVP
	The MBMS‑Bearer-Event AVP (AVP code 3502) is of type Unsigned32 and it shall contain a bit mask with values as defined table 6.4.4-1. Several bits may be set in combination except for bit 0 and bit 1.
	Table 6.4.4-1: MBMS‑Bearer‑Event AVP

	Bit Name
	Description

	0 Bearer Terminated
	The MBMS bearer was terminated.

	1 Bearer Activated
	The MBMS bearer was activated.

	2 Userplane Event
	The userplane event is reported, and the result is further indicated in the Userplane-Protocol‑Result AVP.
	
	3 Bearer Activation Failure
	The MBMS bearer is not activated successfully based on the MBMS-Start-Time.
 */
@DiameterAvpDefinition(code = 3502L, vendorId = KnownVendorIDs.TGPP_ID, name = "MBMS‑Bearer‑Event")
public interface MBMSBearerEvent extends DiameterUnsigned32
{
}