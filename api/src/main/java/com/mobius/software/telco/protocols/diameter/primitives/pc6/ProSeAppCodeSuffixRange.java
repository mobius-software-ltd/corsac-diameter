package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.82	ProSe-App-Code-Suffix-Range 
	The ProSe-App-Code-Suffix-Range AVP is of type Grouped. It contains a range of consecutive ProSe Application Code Suffixes that can be appended to a ProSe Application Code Prefix. It shall contain a Beginning Suffix and may contain an Ending Suffix. If the Ending Suffix is not present, the only ProSe Application Code Suffix included in the ProSe Application Code Suffix Range is equal to the Beginning Suffix.
	The AVP format shall conform to:
		
	ProSe-App-Code-Suffix-Range ::=		<AVP header: 3867 10415>
		 { Beginning-Suffix }
		 [ Ending–Suffix ]
		*[AVP]
	
	Beginning Suffix and Ending Suffix shall have the same length.
 */
@DiameterAvpDefinition(code = 3867L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "ProSe-Restricted-Code-Suffix-Range")
public interface ProSeAppCodeSuffixRange extends DiameterGroupedAvp
{
	ByteBuf getBeginningSuffix();
	
	void setBeginningSuffix(ByteBuf value);
	
	ByteBuf getEndingSuffix();
	
	void setEndingSuffix(ByteBuf value);
}