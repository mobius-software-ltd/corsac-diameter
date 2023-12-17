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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.3.255  fee_fixed AVP

	AVP Name
	fee_fixed

	AVP Code
	20413
	
	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates the charge rate of each short message contained in the monthly SMS package with a limited number of short messages. When the number of short messages exceeds the limited number, the subsequent short messages must be charged by piece. It is used for monthly charging.
 */
@DiameterAvpDefinition(code = 20413L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Fee-Fixed")
public interface FeeFixed extends DiameterUnsigned32
{
}