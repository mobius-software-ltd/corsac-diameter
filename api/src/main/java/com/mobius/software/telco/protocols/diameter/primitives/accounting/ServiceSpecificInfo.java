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
 * 	7.2.195	Service-Specific-Info AVP
	The Service-Specific-Info AVP (AVP Code 1249) is of type Grouped and holds service specific data if and as provided by an Application Server, for IMS charging, a PCEF only for pre-defined PCC rules for PS domain charging, or a Proxy function for VCS charging.
	It has the following ABNF grammar:
	
	Service-Specific-Info  ::=	   < AVP Header: 1249 >
   		[ Service-Specific-Data ]
   		[ Service-Specific-Type ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_SPECIFIC_INFO, vendorId = VendorIDs.TGPP_ID, name = "Service-Specific-Info")
public interface ServiceSpecificInfo extends DiameterAvp
{
	String getServiceSpecificData();
	
	void setServiceSpecificData(String value);
	
	Long getServiceSpecificType();
	
	void setServiceSpecificType(Long value);
}