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
 * 	3.2.264  Call-Type AVP

	AVP Name
	Call-Type

	AVP Code
	20807

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates a call type. The values are as follows:
    	
    	- 0: On-net call
		Indicates the call between subscribers belonging to the same VPN network.
    	
    	- 1: Off-net call
		Indicates the call between a VPN subscriber and a non-VPN subscriber.
    	
    	- 2: cross-net call
		Indicates the call between subscribers belonging to different VPN networks.
    	
    	- 3: Common call (reserved)
		Indicates the call between subscribers not belonging to any VPN network.
    	
    	- 4: Off-net number group call
		Indicates the call whose calling party is a VPN subscriber and called party is a non-VPN subscriber who belongs to the non-VPN number group defined by a corporation.
    	
    	- 5: Attendant call
		Indicates the call initiated or answered by a VPN attendant.
    	
    	- 6: Charge-free call (reserved)
		Indicates the call that is free of charge.
    	
    	- 7: Closed group call
		Indicates the call between subscribers from CUG groups belonging to the same VPN network.
    	
    	- 8: super-group call
		Indicates the call between subscribers (At least one subscriber belong to the higher-level VPN network), for example, between company headquarter and its branch.
    	
    	- 9: cell based charge (reserved)
		Indicates the call that is based on the cell ID.
    	
    	- 10: AIP attendant call (reserved)
		Indicates the call initiated or answered by an AIP attendant.
    	
    	- 11: Off-net number group call at group member level
		Indicates the call, at the group member level, whose calling party is a VPN subscriber and called party is a non-VPN subscriber who belongs to the non-VPN number group defined by a corporate member.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.CALL_TYPE, vendorId = VendorIDs.HUAWEI_ID, name = "Call-Type")
public interface CallType extends DiameterUnsigned32
{
}