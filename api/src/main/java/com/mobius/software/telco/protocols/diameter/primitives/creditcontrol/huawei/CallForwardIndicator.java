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
 * 	3.2.137  Call-Forward-Indicator AVP
	
	AVP Name
	Call-Forward-Indicator

	AVP Code
	20387

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates the forwarding indicator of the called number, 0 for no forwarding and 1 for forwarding.
	In the A->B->C forwarding flow, for the B number:
    	- In the MT flow.
	In case of B forwarding unconditionally, the indicator reported in the Initial message.
	In case of B forwarding conditionally, the indicator reported in the Update or Termination message.
    	- In the MF flow, the indicator reported in the Initial message. 
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.CALL_FORWARD_INDICATOR, vendorId = VendorIDs.HUAWEI_ID, name = "Call-Forward-Indicator")
public interface CallForwardIndicator extends DiameterUnsigned32
{
}