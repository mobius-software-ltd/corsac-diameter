package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.216	eDRX-Cycle-Length-Value
	The eDRX-Cycle-Length-Value AVP is of type OctetString. This AVP shall contain the extended DRX cycle value subscribed for this user for a given RAT type. The contents of eDRX-Cycle-Length-Value shall consist of 1 octet.
	The encoding shall be as defined in 3GPP TS 24.008 [31], clause 10.5.5.32, and it shall only contain the value of the field "eDRX value" for a given RAT type, i.e., the 4 least significant bits of the octet in this AVP shall contain bits 1-4 of octet 3 in the "Extended DRX parameter" IE (see Figure 10.5.5.32 of 3GPP TS 24.008 [31]), and the 4 most significant bits of the octet in this AVP shall be set to 0.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.EDRX_CYCLE_LENGTH_VALUE, vendorId = VendorIDs.TGPP_ID, must = false, name = "eDRX-Cycle-Length-Value")
public interface EDRXCycleLengthValue extends DiameterOctetString
{
}