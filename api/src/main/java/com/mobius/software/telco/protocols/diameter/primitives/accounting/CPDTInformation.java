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
 * 	7.2.46acA	CPDT-Information AVP
	The CPDT-Information AVP (AVP code 3927) is of type Grouped. Its purpose is to allow the transmission of additional CP data transfer service specific information elements.  
	It has the following ABNF grammar:
         
    CPDT-Information :: = < AVP Header: 3927>
			[ External-Identifier ]
			[ SCEF-ID ]
			[ Serving Node Identity ] 
			[ SGW-Change ]
			[ NIDD-submission ]
 */
@DiameterAvpDefinition(code = 3927L, vendorId = KnownVendorIDs.TGPP_ID, name = "CPDT-Information")
public interface CPDTInformation extends DiameterAvp
{
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);
	
	String getSCEFID();
	
	void setSCEFID(String value);
	
	String getServingNodeIdentity();
	
	void setServingNodeIdentity(String value);
	
	SGWChangeEnum getSGWChange();
	
	void setSGWChange(SGWChangeEnum value);
	
	NIDDSubmission getNIDDSubmission();
	
	void setNIDDSubmission(NIDDSubmission value);
}