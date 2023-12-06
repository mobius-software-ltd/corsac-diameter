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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.2.1	Authentication Procedure
	The Multimedia-Authentication-Request (MAR) command, indicated by the Command-Code field set to 303 and the 'R' bit set in the Command Flags field, is sent by the 3GPP AAA Server to the HSS in order to request security information. This corresponds to clause 8.1.2.1.
	Message Format

	< Multimedia-Auth-Request > ::=  < Diameter Header: 303, REQ, PXY, 16777265 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 [ Destination-Host ]
			 { User-Name }
			 [ RAT-Type ]
			 [ AN-Trusted ]
			 [ ANID ]
			 [ Visited-Network-Identifier]
			 [ Terminal-Information ]
			 { SIP-Auth-Data-Item }
			 { SIP-Number-Auth-Items }
			 [AAA-Failure-Indication ]
			 [ OC-Supported-Features ]
			*[ Supported-Features ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777265, commandCode = 303, request = true, proxyable = true, name="Multimedia-Auth-Request")
public interface MultimediaAuthRequest extends SwxRequest
{
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);		
	
	String getANID();
	
	void setANID(String value);	
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
	
	public TerminalInformation getTerminalInformation();
			    
	public void setTerminalInformation(TerminalInformation value);
			    
	SIPAuthDataItem getSIPAuthDataItem();
	
	void setSIPAuthDataItem(SIPAuthDataItem value);  
	
	Long getSIPNumberAuthItems();
	
	void setSIPNumberAuthItems(Long value);	
	
	Long getAAAFailureIndication();
	
	void setAAAFailureIndication(Long value);		
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	 			
}