package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
 * 	6.3.1 User-Identity AVP
	The User-Identity AVP is of type Grouped. This AVP contains either a Public- Identity AVP or an MSISDN AVP or an
	External-Identifier AVP.
	AVP format

	User-Identity ::= <AVP header: 700 10415>
		[Public-Identity]
		[MSISDN]
		[External-Identifier]
 	   *[AVP] 	
 */
@DiameterAvpDefinition(code = 700L, vendorId = KnownVendorIDs.TGPP_ID, name = "User-Identity")
public interface UserIdentity extends DiameterGroupedAvp
{
	String getPublicIdentity();
	
	void setPublicIdentity(String value);	
	
	String getMSISDN();
	
	void setMSISDN(String value);	
	
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);		
}