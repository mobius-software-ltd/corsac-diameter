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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.33.  Validity-Time AVP

   The Validity-Time AVP is of type Unsigned32 (AVP Code 448).  It is
   sent from the credit-control server to the credit-control client.
   The Validity-Time AVP contains the validity time of the granted
   service units.  The measurement of the Validity-Time is started upon
   receipt of the Credit-Control-Answer message containing this AVP.  If
   the granted service units have not been consumed within the validity
   time specified in this AVP, the credit-control client MUST send a
   Credit-Control-Request message to the server, with CC-Request-Type
   set to UPDATE_REQUEST.  The value field of the Validity-Time AVP is
   given in seconds.
   
   The Validity-Time AVP is also used for graceful service termination
   (see Section 5.6) to indicate to the credit-control client how long
   the subscriber is allowed to use network resources after the
   specified action (i.e., REDIRECT or RESTRICT_ACCESS) started.  When
   the Validity-Time elapses, a new intermediate interrogation is sent
   to the server.
 */
@DiameterAvpDefinition(code = 448L, vendorId = -1L, name = "Validity-Time")
public interface ValidityTime extends DiameterUnsigned32
{
}