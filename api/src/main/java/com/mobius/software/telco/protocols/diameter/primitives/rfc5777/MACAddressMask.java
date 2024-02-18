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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.7.9.  MAC-Address-Mask AVP

   The MAC-Address-Mask AVP (AVP Code 525) is of type Grouped and
   specifies a set of MAC addresses using a bit mask to indicate the
   bits of the MAC addresses that must fit to the specified MAC address
   attribute.  For example, a MAC-Address-Mask with the MAC-Address as
   00-10-A4-23-00-00 and with a MAC-Address-Mask-Pattern of FF-FF-FF-FF-
   00-00 will match all MAC addresses from 00-10-A4-23-00-00 up to and
   including 00-10-A4-23-FF-FF.

   Appendix A describes the considerations that should be given to the
   use of MAC address masks in constructing classifiers.

   MAC-Address-Mask ::= < AVP Header: 525 >
                        { MAC-Address }
                        { MAC-Address-Mask-Pattern }
                      * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.MAC_ADDRESS_MASK, vendorId = -1L, name = "MAC-Address-Mask")
public interface MACAddressMask extends DiameterGroupedAvp
{
	ByteBuf getMACAddress();
	
	void setMACAddress(ByteBuf value) throws MissingAvpException;	
	
	ByteBuf getMACAddressMaskPattern();
	
	void setMACAddressMaskPattern(ByteBuf value) throws MissingAvpException;	
}