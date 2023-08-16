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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.17.  Granted-Service-Unit AVP

   The Granted-Service-Unit AVP (AVP Code 431) is of type Grouped and
   contains the amount of units that the Diameter Credit-Control client
   can provide to the end user until the service must be released or the
   new Credit-Control-Request must be sent.  A client is not required to
   implement all the unit types, and it must treat unknown or
   unsupported unit types in the Answer message as an incorrect CCA.  In
   this case, the client MUST terminate the credit-control session and
   indicate the reason as DIAMETER_BAD_ANSWER in the Termination-Cause
   AVP.

   The Granted-Service-Unit AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         Granted-Service-Unit ::= < AVP Header: 431 >
                                  [ Tariff-Time-Change ]
                                  [ CC-Time ]
                                  [ CC-Money ]
                                  [ CC-Total-Octets ]
                                  [ CC-Input-Octets ]
                                  [ CC-Output-Octets ]
                                  [ CC-Service-Specific-Units ]
                                 *[ AVP ]
 */
@DiameterAvpDefinition(code = 431L, vendorId = -1, name = "Granted-Service-Unit")
public interface GrantedServiceUnit extends UsedServiceUnit 
{	
}