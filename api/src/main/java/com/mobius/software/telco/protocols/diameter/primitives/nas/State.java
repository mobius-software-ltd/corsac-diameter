package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 9.3.4.  State AVP

   The State AVP (AVP Code 24) [RADIUS] is of type OctetString and has
   two uses in the Diameter NAS application.

   The State AVP MAY be sent by a Diameter Server to a NAS in an AA-
   Response command that contains a Result-Code of
   DIAMETER_MULTI_ROUND_AUTH.  If so, the NAS MUST return it unmodified
   in the subsequent AA-Request command.
   
   The State AVP MAY also be sent by a Diameter Server to a NAS in an
   AA-Response command that also includes a Termination-Action AVP with
   the value of AA-REQUEST.  If the NAS performs the Termination-Action
   by sending a new AA-Request command upon termination of the current
   service, it MUST return the State AVP unmodified in the new request
   command.

   In either usage, the NAS MUST NOT interpret the AVP locally.  Usage
   of the State AVP is implementation dependent.
 */
@DiameterAvpDefinition(code = AvpCodes.STATE, vendorId = -1L, name = "State")
public interface State extends DiameterOctetString
{
}