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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.237C	TWAN-User-Location-Info AVP
	The TWAN-User-Location-Info AVP (AVP code 2714) is of type Grouped and contains the UE location in a Trusted WLAN Access Network (TWAN) as TWAN Identifier defined in TS 29.274 [226]  .
	It has the following ABNF grammar:

	TWAN-User-Location-Info :: = 	< AVP Header: 2714>
		{ SSID }
		[ BSSID ] 
		[ Civic-Address-Information ]
		[ WLAN-Operator-Id ]
		[ Logical-Access-ID ]
 */
@DiameterAvpDefinition(code = 2714L, vendorId = KnownVendorIDs.TGPP_ID, name = "TWAN-User-Location-Info")
public interface TWANUserLocationInfo extends DiameterAvp
{
	String getSSID();
	
	void setSSID(String value);
	
	String getBSSID();
	
	void setBSSID(String value);
	
	ByteBuf getCivicAddressInformation();
	
	void setCivicAddressInformation(ByteBuf value);
	
	WLANOperatorId getWLANOperatorId();
	
	void setWLANOperatorId(WLANOperatorId value);
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);	
}