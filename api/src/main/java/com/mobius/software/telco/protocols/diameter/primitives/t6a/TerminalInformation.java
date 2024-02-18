package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.30	Terminal-Information
	The Terminal-Information AVP is of type Grouped. This AVP shall contain the information about the user's terminal. It is originally defined in 3GPP TS 29.272 [16].
	AVP format

	Terminal-Information ::= <AVP header: 1401 10415>
			 [ IMEI ]
			 [ Software-Version ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TERMINAL_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Terminal-Information")
public interface TerminalInformation extends DiameterGroupedAvp
{
	String getIMEI();
	
	void setIMEI(String value);
	
	String getSoftwareVersion();
	
	void setSoftwareVersion(String value);
}