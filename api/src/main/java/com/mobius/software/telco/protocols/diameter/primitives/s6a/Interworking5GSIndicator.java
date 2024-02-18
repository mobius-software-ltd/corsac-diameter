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
 * 	7.3.231	Interworking-5GS-Indicator
	The Interworking-5GS-Indicator AVP is of type Enumerated and indicates whether the interworking between 5GS and EPS is subscribed or not subscribed for the APN. See 3GPP TS 23.502 [67].
	The following values are defined:

	NOT-SUBSCRIBED (0)

	SUBSCRIBED (1)

	The default value when this AVP is not present is NOT-SUBSCRIBED (0).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.INTERNETWORKING_5GS__INDICATOR, vendorId = VendorIDs.TGPP_ID, must = false, name = "Interworking-5GS-Indicator")
public interface Interworking5GSIndicator extends DiameterEnumerated<Interworking5GSIndicatorEnum>
{
}