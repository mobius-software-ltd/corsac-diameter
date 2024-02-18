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
 * 	3.2.288  Adjust-Roaming-Type AVP

	AVP Name
	Adjust-Roaming-Type

	AVP Code
	21010

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	When calling in the boundary, whether to adjust the roaming type to no-roaming.
	    - 0: No
	    - 1: Yes
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.ADJUST_ROAMING_TYPE, vendorId = VendorIDs.HUAWEI_ID, name = "Adjust-Roaming-Type")
public interface AdjustRoamingType extends DiameterInteger32
{
}