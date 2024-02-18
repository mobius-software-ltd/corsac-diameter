package com.mobius.software.telco.protocols.diameter.commands.sh;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.8	Push-Notifications-Answer (PNA) Command
	The Push-Notifications-Answer (PNA) command, indicated by the Command-Code field set to 309 and the 'R' bit cleared in the Command Flags field, is sent by a client in response to the Push-Notification-Request command. The Experimental-Result AVP may contain one of the values defined in clause 6.2 or in 3GPP TS 29.229 [6].
	Message Format

	< Push-Notification-Answer > ::=< Diameter Header: 309, PXY, 16777217 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			*[ Supported-Features ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
*/
@DiameterCommandDefinition(applicationId = ApplicationIDs.SH, commandCode = CommandCodes.PUSH_NOTIFICATION, request = false, proxyable = true, name="Push-Notification-Answer")
public interface PushNotificationAnswer extends ShAnswer
{	
}