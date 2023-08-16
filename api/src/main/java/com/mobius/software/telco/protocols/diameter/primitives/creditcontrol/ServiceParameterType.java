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
 * 8.44.  Service-Parameter-Type AVP

   The Service-Parameter-Type AVP is of type Unsigned32 (AVP Code 441)
   and defines the type of the service-event-specific parameter (e.g.,
   it can be the end-user location or service name).  The different
   parameters and their types are service specific, and the meanings of
   these parameters are not defined in this document.  Whoever allocates
   the Service-Context-Id (i.e., a unique identifier of a service-
   specific document) is also responsible for assigning Service-
   Parameter-Type values for the service and ensuring their uniqueness
   within the given service.  The Service-Parameter-Value AVP contains
   the value associated with the service parameter type.

 */
@DiameterAvpDefinition(code = 441L, vendorId = -1L, must = false, name = "Service-Parameter-Type")
public interface ServiceParameterType extends DiameterUnsigned32
{
}