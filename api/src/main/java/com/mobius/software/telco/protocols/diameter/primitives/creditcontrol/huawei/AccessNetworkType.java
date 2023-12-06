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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.262  Access-Network-Type AVP

	AVP Name
	Access-Network-Type

	AVP Code
	20804

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates the network access type.
	The values are as follows:
	    - 100: PSTN
	    - 101: PBX
	    - 102: PHS
	    - 200: GSM
	    - 201: GPRS
	    - 202: EDGE
	    - 300: CDMA
	    - 301: CDMA 450
	    - 400: WCDMA
	    - 500: TD-SCDMA
	    - 600: IP/IMS
	    - 601: WIFI
	    - 602: WIMAX
	
	Others are to be extended.
	NOTE
	    - PSTN: Public Switched Telephone Network
	    - PBX: Private Branch Exchange
	    - PHS: Personal Handyphone System
	    - GSM: Global System for Mobile communications
	    - EDGE: Enhanced Data rates for GSM Evolution
	    - TD-SCDMA: Time Division-Synchronous Code Division Multiple Access
	    - WIFI: Wireless Fidelity
	    - WIMAX: Worldwide Interpretability for Microwave Access  
 */
@DiameterAvpDefinition(code = 20804L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Access-Network-Type")
public interface AccessNetworkType extends DiameterUnsigned32
{
}