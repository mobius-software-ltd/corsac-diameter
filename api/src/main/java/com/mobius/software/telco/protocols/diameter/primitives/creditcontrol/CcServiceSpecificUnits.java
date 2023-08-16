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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.26.  CC-Service-Specific-Units AVP

   The CC-Service-Specific-Units AVP (AVP Code 417) is of type
   Unsigned64 and specifies the number of service-specific units (e.g.,
   number of events, points) given in a selected service.  The service-
   specific units always refer to the service identified in the Service-
   Identifier AVP (or Rating-Group AVP when the Multiple-Services-
   Credit-Control AVP is used).
 */
@DiameterAvpDefinition(code = 417L, vendorId = -1L, name = "Cc-Service-Specific-Units")
public interface CcServiceSpecificUnits extends DiameterUnsigned64
{
}