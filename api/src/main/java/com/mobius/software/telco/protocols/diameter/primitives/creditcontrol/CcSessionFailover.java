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
 * 8.4.  CC-Session-Failover AVP

   The CC-Session-Failover AVP (AVP Code 418) is of type Enumerated and
   contains information as to whether moving the credit-control message
   stream to a backup server during an ongoing credit-control session is
   supported.  In the case of communication failures, the credit-control
   message streams can be moved to an alternative destination if the
   credit-control server supports failover to an alternative server.
   The secondary credit-control server name, if received from the home
   Diameter AAA server, can be used as an address of the backup server.
   An implementation is not required to support moving a credit-control
   message stream to an alternative server, as this also requires moving
   information related to the credit-control session to the backup
   server.

   The following values are defined for the CC-Session-Failover AVP:

   FAILOVER_NOT_SUPPORTED   0

   When the CC-Session-Failover AVP is set to FAILOVER_NOT_SUPPORTED,
   the credit-control message stream MUST NOT be moved to an alternative
   destination in the case of a communication failure.  This is the
   default behavior if the AVP isn't included in the reply from the
   authorization or credit-control server.

   FAILOVER_SUPPORTED       1

   When the CC-Session-Failover AVP is set to FAILOVER_SUPPORTED, the
   credit-control message stream SHOULD be moved to an alternative
   destination in the case of a communication failure.  Moving the
   credit-control message stream to a backup server MAY require that
   information related to the credit-control session should also be
   forwarded to an alternative server.
 */
@DiameterAvpDefinition(code = 418L, vendorId = -1L, name = "CC-Session-Failover")
public interface CcSessionFailover extends DiameterEnumerated<CcSessionFailoverEnum>
{
}