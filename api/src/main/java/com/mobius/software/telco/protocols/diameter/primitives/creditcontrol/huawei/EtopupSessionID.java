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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.238  Etopup-Session-ID AVP

	AVP Name
	Etopup-Session-ID

	AVP Code
	20740
	
	AVP Data Type
	UTF8String
	Length Range: [0,20)

	Vendor ID
	2011

	Description
	Indicates the ID that uniquely identifies an E-topup transaction.
	The value of this parameter is also transferred in for account reconciliation when the UVC is directly connected to the CBP for recharge.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.ETOPUP_SESSION_ID, vendorId = VendorIDs.HUAWEI_ID, name = "Etopup-Session-ID")
public interface EtopupSessionID extends DiameterUTF8String
{
}