package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
 * 	5.2.3.9	AN-Trusted
	The AN-Trusted AVP (AVP Code 1503) is of type Enumerated.
	The AN-Trusted AVP sent from the 3GPP AAA Server to the Non-3GPP access network conveys the decision about the access network being trusted or untrusted by the HPLMN.
	The following values are defined:
	
	TRUSTED (0)
	This value is used when the non-3GPP access network is to be handled as trusted.

	UNTRUSTED (1)
	This value is used when the non-3GPP access network is to be handled as untrusted.
 */
@DiameterAvpDefinition(code = 1503L, vendorId = KnownVendorIDs.TGPP_ID, name = "AN-Trusted")
public interface ANTrusted extends DiameterEnumerated<ANTrustedEnum>
{
}