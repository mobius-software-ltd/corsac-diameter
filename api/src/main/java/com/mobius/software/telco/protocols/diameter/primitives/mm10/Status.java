package com.mobius.software.telco.protocols.diameter.primitives.mm10;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.19	Status AVP
	The Status AVP (AVP code 1116) is of type Grouped. It contains message status information to allow notification of the served user. At least one of both AVP Status-Code and Status-Text shall be present.

	Status ::= <AVP header: 1116 10415>
		[Status-Code]
		[Status-Text]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.STATUS, vendorId = VendorIDs.TGPP_ID, name = "Status")
public interface Status extends DiameterAvp
{
	String getStatusCode();
	
	void setStatusCode(String value);	
	
	String getStatusText();
	
	void setStatusText(String value);
}