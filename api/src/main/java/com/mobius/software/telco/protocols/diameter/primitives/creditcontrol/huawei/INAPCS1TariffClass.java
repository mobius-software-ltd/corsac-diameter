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
 * 	3.2.447  INAPCS1-Tariff-Class AVP

	AVP Name
	INAPCS1-Tariff-Class

	AVP Code
	30383

	AVP Data Type
	UTF8String
	Length Range: [0,5)

	Vendor ID
	2011

	Description
	-
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.INAP_CS_TARIFF_CLASS, vendorId = VendorIDs.HUAWEI_ID, name = "INAPCS1-Tariff-Class")
public interface INAPCS1TariffClass extends DiameterUTF8String
{
}