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
	6.4.16	TMGI‑Deallocation‑Result AVP
	The TMGI‑Deallocation‑Result AVP (AVP code 3514) is of type Unsigned32 and it shall contain a bit mask with values as defined table 6.4.16-1. Several bits indicating errors may be set in combination for error cases.
	Table 6.4.16-1: TMGI‑Deallocation‑Result AVP

	Bit Name
	Description

	0 Success
	The requested TMGI deallocation was successful.

	1 Authorization rejected
	The requested TMGI deallocation failed because the BM‑SC did not authorize it.

	2 Unknown TMGI
	The requested TMGI deallocation failed because the BM‑SC did not know the requested TMGI, e.g. because the TMGI already expired.

	3 System error
	The requested TMGI deallocation failed due to internal system error in the BM-SC.
 */
@DiameterAvpDefinition(code = 3514L, vendorId = KnownVendorIDs.TGPP_ID, name = "TMGI‑Deallocation‑Result")
public interface TMGIDeallocationResult extends DiameterUnsigned32
{
}