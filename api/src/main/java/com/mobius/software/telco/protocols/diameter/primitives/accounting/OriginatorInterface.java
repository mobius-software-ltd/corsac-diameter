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
 * 	7.2.126	Originator-Interface AVP
	The Originator-Interface AVP (AVP code 2009) is the group AVP which contains information related to the Interface on which the message originated.
	It has the following ABNF grammar:

	Originator-Interface ::= < AVP Header: 2009 >
			[ Interface-Id ]
			[ Interface-Text ]
			[ Interface-Port ]
			[ Interface-Type ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ORIGINATOR_INTERFACE, vendorId = VendorIDs.TGPP_ID, name = "Originator-Interface")
public interface OriginatorInterface extends DiameterAvp
{
	String getInterfaceId();
	
	void setInterfaceId(String value);
	
	String getInterfaceText();
	
	void setInterfaceText(String value);
	
	String getInterfacePort();
	
	void setInterfacePort(String value);
	
	InterfaceTypeEnum getInterfaceType();
	
	void setInterfaceType(InterfaceTypeEnum value);
}