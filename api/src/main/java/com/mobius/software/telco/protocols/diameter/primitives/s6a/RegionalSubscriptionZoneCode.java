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
	7.3.52	Regional-Subscription-Zone-Code
	The Regional-Subscription-Zone-Code AVP is of type OctetString. It shall contain a Zone Code (ZC) as defined in 3GPP TS 23.003 [3], clause 4.4. Up to 10 Zone Codes per VPLMN can be defined as part of the users's subscription data.

	NOTE 1:	Each zone code represents a collection of tracking area or routing areas (defined by the operator of the VPLMN) where the user is allowed, or disallowed, to roam. The determination of which areas are actually allowed, and which ones are not allowed, is done by the serving node (MME/SGSN) in an implementation-dependent manner.

	NOTE 2:	The description of RSZI in 3GPP TS 23.003 [3] is applicable, in the context of this specification, not only to location areas, but also to routing and tracking areas.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REGIONAL_SUBSCRIPTION_ZONE_CODE, vendorId = VendorIDs.TGPP_ID, name = "Regional-Subscription-Zone-Code")
public interface RegionalSubscriptionZoneCode extends DiameterOctetString
{
}