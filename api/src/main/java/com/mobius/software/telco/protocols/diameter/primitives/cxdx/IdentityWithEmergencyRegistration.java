package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.57	Identity-with-Emergency-Registration AVP
	The Identity-with-Emergency-Registration AVP is of type Grouped and it contains a pair of private/public user identities which are emergency registered.
	AVP format
	
		Identity-with-Emergency-Registration ::= < AVP header: 651, 10415 >
			{ User-Name }
			{ Public-Identity }
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 651L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Identity-with-Emergency-Registration")
public interface IdentityWithEmergencyRegistration extends DiameterGroupedAvp
{
	String getUserName();
	
	void setUserName(String value);
	
	String getPublicIdentity();
	
	void setPublicIdentity(String value);
}