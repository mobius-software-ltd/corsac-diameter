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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.8	T4-Data
	The T4-Data AVP is of type Grouped and it shall contain information about the network node(s) serving the targeted user for SMS, i.e. the names/numbers of the serving nodes (MSC or MME, SGSN, IP-SM-GW) which allow the trigger delivery. AVP format:
	
	T4-Data ::= <AVP header: 3108 10415>
		 [ HSS-Cause ]
		 [ Serving-Node ]
		*[ Additional-Serving-Node ]
		*[AVP]

	When the HSS-Cause indicates Absent Subscriber, via the corresponding flag in the bit mask, the Serving-Node and Additional-Serving-Node AVPs shall not be present. When the HSS-Cause indicates Teleservice Not Provisioned or
	Call Barred, via the corresponding flag in the bit mask, the Serving-Node and Additional-Serving-Node AVPs should not be present. Additional-Serving-Node AVP shall be absent if Serving-Node AVP is absent.
 */
@DiameterAvpDefinition(code = 3108L, vendorId = KnownVendorIDs.TGPP_ID, name = "T4-Data")
public interface T4Data extends DiameterGroupedAvp
{
	Long getHSSCause();
	
	void setHSSCause(Long value);
	
	ServingNode getServingNode();
	
	void setServingNode(ServingNode value);	
	
	List<AdditionalServingNode> getAdditionalServingNode();
	
	void setAdditionalServingNode(List<AdditionalServingNode> value);
}