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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.39	Retry-Interval AVP
	The Retry-Interval AVP (AVP code 541) is of type Unsigned32, and it indicates a time interval in seconds to wait until which the AF retries to send the same service information to the PCRF (for the same IP-CAN session) when the service information is temporarily rejected by the PCRF (e.g. due to the detected congestion status of the cell the user is located in).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RETRY_INTERVAL, vendorId = VendorIDs.TGPP_ID, must = false, name = "Retry-Interval")
public interface RetryInterval extends DiameterUnsigned32
{
}