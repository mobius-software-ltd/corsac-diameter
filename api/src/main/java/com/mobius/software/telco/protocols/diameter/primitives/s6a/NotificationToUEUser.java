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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.89	Notification-To-UE-User
	The Notification- To-UE-User AVP is of type Enumerated. The following values are defined:

	NOTIFY_LOCATION_ALLOWED (0)

	NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE (1)

	NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE (2)

	LOCATION_NOT_ALLOWED (3)
 */
@DiameterAvpDefinition(code = 1478L, vendorId = KnownVendorIDs.TGPP_ID, name = "Notification-To-UE-User")
public interface NotificationToUEUser extends DiameterEnumerated<NotificationToUEUserEnum>
{
}