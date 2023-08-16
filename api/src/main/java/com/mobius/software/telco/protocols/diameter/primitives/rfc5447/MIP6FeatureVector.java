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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/

/*
	4.2.5.  MIP6-Feature-Vector AVP

   	The MIP6-Feature-Vector AVP (AVP Code 124) is of type Unsigned64 and
   	contains a 64-bit flags field of supported capabilities of the NAS/
   	ASP.  Sending and receiving the MIP6-Feature-Vector AVP with value 0
   	MUST be supported, although that does not provide much guidance about
   	specific needs of bootstrapping.

   	The NAS MAY include this AVP to indicate capabilities of the NAS/ASP
   	to the Diameter server.  For example, the NAS may indicate that a
   	local HA can be provided.  Similarly, the Diameter server MAY include
   	this AVP to inform the NAS/ASP about which of the NAS/ASP indicated
   	capabilities are supported or authorized by the ASA/MSA(/MSP).

   	The following capabilities are defined in this document:
   	
   	MIP6_INTEGRATED (0x0000000000000001)

      When this flag is set by the NAS, it means that the Mobile IPv6
      integrated scenario bootstrapping functionality is supported by
      the NAS.  When this flag is set by the Diameter server, then the
      Mobile IPv6 integrated scenario bootstrapping is supported by the
      Diameter server.

   	LOCAL_HOME_AGENT_ASSIGNMENT (0x0000000000000002)

      When this flag is set in the request message, a local home agent
      outside the home realm is requested and may be assigned to the MN.
      When this flag is set by the Diameter server in the answer
      message, then the assignment of local HAs is authorized by the
      Diameter server.

      A local HA may be assigned by the NAS, LAAA, or VAAA depending on
      the network architecture and the deployment.

   	The following examples show how the LOCAL_HOME_AGENT_ASSIGNMENT
   	(referred to as LOCAL-bit in the examples) capability and the MIP-
   	Agent-Info AVP (referred to as HA-Info in the examples) are used to
   	assign HAs -- either a local HA (L-HA) or a home network HA (H-HA).
   	Below are examples of request message combinations as seen by the
   	HAAA:

    	LOCAL-bit  HA-Info  Meaning

      	0          -      ASP or [LV]AAA is not able to assign an L-HA.
      	0         L-HA    Same as above.  HA-Info must be ignored.
      	1          -      ASP or [LV]AAA can/wishes to assign an L-HA.
      	1         L-HA    Same as above but the ASP or [LV]AAA also
                        provides a hint of the assigned L-HA.

   	The same as above but for answer message combinations as seen by the
   	NAS:

  		LOCAL-bit  HA-Info  Meaning

    	0          -      No HA assignment allowed for HAAA or [LV]AAA.
    	0         H-HA    L-HA is not allowed.  HAAA assigns an H-HA.
    	1          -      L-HA is allowed.  No HAAA- or [LV]AAA-assigned HA.
    	1         L-HA    L-HA is allowed.  [LV]AAA also assigns an L-HA.
    	1         H-HA    L-HA is allowed.  HAAA also assigns an HA.
    	1         H-HA    L-HA is allowed.  HAAA assigns an H-HA and
            	+ L-HA    [LV]AAA also assigns an L-HA.

   	An NAS should expect to receive multiple MIP6-Agent-Info AVPs.
 */
@DiameterAvpDefinition(code = 124L, vendorId = -1, name = "MIP6-Feature-Vector")
public interface MIP6FeatureVector extends DiameterUnsigned64
{
}