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
 * 	8.4.44	NIDD-Authorization-Request
	The NIDD-Authorization-Request AVP is of type Grouped, and it contains the details for the Authorisation of NIDD via the SCEF.
	AVP format:

	NIDD-Authorization-Request ::=	<AVP header: 3150 10415>
			 [ Service-Selection ]
			 [ Requested-Validity-Time ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NIDD_AUTHORIZATION_REQUEST, vendorId = VendorIDs.TGPP_ID, name = "NIDD-Authorization-Request")
public interface NIDDAuthorizationRequest extends DiameterGroupedAvp
{
	String getServiceSelection();
	
	void setServiceSelection(String value);
	
	Date getRequestedValidityTime();
	
	void setRequestedValidityTime(Date value);
}