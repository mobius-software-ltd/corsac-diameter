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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEventNotification;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIExpiry;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.6.4	GCS-Notification-Request (GNR) command
	The GNR command, indicated by the Command-Code field set to 8388663 and the 'R' bit set in the Command Flags field, is sent by the BM‑SC to the GCS AS as part of the MBMS Bearer Status Indication procedure.
	Message Format:

	<GN-Request> ::= < Diameter Header: 8388663, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { Destination-Host }
                 [ Origin-State-Id ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                 [ TMGI-Expiry ]
                *[ MBMS-Bearer-Event-Notification ]
                 [ Restart-Counter ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MB2C, commandCode = CommandCodes.GCS_NOTIFICATION, request = true, proxyable = true, name="GCS-Notification-Request")
public interface GCSNotificationRequest extends AuthenticationRequest
{	
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;	
	
	public TMGIExpiry getTMGIExpiry();
	
	void setTMGIExpiry(TMGIExpiry value);
	
	public List<MBMSBearerEventNotification> getMBMSBearerEventNotification();
	
	void setMBMSBearerEventNotification(List<MBMSBearerEventNotification> value);
	
	public Long getRestartCounter();
	
	void setRestartCounter(Long value);
}