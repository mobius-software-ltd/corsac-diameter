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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6942.ERPRKRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sta.DERFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectivityParameters;
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLANIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	
 	5.2.2.1.1	Diameter-EAP-Request (DER) Command
	The Diameter-EAP-Request (DER) command, indicated by the Command-Code field set to 268 and the "R" bit set in the Command Flags field, is sent from a non-3GPP access network NAS to a 3GPP AAA server. The ABNF is re-used from the IETF RFC 5779 [2].

 	< Diameter-EAP-Request > ::=	< Diameter Header: 268, REQ, PXY, 16777250 >
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
					[ Calling-Station-Id ]
				…
					[ RAT-Type ]
					[ ANID ]
					[ Full-Network-Name ]
					[ Short-Network-Name ]
					[ QoS-Capability ]
					[ MIP6-Feature-Vector ]
					[ Visited-Network-Identifier ]
					[ Service-Selection ]
					[ Terminal-Information ]
					[ OC-Supported-Features ]
				*	[ Supported-Features ]
					[ AAA-Failure-Indication ]
					[ WLAN-Identifier ]
					[ DER-Flags ]
					[ TWAN-Connection-Mode ]
					[ TWAN-Connectivity-Parameters ]
				* 2 [ TWAG-CP-Address ]
					[ ERP-RK-Request ]
				…
				*	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777250, commandCode = 268, request = true, proxyable = true, name="Diameter-EAP-Request")
public interface EAPRequest extends StaRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
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
	
	QoSCapability getQoSCapability();
	
	void setQoSCapability(QoSCapability value);	
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	public TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);
	
	public OCSupportedFeatures getOCSupportedFeatures();
			
	void setOCSupportedFeatures(OCSupportedFeatures value);
							
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	Long getAAAFailureIndication();
	
	void setAAAFailureIndication(Long value);
	
	WLANIdentifier getWLANIdentifier();
	
	void setWLANIdentifier(WLANIdentifier value);
	
	DERFlags getDERFlags();
	
	void setDERFlags(DERFlags value);

	Long getTWANConnectionMode();
	
	void setTWANConnectionMode(Long value);
	
	TWANConnectivityParameters getTWANConnectivityParameters();
	
	void setTWANConnectivityParameters(TWANConnectivityParameters value);
	
	List<InetAddress> getTWAGCPAddress();
	
	void setTWAGCPAddress(List<InetAddress> value);
	
	ERPRKRequest getERPRKRequest();
	
	void setERPRKRequest(ERPRKRequest value);
}