package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
 * 	6.3.44	Change-Of-Area-Type
	The Change-Of-Area-Type AVP is of type Grouped. It shall contain the information related to the type of event that will trigger a locate update procedure to forward the location of UE to the ProSe Function initiating the Proximity Request.
	The AVP format shall conform to:
		
	Change-Of-Area-Type::=	<AVP header: 3825 10415>
		 { Location-Update-Event-Trigger }
		 { Report-Cardinality }
		 [ Minimum-Interval-Time ]
		*[AVP]

	The Minimum-Interval-Time AVP may be present only if the Report-Cardinality AVP value is set to MULTIPLE (1).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CHANGE_OF_AREA_TYPE, vendorId = VendorIDs.TGPP_ID, name = "Change-Of-Area-Type")
public interface ChangeOfAreaType extends DiameterGroupedAvp
{
	LocationUpdateEventTriggerEnum getLocationUpdateEventTrigger();
	
	void setLocationUpdateEventTrigger(LocationUpdateEventTriggerEnum value) throws MissingAvpException;
	
	ReportCardinalityEnum getReportCardinality();
	
	void setReportCardinality(ReportCardinalityEnum value) throws MissingAvpException;
	
	Long getMinimumIntervalTime();
	
	void setMinimumIntervalTime(Long value);
}