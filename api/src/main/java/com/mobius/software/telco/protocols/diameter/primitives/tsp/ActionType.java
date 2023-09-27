package com.mobius.software.telco.protocols.diameter.primitives.tsp;
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
 *	6.4.6	Action-Type AVP
	The Action-Type AVP (AVP code 3005) is of type Enumerated, and informs the MTC-IWF of what action type is required in the request and also informs the SCS of what action type is reported.
	The following values are defined:

	Device Trigger Request (1)
	This value indicates a device trigger request and is used:
	-	in the Device-Action AVP of the Device-Action-Request command;
	-	in the Device-Notification AVP of the Device-Action-Answer command.

	Delivery Report (2)
	This value indicates a delivery report sent from MTC-IWF to the SCS and is used:
	-	in the Device-Notification AVP of the Device-Notification-Request command.

	Device Trigger Recall (3)
	This value indicates a device trigger recall request and is used:
	-	in the Device-Action AVP of the Device-Action-Request command;
	-	in the Device-Notification AVP of the Device-Action-Answer command.

	Device Trigger Replace (4)
	This value indicates a device trigger replace request and is used:
	-	in the Device-Action AVP of the Device-Action-Request command;
	-	in the Device-Notification AVP of the Device-Action-Answer command.

	MSISDN-less MO-SMS Delivery (5)
	This value indicates the delivery of an MSISDN-less MO-SMS and is used in the Device-Notification AVP of the Device-Notification-Request command.
 */
@DiameterAvpDefinition(code = 3005L, vendorId = KnownVendorIDs.TGPP_ID, name = "Action-Type")
public interface ActionType extends DiameterEnumerated<ActionTypeEnum>
{
}