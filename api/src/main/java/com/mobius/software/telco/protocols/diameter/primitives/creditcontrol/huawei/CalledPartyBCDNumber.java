package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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

import com.mobius.software.telco.protocols.diameter.HuaweiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.297  Called-Party-BCDNumber AVP

	AVP Name
	Called-Party-BCDNumber
	
	AVP Code
	21164

	AVP Data Type
	OctetString
	Length Range: [0,32)

	Vendor ID
	2011

	Description
	IDP.Called Party BCD Number.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.CALLED_PARTY_BCD_NUMBER, vendorId = VendorIDs.HUAWEI_ID, name = "Called-Party-BCDNumber")
public interface CalledPartyBCDNumber extends DiameterOctetString
{
}