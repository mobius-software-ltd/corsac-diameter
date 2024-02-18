package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.46B CSG-Membership-Indication AVP
	The CSG-Membership-Indication AVP (AVP code 2318) is of type Enumerated, and indicates the UE is a member of
	the accessing CSG cell, if the access mode is Hybrid, as described in TS 29.060 [225], and in TS 29.274 [226]. If this
	indication is not present, this means the UE is a Not member of the CSG cell for hybrid access mode. The following
	values are defined:

	0 Not CSG member
	1 CSG Member 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CSG_MEMBERSHIP_INDICATION, vendorId = VendorIDs.TGPP_ID, name = "CSG-Membership-Indication")
public interface CSGMembershipIndication extends DiameterEnumerated<CSGMembershipIndicationEnum>
{
}