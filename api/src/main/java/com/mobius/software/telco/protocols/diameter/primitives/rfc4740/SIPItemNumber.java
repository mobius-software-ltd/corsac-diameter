package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	9.5.2.  SIP-Item-Number AVP

   	The SIP-Item-Number (AVP Code 378) is of type Unsigned32 and is
   	included in a SIP-Auth-Data-Item grouped AVP in circumstances where
   	there are multiple occurrences of SIP-Auth-Data-Item AVPs and the
   	order of processing is relevant.  The AVP indicates the order in
   	which the Grouped SIP-Auth-Data-Item should be processed.  Lower
   	values of the SIP-Item-Number AVP indicate that the whole
   	SIP-Auth-Data-Item SHOULD be processed before other
   	SIP-Auth-Data-Item AVPs that contain higher values in the
   	SIP-Item-Number AVP.
 */
@DiameterAvpDefinition(code = 378L, vendorId = -1, name = "SIP-Item-Number")
public interface SIPItemNumber extends DiameterUnsigned32
{
}