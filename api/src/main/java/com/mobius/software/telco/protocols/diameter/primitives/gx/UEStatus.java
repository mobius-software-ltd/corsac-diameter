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
 * 	5.3.140 UE-Status AVP (3GPP-EPS access type)
	The UE-Status AVP (AVP code 2854) is of type Unsigned32. It is sent from the PCEF to the PCRF to indicate the
	status of the UE.
	The following values are defined in this specification:

	1 (UE status suspend)
	 	This value indicates that the policy enforcement has failed because the UE is in suspend status, and that the
		PCRF should refrain from sending policy decisions to the PCEF until it is informed that the UE has been
		resumed. This value shall not be used if the IP-CAN Session Modification procedure is initiated for PCC rule
		removal only. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UE_STATUS, vendorId = VendorIDs.TGPP_ID, must = false, name = "UE-Status")
public interface UEStatus extends DiameterEnumerated<UEStatusEnum>
{
}