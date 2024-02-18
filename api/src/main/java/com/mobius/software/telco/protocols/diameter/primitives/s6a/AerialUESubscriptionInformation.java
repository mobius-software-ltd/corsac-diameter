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
 * 	7.3.224	Aerial-UE-Subscription-Information
	The Aerial-UE-Subscription-Information AVP is of type Unsigned32 and indicates the subscription of Aerial UE function. The following values are defined:

	AERIAL_UE_ALLOWED (0)

	AERIAL_UE_NOT_ALLOWED (1)

	This AVP corresponds to the "Aerial UE subscription information" information element as defined in 3GPP TS 36.413[19] and TS 36.423 [65].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AERIAL_UE_SUBSCRIPTION_INFORMATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Aerial-UE-Subscription-Information")
public interface AerialUESubscriptionInformation extends DiameterEnumerated<AerialUESubscriptionInformationEnum>
{
}