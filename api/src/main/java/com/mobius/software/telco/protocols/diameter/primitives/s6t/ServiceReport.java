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
 * 	8.4.47	Service-Report
	The Service-Report AVP is of type Grouped, and it contains the result of the handling of the Requested action for the Monitoring event, the type of node and the services it supports.
	AVP format:

	Service-Report ::=	<AVP header: 3152 10415>
			 [ Service-Result ]
			 [ Node-Type ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3152L, vendorId = KnownVendorIDs.TGPP_ID, name = "Service-Report")
public interface ServiceReport extends DiameterGroupedAvp
{
	ServiceResult getServiceResult();
	
	void setServiceResult(ServiceResult value);
	
	NodeTypeEnum getNodeType();
	
	void setNodeType(NodeTypeEnum value);
}