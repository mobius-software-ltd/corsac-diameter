package com.mobius.software.telco.protocols.diameter.primitives.rfc5447;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.2.1.  MIP6-Agent-Info AVP

   The MIP6-Agent-Info AVP (AVP code 486) is of type Grouped and
   contains necessary information to assign an HA to the MN.  When the
   MIP6-Agent-Info AVP is present in a message, it MUST contain either
   the MIP-Home-Agent-Address AVP, the MIP-Home-Agent-Host AVP, or both
   AVPs.  The grouped AVP has the following modified ABNF (as defined in
   [RFC3588]):

       MIP6-Agent-Info ::= < AVP-Header: 486 >
                         *2[ MIP-Home-Agent-Address ]
                           [ MIP-Home-Agent-Host ]
                           [ MIP6-Home-Link-Prefix ]
                         * [ AVP ]
                         
                         
   If both the MIP-Home-Agent-Address and MIP-Home-Agent-Host APVs are
   present in the MIP6-Agent-Info, the MIP-Home-Agent-Address SHOULD
   have a precedence over the MIP-Home-Agent-Host.  The reason for this
   recommendation is that the MIP-Home-Agent-Address points to a
   specific home agent, whereas the MIP-Home-Agent-Host may point to a
   group of HAs located within the same realm.  A Diameter client or
   agent may use the MIP-Home-Agent-Host AVP, for instance, to find out
   in which realm the HA is located.

   The ABNF allows returning up to two MIPv6 HA addresses.  This is a
   useful feature for deployments where the HA has both IPv6 and IPv4
   addresses, and particularly addresses Dual Stack Mobile IPv6
   (DSMIPv6) deployment scenarios [DSMIPv6].

   The MIP6-Agent-Info AVP MAY also be attached by the NAS or by the
   intermediating Diameter proxies in a request message when sent to the
   Diameter server as a hint of a locally assigned HA.  This AVP MAY
   also be attached by the intermediating Diameter proxies in a reply
   message from the Diameter server, if locally assigned HAs are
   authorized by the Diameter server.  There MAY be multiple instances
   of the MIP6-Agent-Info AVP in Diameter messages, for example, in
   cases where the NAS receives HA information from an MN's home network
   and locally allocated HA information from the visited network.  See
   Section 4.2.5 for further discussion on possible scenarios.
 */
@DiameterAvpDefinition(code = 486L, vendorId = -1L, name = "MIP6-Agent-Info")
public interface MIP6AgentInfo extends DiameterGroupedAvp
{
	List<InetAddress> getMIPHomeAgentAddress();
	
	void setMIPHomeAgentAddress(List<InetAddress> value);	
	
	MIPHomeAgentHost getMIPHomeAgentHost();
	
	void setMIPHomeAgentHost(MIPHomeAgentHost value);
	
	ByteBuf getMIP6HomeLinkPrefix();
	
	void setMIP6HomeLinkPrefix(ByteBuf value);
}