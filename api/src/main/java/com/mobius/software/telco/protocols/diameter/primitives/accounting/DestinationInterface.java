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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.53	Destination-Interface AVP
	The Destination-Interface AVP (AVP code 2002) is type Grouped, which contains information related to the Interface on which the message is to be delivered.

	Destination-Interface ::= < AVP Header: 2002 >
		  [ Interface-Id ]
		  [ Interface-Text ]
		  [ Interface-Port ]
		  [ Interface-Type ]
 */
@DiameterAvpDefinition(code = 2002L, vendorId = KnownVendorIDs.TGPP_ID, name = "Destination-Interface")
public interface DestinationInterface extends DiameterAvp
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