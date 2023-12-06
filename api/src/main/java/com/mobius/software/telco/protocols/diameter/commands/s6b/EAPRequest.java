package com.mobius.software.telco.protocols.diameter.commands.s6b;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.2.2.1.1	Diameter-EAP-Request (DER) Command
	The Diameter-EAP-Request (DER) command, indicated by the Command-Code field set to 268 and the "R" bit set in the Command Flags field, is sent from a PGW to a 3GPP AAA server. The Command Code value and the ABNF are re-used from the IETF RFC 5778 [11].

	< Diameter-EAP-Request > ::=	< Diameter Header: 268, REQ, PXY, 16777272 >
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 { Auth-Request-Type }
			 [ RAT-Type ]
			 [ User-Name ]
			 [ Service-Selection ]
			 { EAP-Payload }
			 [ MIP6-Feature-Vector ]
			 [ MIP6-Agent-Info ]
			 [ QoS-Capability ]
			 [ Visited-Network-Identifier ]
			 [ MIP-Careof-Address ]
			 [ AAA-Failure-Indication ]
			*[ Supported-Features ]
			 [DER-S6b-Flags]
			 [ UE-Local-IP-Address]
			...
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777272, commandCode = 268, request = true, proxyable = true, name="Diameter-EAP-Request")
public interface EAPRequest extends S6bRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	QoSCapability getQoSCapability();
	
	void setQoSCapability(QoSCapability value);	
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
			
	InetAddress getMIPCareofAddress();
	
	void setMIPCareofAddress(InetAddress value);	

	Long getAAAFailureIndication();
	
	void setAAAFailureIndication(Long value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	Long getDERS6bFlags();
	
	void setDERS6bFlags(Long value);
	
	public InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
}