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
 * 8.41.  Requested-Action AVP

   The Requested-Action AVP (AVP Code 436) is of type Enumerated and
   contains the requested action being sent in a Credit-Control-Request
   command where the CC-Request-Type is set to EVENT_REQUEST.  The
   following values are defined for the Requested-Action AVP:

   DIRECT_DEBITING   0

   This indicates a request to decrease the end user's account according
   to information specified in the Requested-Service-Unit AVP and/or
   Service-Identifier AVP (additional rating information may be included
   in service-specific AVPs or in the Service-Parameter-Info AVP).  The
   Granted-Service-Unit AVP in the Credit-Control-Answer command
   contains the debited units.
   
    REFUND_ACCOUNT    1

   This indicates a request to increase the end user's account according
   to information specified in the Requested-Service-Unit AVP and/or
   Service-Identifier AVP (additional rating information may be included
   in service-specific AVPs or in the Service-Parameter-Info AVP).  The
   Granted-Service-Unit AVP in the Credit-Control-Answer command
   contains the refunded units.

   CHECK_BALANCE     2

   This indicates a balance-check request.  In this case, the checking
   of the account balance is done without any credit reservations from
   the account.  The Check-Balance-Result AVP in the Credit-Control-
   Answer command contains the result of the balance check.

   PRICE_ENQUIRY     3

   This indicates a price-inquiry request.  In this case, neither
   checking of the account balance nor reservation from the account will
   be done; only the price of the service will be returned in the
   Cost-Information AVP in the Credit-Control-Answer command.
 */
@DiameterAvpDefinition(code = 436L, vendorId = -1L, name = "Requested-Action")
public interface RequestedAction extends DiameterEnumerated<RequestedActionEnum>
{
}