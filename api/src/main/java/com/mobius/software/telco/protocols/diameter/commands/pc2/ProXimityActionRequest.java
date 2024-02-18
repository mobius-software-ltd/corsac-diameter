package com.mobius.software.telco.protocols.diameter.commands.pc2;
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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.6.2	ProXimity-Action-Request (PXR) command
	The PXR command, indicated by the Command-Code field set to 8388676 and the 'R' bit set in the Command Flags field, is sent by the ProSe Function to the ProSe Application Server as part of  the procedures specified for EPC-level ProSe discovery and ProSe direct discovery in clause 5.
	Message Format:

	<PX-Request> ::= <Diameter Header: 8388676, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 [ Destination-Host ]
                 [ Origin-State-Id ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                 { ProSe-Request-Type }
                 [ Origin-App-Layer-User-Id ]
                 [ Target-App-Layer-User-Id ]
                 [ Requesting-EPUID ]
                 [ ProSe-Function-ID ]
                 [ Requesting-RPAUID ] 
                 [ ProSe-App-Id ]
                 [ Application-Data ]
                 [ Allowed-Suffix-Number]
                 [ Target-RPAUID ]
                *[ Banned-User-Target ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.PC2, commandCode = CommandCodes.PROXIMITY_ACTION, request = true, proxyable = true, name="PX-Request")
public interface ProXimityActionRequest extends Pc2Request
{
	String getOriginAppLayerUserId();
	
	void setOriginAppLayerUserId(String value);
	
	String getTargetAppLayerUserId();
	
	void setTargetAppLayerUserId(String value);
	      
	String getRequestingEPUID();
	
	void setRequestingEPUID(String value);
	      
	ByteBuf getProSeFunctionID();
	
	void setProSeFunctionID(ByteBuf value);
	
	String getProSeAppId();
	
	void setProSeAppId(String value);
	
	String getApplicationData();
	
	void setApplicationData(String value);
	
	Long getAllowedSuffixNumber();
	
	void setAllowedSuffixNumber(Long value);
	
	String getTargetRPAUID();
	
	void setTargetRPAUID(String value);
}