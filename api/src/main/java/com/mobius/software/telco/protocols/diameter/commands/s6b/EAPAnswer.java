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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  9.2.2.1.2	Diameter-EAP-Answer (DEA) Command
	The Diameter-EAP-Answer (DEA) command, indicated by the Command-Code field set to 268 and the "R" bit cleared in the Command Flags field, is sent from a 3GPP AAA server to a PGW. The Command Code value and the ABNF are re-used from the IETF RFC 5778 [11].
  	<Diameter-EAP-Answer> ::= < Diameter Header: 268, PXY, 16777272 >

				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Auth-Request-Type }
				 { Result-Code }
				 { Origin-Host }
				 { Origin-Realm }
				 [ User-Name ]
				 [ EAP-Payload ]
				 [ EAP-Master-Session-Key ]
				 [ Mobile-Node-Identifier ]
				 [ APN-Configuration ]
				 [ MIP6-Agent-Info ]
				 [ MIP6-Feature-Vector ]
				 [ 3GPP-Charging-Characteristics ]
				*[ QoS-Resources ]
				*[ Redirect-Host ]
				 [ Trace-Info ]
				*[ Supported-Features ]
				...
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777272, commandCode = 268, request = false, proxyable = true, name="Diameter-EAP-Answer")
public interface EAPAnswer extends S6bAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
	ByteBuf getEAPMasterSessionKey();
	
	void setEAPMasterSessionKey(ByteBuf value);	
	
	String getMobileNodeIdentifier();
	
	void setMobileNodeIdentifier(String value);	
	        		  
	APNConfiguration getAPNConfiguration();
	
	void setAPNConfiguration(APNConfiguration value);	
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);	
	 
	List<QoSResources> getQoSResources();
		
	void setQoSResources(List<QoSResources> value);
		
	TraceInfo getTraceInfo();
	
	void setTraceInfo(TraceInfo value);	
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
}