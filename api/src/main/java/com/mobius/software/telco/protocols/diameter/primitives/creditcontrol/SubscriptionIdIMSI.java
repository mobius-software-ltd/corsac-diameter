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
 * 8.60.  Subscription-Id-IMSI AVP

   The Subscription-Id-IMSI AVP (AVP Code 661) is of type UTF8String.
   The Subscription-Id-IMSI AVP contains the IMSI format, according to
   the ITU-T E.212 identification plan as defined in [E212] and [CE212].
 */
@DiameterAvpDefinition(code = AvpCodes.SUBSCRIPTION_ID_IMSI, vendorId = -1L, must = false, name = "Subscription-Id-IMSI")
public interface SubscriptionIdIMSI extends DiameterUTF8String
{
}