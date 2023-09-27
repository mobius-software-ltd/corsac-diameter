package com.mobius.software.telco.protocols.diameter.primitives.np;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	5.3.11	IMSI-List AVP
	The IMSI-List AVP (AVP code 4009) is of type OctetString, and it contains a list of user ids identified by IMSI. Each IMSI shall be encoded as TBCD digits as defined in ITU-T Recommendation E.212 [13], i.e. digits from 0 through 9 are encoded "0000" to "1001". Each IMSI shall be encoded as 8 octets. If the length of the IMSI is 14, then the last octet shall be encoded as "1111 1111". If the length of the IMSI is 15, bits 5 to 8 of the last octet shall be encoded with the filler "1111". The maximum number of digits is 15. An example of the encoding of the IMSI List as the data part of the OctetString AVP is given below in Figure 5.3.11-1. Octet 1 given below is the first octet of the data part of the IMSI-List AVP.


	Octets  Bits
		    8      7      6      5      4      3      2      1
	1 		Number digit 2 of IMSI-1    Number digit 1 of IMSI-1
	2		Number digit 4 of IMSI-1	Number digit 3 of IMSI1
	…
	…
	…
	8		1111						Number digit 15 of IMSI-1
	9		Number digit 2 of IMSI-2	Number digit 1 of IMSI-2
	10		Number digit 4 of IMSI-2	Number digit 3 of IMSI-2
	…
	…
	…
	15		Number digit 14 of IMSI-2	Number digit 13 of IMSI-2
	16		1111						1111
	17		Number digit 2 of IMSI-3	Number digit 1 of IMSI-3
	18		Number digit 4 of IMSI-3	Number digit 3 of IMSI-3
	…
	…
	…
	23		Number digit 14 of IMSI-3	Number digit 13 of IMSI-3
	24		1111						1111
	…
	…
	…		
  (n-1)*8+1 Number digit 2 of IMSI-n	Number digit 1 of IMSI-n
  (n-1)*8+2 Number digit 4 of IMSI-n	Number digit 3 of IMSI-n
	…
	…
	…
  (n-1)*8+8 1111						Number digit 15 of IMSI-n


	NOTE:	In the above figure showing an example of encoding, it is assumed that n IMSIs are included in the IMSI-List AVP. The digit length of IMSI-1, IMSI-2, IMSI-3 and IMSI-n are 15, 14, 14, 15 respectively. 
*/
@DiameterAvpDefinition(code = 4009L, vendorId = KnownVendorIDs.TGPP_ID, name = "IMSI-List")
public interface IMSIList extends DiameterOctetString
{
}