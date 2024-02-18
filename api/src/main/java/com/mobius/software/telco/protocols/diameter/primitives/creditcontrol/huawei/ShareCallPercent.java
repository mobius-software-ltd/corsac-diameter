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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.402  Share-Call-Percent AVP

	AVP Name
	Share-Call-Percent

	AVP Code
	30023

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Percentage of the fees that the called party is entrusted to pay in the Share Call function. The value 100 indicates that the called party is entrusted to pay all the fees.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.SHARE_CALL_PERCENT, vendorId = VendorIDs.HUAWEI_ID, name = "Share-Call-Percent")
public interface ShareCallPercent extends DiameterInteger32
{
}