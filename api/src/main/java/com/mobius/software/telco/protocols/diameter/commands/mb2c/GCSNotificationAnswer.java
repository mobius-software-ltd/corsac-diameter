package com.mobius.software.telco.protocols.diameter.commands.mb2c;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.6.5	GCS-Notification-Answer (GNA) command
	The GNA command, indicated by the Command-Code field set to 8388663 and the 'R' bit cleared in the Command Flags field, is sent by the GCS AS to the BM‑SC as part of the MBMS Bearer Status Indication procedure.
	Message Format:

	<GN-Answer> ::=  < Diameter Header: 8388663, PXY >
                 < Session-Id >
                 [ DRMP ]
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
                 [ Restart-Counter ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777335, commandCode = 8388663, request = false, proxyable = true, name="GCS-Notification-Answer")
public interface GCSNotificationAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
	
	public Long getRestartCounter();
	
	void setRestartCounter(Long value);
}