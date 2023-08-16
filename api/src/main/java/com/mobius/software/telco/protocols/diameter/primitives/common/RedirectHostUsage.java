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
 * 6.13.  Redirect-Host-Usage AVP

   The Redirect-Host-Usage AVP (AVP Code 261) is of type Enumerated.
   This AVP MAY be present in answer messages whose 'E' bit is set and
   the Result-Code AVP is set to DIAMETER_REDIRECT_INDICATION.

   When present, this AVP provides hints about how the routing entry
   resulting from the Redirect-Host is to be used.  The following values
   are supported:
   
   DONT_CACHE 0

      The host specified in the Redirect-Host AVP SHOULD NOT be cached.
      This is the default value.

   ALL_SESSION 1

      All messages within the same session, as defined by the same value
      of the Session-ID AVP SHOULD be sent to the host specified in the
      Redirect-Host AVP.

   ALL_REALM 2

      All messages destined for the realm requested SHOULD be sent to
      the host specified in the Redirect-Host AVP.

   REALM_AND_APPLICATION 3

      All messages for the application requested to the realm specified
      SHOULD be sent to the host specified in the Redirect-Host AVP.

   ALL_APPLICATION 4

      All messages for the application requested SHOULD be sent to the
      host specified in the Redirect-Host AVP.

   ALL_HOST 5

      All messages that would be sent to the host that generated the
      Redirect-Host SHOULD be sent to the host specified in the
      Redirect-Host AVP.

   ALL_USER 6

      All messages for the user requested SHOULD be sent to the host
      specified in the Redirect-Host AVP.

   When multiple cached routes are created by redirect indications and
   they differ only in redirect usage and peers to forward requests to
   (see Section 6.1.8), a precedence rule MUST be applied to the
   redirect usage values of the cached routes during normal routing to
   resolve contentions that may occur.  The precedence rule is the order
   that dictate which redirect usage should be considered before any
   other as they appear.  The order is as follows:
   
   1.  ALL_SESSION

   2.  ALL_USER

   3.  REALM_AND_APPLICATION

   4.  ALL_REALM

   5.  ALL_APPLICATION

   6.  ALL_HOST
 */
@DiameterAvpDefinition(code = 261L, vendorId = -1L, name = "Redirect-Host-Usage")
public interface RedirectHostUsage extends DiameterEnumerated<RedirectHostUsageEnum>
{
}