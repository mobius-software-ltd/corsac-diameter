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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIDeallocationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.6.3	GCS-Action-Answer (GAA) command
	The GAA command, indicated by the Command-Code field set to 8388662 and the 'R' bit cleared in the Command Flags field, is sent by the BM‑SC to the GCS AS as part of the MBMS bearer activation, modification, or deactivation procedure, or as part of the TMGI allocation or deallocation procedure.
	Message Format:

	<GA-Answer> ::=  < Diameter Header: 8388662, PXY >
                 < Session-Id >
                 [ DRMP ]
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
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                *[ Proxy-Info ]
                *{ Supported-Features }
                 [ TMGI-Allocation-Response ]
                *[ TMGI-Deallocation-Response ]
                *[ MBMS-Bearer-Response ]
                 [ Restart-Counter ]
                *[ Load ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777335, commandCode = 8388662, request = false, proxyable = true, name="GCS-Action-Answer")
public interface GCSActionAnswer extends AuthenticationAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public TMGIAllocationResponse getTMGIAllocationResponse();
	
	void setTMGIAllocationResponse(TMGIAllocationResponse value);
	
	public TMGIDeallocationResponse getTMGIDeallocationResponse();
	
	void setTMGIDeallocationResponse(TMGIDeallocationResponse value);
	
	public List<MBMSBearerResponse> getMBMSBearerResponse();
	
	void setMBMSBearerResponse(List<MBMSBearerResponse> value);
	
	public Long getRestartCounter();
	
	void setRestartCounter(Long value);
	
    List<Load> getLoad();
       	 
    void setLoad(List<Load> value);
}