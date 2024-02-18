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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.49 Data-Coding-Scheme AVP
	The Data-Coding-Scheme AVP (AVP code 2001) is of type Integer32 and contains the data coding scheme of the
	message. For SM applications the specific coding is as described in TS 23.040 [216].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DATA_CODING_SCHEME, vendorId = VendorIDs.TGPP_ID, name = "Data-Coding-Scheme")
public interface DataCodingScheme extends DiameterInteger32
{
}