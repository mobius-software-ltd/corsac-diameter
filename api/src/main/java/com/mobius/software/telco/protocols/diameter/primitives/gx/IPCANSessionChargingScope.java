package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.114 IP-CAN-Session-Charging-Scope AVP
	The IP-CAN-Session-Charging-Scope AVP (AVP code 2827) is of type Enumerated, and indicates that the AccessNetwork-Charging-Identifier-Gx AVP applies to the whole IP-CAN Session. The following values are defined:

	IP-CAN_SESSION_SCOPE (0)
 		This value indicates that the charging identifier corresponds to the IP-CAN Session
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IPCAN_SESSION_CHARGING_SCOPE, vendorId = VendorIDs.TGPP_ID, must = false, name = "IP-CAN-Session-Charging-Scope")
public interface IPCANSessionChargingScope extends DiameterEnumerated<IPCANSessionChargingScopeEnum>
{
}