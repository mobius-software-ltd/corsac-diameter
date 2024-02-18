package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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

import com.mobius.software.telco.protocols.diameter.HuaweiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.185  BearerProtocolType AVP

	AVP Name
	Bearer-Protocol-Type

	AVP Code
	20522

	AVP Data Type
	Integer32

	Vendor ID
	2011

	Description
	Indicates the network access type.

	The values are as follows:
	    - 01: WAP/IP
	    - 10: HTTP/TCP/IP
	    - 20: STMP
	    - 30: RTSP
	    - 40: FTP
	    - 100: ADSL/LAN
	    - 101: Dial-Up/ISDN
	    - 102: WiFi
	    - 200: GPRS/UMTS
	    - 300: CDMA
	    - 400: WiMAX
	    - 500: TD-SCDMA
	    - others to be extended
NOTE
When the interconnection between the OCS system and the AAA system is enabled. This AVP indicates the access network type.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.BEARER_PROTOCOL_TYPE, vendorId = VendorIDs.HUAWEI_ID, name = "Bearer-Protocol-Type")
public interface BearerProtocolType extends DiameterUnsigned32
{
}