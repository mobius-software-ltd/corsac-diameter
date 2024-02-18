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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.7	Multimedia-Auth-Request (MAR) Command
	The Multimedia-Auth-Request (MAR) command, indicated by the Command-Code field set to 303 and the 'R' bit set in the Command Flags field, is sent by a Diameter Multimedia client to a Diameter Multimedia server in order to request security information.
	Message Format

	< Multimedia-Auth-Request > ::=  < Diameter Header: 303, REQ, PXY, 16777216 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 [ Destination-Host ]
			 { User-Name }
			 [ OC-Supported-Features ]
			*[ Supported-Features ]
			 { Public-Identity }
			 { SIP-Auth-Data-Item }
			 { SIP-Number-Auth-Items }
			 { Server-Name }
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.CX_DX, commandCode = CommandCodes.MULTIMEDIA_AUTH, request = true, proxyable = true, name="Multimedia-Auth-Request")
public interface MultimediaAuthRequest extends CxDxRequest
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	String getPublicIdentity();
	
	void setPublicIdentity(String value) throws MissingAvpException;
	
	SIPAuthDataItem getSIPAuthDataItem();
	
	void setSIPAuthDataItem(SIPAuthDataItem value) throws MissingAvpException;  
	
	Long getSIPNumberAuthItems();
	
	void setSIPNumberAuthItems(Long value) throws MissingAvpException;	
	
	String getServerName();
	 
	void setServerName(String value) throws MissingAvpException;
}