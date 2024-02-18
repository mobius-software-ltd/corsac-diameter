package com.mobius.software.telco.protocols.diameter.commands.s9a;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	A.7.6.6	Trigger-Establishment-Request (TER) Command
	The TER command, indicated by the Command-Code field set to 8388656 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the BPCF in order to trigger the S9a Session Establishment.
	Message Format:

	<TE-Request> ::= < Diameter Header: 8388656, REQ, PXY >
                < Session-Id >
                [ DRMP ]
                { Auth-Application-Id }
                { Origin-Host }
                { Origin-Realm }
                { Destination-Realm }
                { Destination-Host }
                [ Auth-Session-State ]
                [ Origin-State-Id ]
                [ OC-Supported-Features ]
                [ Subscription-Id ]
                [ Called-Station-Id ]
                [ PCRF-Address ]
                [ UE-Local-IP-Address ]
                [ HeNB-Local-IP-Address ]
                [ UDP-Source-Port ]            
               *[ Proxy-Info ]
               *[ Route-Record ]
               *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S9A, commandCode = CommandCodes.TRIGGER_ESTABLIHMENT, request = true, proxyable = true, name="Trigger-Establishment-Request")
public interface TriggerEstablishmentRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	public AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;

	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	public SubscriptionId getSubscriptionId();
	
	void setSubscriptionId(SubscriptionId value);

	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	String getPCRFAddress();
	
	void setPCRFAddress(String value);
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	InetAddress getHeNBLocalIPAddress();
	
	void setHeNBLocalIPAddress(InetAddress value);	
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
}