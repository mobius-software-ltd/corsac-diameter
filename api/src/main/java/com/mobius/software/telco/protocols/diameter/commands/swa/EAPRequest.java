package com.mobius.software.telco.protocols.diameter.commands.swa;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TransportAccessTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	4.2.2.1.1	Diameter-EAP-Request (DER) Command
	The Diameter-EAP-Request (DER) command, indicated by the Command-Code field set to 268 and the 'R' bit set in the Command Flags field, is sent from a trusted non-3GPP access network to a 3GPP AAA Server.

	< Diameter-EAP-Request > ::=	< Diameter Header: 268, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Auth-Request-Type }
				 { EAP-Payload }
				 [ User-Name ]
				 [ Calling-Station-Id ]
				 [ RAT-Type ]
				…
				 [ ANID ]
				 [ Full-Network-Name ]
				 [ Short-Network-Name ]
				*[ Supported-Features ]
				 [ AAA-Failure-Indication ]
				 [ Transport-Access-Type ]
				 [ OC-Supported-Features ]
				 [ Access-Network-Info ]
				 [ User-Location-Info-Time ]
				…
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.STA, commandCode = CommandCodes.EAP, request = true, proxyable = true, name="Diameter-EAP-Request")
public interface EAPRequest extends SwaRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value) throws MissingAvpException;	
	
	String getCallingStationId();
	
	void setCallingStationId(String value);	
			
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);	
	
	String getANID();
	
	void setANID(String value);	
	
	ByteBuf getFullNetworkName();
	
	void setFullNetworkName(ByteBuf value);	
	
	ByteBuf getShortNetworkName();
	
	void setShortNetworkName(ByteBuf value);	
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	Long getAAAFailureIndication();
	
	void setAAAFailureIndication(Long value);
	
	TransportAccessTypeEnum getTransportAccessType();
	
	void setTransportAccessType(TransportAccessTypeEnum value);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);

	public AccessNetworkInfo getAccessNetworkInfo();
	
	void setAccessNetworkInfo(AccessNetworkInfo value);

	public Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
}