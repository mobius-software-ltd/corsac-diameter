package com.mobius.software.telco.protocols.diameter.primitives.rfc7683;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.7.  OC-Reduction-Percentage AVP

	   The OC-Reduction-Percentage AVP (AVP Code 627) is of type Unsigned32
	   and describes the percentage of the traffic that the sender is
	   requested to reduce, compared to what it otherwise would send.  The
	   OC-Reduction-Percentage AVP applies to the default (loss) algorithm
	   specified in this specification.  However, the AVP can be reused for
	   future abatement algorithms, if its semantics fit into the new
	   algorithm.
	
	   The value of the Reduction-Percentage AVP is between zero (0) and one
	   hundred (100).  Values greater than 100 are ignored.  The value of
	   100 means that all traffic is to be throttled, i.e., the reporting
	   node is under a severe load and ceases to process any new messages.
	   The value of 0 means that the reporting node is in a stable state and
	   has no need for the reacting node to apply any traffic abatement.
*/
@DiameterAvpDefinition(code = AvpCodes.OC_REDUCTION_PERCENTAGE, vendorId = -1L, must = false, name = "OC-Reduction-Percentage")
public interface OCReductionPercentage extends DiameterUnsigned32
{
}