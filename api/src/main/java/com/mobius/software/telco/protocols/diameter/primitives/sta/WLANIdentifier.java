package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.2.3.18	WLAN-Identifier
	The WLAN-Identifier AVP is of type Grouped. It contains the type and value of an IEEE 802.11 identifier of a Trusted WLAN.
	AVP Format:
	
	WLAN-Identifier ::=	< AVP Header: 1509 10415 >
		 [SSID ]
		 [HESSID ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 1509L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "WLAN-Identifier")
public interface WLANIdentifier extends DiameterGroupedAvp
{
	String getSSID();
	
	void setSSID(String value);	
	
	String getHESSID();
	
	void setHESSID(String value);
}