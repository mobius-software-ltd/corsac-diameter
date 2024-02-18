package com.mobius.software.telco.protocols.diameter.commands.s6a;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RequestedEUTRANAuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RequestedUTRANGERANAuthenticationInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.5	Authentication-Information-Request (AIR) Command
	The Authentication-Information-Request (AIR) command, indicated by the Command-Code field set to 318 and the 'R' bit set in the Command Flags field, is sent from MME or SGSN to HSS.
	Message Format

	< Authentication-Information-Request> ::=	< Diameter Header: 318, REQ, PXY, 16777251 >
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { User-Name }
				 [ OC-Supported-Features ]
				*[ Supported-Features]
				 [ Requested-EUTRAN-Authentication-Info ]
				 [ Requested-UTRAN-GERAN-Authentication-Info ]
				 { Visited-PLMN-Id }
				 [ AIR-Flags ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6A, commandCode = CommandCodes.AUTHENTICATION, request = true, proxyable = true, name="Authentication-Information-Request")
public interface AuthenticationInformationRequest extends S6aRequest
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	RequestedEUTRANAuthenticationInfo getRequestedEUTRANAuthenticationInfo();
	
	void setRequestedEUTRANAuthenticationInfo(RequestedEUTRANAuthenticationInfo value);
	
	RequestedUTRANGERANAuthenticationInfo getRequestedUTRANGERANAuthenticationInfo();
	
	void setRequestedUTRANGERANAuthenticationInfo(RequestedUTRANGERANAuthenticationInfo value);	
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value) throws MissingAvpException;	
	
	AIRFlags getAIRFlags();
	
	void setAIRFlags(AIRFlags value);				
}