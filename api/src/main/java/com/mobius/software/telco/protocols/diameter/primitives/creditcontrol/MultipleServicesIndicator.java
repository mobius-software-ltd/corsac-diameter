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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.40.  Multiple-Services-Indicator AVP

   The Multiple-Services-Indicator AVP (AVP Code 455) is of type
   Enumerated and indicates whether the Diameter Credit-Control client
   is capable of handling multiple services independently within a
   (sub-)session.  The absence of this AVP means that independent
   credit-control of multiple services is not supported.

   A server not implementing the independent credit-control of multiple
   services MUST treat the Multiple-Services-Indicator AVP as an
   invalid AVP.

   The following values are defined for the Multiple-Services-Indicator
   AVP:

   MULTIPLE_SERVICES_NOT_SUPPORTED   0

   The client does not support independent credit-control of multiple
   services within a (sub-)session.

   MULTIPLE_SERVICES_SUPPORTED       1

   The client supports independent credit-control of multiple services
   within a (sub-)session.
 */
@DiameterAvpDefinition(code = 455L, vendorId = -1L, name = "Multiple-Services-Indicator")
public interface MultipleServicesIndicator extends DiameterEnumerated<MultipleServicesIndicatorEnum>
{
}