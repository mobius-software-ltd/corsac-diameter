package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.54	Deferred-MT-LR-Data
	The Deferred-MT-LR-Data AVP is of type Grouped.
	AVP format:

	Deferred-MT-LR-Data ::= <AVP header: 2547 10415>
		 { Deferred-Location-Type }
		 [ Termination-Cause ]
		 [ Serving-Node ]
 		*[ AVP ]

	Serving-Node may be included only when the Termination-Cause is present indicating MT_LR_RESTART.

	The Serving-Node refers to the node where the UE has moved to and shall be included, if available.
 */
@DiameterAvpDefinition(code = 2547L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Deferred-MT-LR-Data")
public interface DeferredMTLRData extends DiameterGroupedAvp
{
	Long getDeferredLocationType();
	
	void setDeferredLocationType(Long value);
	
	Long getTerminationCause();
	
	void setTerminationCause(Long value);
	
	ServingNode getServingNode();
	
	void setServingNode(ServingNode value);
}