package com.mobius.software.telco.protocols.diameter.primitives.sgmb;
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
 * 	120.5a.1	MBMS-Access-Indicator AVP
	The MBMS-Access-Indicator AVP (AVP code 923) is of type Enumerated. It indicates whether the MBMS bearer service will be delivered in UTRAN-only, E-UTRAN-only or both coverage areas. The following values are supported:
	
	UTRAN (0)
	The MBMS bearer service shall only be delivered in UTRAN only coverage areas.

	E-UTRAN (1)
	The MBMS bearer service shall only be delivered in E-UTRAN only coverage areas.

	UTRAN-AND-E-UTRAN (2)
	The MBMS bearer service shall be delivered both in UTRAN and E-UTRAN coverage areas.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_ACCESS_INDICATOR, vendorId = VendorIDs.TGPP_ID, name = "MBMS-Access-Indicator")
public interface MBMSAccessIndicator extends DiameterEnumerated<MBMSAccessIndicatorEnum>
{
}