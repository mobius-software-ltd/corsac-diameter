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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.3	Aggregated-RUCI-Report AVP
	The Aggregated-RUCI-Report AVP (AVP code 4001) is of type Grouped, and it is used to contain the congestion level value or congestion level set id for a set of users which have the same PCRF for the same PDN ID.
	The congestion-Level-Value AVP contains the congestion level value if the PCRF did not provide the reporting restriction earlier for the user id and PDN ID.
	The Congestion-Level-Set-Id AVP contains the congestion level set identifier between the PCRF and the RCAF if the PCRF provided the reporting restriction earlier for the user id and PDN ID.
	The Called-Station-Id AVP contains the PDN ID.
	The Aggregated-Congestion-Info AVP shall indicate the list of users included in the IMSI-List AVP and the congested location included in the Congestion-Location-Id AVP (if applicable), where a congestion level included in the Congestion-Level-Value AVP or congestion level set included in the Congestion-Level-Set-Id AVP shall apply.
	
	Aggregated-RUCI-Report ::= < AVP Header: 4001 >
			  1*{ Aggregated-Congestion-Info }
				[ Called-Station-Id ]
				[ Congestion-Level-Value ]
				[ Congestion-Level-Set-Id ]
 			   *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AGGREGATED_RUCI_REPORT, vendorId = VendorIDs.TGPP_ID, name = "Aggregated-RUCI-Report")
public interface AggregatedRUCIReport extends DiameterGroupedAvp
{
	List<AggregatedCongestionInfo> getAggregatedCongestionInfo();
	
	void setAggregatedCongestionInfo(List<AggregatedCongestionInfo> value) throws MissingAvpException;
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	Long getCongestionLevelValue();
	
	void setCongestionLevelValue(Long value);
	
	Long getCongestionLevelSetId();
	
	void setCongestionLevelSetId(Long value);
}