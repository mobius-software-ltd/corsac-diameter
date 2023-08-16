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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUri;

/**
*
* @author yulian oifa
*
*/
/*
 * 6.12.  Redirect-Host AVP

   The Redirect-Host AVP (AVP Code 292) is of type DiameterURI.  One or
   more instances of this AVP MUST be present if the answer message's
   'E' bit is set and the Result-Code AVP is set to
   DIAMETER_REDIRECT_INDICATION.

   Upon receiving the above, the receiving Diameter node SHOULD forward
   the request directly to one of the hosts identified in these AVPs.
   The server contained in the selected Redirect-Host AVP SHOULD be used
   for all messages matching the criteria set by the Redirect-Host-Usage
   AVP.
 */
@DiameterAvpDefinition(code = 292L, vendorId = -1L, name = "Redirect-Host")
public interface RedirectHost extends DiameterUri
{
}