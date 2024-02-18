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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.2.2.2.1	AA-Request (AAR) Command
	The AA-Request (AAR) command, indicated by the Command-Code field set to 265 and the "R" bit set in the Command Flags field, is sent from the PDN GW to the 3GPP AAA Server. The Command Code value and ABNF are re-used from the IETF RFC 4005 [4] AA-Request command. New AVPs are added using the *[AVP] extension mechanism in the original ABNF.
	NOTE:	This command is used for the S6b Authorization Procedure for PMIPv6 or GTPv2, and also for the S6b Service Authorization Information Update procedure for PMIPv6, GTPv2 or DSMIPv6 following a previous RAR/RAA command exchange initiated by the 3GPP AAA Server.

	<AA-Request> ::=	< Diameter Header: 265, REQ, PXY, 16777272 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Auth-Request-Type }
				 [ User-Name ]
				 [ MIP6-Agent-Info ]
				 [ MIP6-Feature-Vector ]
				 [ Visited-Network-Identifier ]
				 [ QoS-Capability ]
				 [ Service-Selection ]
				 [ OC-Supported-Features ]
				 [ Origination-Time-Stamp ]
				 [ Maximum-Wait-Time ]
				*[ Supported-Features ]
				 [ Emergency- Services ]
				...
				*[ AVP ]	
				
	9.2.2.5.1	AA-Request (AAR) Command
	The AA-Request (AAR) command, indicated by the Command-Code field set to 265 and the "R" bit set in the Command Flags field, is sent from a PDN GW to a 3GPP AAA Server. The Command Code value and ABNF are re-used from the IETF RFC 4005 [4] AA-Request command. New AVPs are added using the *[AVP] extension mechanism in the original ABNF.

	<AA-Request> ::=	< Diameter Header: 265, REQ, PXY, 16777272 >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Auth-Request-Type }
				 [ User-Name ]
				 [ MIP6-Agent-Info ]
				 [ MIP6-Feature-Vector ]
				 [ Visited-Network-Identifier ]
				 [ QoS-Capability ]
				 [ Service-Selection ]
				*[ Supported-Features ]
				 [MIP-MN-HA-SPI]
				 [ OC-Supported-Features ]
				...
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S6B, commandCode = CommandCodes.AAA, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends S6bRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
	
	QoSCapability getQoSCapability();
	
	void setQoSCapability(QoSCapability value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
					 
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);

	Long getMIPMNHASPI();
	
	void setMIPMNHASPI(Long value);

	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	Long getOriginationTimeStamp();
	
	void setOriginationTimeStamp(Long value);
	
	Long getMaximumWaitTime();
	
	void setMaximumWaitTime(Long value);
					 
	EmergencyServices getEmergencyServices();
	
	void setEmergencyServices(EmergencyServices value);
}