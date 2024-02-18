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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 6.14.  Redirect-Max-Cache-Time AVP

   The Redirect-Max-Cache-Time AVP (AVP Code 262) is of type Unsigned32.
   This AVP MUST be present in answer messages whose 'E' bit is set,
   whose Result-Code AVP is set to DIAMETER_REDIRECT_INDICATION, and
   whose Redirect-Host-Usage AVP set to a non-zero value.

   This AVP contains the maximum number of seconds the peer and route
   table entries, created as a result of the Redirect-Host, SHOULD be
   cached.  Note that once a host is no longer reachable, any associated
   cache, peer, and routing table entries MUST be deleted.
 */
@DiameterAvpDefinition(code = AvpCodes.REDIRECT_MAX_CACHE_TIME, vendorId = -1L, name = "Redirect-Max-Cache-Time")
public interface RedirectMaxCacheTime extends DiameterUnsigned32
{
}