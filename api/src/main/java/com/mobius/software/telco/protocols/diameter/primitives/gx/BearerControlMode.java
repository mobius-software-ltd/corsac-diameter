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
 * 	5.3.23 Bearer-Control-Mode AVP
	The Bearer-Control-Mode AVP (AVP code 1023) is of type of Enumerated. It is sent from PCRF to PCEF and indicates
	the PCRF selected bearer control mode.
	The following values are defined:

	UE_ONLY (0)
 		This value is used to indicate that the UE shall request any resource establishment, modification or termination.
	RESERVED (1)
 		This value is not used in this Release.
	UE_NW (2)
 		This value is used to indicate that both the UE and PCEF may request any resource establishment, modification
		or termination by adding, modifying or removing traffic flow information.
		See Annex A.3.8 for particularities in 3GPP-GPRS access. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.BEARER_CONTROL_MODE, vendorId = VendorIDs.TGPP_ID, name = "Bearer-Control-Mode")
public interface BearerControlMode extends DiameterEnumerated<BearerControlModeEnum>
{
}