package com.mobius.software.telco.protocols.diameter.commands.swx;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ActiveAPN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.2.3	Non-3GPP IP Access Registration Procedure
	The Server-Assignment-Request (SAR) command, indicated by the Command-Code field set to 301 and the 'R' bit set in the Command Flags field, is sent by the 3GPP AAA Server to the HSS; this corresponds to clause 8.1.2.2.2. This command is also sent by the 3GPP AAA Server to restore the registration data and the dynamic data previously stored in HSS, which may have been lost after a restart; this corresponds to clause 8.1.2.4.2.
	Message Format

	< Server-Assignment-Request > ::=	< Diameter Header: 301, REQ, PXY, 16777265 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Destination-Host ]
			 { Destination-Realm }
			 [ Service-Selection ]
			 [ Context-Identifier ]
			 [ MIP6-Agent-Info ]
			 [ Visited-Network-Identifier ]
			 { User-Name}
			 { Server-Assignment-Type }
			*[ Active-APN ]
			 [ OC-Supported-Features ]
			*[ Supported-Features ]
			 [ Terminal-Information ]
			 [ Emergency-Services ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SWX, commandCode = CommandCodes.SERVER_ASSIGNMENT, request = true, proxyable = true, name="Server-Assignment-Request")
public interface ServerAssignmentRequest extends SwxRequest
{
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value);
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
	
	ServerAssignmentTypeEnum getServerAssignmentType();
	
	void setServerAssignmentType(ServerAssignmentTypeEnum value) throws MissingAvpException;
	
	List<ActiveAPN> getActiveAPN();
	
	void setActiveAPN(List<ActiveAPN> value);
						
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	TerminalInformation getTerminalInformation();
    
    void setTerminalInformation(TerminalInformation value);
    
    EmergencyServices getEmergencyServices();
    
    void setEmergencyServices(EmergencyServices value);
}