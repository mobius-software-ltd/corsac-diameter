package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.32	AESE-Communication-Pattern-Config-Status
	The AESE-Communication-Pattern-Config-Status AVP is of type Grouped, and it shall contain the details of the outcome of Communication-Pattern handling from the HSS.
	AVP format
 
 	AESE-Communication-Pattern-Config-Status ::= <AVP header: 3120 10415>
			 { SCEF-Reference-ID }
			 [ SCEF-Reference-ID-Ext ]
			 [ SCEF-ID ]
			 [ AESE-Error-Report ]
			*[AVP]

	When the "Extended Reference IDs" feature is supported by the HSS and SCEF, the SCEF-Reference-ID-Ext AVP shall be used insted of SCEF-Reference-ID; in such case, the required AVP "SCEF-Reference-ID" shall be included in the grouped AVP by the sender, but its content shall be discarded by the receiver.
 */
@DiameterAvpDefinition(code = 3120L, vendorId = KnownVendorIDs.TGPP_ID, name = "AESE-Communication-Pattern-Config-Status")
public interface AESECommunicationPatternConfigStatus extends DiameterGroupedAvp
{
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	Long getSCEFReferenceIDExt();
	
	void setSCEFReferenceIDExt(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);	
	
	AESEErrorReport getAESEErrorReport();
	
	void setAESEErrorReport(AESEErrorReport value);
}