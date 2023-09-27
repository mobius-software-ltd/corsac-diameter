package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.150	Subscribed-VSRVCC
	The Subscribed-VSRVCC AVP is of type Enumerated. It shall indicate that the user is subscribed to the vSRVCC. The following value is defined:

	VSRVCC_SUBSCRIBED (0)

	Absence of this AVP in IDR shall be interpreted as the Subscribed-VSRVCC has not been modified.

	Absence of this AVP in ULA shall be interpreted as the user is not subscribed to the vSRVCC.
 */
@DiameterAvpDefinition(code = 1636L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Subscribed-VSRVCC")
public interface SubscribedVSRVCC extends DiameterEnumerated<SubscribedVSRVCCEnum>
{
}