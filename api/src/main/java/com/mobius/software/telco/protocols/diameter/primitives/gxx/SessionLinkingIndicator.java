package com.mobius.software.telco.protocols.diameter.primitives.gxx;
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
 * 	5a.3.6	Session-Linking-Indicator AVP (All access types)
	The Session-Linking-Indicator AVP (AVP code 1064) is of type Enumerated and indicates whether the session linking between the Gateway Control Session and the Gx session shall be deferred. The absence of this AVP in case 2b as defined in 3GPP TS 29.213 [8] shall indicate the value SESSION_LINKING_IMMEDIATE.
	The following values are defined:

	SESSION_LINKING_IMMEDIATE (0)
	This value shall be used to indicate that the PCRF shall perform the linking between the new Gateway Control Session with an existing Gx session immediately.

	SESSION_LINKING_DEFERRED (1)
	This value shall be used to indicate that the PCRF shall not attempt linking the new Gateway Control Session with an existing Gx session immediately.
 */
@DiameterAvpDefinition(code = 1064L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Session-Linking-Indicator")
public interface SessionLinkingIndicator extends DiameterEnumerated<SessionLinkingIndicatorEnum>
{
}