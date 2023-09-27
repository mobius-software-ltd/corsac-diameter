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
 * 	8.4.73	Group-User-Identifier
	The Group-User-Identifier AVP is of type Grouped and it contains the External-Identifier or MSISDN and the IMSI of a user belonging to a group.
	AVP format:

	Group-User-Identifier ::= <AVP header: 3177 10415>
			 [ User-Name ]
			 [ MSISDN ]
			 [ External-Identifier ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3177L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Group-User-Identifier")
public interface GroupUserIdentifier extends DiameterGroupedAvp
{
	String getUserName();
	
	void setUserName(String value);
	
	String getMSISDN();
	
	void setMSISDN(String value);
	
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);
}