package com.mobius.software.telco.protocols.diameter.primitives.gq;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.5.9	Flow-Grouping AVP
	The Flow-Grouping AVP (AVP code 508) is of type Grouped, and it indicates that no other IP Flows shall be transported together with the listed IP Flows in the same PDP context(s). 
	If Flow-Grouping AVP(s) have been provided in earlier service information, but are not provided in subsequent service information, the old flow grouping remains valid.
	If Flow-Grouping AVP(s) have been provided in earlier service information, and new Flow-Grouping AVP(s) are provided, the new flow grouping information replaces the previous information. Previous flow grouping information is invalidated even if the new Flow-Grouping AVP(s) affect other IP flows.
	A Flow-Grouping AVP containing no Flows AVP may be used to invalidate flow grouping information provided in earlier service information. A Flow-Grouping AVP containing no Flows AVP shall not be supplied together with other Flow-Grouping AVP(s).
	If earlier service information has already been provided, flow grouping information in subsequent service information shall not restrict the flow grouping further for IP flows already described in the previous service information. However, new IP flows described for the first time in the subsequent service information may be added to existing flow groups or in new flow groups.

		AVP Format:
			Flow-Grouping ::= < AVP Header: 508 >
	        	*[Flows]
 */
@DiameterAvpDefinition(code = 508L, vendorId = KnownVendorIDs.TGPP_ID, name = "Flow-Grouping")
public interface FlowGrouping extends DiameterAvp
{
	List<Flows> getFlows();
	
	void setFlows(List<Flows> value);
}