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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	
 	7.2.2.1.1	Diameter-EAP-Request (DER) Command
	The Diameter-EAP-Request (DER) command, indicated by the Command-Code field set to 268 and the "R" bit set in the Command Flags field, is sent from a ePDG to a 3GPP AAA Server/Proxy. The ABNF is based on the one in IETF RFC 5779 [2].
	< Diameter-EAP-Request > ::=	< Diameter Header: 268, REQ, PXY, 16777264 >
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 [ Destination-Host ]
			 { Auth-Request-Type }
			 { EAP-Payload }
			 [ User-Name ]
			 [ RAT-Type ]
			 [ Service-Selection ]
			 [ MIP6-Feature-Vector ]
			 [ QoS-Capability ]
			 [ Visited-Network-Identifier ]
			 [ AAA-Failure-Indication ]
			*[ Supported-Features ]
			 [ UE-Local-IP-Address ]
			 [ OC-Supported-Features ]
			 [ Terminal-Information ]
			 [ Emergency- Services ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777264, commandCode = 268, request = true, proxyable = true, name="Diameter-EAP-Request")
public interface EAPRequest extends SwmRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);	
	
	void setServiceSelection(String value);	
	
	String getServiceSelection();
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	QoSCapability getQoSCapability();
	
	void setQoSCapability(QoSCapability value);	
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
	
	Long getAAAFailureIndication();
	
	void setAAAFailureIndication(Long value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	public OCSupportedFeatures getOCSupportedFeatures();
			
	void setOCSupportedFeatures(OCSupportedFeatures value);
							
	public TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);
	
	Long getEmergencyServices();
	
	void setEmergencyServices(Long value);
}