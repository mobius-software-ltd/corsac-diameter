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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.104	Message-Class AVP
	The Message-Class AVP (AVP code 1213) is of type Grouped. 
	It has the following ABNF grammar:
	
	Message-Class :: = < AVP Header: 1213 >
		 [ Class-Identifier ]
		 [ Token-Text ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MESSAGE_CLASS, vendorId = VendorIDs.TGPP_ID, name = "Message-Class")
public interface MessageClass extends DiameterAvp
{
	ClassIdentifierEnum getClassIdentifier();
	
	void setClassIdentifier(ClassIdentifierEnum value);
	
	String getTokenText();
	
	void setTokenText(String value);
}