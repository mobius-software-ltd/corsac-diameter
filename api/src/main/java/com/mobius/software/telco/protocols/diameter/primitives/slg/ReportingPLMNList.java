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
 * 	7.4.48	Reporting-PLMN-List
	The Reporting-PLMN-List AVP is of type Grouped.
	AVP format:

	Reporting-PLMN-List ::= <AVP header: 2543 10415>

		1*20 { PLMN-ID-List }
			 [ Prioritized-List-Indicator ]
 			*[ AVP ]

	If not included, the default value of Prioritized-List-Indicator shall be considered as "NOT_PRIORITIZED" (0).
 */
@DiameterAvpDefinition(code = 2543L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Reporting-PLMN-List")
public interface ReportingPLMNList extends DiameterGroupedAvp
{
	List<PLMNIDList> getPLMNIDList();
	
	void setPLMNIDList(List<PLMNIDList> value);
	
	PrioritizedListIndicatorEnum getPrioritizedListIndicator();
	
	void setPrioritizedListIndicator(PrioritizedListIndicatorEnum value);
}