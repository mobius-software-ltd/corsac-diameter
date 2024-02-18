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
 * 	3.2.236  Active-Method AVP

	AVP Name
	Active-Method

	AVP Code
	20738

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates the channel through which a subscriber activates the personal account for the first time. The OCG transfers the channel to the Convergent Billing Point(CBP) when the subscriber activates the account. The following channels are used by the OCS system:
	    - 1: IVR
	    - 2: USSD
	    - 3: SMS
	    - 4: OCS
	    - 5: WebService interface
	    - 6: GPRS
	
	The carrier can extend other channels.
 */
@DiameterAvpDefinition(code = HuaweiAvpCodes.ACTIVE_METHOD, vendorId = VendorIDs.HUAWEI_ID, name = "Active-Method")
public interface ActiveMethod extends DiameterUnsigned32
{
}