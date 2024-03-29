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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.7.  Auth-Request-Type AVP

   The Auth-Request-Type AVP (AVP Code 274) is of type Enumerated and is
   included in application-specific auth requests to inform the peers
   whether a user is to be authenticated only, authorized only, or both.
   Note any value other than both MAY cause RADIUS interoperability
   issues.  The following values are defined:

   AUTHENTICATE_ONLY 1

      The request being sent is for authentication only, and it MUST
      contain the relevant application-specific authentication AVPs that
      are needed by the Diameter server to authenticate the user.

   AUTHORIZE_ONLY 2

      The request being sent is for authorization only, and it MUST
      contain the application-specific authorization AVPs that are
      necessary to identify the service being requested/offered.

   AUTHORIZE_AUTHENTICATE 3

      The request contains a request for both authentication and
      authorization.  The request MUST include both the relevant
      application-specific authentication information and authorization
      information necessary to identify the service being requested/
      offered.
 */
@DiameterAvpDefinition(code = AvpCodes.AUTH_REQUEST_TYPE, vendorId = -1L, name = "Auth-Request-Type")
public interface AuthRequestType extends DiameterEnumerated<AuthRequestTypeEnum>
{
}