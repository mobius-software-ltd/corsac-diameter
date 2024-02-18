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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.14.  Credit-Control-Failure-Handling AVP (CCFH)

   The CCFH (AVP Code 427) is of type Enumerated.  The credit-control
   client uses information in this AVP to decide what to do if sending
   credit-control messages to the credit-control server has been, for
   instance, temporarily prevented due to a network problem.  Depending
   on the service logic, the credit-control server can order the client
   to terminate the service immediately when there is a reason to
   believe that the service cannot be charged, or to try failover to an
   alternative server, if possible.  The server could then either
   terminate or grant the service, should the alternative connection
   also fail.

   The following values are defined for the CCFH:

   TERMINATE             0

   When the CCFH is set to TERMINATE, the service MUST only be granted
   for as long as there is a connection to the credit-control server.
   If the credit-control client does not receive any Credit-Control-
   Answer messages before the Tx timer (as defined in Section 13)
   expires, the credit-control request is regarded as failed, and the
   end user's service session is terminated.

   This is the default behavior if the AVP isn't included in the reply
   from the authorization or credit-control server.

   CONTINUE              1

   When the CCFH is set to CONTINUE, the credit-control client SHOULD
   resend the request to an alternative server in the case of transport
   or temporary failures, provided that (1) a failover procedure is
   supported in the credit-control server and the credit-control client
   and (2) an alternative server is available.  Otherwise, the service
   SHOULD be granted, even if credit-control messages can't be
   delivered.

   RETRY_AND_TERMINATE   2

   When the CCFH is set to RETRY_AND_TERMINATE, the credit-control
   client SHOULD resend the request to an alternative server in the case
   of transport or temporary failures, provided that (1) a failover
   procedure is supported in the credit-control server and the
   credit-control client and (2) an alternative server is available.
   
   Otherwise, the service SHOULD NOT be granted when the credit-control
   messages can't be delivered.
 */
@DiameterAvpDefinition(code = AvpCodes.CREDIT_CONTROL_FAILURE_HADING, vendorId = -1L, name = "Credit-Control-Failure-Handling")
public interface CreditControlFailureHandling extends DiameterEnumerated<CreditControlFailureHandlingEnum>
{
}