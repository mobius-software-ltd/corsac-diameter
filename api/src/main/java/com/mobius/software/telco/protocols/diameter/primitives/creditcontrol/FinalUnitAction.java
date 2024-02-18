package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
 * 8.35.  Final-Unit-Action AVP

   The Final-Unit-Action AVP (AVP Code 449) is of type Enumerated and
   indicates to the credit-control client the action to be taken when
   the user's account cannot cover the service cost.

   Final-Unit-Action can be set to one of the following values:

   TERMINATE         0

   The credit-control client MUST terminate the service session.  This
   is the default handling, applicable whenever the credit-control
   client receives an unsupported Final-Unit-Action value, and it MUST
   be supported by all the Diameter Credit-Control client
   implementations conforming to this specification.
   
   REDIRECT          1

   The Service Element MUST redirect the user to the address specified
   in the Redirect-Server-Address AVP or one of the AVPs included in the
   Redirect-Server-Extension AVP.  The redirect action is defined in
   Section 5.6.2.

   RESTRICT_ACCESS   2

   The access device MUST restrict the user's access according to the
   filter AVPs contained in the applied Grouped AVP: according to IP
   packet filters defined in the Restriction-Filter-Rule AVP, according
   to the packet classifier filters defined in the Filter-Rule AVP, or
   according to the packet filters identified by the Filter-Id AVP.  All
   of the packets not matching any restriction filters (see
   Section 5.6.3) MUST be dropped.
 */
@DiameterAvpDefinition(code = AvpCodes.FINAL_UNIT_ACTION, vendorId = -1L, name = "Final-Unit-Action")
public interface FinalUnitAction extends DiameterEnumerated<FinalUnitActionEnum>
{
}