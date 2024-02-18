package com.mobius.software.telco.protocols.diameter.primitives.pc2;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
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
 * 	6.4.10	ProSe- Code-Suffix-Mask AVP
	The ProSe-Code-Suffix-Mask AVP (AVP code 3608) is of type Grouped. It contains a suffix code and one or more suffix mask(s), each of which has the same size as the suffix code.
	The AVP format shall conform to:
	ProSe-Code-Suffix-Mask ::= <AVP header:3608>
                   { Suffix-Code }
                 1*{ Suffix-Mask }
                  *[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_CODE_SUFFIX_MAX, vendorId = VendorIDs.TGPP_ID, must = false, name = "ProSe-Code-Suffix-Mask")
public interface ProSeCodeSuffixMask extends DiameterGroupedAvp
{
	ByteBuf getSuffixCode();
	
	void setSuffixCode(ByteBuf value) throws MissingAvpException;
	
	List<ByteBuf> getSuffixMask();
	
	void setSuffixMask(List<ByteBuf> value) throws MissingAvpException;
}