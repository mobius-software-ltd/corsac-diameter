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
 * 	7.3.133	LIPA-Permission
	The LIPA-Permission AVP is of type Enumerated. It shall indicate whether the APN can be accessed via Local IP Access. The following values are defined:

	LIPA_PROHIBITED (0)
	This value indicates that this APN is prohibited to be accessed via LIPA.

	LIPA_ONLY (1)
	This value indicates that this APN can be accessed only via LIPA.

	LIPA_CONDITIONAL (2)
	This value indicates that this APN can be accessed via both non LIPA and LIPA.
 */
@DiameterAvpDefinition(code = 1618L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "LIPA-Permission")
public interface LIPAPermission extends DiameterEnumerated<LIPAPermissionEnum>
{
}