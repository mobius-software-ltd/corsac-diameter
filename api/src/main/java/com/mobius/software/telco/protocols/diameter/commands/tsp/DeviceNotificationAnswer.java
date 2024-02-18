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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.6.5	Device-Notification-Answer (DNA) command
	The DNA command, indicated by the Command-Code field set to 8388640 and the 'R' bit cleared in the Command Flags field, is sent by the SCS to the MTC-IWF as part of the device notification report procedure.
	Message Format:

	<DN-Answer> ::=  < Diameter Header: 8388640, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Origin-State-Id ]    
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                 [ Failed-AVP ]
                *[ Proxy-Info ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.TSP, commandCode = CommandCodes.DEVICE_NOTIFICATION, request = false, proxyable = true, name="Device-Notification-Answer")
public interface DeviceNotificationAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;
}