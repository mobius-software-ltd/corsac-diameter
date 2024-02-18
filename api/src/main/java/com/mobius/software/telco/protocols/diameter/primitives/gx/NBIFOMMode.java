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
 * 	5.3.117 NBIFOM-Mode AVP
	The NBIFOM-Mode AVP (AVP code 2830) is of type of Enumerated. When the AVP is sent from the PCEF to the
	PCRF in the initial CCR command, it indicates the NBIFOM mode suggested by the UE. When the AVP is sent from
	the PCRF to the PCEF in the CCA command, it indicates the NBIFOM mode selected by the PCRF.
	The following value is defined:

	UE_INITIATED (0)
 		IP flow mobility can be initiated by the UE.
	NETWORK_INITIATED (1)
 		IP flow mobility can be initiated by the network.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NBIFOM_MODE, vendorId = VendorIDs.TGPP_ID, must = false, name = "NBIFOM-Mode")
public interface NBIFOMMode extends DiameterEnumerated<NBIFOMModeEnum>
{
}