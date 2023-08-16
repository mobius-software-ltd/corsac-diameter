package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
 * 	6.3.7 Requested-Domain AVP
	The Requested-Domain AVP is of type Enumerated, and indicates the access domain for which certain data (e.g. user
	state) are requested. The following values are defined:

	CS-Domain (0)
		The requested data apply to the CS domain.
	PS-Domain (1)
		The requested data apply to the PS domain. 
 */
@DiameterAvpDefinition(code = 706L, vendorId = KnownVendorIDs.TGPP_ID, name = "Requested-Domain")
public interface RequestedDomain extends DiameterEnumerated<RequestedDomainEnum>
{
}