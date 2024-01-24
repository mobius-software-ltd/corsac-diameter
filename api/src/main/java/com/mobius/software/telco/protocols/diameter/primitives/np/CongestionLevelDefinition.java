package com.mobius.software.telco.protocols.diameter.primitives.np;
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
 * 	5.3.4	Congestion-Level-Definition AVP
	The Congestion-Level-Definition AVP (AVP code 4002) is of type Grouped, and it is used to define a congestion level set and corresponding congestion level(s) to be used by the RCAF for a specific user id and PDN ID at congestion reporting. When this AVP is present in the MUR command reporting restrictions apply, when this AVP is absent there are no reporting restriction for the specific user id and PDN ID.
	Congestion-Level-Definition ::= < AVP Header: 4002 >
			{ Congestion-Level-Set-Id }
			{ Congestion-Level-Range }
 		   *[ AVP ]
 */
@DiameterAvpDefinition(code = 4002L, vendorId = KnownVendorIDs.TGPP_ID,must = false, name = "Congestion-Level-Definition")
public interface CongestionLevelDefinition extends DiameterGroupedAvp
{
	Long getCongestionLevelSetId();
	
	void setCongestionLevelSetId(Long value);
	
	CongestionLevelRange getCongestionLevelRange();
	
	void setCongestionLevelRange(CongestionLevelRange value);
}