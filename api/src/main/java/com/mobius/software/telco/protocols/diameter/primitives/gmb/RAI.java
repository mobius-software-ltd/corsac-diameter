package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
	17.7.12	RAI AVP
	The RAI AVP (AVP Code 909) is of type UTF8String, and contains the Routing Area Identity of the SGSN where the UE is registered. RAI use and structure is specified in 3GPP TS 23.003 [40].
	Its value shall be encoded as a UTF-8 string on either 11 (if the MNC contains two digits) or 12 (if the MNC contains three digits) octets as follows:

	-	The MCC shall be encoded first using three UTF-8 characters on three octets, each character representing a decimal digit starting with the first MCC digit.

	-	Then, the MNC shall be encoded as either two or three UTF-8 characters on two or three octets, each character representing a decimal digit starting with the first MNC digit.

	-	The Location Area Code (LAC) is encoded next using four UTF-8 characters on four octets, each character representing a hexadecimal digit of the LAC which is two binary octets long.

	-	The Routing Area Code (RAC) is encoded last using two UTF-8 characters on two octets, each character representing a hexadecimal digit of the RAC which is one binary octet long.

	NOTE:	As an example, a RAI with the following information: MCC=123, MNC=45, LAC=41655(0xA2C1) and RAC=10(0x0A) is encoded within the RAI AVP as a UTF-8 string of "12345A2C10A".
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RAI, vendorId = VendorIDs.TGPP_ID, name = "RAI")
public interface RAI extends DiameterUTF8String
{
}