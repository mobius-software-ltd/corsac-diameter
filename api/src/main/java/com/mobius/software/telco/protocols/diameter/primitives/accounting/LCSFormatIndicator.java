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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.88 LCS-Format-Indicator AVP
	The LCS-Format-Indicator AVP (AVP code 1237) is of type Enumerated and contains the format of the LCS Client
	name. It can be one of the following values:
	
	0 LOGICAL_NAME
	1 EMAIL_ADDRESS
	2 MSISDN
	3 URL
	4 SIP_URL
 */
@DiameterAvpDefinition(code = 1237L, vendorId = KnownVendorIDs.TGPP_ID, name = "LCS-Format-Indicator")
public interface LCSFormatIndicator extends DiameterEnumerated<LCSFormatIndicatorEnum>
{
}