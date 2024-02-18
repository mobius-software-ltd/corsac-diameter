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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.122 Online-Charging-Flag AVP
	The Online-Charging-Flag AVP (AVP code 2303) is of type Enumerated and indicates the Online Charging Request
	was sent based on the provided ECF address from the SIP P-header "P-Charging-Function-Addresses". It has the
	following values:

	0 ECF address not provided
	1 ECF address provided 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ONLINE_CHARGING_FLAG, vendorId = VendorIDs.TGPP_ID, name = "Online-Charging-Flag")
public interface OnlineChargingFlag extends DiameterEnumerated<OnlineChargingFlagEnum>
{
}