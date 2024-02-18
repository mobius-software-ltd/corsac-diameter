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

import java.util.List;

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
 * 	7.2.24	Application-Server-Information AVP
	The Application-Server-Information AVP (AVP code 850) is of type Grouped and contains information about application servers visited through ISC interface. 
	It has the following ABNF grammar:
	
	<Application-Server-Information>::=	<AVP Header: 850 >
				[ Application-Server ]
			* 	[ Application-Provided-Called-Party-Address ]
				[ Status- AS-Code ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.APPLICATION_SERVER_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Application-Server-Information")
public interface ApplicationServerInformation extends DiameterAvp
{
	String getApplicationServer();
	
	void setApplicationServer(String value);
	
	List<String> getApplicationProvidedCalledPartyAddress();
	
	void setApplicationProvidedCalledPartyAddress(List<String> value);
	
	StatusASCodeEnum getStatusASCode();
	
	void setStatusASCode(StatusASCodeEnum value);
}