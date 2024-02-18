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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.397  Personal-Pay-Notify-Mode AVP

	AVP Name
	Personal-Pay-Notify-Mode

	AVP Code
	30015

	AVP Data Type
	UTF8String
	Length Range:  [0,16)

	Vendor ID
	2011

	Description
	Individual payment notification mode.
	    - First digit: Whether the system notifies a subscriber of the individual payment mode before a call through IVR.
	            - 0: No notification
	            - 1: Only once
	            - 2: Every time
	    - Second digit: Whether the system notifies a subscriber of the individual payment mode after a call through USSD.
	            - 0: No notification
	            - 1: Only once
	            - 2: Every time
	    - Other: reserved
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.PERSONAL_PAY_NOTIFY_MODE, vendorId = VendorIDs.HUAWEI_ID, name = "Personal-Pay-Notify-Mode")
public interface PersonalPayNotifyMode extends DiameterUTF8String
{
}