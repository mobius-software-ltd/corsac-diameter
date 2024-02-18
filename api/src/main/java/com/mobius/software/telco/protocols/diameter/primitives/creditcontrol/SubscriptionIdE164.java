package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.59.  Subscription-Id-E164 AVP

   The Subscription-Id-E164 AVP (AVP Code 660) is of type UTF8String.
   The Subscription-Id-E164 AVP contains the international E.164 format
   (e.g., MSISDN), according to the ITU-T E.164 numbering plan defined
   in [E164] and [CE164].
 */
@DiameterAvpDefinition(code = AvpCodes.SUBSCRIPTION_ID_E164, vendorId = -1L, must = false, name = "Subscription-Id-E164")
public interface SubscriptionIdE164 extends DiameterUTF8String
{
}