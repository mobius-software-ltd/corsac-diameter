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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.213	V2X-Permission
	The V2X-Permission AVP is of type Unsigned32 and it shall contain a bit mask that indicates the permissions for V2X service subscribed by the user. The meaning of the bits shall be as defined in table 7.3.x2-1:
	Table 7.3.x2-1: V2X-Permission

	Bit Name
	Description

	0 Allow V2X communication over PC5 as Vehicle UE
	This bit, when set, indicates that the user is allowed to use V2X communication over PC5 as Vehicle UE in the serving PLMN.

	1 Allow V2X communication over PC5 as Pedestrian UE
	This bit, when set, indicates that the user is allowed to use V2X communication over PC5 as Pedestrian UE in the serving PLMN.

	NOTE:	Bits not defined in this table shall be cleared by the HSS and discarded by the MME.
 */
@DiameterAvpDefinition(code = 1689L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "V2X-Permission")
public interface V2XPermission extends DiameterUnsigned32
{
}