package com.mobius.software.telco.protocols.diameter.primitives.s6m;
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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.2	User-Identifier
	The User-Identifier AVP is of type Grouped and it contains the different identifiers used by the UE.
	AVP format:

	User-Identifier ::= <AVP header: 3102 10415>
		 [ User-Name ]
		 [ MSISDN ]
		 [ External-Identifier ]
		 [ LMSI ]
		*[AVP]
		*
	This AVP shall contain at least one of the identifiers used by the UE, i.e., it shall not be empty. The IMSI of the UE shall be included (when applicable) in the User-Name AVP.
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
	
	ByteBuf getLMSI();
	
	void setLMSI(ByteBuf value);
}