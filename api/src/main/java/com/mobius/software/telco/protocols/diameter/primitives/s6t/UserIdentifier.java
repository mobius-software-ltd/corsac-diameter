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
 * 	8.4.36	User-Identifier
	The User-Identifier AVP is of type Grouped and it contains the different identifiers used by the UE. This AVP is defined in clause 6.4.2. The AVP format for the S6t interface shall be as given below.
	AVP format:	
	User-Identifier ::= <AVP header: 3102 10415>
			 [ User-Name ]
			 [ MSISDN ]
			 [ External-Identifier ]
			 [ Type-Of-External-Identifier ]
			*[AVP]

	This AVP shall contain one of the identifiers (IMSI, MSISDN or External-Identifier). The IMSI of the UE shall be included (when applicable) in the User-Name AVP.
	The External-Identifier AVP may either contain the identity of an individual UE or the identity of a Group of UEs. The Type-Of-External-Identifier is used to indicate which type of identity is carried in the External-Identifier. When the Type-Of-External-Identifier is not present, it means the External-Identifier AVP contains the identity of an individual UE.
 */
@DiameterAvpDefinition(code = 3102L, vendorId = KnownVendorIDs.TGPP_ID, name = "User-Identifier")
public interface UserIdentifier extends DiameterGroupedAvp
{
	String getUserName();
	
	void setUserName(String value);
	
	String getMSISDN();
	
	void setMSISDN(String value);	
	
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);
	
	TypeOfExternalIdentifierEnum getTypeOfExternalIdentifier();
	
	void setTypeOfExternalIdentifier(TypeOfExternalIdentifierEnum value);
}