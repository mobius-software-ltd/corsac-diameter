package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.4	IMEI
	The IMEI AVP is of type UTF8String. This AVP shall contain the International Mobile Equipment Identity, as specified in 
	3GPP TS 23.003 [3]. It should consist of 14 digits, including the 8-digit Type Allocation Code (TAC) and the 6-digit 
	Serial Number (SNR). It may also include a 15th digit.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMEI, vendorId = VendorIDs.TGPP_ID, name = "IMEI")
public interface IMEI extends DiameterUTF8String
{
}