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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.1.  CC-Correlation-Id AVP

   The CC-Correlation-Id AVP (AVP Code 411) is of type OctetString and
   contains information to correlate credit-control requests generated
   for different components of the service, e.g., transport and service
   level.  Whoever allocates the Service-Context-Id (i.e., a unique
   identifier of a service-specific document) is also responsible for
   defining the content and encoding of the CC-Correlation-Id AVP.
 */
@DiameterAvpDefinition(code = AvpCodes.CC_CORRELATION_ID, vendorId = -1L, must = false, name = "Cc-Correlation-Id")
public interface CcCorrelationId extends DiameterOctetString
{
}