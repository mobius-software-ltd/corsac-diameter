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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.7.6.  IP-Address-Mask AVP

   The IP-Address-Mask AVP (AVP Code 522) is of type Grouped and
   specifies an IP address range using a base IP address and the bit-
   width of the mask.  For example, a range expressed as 192.0.2.0/24
   will match all IP addresses from 192.0.2.0 up to and including
   192.0.2.255.  The bit-width MUST be valid for the type of IP address.

   IP-Address-Mask ::= < AVP Header: 522 >
                       { IP-Address }
                       { IP-Bit-Mask-Width }
                     * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.IP_ADDRESS_MASK, vendorId = -1L, name = "IP-Address-Mask")
public interface IPAddressMask extends DiameterGroupedAvp
{
	InetAddress getIPAddress();
	
	void setIPAddress(InetAddress value) throws MissingAvpException;	
	
	Long getIPBitMaskWidth();
	
	void setIPBitMaskWidth(Long value) throws MissingAvpException;	
}