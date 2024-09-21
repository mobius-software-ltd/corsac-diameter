package com.mobius.software.telco.protocols.diameter.primitives.cip;
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

import com.mobius.software.telco.protocols.diameter.EricssonAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/*	
	4.4.4 Charging-State-Information AVP
	The Charging-State-Information AVP (AVP code 1066) is used for storing
	the SDP service and session state in the CIP/IP Client. The content of the
	Charging-State-Information AVP is transparent to CIP/IP Client, which shall
	never modify it. The Charging-State-Information is received by CIP/IP Client in
	a Charging Interrogation Answer (CIA), and it is returned unmodified to SDP in
	a Charging Interrogation Request (CIR). The information is NOT forwarded to
	external DCC Clients. The Charging-State-Information AVP can be present on
	command level and within an MSCC.
	The Charging-State-Information AVP is of type Octetstring.
*/

@DiameterAvpDefinition(code = EricssonAvpCodes.CHARGING_STATE_INFORMATION, vendorId = VendorIDs.ERICSSON_ID, name = "Charging-State-Information")
public interface ChargingStateInformation extends DiameterOctetString
{
	
}