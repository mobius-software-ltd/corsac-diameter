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
 * 4.3.12.  ARAP-Security-Data AVP

   The ARAP-Security-Data AVP (AVP Code 74) is of type OctetString and
   MAY be present in the AA-Request or AA-Answer message if the Framed-
   Protocol AVP (Section 4.4.10.1) is set to the value of ARAP and the
   Result-Code AVP ([RFC6733], Section 7.1) is set to
   DIAMETER_MULTI_ROUND_AUTH.  This AVP contains the security module
   challenge or response associated with the ARAP Security Module
   specified in the ARAP-Security AVP (Section 4.3.11).
 */
@DiameterAvpDefinition(code = AvpCodes.ARAP_SECURITY_DATA, vendorId = -1L, name = "ARAP-Security-Data")
public interface ARAPSecurityData extends DiameterOctetString
{
}