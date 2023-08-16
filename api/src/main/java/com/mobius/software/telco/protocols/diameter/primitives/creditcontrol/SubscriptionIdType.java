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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.47.  Subscription-Id-Type AVP

   The Subscription-Id-Type AVP (AVP Code 450) is of type Enumerated,
   and it is used to determine which type of identifier is carried by
   the Subscription-Id AVP.

   This specification defines the following subscription identifiers.
   However, new Subscription-Id-Type values can be assigned by IANA as
   defined in Section 12.  A server MUST implement all the Subscription-
   Id-Type values required to perform credit authorization for the
   services it supports, including possible future values.  Unknown or
   unsupported Subscription-Id-Type values MUST be treated according to
   the 'M' flag rule, as defined in [RFC6733].

   END_USER_E164      0

   The identifier is in international E.164 format (e.g., MSISDN),
   according to the ITU-T E.164 numbering plan defined in [E164] and
   [CE164].

   END_USER_IMSI      1

   The identifier is in IMSI format, according to the ITU-T E.212
   identification plan as defined in [E212] and [CE212].

   END_USER_SIP_URI   2

   The identifier is in the form of a SIP URI, as defined in [RFC3261].
   
   END_USER_NAI       3

   The identifier is in the form of a Network Access Identifier, as
   defined in [RFC7542].

   END_USER_PRIVATE   4

   The identifier is a credit-control server private identifier.
 */
@DiameterAvpDefinition(code = 450L, vendorId = -1L, name = "Subscription-id-Type")
public interface SubscriptionIdType extends DiameterEnumerated<SubscriptionIdTypeEnum>
{
}