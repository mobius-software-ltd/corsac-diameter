package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.181	WLAN-offloadability
	The WLAN-offloadability AVP is of type Grouped. This AVP contains WLAN offloadability for E-UTRAN or UTRAN.
	AVP format:

	WLAN-offloadability ::= <AVP header: 1667>
			 [ WLAN-offloadability-EUTRAN ]
			 [ WLAN-offloadability-UTRAN ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 1667L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "WLAN-Offloadability")
public interface WLANOffloadability extends DiameterGroupedAvp
{
	Long getWLANOffloadabilityEUTRAN();
	
	void setWLANOffloadabilityEUTRAN(Long value);	
	
	Long getWLANOffloadabilityUTRAN();
	
	void setWLANOffloadabilityUTRAN(Long value);
}