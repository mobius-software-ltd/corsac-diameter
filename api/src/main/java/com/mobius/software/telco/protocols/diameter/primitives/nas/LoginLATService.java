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
 * 4.4.11.5.1.  Login-LAT-Service AVP

   The Login-LAT-Service AVP (AVP Code 34) is of type OctetString and
   contains the system with which the user is to be connected by LAT.
   It MAY be used in an authorization request as a hint to the server
   that a specific service is desired, but the server is not required to
   honor the hint in the corresponding response.  This AVP MUST only be
   present in the response if the Login-Service AVP states that LAT is
   desired.

   Administrators use this service attribute when dealing with clustered
   systems.  In these environments, several different time-sharing hosts
   share the same resources (disks, printers, etc.), and administrators
   often configure each host to offer access (service) to each of the
   shared resources.  In this case, each host in the cluster advertises
   its services through LAT broadcasts.

   Sophisticated users often know which service providers (machines) are
   faster and tend to use a node name when initiating a LAT connection.
   Some administrators want particular users to use certain machines as
   a primitive form of load balancing (although LAT knows how to do load
   balancing itself).

   The String field contains the identity of the LAT service to use.
   The LAT Architecture allows this string to contain $ (dollar), -
   (hyphen), . (period), _ (underscore), numerics, upper- and lower-case
   alphabetics, and the ISO Latin-1 character set extension
   [ISO.8859-1.1987].  All LAT string comparisons are case insensitive.
 */
@DiameterAvpDefinition(code = AvpCodes.LOGIN_LAT_SERVICE, vendorId = -1L, name = "Login-LAT-Service")
public interface LoginLATService extends DiameterOctetString
{
}