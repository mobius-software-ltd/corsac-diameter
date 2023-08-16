package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.6.8.  Acct-Delay-Time AVP

   The Acct-Delay-Time AVP (AVP Code 41) is of type Unsigned32 and
   indicates the number of seconds the Diameter client has been trying
   to send the Accounting-Request (ACR).  The accounting server may
   subtract this value from the time when the ACR arrives at the server
   to calculate the approximate time of the event that caused the ACR to
   be generated.
   This AVP is not used for retransmissions at the transport level (TCP
   or SCTP).  Rather, it may be used when an ACR command cannot be
   transmitted because there is no appropriate peer to transmit it to or
   it was rejected because it could not be delivered.  In these cases,
   the command MAY be buffered and transmitted later, when an
   appropriate peer-connection is available or after sufficient time has
   passed that the destination-host may be reachable and operational.
   If the ACR is re-sent in this way, the Acct-Delay-Time AVP SHOULD be
   included.  The value of this AVP indicates the number of seconds that
   elapsed between the time of the first attempt at transmission and the
   current attempt.
 */
@DiameterAvpDefinition(code = 41L, vendorId = -1L, name = "Acct-Delay-Time")
public interface AcctDelayTime extends DiameterUnsigned32
{
}