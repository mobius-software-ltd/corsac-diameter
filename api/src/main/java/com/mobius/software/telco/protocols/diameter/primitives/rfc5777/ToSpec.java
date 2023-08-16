package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.6.  To-Spec AVP

   The To-Spec AVP (AVP Code 516) is a grouped AVP that specifies the
   Destination Specification used to match the packet.  Zero or more of
   these AVPs may appear in the classifier.  If this AVP is absent from
   the classifier, then all packets are matched regardless of the
   destination address.  If more than one instance of this AVP appears
   in the classifier, then the destination of the packet can match any
   To-Spec AVP.  The contents of this AVP are protocol specific.
   
   
   If one instance (or multiple instances) of the IP address AVP (IP-
   Address, IP-Address-Range, IP-Address-Mask, Use-Assigned-Address)
   appears in the To-Spec AVP, then the destination IP address of the
   packet MUST match one of the addresses represented by these AVPs.

   If more than one instance of the layer 2 address AVPs (MAC-Address,
   MAC-Address-Mask, EUI64-Address, EUI64-Address-Mask) appears in the
   To-Spec, then the destination layer 2 address of the packet MUST
   match one of the addresses represented in these AVPs.

   If more than one instance of the port AVPs (Port, Port-Range) appears
   in the To-Spec AVP, then the destination port number MUST match one
   of the port numbers represented in these AVPs.

   If the IP address, MAC address, and port AVPs appear in the same To-
   Spec AVP, then the destination packet MUST match all the
   specifications, i.e., match the IP address AND MAC address AND port
   number.

   To-Spec ::= < AVP Header: 516 >
             * [ IP-Address ]
             * [ IP-Address-Range ]
             * [ IP-Address-Mask ]
             * [ MAC-Address ]
             * [ MAC-Address-Mask]
             * [ EUI64-Address ]
             * [ EUI64-Address-Mask]
             * [ Port ]
             * [ Port-Range ]
               [ Negated ]
               [ Use-Assigned-Address ]
             * [ AVP ]
 */
@DiameterAvpDefinition(code = 516L, vendorId = -1L, name = "To-Spec")
public interface ToSpec extends FromSpec
{	
}