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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.45	NIDD-Authorization-Response
	The NIDD-Authorization-Response AVP is of type Grouped, and it contains the information to be provided triggered by NIDD-Authorization-Request.
	AVP format:

	NIDD-Authorization-Response::=	<AVP header: 3151 10415>
			 [ MSISDN ]
			 [ User-Name ]
			 [ External-Identifier ]
			 [ Granted-Validity-Time ]
			*[AVP]

	The User-Name AVP, when present, shall contain the IMSI.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NIDD_AUTHORIZATION_RESPONSE, vendorId = VendorIDs.TGPP_ID, name = "NIDD-Authorization-Response")
public interface NIDDAuthorizationResponse extends DiameterGroupedAvp
{
	String getMSISDN();
	
	void setMSISDN(String value);
	
	String getUserName();
	
	void setUserName(String value);
	
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);
	
	Date getGrantedValidityTime();
	
	void setGrantedValidityTime(Date value);
}