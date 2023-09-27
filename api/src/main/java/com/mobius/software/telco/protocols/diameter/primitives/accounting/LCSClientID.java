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
 * 	7.2.84	LCS-Client-ID AVP
	The LCS-Client-Id AVP (AVP code 1232) is of type Grouped and holds information related to the identity of an LCS client.
	It has the following ABNF grammar:
	
	<LCS-Client-ID>:: = < AVP Header: 1232 >
		[ LCS-Client-Type ]
		[ LCS-Client-External-ID ]
		[ LCS-Client-Dialed-By-MS ]
		[ LCS-Client-Name ]
		[ LCS-APN ]
		[ LCS-Requestor-ID ]
 */
@DiameterAvpDefinition(code = 1232L, vendorId = KnownVendorIDs.TGPP_ID, name = "LCS-Client-ID")
public interface LCSClientID extends DiameterAvp
{
	LCSClientTypeEnum getLCSClientType();
	
	void setLCSClientType(LCSClientTypeEnum value);
	
	String getLCSClientExternalID();
	
	void setLCSClientExternalID(String value);
	
	String getLCSClientDialedByMS();
	
	void setLCSClientDialedByMS(String value);
	
	LCSClientName getLCSClientName();
	
	void setLCSClientName(LCSClientName value);
	
	String getLCSAPN();
	
	void setLCSAPN(String value);
	
	LCSRequestorID getLCSRequestorID();
	
	void setLCSRequestorID(LCSRequestorID value);
}