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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.222	RDS-Indicator
	The RDS-Indicator AVP is of type Enumerated and indicates whether the Reliable Data Service (RDS) is enabled or disabled for the APN. See 3GPP TS 23.682 [55].
 	The following values are defined:

	DISABLED (0)

	ENABLED (1)

	The default value when this AVP is not present is DISABLED (0).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RDS_INDICATOR, vendorId = VendorIDs.TGPP_ID, must = false, name = "RDS-Indicator")
public interface RDSIndicator extends DiameterEnumerated<RDSIndicatorEnum>
{
}