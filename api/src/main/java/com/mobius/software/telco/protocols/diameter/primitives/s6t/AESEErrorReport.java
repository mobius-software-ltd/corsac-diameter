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
 * 	8.4.33	AESE-Error-Report
	The AESE-Error-Report AVP is of type Grouped, and it contains the details of the Error occurred during handling of the Requested action for the Communication-Pattern-Set.
	AVP format
 
 	AESE-Error-Report ::= <AVP header: 3121 10415>
			 [ Service-Result ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3121L, vendorId = KnownVendorIDs.TGPP_ID, name = "AESE-Error-Report")
public interface AESEErrorReport extends DiameterGroupedAvp
{
	ServiceResult getServiceResult();
	
	void setServiceResult(ServiceResult value);
}