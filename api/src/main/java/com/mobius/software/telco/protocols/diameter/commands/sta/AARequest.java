package com.mobius.software.telco.protocols.diameter.commands.sta;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.2.2.3.3	AA-Request (AAR) Command
	The AA-Request (AAR) command, indicated by the Command-Code field set to 265 and the "R" bit set in the Command Flags field, is sent from a Trusted Non-3GPP access network to a 3GPP AAA Server/Proxy. The ABNF is re-used from IETF RFC 4005 [4], adding AVPs from IETF RFC 5779 [2].

	< AA-Request >  ::=	< Diameter Header: 265, REQ, PXY, 16777250 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Auth-Request-Type }
				 [ Destination-Host ]
				 [ User-Name ]
				 [ MIP6-Feature-Vector ]
				 [ Access-Network-Info ]
				 [ Local-Time-Zone ]
				
				 [ OC-Supported-Features ]
				…
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777250, commandCode = 265, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends StaRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	public AccessNetworkInfo getAccessNetworkInfo();
	
	void setAccessNetworkInfo(AccessNetworkInfo value);
	
	LocalTimeZone getLocalTimeZone();
	
	void setLocalTimeZone(LocalTimeZone value);
			
	public OCSupportedFeatures getOCSupportedFeatures();
			 
	void setOCSupportedFeatures(OCSupportedFeatures value);
}