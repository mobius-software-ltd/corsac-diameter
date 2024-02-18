package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
 * 6.3.22 One-Time-Notification AVP
	The One-Time-Notification AVP is of type Enumerated. If present it indicates that the sender requests to be notified
	only one time. The following values are defined:

	ONE_TIME_NOTIFICATION_REQUESTED (0)
	
	This AVP is only applicable to UE reachability for IP (25) 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ONE_TIME_NOTIFICATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "One-Time-Notification")
public interface OneTimeNotification extends DiameterEnumerated<OneTimeNotificationEnum>
{
}