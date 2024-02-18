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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.6.10.  Acct-Tunnel-Connection AVP

   The Acct-Tunnel-Connection AVP (AVP Code 68) is of type OctetString
   and contains the identifier assigned to the tunnel session.  This
   AVP, along with the Tunnel-Client-Endpoint (Section 4.5.4) and
   Tunnel-Server-Endpoint (Section 4.5.5) AVPs, may be used to provide a
   means to uniquely identify a tunnel session for auditing purposes.

   The format of the identifier in this AVP depends upon the value of
   the Tunnel-Type AVP (Section 4.5.2).  For example, to identify an
   L2TP tunnel connection fully, the L2TP Tunnel Id and Call Id might be
   encoded in this field.  The exact encoding of this field is
   implementation dependent.
 */
@DiameterAvpDefinition(code = AvpCodes.ACCT_TUNNEL_CONNECTION, vendorId = -1L, name = "Acct-Tunnel-Connection")
public interface AcctTunnelConnection extends DiameterOctetString
{
}