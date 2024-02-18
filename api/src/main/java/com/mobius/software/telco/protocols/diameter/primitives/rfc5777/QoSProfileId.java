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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	5.2.  QoS-Profile-Id AVP

   	The QoS-Profile-Id AVP (AVP Code 573) is of type Unsigned32 and
   	contains a QoS profile template identifier.  An initial QoS profile
   	template is defined with value of 0 and can be found in [RFC5624].
   	The registry for the QoS profile templates is created with the same
   	document.
 */
@DiameterAvpDefinition(code = AvpCodes.QOS_PROFILE_ID, vendorId = -1L, name = "QoS-Profile-Id")
public interface QoSProfileId extends DiameterUnsigned32
{
}