package com.mobius.software.telco.protocols.diameter.commands.tsp;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.DeviceNotification;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.6.4	Device-Notification-Request (DNR) command
	The DNR command, indicated by the Command-Code field set to 8388640 and the 'R' bit set in the Command Flags field, is sent by the MTC-IWF to the SCS as part of the device notification report procedure.
	Message Format:

	<DN-Request> ::= < Diameter Header: 8388640, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { Destination-Host }
                 [ Origin-State-Id ]
                 [ Device-Notification ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ AVP ]

 */
@DiameterCommandDefinition(applicationId = 16777309, commandCode = 8388640, request = true, proxyable = true, name="Device-Notification-Request")
public interface DeviceNotificationRequest extends AuthenticationRequest
{	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	public DeviceNotification getDeviceNotification();
	
	void setDeviceNotification(DeviceNotification value);
}