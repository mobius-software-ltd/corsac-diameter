package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
 * 	7.2.111AaA Monitoring-Event-Configuration-Activity AVP
	The Monitoring-Event-Configuration-Activity AVP (AVP code3919) is of type Enumerated and indicates Monitoring
	Event configuration action which triggers the Monitoring Event charging. The AVP may take the values as follows:

	0 create
	1 transfer
	2 update
	3 delete 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MONITORING_EVENT_CONFIGURATION, vendorId = VendorIDs.TGPP_ID, name = "Monitoring-Event-Configuration-Activity")
public interface MonitoringEventConfigurationActivity extends DiameterEnumerated<MonitoringEventConfigurationActivityEnum>
{
}