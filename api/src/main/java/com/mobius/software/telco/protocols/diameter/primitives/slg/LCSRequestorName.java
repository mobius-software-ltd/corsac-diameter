package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSFormatIndicatorEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.4	LCS-Requestor-Name
	The LCS-Requestor-Name AVP is of type Grouped.
	AVP format:

	LCS-Requestor-Name ::= <AVP header: 2502 10415>
			[ LCS-Requestor-Id-String ]
			[ LCS-Format-Indicator ]

	The details of the LCS-Requestor-Id-String AVP and the LCS-Format-Indicator AVP are described in 3GPP TS 32.299 [10].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LCS_REQUESTOR_NAME, vendorId = VendorIDs.TGPP_ID, name = "LCS-Requestor-Name")
public interface LCSRequestorName extends DiameterAvp
{
	String getLCSRequestorIDString();
	
	void setLCSRequestorIDString(String value);
	
	LCSFormatIndicatorEnum getLCSFormatIndicator();
	
	void setLCSFormatIndicator(LCSFormatIndicatorEnum value);
}