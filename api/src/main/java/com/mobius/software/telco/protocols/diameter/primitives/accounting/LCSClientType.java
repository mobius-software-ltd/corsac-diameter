package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.86 LCS-Client-Type AVP
	The LCS-Client-Type AVP (AVP code 1241) is of type Enumerated and contains the type of services requested by the
	LCS Client. It can be one of the following values:
	
	0 EMERGENCY_SERVICES
	1 VALUE_ADDED_SERVICES
	2 PLMN_OPERATOR_SERVICES
	3 LAWFUL_INTERCEPT_SERVICES
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LCS_CLIENT_TYPE, vendorId = VendorIDs.TGPP_ID, name = "LCS-Client-Type")
public interface LCSClientType extends DiameterEnumerated<LCSClientTypeEnum>
{
}