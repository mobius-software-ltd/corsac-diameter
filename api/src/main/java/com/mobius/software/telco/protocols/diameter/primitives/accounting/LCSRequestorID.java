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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.91	LCS-Requestor-ID AVP
	The LCS-Requestor-ID AVP (AVP code 1239) is of type Grouped and contains information related to the identification of the Requestor.

	It has the following ABNF grammar:
	
	<LCS-Requestor-ID>:: = 	< AVP Header: 1239 >
		[ LCS-Data-Coding-Scheme ]
		[ LCS-Requestor-ID-String ]
 */
@DiameterAvpDefinition(code = 1239L, vendorId = KnownVendorIDs.TGPP_ID, name = "LCS-Requestor-ID")
public interface LCSRequestorID extends DiameterAvp
{
	String getLCSDataCodingScheme();
	
	void setLCSDataCodingScheme(String value);
	
	String getLCSRequestorIDString();
	
	void setLCSRequestorIDString(String value);
}