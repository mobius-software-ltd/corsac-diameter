package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.17	Reason-Code AVP
	The Reason-Code AVP is of type Enumerated, and defines the reason for the network initiated de-registration. The following values are defined:

	PERMANENT_TERMINATION (0)

	NEW_SERVER_ASSIGNED (1)
	
	SERVER_CHANGE (2)

	REMOVE_S-CSCF (3)

	The detailed behaviour of the S-CSCF is defined in 3GPP TS 29.228 [1].
 */
@DiameterAvpDefinition(code = 616L, vendorId = KnownVendorIDs.TGPP_ID, name = "Reason-Code")
public interface ReasonCode extends DiameterEnumerated<ReasonCodeEnum>
{
}