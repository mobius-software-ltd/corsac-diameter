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
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.210	Emergency-Info
	The Emergency-Info AVP is of type Grouped. It shall contain the identity of the PDN-GW used for the establishment of emergency PDN connections.
	The AVP format shall conform to:
	
	Emergency-Info ::= <AVP header: 1687 10415>
			 [ MIP6-Agent-Info ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 1687L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Emergency-Info")
public interface EmergencyInfo extends DiameterGroupedAvp
{
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);
}