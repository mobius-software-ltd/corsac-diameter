package com.mobius.software.telco.protocols.diameter.primitives.mm10;
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
 * 	6.3.1	Served-User-Identity AVP
	The Served-User-Identity AVP (AVP Code 1100) is of type Grouped. This AVP contains identity of the served subscriber for whom a messaging processing is requested.
	AVP format

	Served-User-Identity ::= <AVP header: 1100 10415>
		 [MSISDN]
		 [VASP-ID]
		 [VAS-ID]
		*[AVP]
 */
@DiameterAvpDefinition(code = 1100L, vendorId = KnownVendorIDs.TGPP_ID, name = "Served-User-Identity")
public interface ServedUserIdentity extends DiameterGroupedAvp
{
	String getMSISDN();
	
	void setMSISDN(String value);	
	
	String getVASPID();
	
	void setVASPID(String value);
	
	String getVASID();
	
	void setVASID(String value);
}