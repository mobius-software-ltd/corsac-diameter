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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.7.3.  IP-Address-Range AVP

   The IP-Address-Range AVP (AVP Code 519) is of type Grouped and
   specifies an inclusive IP address range.

   IP-Address-Range ::= < AVP Header: 519 >
                        [ IP-Address-Start ]
                        [ IP-Address-End ]
                      * [ AVP ]

   If the IP-Address-Start AVP is not included, then the address range
   starts from the first valid IP address up to and including the
   specified IP-Address-End address.

   If the IP-Address-End AVP is not included, then the address range
   starts at the address specified by the IP-Address-Start AVP and
   includes all the remaining valid IP addresses.

   For the IP-Address-Range AVP to be valid, the IP-Address-Start AVP
   MUST contain a value that is less than that of the IP-Address-End
   AVP.
 */
@DiameterAvpDefinition(code = AvpCodes.IP_ADDRESS_RANGE, vendorId = -1L, name = "IP-Address-Range")
public interface IPAddressRange extends DiameterGroupedAvp
{
	InetAddress getIPAddressStart();
	
	void setIPAddressStart(InetAddress value);	
	
	InetAddress getIPAddressEnd();
	
	void setIPAddressEnd(InetAddress value);	
}