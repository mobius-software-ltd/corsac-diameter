package com.mobius.software.telco.protocols.diameter.commands.swm;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.2.1.3	Diameter-AA-Request (AAR) Command
	The AA-Request (AAR) command, indicated by the Command-Code field set to 265 and the "R" bit set in the Command Flags field, is sent from a ePDG to a 3GPP AAA Server/Proxy.

	<AA-Request> ::=	< Diameter Header: 265, REQ, PXY, 16777264 >
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 [ Destination-Host ]
			 { Auth-Request-Type }
			 [ User-Name ]
			 [ OC-Supported-Features ]
			 [ AAR-Flags ]
			 [ UE-Local-IP-Address ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777264, commandCode = 265, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends SwmRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);			
			
	public OCSupportedFeatures getOCSupportedFeatures();
			 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	Long getAARFlags();
	
	void setAARFlags(Long value);	
	
	public InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);
}