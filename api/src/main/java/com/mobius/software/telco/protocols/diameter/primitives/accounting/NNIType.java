package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.112B NNI-Type AVP
	The NNI-Type AVP (AVP code 2704) is of type Enumerated and indicates whether the type of used NNI is nonroaming, roaming without loopback routing or roaming with loopback routing. It has the following values:
 	
 	0 non-roaming
 	1 roaming without loopback
 	2 roaming with loopback 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NNI_TYPE, vendorId = VendorIDs.TGPP_ID, name = "NNI-Type")
public interface NNIType extends DiameterEnumerated<NNITypeEnum>
{
}