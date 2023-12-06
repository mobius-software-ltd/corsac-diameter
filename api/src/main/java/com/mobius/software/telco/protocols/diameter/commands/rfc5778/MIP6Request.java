package com.mobius.software.telco.protocols.diameter.commands.rfc5778;
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

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIP6AuthModeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.2.1.  MIP6-Request

   The MIP6-Request (MIR), indicated by the Command-Code field set to
   325 and the 'R' bit set in the Command Flags field, is sent by the
   HA, acting as a Diameter client, in order to request the
   authentication and authorization of an MN.

   Although the HA provides the Diameter server with replay protection-
   related information, the HA is responsible for the replay protection.

   The message format is shown below.

   <MIP6-Request> ::= < Diameter Header: 325, REQ, PXY >
                      < Session-ID >
                      { Auth-Application-Id }
                      { User-Name }
                      { Destination-Realm }
                      { Origin-Host }
                      { Origin-Realm }
                      { Auth-Request-Type }
                      [ Destination-Host ]
                      [ Origin-State-Id ]
                      [ NAS-Identifier ]
                      [ NAS-IP-Address ]
                      [ NAS-IPv6-Address ]
                      [ NAS-Port-Type ]
                      [ Called-Station-Id ]
                      [ Calling-Station-Id ]
                      [ MIP6-Feature-Vector ]
                      { MIP6-Auth-Mode }
                      [ MIP-MN-AAA-SPI ]
                      [ MIP-MN-HA-SPI ]
                   1*2{ MIP-Mobile-Node-Address }
                      { MIP6-Agent-Info }
                      { MIP-Careof-Address }
                      [ MIP-Authenticator ]
                      [ MIP-MAC-Mobility-Data ]
                      [ MIP-Timestamp ]
                      [ QoS-Capability ]
                    * [ QoS-Resources ]
                      [ Chargeable-User-Identity ]
                      [ Service-Selection ]
                      [ Authorization-Lifetime ]
                      [ Auth-Session-State ]
                    * [ Proxy-Info ]
                    * [ Route-Record ]
                    * [ AVP ]

   	If the MN is both authenticated and authorized for the mobility
   	service, then the Auth-Request-Type AVP is set to the value
   	AUTHORIZE_AUTHENTICATE.  This is the case when the MIP6-Auth-Mode is
   	set to the value MIP6_AUTH_MN_AAA.
 */
@DiameterCommandDefinition(applicationId = 8, commandCode = 325, request = true, proxyable = true, name="MIP6-Request")
public interface MIP6Request extends AuthenticationRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	String getNASIdentifier();
	
	void setNASIdentifier(String value);	
	
	InetAddress getNASIPAddress();
	
	void setNASIPAddress(Inet4Address value);	
	
	InetAddress getNASIPv6Address();
	
	void setNASIPv6Address(Inet6Address value);	
	
	NASPortTypeEnum getNASPortType();
	
	void setNASPortType(NASPortTypeEnum value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	String getCallingStationId();
	
	void setCallingStationId(String value);
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	MIP6AuthModeEnum getMIP6AuthMode();
	
	void setMIP6AuthMode(MIP6AuthModeEnum value);	
	
	Long getMIPMNAAASPI();
	
	void setMIPMNAAASPI(Long value);	
	
	Long getMIPMNHASPI();
	
	void setMIPMNHASPI(Long value);

	List<InetAddress> getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(List<InetAddress> value);	
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	InetAddress getMIPCareofAddress();
	
	void setMIPCareofAddress(InetAddress value);	

	ByteBuf getMIPAuthenticator();
	
	void setMIPAuthenticator(ByteBuf value);	

	ByteBuf getMIPMACMobilityData();
	
	void setMIPMACMobilityData(ByteBuf value);	

	ByteBuf getMIPTimestamp();
	
	void setMIPTimestamp(ByteBuf value);	
	
	QoSCapability getQoSCapability();
	
	void setQoSCapability(QoSCapability value);	
	
	List<QoSResources> getQoSResources();
	
	void setQoSResources(List<QoSResources> value);	
	
	ByteBuf getChargeableUserIdentity();
	
	void setChargeableUserIdentity(ByteBuf value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
}