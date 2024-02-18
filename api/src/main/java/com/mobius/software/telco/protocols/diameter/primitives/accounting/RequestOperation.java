package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.OneM2MAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
	A.4.22. Request-Operation AVP
	The Request-Operation AVP (AVP Code 1017) is of type Enumerated and identifies the type of operation 
	requested. The values are defined in Table 6.3.4.2.5-6.
	
	6.3.4.2.5 m2m:operation
	Used for Operation parameter in request and operation attribute in <request> resource as well as operationMonitor.
	Table 6.3.4.2.5‑6: Interpretation of operation
	Value Interpretation
	1 Create
	2 Retrieve
	3 Update
	4 Delete
	5 Notify

	NOTE: See clause 6.4.1 “Request message parameter data types”
 */
@DiameterAvpDefinition(code = OneM2MAvpCodes.REQUEST_OPERATION, vendorId = VendorIDs.ONEM2M_ID, name = "Request-Operation")
public interface RequestOperation extends DiameterEnumerated<RequestOperationEnum>
{
}