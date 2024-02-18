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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIDeallocationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.6.2	GCS-Action-Request (GAR) command
	The GAR command, indicated by the Command-Code field set to 8388662 and the 'R' bit set in the Command Flags field, is sent by the GCS AS to the BM‑SC as part of the MBMS bearer activation, modification, or deactivation procedure, or as part of the TMGI allocation or deallocation procedure.
	Message Format:

	<GA-Request> ::= <Diameter Header: 8388662, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 [ Destination-Host ]
                 [ Origin-State-Id ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *{ Supported-Features }
                 [ TMGI-Allocation-Request ]
                 [ TMGI-Deallocation-Request ]
                *[ MBMS-Bearer-Request ]
                 [ Restart-Counter ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MB2C, commandCode = CommandCodes.GCS_ACTION, request = true, proxyable = true, name="GCS-Action-Request")
public interface GCSActionRequest extends AuthenticationRequest
{	
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;	
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public TMGIAllocationRequest getTMGIAllocationRequest();
	
	void setTMGIAllocationRequest(TMGIAllocationRequest value);
	
	public TMGIDeallocationRequest getTMGIDeallocationRequest();
	
	void setTMGIDeallocationRequest(TMGIDeallocationRequest value);
	
	public List<MBMSBearerRequest> getMBMSBearerRequest();
	
	void setMBMSBearerRequest(List<MBMSBearerRequest> value);
	
	public Long getRestartCounter();
	
	void setRestartCounter(Long value);
}