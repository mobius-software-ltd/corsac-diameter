package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.8.23.  User-Priority-Range AVP

   The User-Priority-Range AVP (AVP Code 557) is of type Grouped and
   specifies an inclusive range to match the user_priority parameter
   specified in [IEEE802.1D].  An Ethernet packet containing the
   user_priority parameter matches this classifier if the value is
   greater than or equal to Low-User-Priority and less than or equal to
   High-User-Priority.  If this AVP is omitted, then comparison of the
   IEEE 802.1D user_priority parameter for this classifier is
   irrelevant.

   User-Priority-Range ::= < AVP Header: 557 >
                         * [ Low-User-Priority ]
                         * [ High-User-Priority ]
                         * [ AVP ]
 */
@DiameterAvpDefinition(code = 557L, vendorId = -1L, name = "User-Priority-Range")
public interface UserPriorityRange extends DiameterGroupedAvp
{
	List<Long> getLowUserPriority();
	
	void setLowUserPriority(List<Long> value);	
	
	List<Long> getHighUserPriority();
	
	void setHighUserPriority(List<Long> value);	
}