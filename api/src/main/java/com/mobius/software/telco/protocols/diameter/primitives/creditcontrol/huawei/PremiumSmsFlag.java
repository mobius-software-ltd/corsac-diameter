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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.403  Premium-Sms-Flag AVP

	AVP Name
	Premium-Sms-Flag

	AVP Code
	30127

	AVP Data Type
	Enumerated

	Vender-ID
	2001

	Vendor Specific
	1

	Mandatory
	1

	Protected
	0 or 1

	Description
	-
 */
@DiameterAvpDefinition(code = 30127L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Premium-Sms-Flag")
public interface PremiumSmsFlag extends DiameterEnumerated<PremiumSmsFlagEnum>
{
}