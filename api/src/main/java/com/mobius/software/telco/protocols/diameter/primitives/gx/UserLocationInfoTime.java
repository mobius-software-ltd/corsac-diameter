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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.101 User-Location-Info-Time AVP
	The User-Location-Info-Time AVP (AVP Code 2812) is of type Time, and it contains the NTP time at which the UE
	was last known to be in the location. The User-Location-Info-Time AVP is sent from the PCEF to the PCRF. The PCRF
	forwards it to the AF. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USER_LOCATION_INFO_TIME, vendorId = VendorIDs.TGPP_ID, must = false, name = "User-Location-Info-Time")
public interface UserLocationInfoTime extends DiameterTime
{
}