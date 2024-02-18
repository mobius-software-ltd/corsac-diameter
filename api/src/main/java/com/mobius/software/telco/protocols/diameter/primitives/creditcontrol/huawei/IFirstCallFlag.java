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
 * 	3.3.638  IFirstCallFlag AVP

	AVP Name
	IFirstCallFlag

	AVP Code
	30050

	AVP Data Type
	UTF8String

	Vendor ID
	2011

	Description
	Indicates whether the call is the first call.

	0: yes (The RB updates the attribute and returns the attribute to the OM.)
	1: no (The RB is 1 by default and is not updated for a non-first call.)
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.IFIRST_CALL_FLAG, vendorId = VendorIDs.HUAWEI_ID, name = "I-First-Call-Flag")
public interface IFirstCallFlag extends DiameterUTF8String
{
}