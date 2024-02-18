package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.27 Local-Time-Zone-Indication AVP
	The Local-Time-Zone-Indication AVP is of type Enumerated. If present it indicates that the Local Time Zone
	information (time zone and daylight saving time) of the visited network where the UE is attached is requested with or
	without other location information. The following values are defined:

	ONLY_LOCAL_TIME_ZONE_REQUESTED (0)

	LOCAL_TIME_ZONE_WITH_LOCATION_INFO_REQUESTED (1)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOCAL_TIMEZONE_INDICATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Local-Time-Zone-Indication")
public interface LocalTimeZoneIndication extends DiameterEnumerated<LocalTimeZoneIndicationEnum>
{
}