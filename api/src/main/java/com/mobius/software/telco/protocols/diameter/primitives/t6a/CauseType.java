package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
 * 	6.4.5	Cause-Type
	The Cause-Type AVP is of type Unsigned32 and it shall identify the type of the S1AP-Cause. The following values are defined:

	RADIO_NETWORK_LAYER (0)

	TRANSPORT_LAYER (1)

	NAS (2)

	PROTOCOL (3)

	MISCELLANEOUS (4)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CAUSE_TYPE, vendorId = VendorIDs.TGPP_ID, name = "Cause-Type")
public interface CauseType extends DiameterEnumerated<CauseTypeEnum>
{
}