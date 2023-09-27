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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.65	APN-Validity-Time
	The APN-Validity-Time AVP is of type Grouped, and it contains the APN (within the Service-Selection AVP) and the updated validity time for the granted NIDD authorization associated to the APN.
	AVP format:

	APN-Validity-Time::=	<AVP header:3169 10415>
			 { Granted-Validity-Time }
			 [ Service-Selection ]
			*[AVP]

	Absence of Service-Selection AVP indicates that the Granted-Validity-Time applies to all granted NIDD Authorizations for the user. In this case only one APN-Validity-Time AVP shall be present within the NIDD-Authorization-Update AVP.
 */
@DiameterAvpDefinition(code = 3169L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "APN-Validity-Time")
public interface APNValidityTime extends DiameterGroupedAvp
{
	Date getGrantedValidityTime();
	
	void setGrantedValidityTime(Date value);
	
	String getServiceSelection();
	
	void setServiceSelection(String value);
}