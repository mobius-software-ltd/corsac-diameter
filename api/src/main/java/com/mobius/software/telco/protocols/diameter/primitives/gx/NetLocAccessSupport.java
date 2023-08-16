package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.111 NetLoc-Access-Support AVP
	The NetLoc-Access-Support AVP (AVP code 2824) is of type Unsigned32. It indicates the level of support for NetLoc
	procedures provided by the current access network.
	The following values are defined:

	0 (NETLOC_ACCESS_NOT_SUPPORTED)
	 	This value is used when the access network currently serving the UE does not support access network
		information retrieval as described by the NetLoc feature in clause 5.4.1
*/
@DiameterAvpDefinition(code = 2824L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "NetLoc-Access-Support")
public interface NetLocAccessSupport extends DiameterEnumerated<NetLocAccessSupportEnum>
{
}