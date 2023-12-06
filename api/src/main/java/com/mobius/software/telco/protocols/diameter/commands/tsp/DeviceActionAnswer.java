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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.DeviceNotification;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.6.3	Device-Action-Answer (DAA) command
	The DAA command, indicated by the Command-Code field set to 8388639 and the 'R' bit cleared in the Command Flags field, is sent by the MTC-IWF to the SCS as part of the device action request procedure.
	Message Format:

	<DA-Answer> ::=  < Diameter Header: 8388639, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                 [ Failed-AVP ]
                 [ Origin-State-Id ]
                 { Device-Notification }
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                *[ Proxy-Info ]
                *[ Supported-Features ]
                 [ Feature-Supported-In-Final-Target ]
                *[ Load ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777309, commandCode = 8388639, request = false, proxyable = true, name="Device-Action-Answer")
public interface DeviceActionAnswer extends AuthenticationAnswer
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	public DeviceNotification getDeviceNotification();
	
	void setDeviceNotification(DeviceNotification value);		
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	Long getFeatureSupportedInFinalTarget();		
	
	void setFeatureSupportedInFinalTarget(Long value);
	
    List<Load> getLoad();
       	 
    void setLoad(List<Load> value);
}