package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.45 Priority-Level AVP (All access types)
	The Priority-Level AVP (AVP code 1046) is of type Unsigned 32. The AVP is used for deciding whether a bearer
	establishment or modification request can be accepted or needs to be rejected in case of resource limitations (typically
	used for admission control of GBR traffic). The AVP can also be used to decide which existing bearers to pre-empt
	during resource limitations. The priority level defines the relative importance of a resource request.
	Values 1 to 15 are defined, with value 1 as the highest level of priority.
	Values 1 to 8 should only be assigned for services that are authorized to receive prioritized treatment within an operator
	domain. Values 9 to 15 may be assigned to resources that are authorized by the home network and thus applicable when
	a UE is roaming.

	NOTE: The Priority-Level AVP can be used in addition to the QoS-Class-Identifier AVP to determine the user
	plane transport level packet marking, e.g. to set the DSCP marking of the associated EPS bearer
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PRIORITY_LEVEL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Priority-Level")
public interface PriorityLevel extends DiameterUnsigned32
{
}