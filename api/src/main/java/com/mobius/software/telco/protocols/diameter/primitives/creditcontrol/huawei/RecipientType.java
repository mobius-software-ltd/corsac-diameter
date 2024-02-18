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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.458  Recipient-Type AVP

	AVP Name
	Recipient-Type

	AVP Code
	30809

	AVP Data Type
	Enumerated

	Vendor ID
	2011

	Description
	Indicates recipient type of the received number.
	    - 0: MM1 (mobile)
	    - 1: MM3 (e-mail) 
	    - 5: MM4 (other operator's destination)
	    - 4: MM7 (VAS or short code)
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.RECIPIENT_TYPE, vendorId = VendorIDs.HUAWEI_ID, name = "Recipient-Type")
public interface RecipientType extends DiameterEnumerated<PremiumSmsFlagEnum>
{
}