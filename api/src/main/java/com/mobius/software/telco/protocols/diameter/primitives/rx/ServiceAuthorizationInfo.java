package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.46	Service-Authorization-Info AVP
	The Service-Authorization-Info AVP (AVP code 548) is of type Unsigned32, it shall contain a bit mask and indicatethe result of the authorization for the service request from the AF. The bit 0 shall be the least significant bit. For example, to get the value of bit 0, a bit mask of 0x0001 should be used. The meaning of the bits shall be as defined below:
	
	Table 5.3.46: Service-Authorization-Info
	Bit	 Name
	Description

	0 The transfer policy is known/unknown.
	This bit, when set, indicates that the transfer policy is unknown.

	1 The transfer policy has expired/has not expired
	This bit, when set, indicates that the transfer policy has expired.

	2 The time window of the transfer policy has occurred/has not yet occurred
	This bit, when set, indicates that the time window of the transfer policy has not yet occurred.
 */
@DiameterAvpDefinition(code = 548L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Service-Authorization-Info")
public interface ServiceAuthorizationInfo extends DiameterUnsigned32
{
}