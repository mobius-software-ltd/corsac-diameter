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
 * 	5.3.133 3GPP-PS-Data-Off-Status AVP (Applicable access type 3GPP-EPS)
	The 3GPP-PS-Data-Off-Status AVP (AVP code 2847) is of type Enumerated, and describes the 3GPP PS Data off
	status indicated by the UE.
	The following values are defined:

	ACTIVE (0)
 		This value is used to indicate that the UE activates the 3GPP PS Data off.
	INACTIVE (1)
 		This value is used to indicate that the UE deactivates the 3GPP PS Data off. This is the default value applicable
		if this AVP has not been supplied yet. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TGPP_PS_DATA_OFF_STATUS, vendorId = VendorIDs.TGPP_ID, must = false, name = "3GPP-PS-Data-Off-Status")
public interface TGPPPSDataOffStatus extends DiameterEnumerated<TGPPPSDataOffStatusEnum>
{
}