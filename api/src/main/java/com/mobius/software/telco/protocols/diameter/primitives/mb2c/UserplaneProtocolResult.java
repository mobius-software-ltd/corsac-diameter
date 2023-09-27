package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.31	Userplane-Protocol‑Result AVP
	The Userplane-Protocol‑Result AVP (AVP code 3529) is of type Grouped.
	It is used by the BM-SC to report the result of the activation of failures of the execution of user plane protocols,
	The Flow-Description AVP(s) shall describe the downlink media streams for which the user plane protocol(s) apply. The description shall relate to the IP layer and higher protocols within the "User Plane Data" as depicted in Figure 7.1-1 Omitting this AVP shall indicate that the reported result applies for all media streams.
	AVP Format:

	Userplane-Protocol-Result::=     < AVP Header: 3529 >
                                *[ Flow-Description ]
                                 [ ROHC-Result ]
                                 [ FEC-Result ]
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = 3529L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Userplane-Protocol-Result")
public interface UserplaneProtocolResult extends DiameterGroupedAvp
{
	List<FlowDescription> getFlowDescription();
	
	void setFlowDescription(List<FlowDescription> value);	
	
	Long getROHCResult();
	
	void setROHCResult(Long value);
	
	Long getFECResult();
	
	void setFECResult(Long value);
}