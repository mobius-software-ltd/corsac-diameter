package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.7	Monitoring-Type
	The Monitoring-Type AVP is of type Unsigned32 and shall identify the type of event to be monitored. The following values are defined:

	LOSS_OF_CONNECTIVITY (0)

	UE_REACHABILITY (1)

	LOCATION_REPORTING (2)
	
	CHANGE_OF_IMSI_IMEI(SV)_ASSOCIATION (3)

	ROAMING_STATUS (4)

	COMMUNICATION_FAILURE (5)

	AVAILABILITY_AFTER_DDN_FAILURE (6)

	NUMBER_OF_UES_PRESENT_IN_A_GEOGRAPHICAL_AREA (7)

	UE_REACHABILITY_AND_IDLE_STATUS_INDICATION (8)

	AVAILABILITY_AFTER_DDN_FAILURE_AND_IDLE_STATUS_INDICATION (9)

	PDN_CONNECTIVITY_STATUS (10)  
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MONITORING_TYPE, vendorId = VendorIDs.TGPP_ID, name = "Monitoring-Type")
public interface MonitoringType extends DiameterEnumerated<MonitoringTypeEnum>
{
}