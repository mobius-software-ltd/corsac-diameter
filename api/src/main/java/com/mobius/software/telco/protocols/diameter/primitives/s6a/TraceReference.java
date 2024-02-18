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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.64	Trace-Reference AVP
	The Trace-Reference AVP is of type OctetString. This AVP shall contain the concatenation of MCC, MNC and Trace ID, where the Trace ID is a 3 byte Octet String. See 3GPP TS 32.422 [23].
	The content of this AVP shall be encoded as octet strings according to table 7.3.64/1.
	See 3GPP TS 24.008 [31], clause 10.5.1.13, PLMN list, for the coding of MCC and MNC. If MNC is 2 digits long, bits 5 to 8 of octet 2 are coded as "1111".
	
	Table 7.3.64/1: Encoding format for Trace-Reference AVP
	8  7  6  5  4  3  2  1
	MCC digit 2 MCC digit 1 octet 1
	MNC digit 3 MCC digit 3 octet 2
	MNC digit 2 MNC digit 1 octet 3
			        		octet 4  
			Trace ID		octet 5
							octet 6
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TRACE_REFERENCE, vendorId = VendorIDs.TGPP_ID, name = "Trace-Reference")
public interface TraceReference extends DiameterOctetString
{
}