package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.125 Resource-Release-Notification AVP (All access types)
	The Resource-Release-Notification AVP (AVP code 2841) is of type Enumerated.
	If the Resource-Release-Notification AVP is included within a Charging-Rule-Remove AVP it defines whether the
	rules included within the Charging-Rule-Remove AVP need to be notified.
	The following values are defined:

	ENABLE_NOTIFICATION (0)
 		This value shall be used to indicate that the outcome of the release of resources for the related PCC rules shall be
		notified.
 */
@DiameterAvpDefinition(code = 2841L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Resource-Release-Notification")
public interface ResourceReleaseNotification extends DiameterEnumerated<ResourceReleaseNotificationEnum>
{
}