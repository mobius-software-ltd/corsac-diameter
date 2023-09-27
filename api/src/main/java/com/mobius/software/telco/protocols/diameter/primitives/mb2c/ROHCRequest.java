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
 * 	6.4.28	ROHC‑Request AVP
	The ROHC‑Request AVP (AVP code 3526) is of type Grouped.
	It is used by the GCS AS to request that the BM-SC applies ROHC (see IETF RFC 5795 [29] and IETF RFC 3095 [30]) for the indicated downlink media stream(s),
	The Flow-Description AVP(s) shall describe the downlink media streams for which ROHC applies. The description shall relate to the IP layer and higher protocols within the "User Plane Data" as depicted in Figure 7.1-1.
	AVP Format:

	ROHC-Request::=                  < AVP Header: 3526 >
                               1*{ Flow-Description }
                                 [ ROHC-Full-Header-Periodicity ]
                                 { ROHC-Profile }
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = 3526L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "ROHC‑Request")
public interface ROHCRequest extends DiameterGroupedAvp
{
	List<FlowDescription> getFlowDescription();
	
	void setFlowDescription(List<FlowDescription> value);	
	
	Float getROHCFullHeaderPeriodicity();
	
	void setROHCFullHeaderPeriodicity(Float value);
	
	Long getROHCProfile();
	
	void setROHCProfile(Long value);
}