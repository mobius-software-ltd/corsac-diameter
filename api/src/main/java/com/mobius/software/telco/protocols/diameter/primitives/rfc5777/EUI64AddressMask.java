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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.7.12.  EUI64-Address-Mask AVP

   The EUI64-Address-Mask AVP (AVP Code 528) is of type Grouped and
   specifies a set of EUI64 addresses using a bit mask to indicate the
   bits of the EUI64 addresses that must fit to the specified EUI64
   address attribute.  For example, a EUI64-Address-Mask with the EUI64-
   Address as 00-10-A4-FF-FE-23-00-00 and with a EUI64-Address-Mask-
   Pattern of FF-FF-FF-FF-FF-FF-00-00 will match all EUI64 addresses
   from 00-10-A4-FF-FE-23-00-00 up to and including 00-10-A4-FF-FE-23-
   FF-FF.

   Appendix A describes the considerations that should be given to the
   use of EUI64 address masks in constructing classifiers.

   EUI64-Address-Mask ::= < AVP Header: 528 >
                          { EUI64-Address }
                          { EUI64-Address-Mask-Pattern }
                        * [ AVP ]
 */
@DiameterAvpDefinition(code = 528L, vendorId = -1L, name = "EUI64-Address-Mask")
public interface EUI64AddressMask extends DiameterGroupedAvp
{
	ByteBuf getEUI64Address();
	
	void setEUI64Address(ByteBuf value);	
	
	ByteBuf getEUI64AddressMaskPattern();
	
	void setEUI64AddressMaskPattern(ByteBuf value);	
}