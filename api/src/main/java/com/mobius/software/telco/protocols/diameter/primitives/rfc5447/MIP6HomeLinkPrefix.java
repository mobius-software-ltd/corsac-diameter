package com.mobius.software.telco.protocols.diameter.primitives.rfc5447;
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
	4.2.4.  MIP6-Home-Link-Prefix AVP

   	The MIP6-Home-Link-Prefix AVP (AVP Code 125) is of type OctetString
   	and contains the Mobile IPv6 home network prefix information in a
   	network byte order.  The home network prefix MUST be encoded as the
   	8-bit prefix length information (one octet) followed by the 128-bit
   	field (16 octets) for the available home network prefix.  The
   	trailing bits of the IPv6 prefix after the prefix length bits MUST be
   	set to zero (e.g., if the prefix length is 60, then the remaining 68
   	bits MUST be set to zero).

   	The HAAA MAY act as a central entity managing prefixes for MNs.  In
   	this case, the HAAA returns to the NAS the prefix allocated to the
   	MN.  The NAS/ASP then delivers the home link prefix to the MN using,
   	e.g., mechanisms described in [INTEGRATED].  The NAS/ASP MAY propose
   	to the HAAA a specific prefix to allocate to the MN by including the
   	MIP6-Home-Link-Prefix AVP in the request message.  However, the HAAA
   	MAY override the prefix allocation hint proposed by the NAS/ASP and
   	return a different prefix in the response message.
 */
@DiameterAvpDefinition(code = AvpCodes.MIP6_HOME_LINK_PREFIX, vendorId = -1L, name = "MIP6-Home-Link-Prefix")
public interface MIP6HomeLinkPrefix extends DiameterOctetString
{
}