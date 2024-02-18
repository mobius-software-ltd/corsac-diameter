package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.95A	Location-Info AVP
	The Location-Info AVP (AVP code 3460) is of type Grouped and provides information on the location (i.e., ECGI) and associated time for the change to that location.
	It has the following ABNF grammar:

	Location-Info :: = < AVP Header: 3460>
		[ 3GPP-User-Location-Info ]
		[ Change-Time ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOCATION_INFO, vendorId = VendorIDs.TGPP_ID, name = "Location-Info")
public interface LocationInfo extends DiameterAvp
{
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
}