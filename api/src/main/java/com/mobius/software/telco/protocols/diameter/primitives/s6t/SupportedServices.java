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
 * 	8.4.40	Supported-Services
	The Supported-Services AVP is of type Grouped and it shall contain the different bit masks representing the services supported by the HSS:
	AVP format
 
 	Supported-Services ::= <AVP header: 3143 10415>
			 [ Supported-Monitoring-Events ]
			 [ Node-Type ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3143L, vendorId = KnownVendorIDs.TGPP_ID, name = "Supported-Services")
public interface SupportedServices extends DiameterGroupedAvp
{
	Long getSupportedMonitoringEvents();
	
	void setSupportedMonitoringEvents(Long value);
	
	NodeTypeEnum getNodeType();
	
	void setNodeType(NodeTypeEnum value);
}