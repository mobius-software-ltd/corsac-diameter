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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterFloat32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.64	Desired-Max-Latency AVP
	The Desired-Max-Latency AVP (AVP code 567) is of type Float32 and describes the maximum desirable end to end transport level packet latency in milliseconds as a zero-based integer or as a non-zero real value. The value excludes any application level processing in the sender and receivers, such as e.g. application-level retransmission or encoding/decoding.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DESIRED_MAX_LATENCY, vendorId = VendorIDs.TGPP_ID, must = false, name = "Desired-Max-Latency")
public interface DesiredMaxLatency extends DiameterFloat32
{
}