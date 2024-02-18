package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.156	Local-Time-Zone
	The Local-Time-Zone AVP is of type Grouped and shall contain the Time Zone and the Daylight Saving Time (DST) adjustment of the location in the visited network where the UE is attached.
	The AVP format shall conform to:
	
	Local-Time-Zone ::= <AVP header: 1649 10415>
			 { Time-Zone }
			 { Daylight-Saving-Time }
			* [ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOCAL_TIMEZONE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Local-Time-Zone")
public interface LocalTimeZone extends DiameterGroupedAvp
{
	String getTimeZone();
	
	void setTimeZone(String value) throws MissingAvpException;	
	
	DaylightSavingTimeEnum getDaylightSavingTime();
	
	void setDaylightSavingTime(DaylightSavingTimeEnum value) throws MissingAvpException;
}