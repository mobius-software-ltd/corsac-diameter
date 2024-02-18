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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger64;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.342  Parent-Limit-Value AVP

	AVP Name
	Parent-Limit-Value

	AVP Code
	21220

	AVP Data Type
	Integer64

	Vendor ID
	2011

	Description
	It is used in the balance query process. Payment limit that the parent card subscriber assigns to the special child card subscriber if the calling party is a special child card subscriber. If there are multiple payment limit records, only one record is returned. If there is no payment limit, value 0 is returned.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.PARENT_LIMIT_VALUE, vendorId = VendorIDs.HUAWEI_ID, name = "Parent-Limit-Value")
public interface ParentLimitValue extends DiameterInteger64
{
}