package com.mobius.software.telco.protocols.diameter.primitives.common;
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
 * 8.12.  Re-Auth-Request-Type AVP

   The Re-Auth-Request-Type AVP (AVP Code 285) is of type Enumerated and
   is included in application-specific auth answers to inform the client
   of the action expected upon expiration of the Authorization-Lifetime.
   
   If the answer message contains an Authorization-Lifetime AVP with a
   positive value, the Re-Auth-Request-Type AVP MUST be present in an
   answer message.  The following values are defined:

   AUTHORIZE_ONLY 0

      An authorization only re-auth is expected upon expiration of the
      Authorization-Lifetime.  This is the default value if the AVP is
      not present in answer messages that include the Authorization-
      Lifetime.

   AUTHORIZE_AUTHENTICATE 1

      An authentication and authorization re-auth is expected upon
      expiration of the Authorization-Lifetime.
 */
@DiameterAvpDefinition(code = 285L, vendorId = -1L, name = "Re-Auth-Request-Type")
public interface ReAuthRequestType extends DiameterEnumerated<ReAuthRequestTypeEnum>
{
}