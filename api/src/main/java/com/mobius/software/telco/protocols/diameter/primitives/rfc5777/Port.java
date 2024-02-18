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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/

/*
	4.1.7.14.  Port AVP

   	The Port AVP (AVP Code 530) is of type Integer32 in the range of 0 to
   	65535 and specifies port numbers to match.  The type of port is
   	indicated by the value of the Protocol AVP; i.e., if Protocol AVP
   	value is 6 (TCP), then the Port AVP represents a TCP port.
 */
@DiameterAvpDefinition(code = AvpCodes.PORT, vendorId = -1L, name = "Port")
public interface Port extends DiameterInteger32
{
}