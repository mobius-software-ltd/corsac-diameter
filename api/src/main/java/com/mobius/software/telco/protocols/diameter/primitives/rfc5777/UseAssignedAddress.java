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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.7.18.  Use-Assigned-Address AVP

   In some scenarios, the AAA does not know the IP address assigned to
   the managed terminal at the time that the classifier is sent to the
   Classifying Entity.  The Use-Assigned-Address AVP (AVP Code 534) is
   of type Enumerated containing the values of True or False.  When
   present and set to True, it represents the IP address assigned to the
   managed terminal.

     Value | Name
     ------+--------
       0   | False
       1   | True
 */
@DiameterAvpDefinition(code = AvpCodes.USE_ASSIGNED_ADDRESS, vendorId = -1L, name = "Use-Assigned-Address")
public interface UseAssignedAddress extends DiameterEnumerated<UseAssignedAddressEnum>
{
}