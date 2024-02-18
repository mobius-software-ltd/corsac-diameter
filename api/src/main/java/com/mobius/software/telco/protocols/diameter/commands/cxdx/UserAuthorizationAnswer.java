package com.mobius.software.telco.protocols.diameter.commands.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.2	User-Authorization-Answer (UAA) Command
	The User-Authorization-Answer (UAA) command, indicated by the Command-Code field set to 300 and the 'R' bit cleared in the Command Flags field, is sent by a server in response to the User-Authorization-Request command. The Experimental-Result AVP may contain one of the values defined in clause 6.2.
	Message Format

	< User-Authorization-Answer> ::=	< Diameter Header: 300, PXY, 16777216 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			*[ Supported-Features ]
			 [ Server-Name ]
			 [ Server-Capabilities ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
		 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.CX_DX, commandCode = CommandCodes.USER_AUTHORIZATION, request = false, proxyable = true, name="User-Authorization-Answer")
public interface UserAuthorizationAnswer extends CxDxAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	 		
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 		
	String getServerName();
	
	void setServerName(String value);	
	
	ServerCapabilities getServerCapabilities();
	
	void setServerCapabilities(ServerCapabilities value);	
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);
}