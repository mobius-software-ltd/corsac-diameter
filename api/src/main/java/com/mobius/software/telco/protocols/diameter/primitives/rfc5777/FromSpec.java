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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.5.  From-Spec AVP

   The From-Spec AVP (AVP Code 515) is a grouped AVP that specifies the
   Source Specification used to match the packet.  Zero or more of these
   AVPs may appear in the classifier.  If this AVP is absent from the
   classifier, then all packets are matched regardless of the source
   
   address.  If more than one instance of this AVP appears in the
   classifier, then the source of the packet can match any From-Spec
   AVP.  The contents of this AVP are protocol specific.

   If one instance (or multiple instances) of the IP address AVP (IP-
   Address, IP-Address-Range, IP-Address-Mask, Use-Assigned-Address)
   appears in the From-Spec AVP, then the source IP address of the
   packet MUST match one of the addresses represented by these AVPs.

   If more than one instance of the layer 2 address AVPs (MAC-Address,
   MAC-Address-Mask, EUI64-Address, EUI64-Address-Mask) appears in the
   From-Spec, then the source layer 2 address of the packet MUST match
   one of the addresses represented in these AVPs.

   If more than one instance of the port AVPs (Port, Port-Range) appears
   in the From-Spec AVP, then the source port number MUST match one of
   the port numbers represented in these AVPs.

   If the IP address, MAC address, and port AVPs appear in the same
   From-Spec AVP, then the source packet MUST match all the
   specifications, i.e., match the IP address AND MAC address AND port
   number.

   From-Spec ::= < AVP Header: 515 >
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
@DiameterAvpDefinition(code = 515L, vendorId = -1L, name = "From-Spec")
public interface FromSpec extends DiameterGroupedAvp
{
	List<InetAddress> getIPAddress();
	
	void setIPAddress(List<InetAddress> value);	
	
	List<IPAddressRange> getIPAddressRange();
	
	void setIPAddressRange(List<IPAddressRange> value);
	
	List<IPAddressMask> getIPAddressMask();
	
	void setIPAddressMask(List<IPAddressMask> value);
	
	List<ByteBuf> getMACAddress();
	
	void setMACAddress(List<ByteBuf> value);
	
	List<MACAddressMask> getMACAddressMask();
	
	void setMACAddressMask(List<MACAddressMask> value);
	
	List<ByteBuf> getEUI64Address();
	
	void setEUI64Address(List<ByteBuf> value);
	
	List<EUI64AddressMask> getEUI64AddressMask();
	
	void setEUI64AddressMask(List<EUI64AddressMask> value);
	
	List<Integer> getPort();
	
	void setPort(List<Integer> value);

	List<PortRange> getPortRange();
	
	void setPortRange(List<PortRange> value);
	
	NegatedEnum getNegated();
	
	void setNegated(NegatedEnum value);
	
	UseAssignedAddressEnum getUseAssignedAddress();
	
	void setUseAssignedAddress(UseAssignedAddressEnum value);
}