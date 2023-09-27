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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.2.3.24	Access-Network-Info
	The Access-Network-Info AVP is of type Grouped.
	For a Trusted WLAN, it shall contain the SSID of the WLAN and, unless otherwise determined by the TWAN operator's policies, it shall contain at least one of the following elements:

	-	the BSSID,
	-	the civic address of the access point to which the UE is attached,
	-	the Logical Access ID (see ETSI ES 283 034 [48]) associated to the access point to which the UE is attached.

	It may also contain the name of the TWAN operator (either a PLMN-ID or an operator name in realm format).
	For an untrusted WLAN, it shall contain the same information as specified above for a trusted WLAN, where the operator name indicates the WLAN operator name.
	AVP Format:
	
	Access-Network-Info ::=	< AVP Header: 1526 10415 >
		 [ SSID ]
		 [ BSSID ]
		 [ Location-Information ]
		 [ Location-Data ]
		 [ Operator-Name ]
		 [ Logical-Access-ID ]
		*[ AVP ]

	The Location-Data and Location-Information AVPs are defined in IETF RFC 5580 [46]; the content of Location-Information shall indicate that the encoding follows a civic location profile, by setting the "Code" field to 0.
	The Operator-Name AVP is defined in IETF RFC 5580 [46]; the first 8 bits contain the Namespace ID field, whose values are managed by IANA, and are encoded as a single ASCII character. Only values "1" (Realm) and "2" (E212, containing MCC and MNC values) shall be used in this specification.
 */
@DiameterAvpDefinition(code = 1526L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Access-Network-Info")
public interface AccessNetworkInfo extends DiameterGroupedAvp
{
	String getSSID();
	
	void setSSID(String value);	
	
	String getBSSID();
	
	void setBSSID(String value);
	
	ByteBuf getLocationInformation();
	
	void setLocationInformation(ByteBuf value);
	
	ByteBuf getLocationData();
	
	void setLocationData(ByteBuf value);
	
	ByteBuf getOperatorName();
	
	void setOperatorName(ByteBuf value);
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);
}