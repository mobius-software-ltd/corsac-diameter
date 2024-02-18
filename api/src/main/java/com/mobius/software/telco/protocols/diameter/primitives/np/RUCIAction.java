package com.mobius.software.telco.protocols.diameter.primitives.np;
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
 * 	5.3.14	RUCI-Action AVP
	The RUCI-Action AVP (AVP code 4012) is of type Unsigned32, and it is used to disable or enable RUCI reporting between the PCRF and RCAF or to release the context for a specific user id and PDN ID.
	The following values are defined:

	0 (Disable RUCI reporting):
	This value shall be used by the PCRF to indicate to the RCAF that RUCI reporting shall not be performed for a specific user id and PDN ID.

	1 (Enable RUCI reporting):
	This value shall be used by the PCRF to indicate to the RCAF that RUCI reporting shall be performed for a specific user id and PDN ID.

	2 (Release Context):
	This value shall be used by the PCRF to indicate to the RCAF that the context shall be released for a specific user id and PDN ID.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RUCI_ACTION, vendorId = VendorIDs.TGPP_ID, must = false, name = "RUCI-Action")
public interface RUCIAction extends DiameterEnumerated<RUCIActionEnum>
{
}