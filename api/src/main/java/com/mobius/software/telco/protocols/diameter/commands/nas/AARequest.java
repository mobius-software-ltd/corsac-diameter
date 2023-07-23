package com.mobius.software.telco.protocols.diameter.commands.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPAuth;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * The AA-Request (AAR), which is indicated by setting the Command Code
   field to 265 and the 'R' bit in the Command Flags field, is used to
   request authentication and/or authorization for a given NAS user.
   The type of request is identified through the Auth-Request-Type AVP
   [RFC6733].  The recommended value for most situations is
   AUTHORIZE_AUTHENTICATE.

      Message Format

         <AA-Request> ::= < Diameter Header: 265, REQ, PXY >
                          < Session-Id >
                          { Auth-Application-Id }
                          { Origin-Host }
                          { Origin-Realm }
                          { Destination-Realm }
                          { Auth-Request-Type }
                          [ Destination-Host ]
                          [ NAS-Identifier ]
                          [ NAS-IP-Address ]
                          [ NAS-IPv6-Address ]
                          [ NAS-Port ]
                          [ NAS-Port-Id ]
                          [ NAS-Port-Type ]
                          [ Origin-AAA-Protocol ]
                          [ Origin-State-Id ]
                          [ Port-Limit ]
                          [ User-Name ]
                          [ User-Password ]
                          [ Service-Type ]
                          [ State ]
                          [ Authorization-Lifetime ]
                          [ Auth-Grace-Period ]
                          [ Auth-Session-State ]
                          [ Callback-Number ]
                          [ Called-Station-Id ]
                          [ Calling-Station-Id ]
                          [ Originating-Line-Info ]
                          [ Connect-Info ]
                          [ CHAP-Auth ]
                          [ CHAP-Challenge ]
                        * [ Framed-Compression ]
                          [ Framed-Interface-Id ]
                          [ Framed-IP-Address ]
                        * [ Framed-IPv6-Prefix ]
                          [ Framed-IP-Netmask ]
                          [ Framed-MTU ]
                          [ Framed-Protocol ]
                          [ ARAP-Password ]
                          [ ARAP-Security ]
                        * [ ARAP-Security-Data ]
                        * [ Login-IP-Host ]
                        * [ Login-IPv6-Host ]
                          [ Login-LAT-Group ]
                          [ Login-LAT-Node ]
                          [ Login-LAT-Port ]
                          [ Login-LAT-Service ]
                        * [ Tunneling ]
                        * [ Proxy-Info ]
                        * [ Route-Record ]
                        * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 265, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends AuthenticationRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	String getNASIdentifier();
	
	void setNASIdentifier(String nasIdentifier);	
	
	InetAddress getNASIPAddress();
	
	void setNASIPAddress(Inet4Address nasIPAddress);	
	
	InetAddress getNASIPv6Address();
	
	void setNASIPv6Address(Inet6Address nasIPv6Address);	
	
	Long getNASPort();
	
	void setNASPort(Long nasPort);	
	
	String getNASPortId();
	
	void setNASPortId(String nasPortId);	
	
	NASPortTypeEnum getNASPortType();
	
	void setNASPortType(NASPortTypeEnum nasPortType);	
	
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum originAAAProtocol);	
	
	Long getPortLimit();
	
	void setPortLimit(Long portLimit);	
	
	ByteBuf getUserPassword();
	
	void setUserPassword(ByteBuf userPassword);	
	
	ServiceTypeEnum getServiceType();
	
	void setServiceType(ServiceTypeEnum serviceType);	
	
	ByteBuf getState();
	
	void setState(ByteBuf state);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long authorizationLifetime);	
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long authGracePeriod);	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum authSessionState);	
	
	String getCallbackNumber();
	
	void setCallbackNumber(String callbackNumber);	
	
	String getCalledStationId();
	
	void setCalledStationId(String calledStationId);	
	
	String getCallingStationId();
	
	void setCallingStationId(String callingStationId);
	
	ByteBuf getOriginatingLineInfo();
	
	void setOriginatingLineInfo(ByteBuf originatingLineInfo);	

	String getConnectInfo();
	
	void setConnectInfo(String connectInfo);	
	
	CHAPAuth getCHAPAuth();
	
	void setCHAPAuth(CHAPAuth chapAuth);	
	
	ByteBuf getCHAPChallenge();
	
	void setCHAPChallenge(ByteBuf chapChallenge);	
	
	List<FramedCompressionEnum> getFramedCompression();
	
	void setFramedCompression(List<FramedCompressionEnum> framedCompression);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long framedInterfaceId);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address framedIPAddress);	
	
	List<ByteBuf> getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(List<ByteBuf> framedIPv6Prefix);	
	
	ByteBuf getFramedIPNetmask();
	
	void setFramedIPNetmask(ByteBuf framedIPNetmask);	
	
	Long getFramedMTU();
	
	void setFramedMTU(Long framedMTU);	
	
	FramedProtocolEnum getFramedProtocol();
	
	void setFramedProtocol(FramedProtocolEnum framedProtocol);	
	
	ByteBuf getARAPPassword();
	
	void setARAPPassword(ByteBuf arapPassword);	
	
	Long getARAPSecurity();
	
	void setARAPSecurity(Long arapSecurity);	
	
	List<ByteBuf> getARAPSecurityData();
	
	void setARAPSecurityData(List<ByteBuf> arapSecurityData);	
	
	List<InetAddress> getLoginIPHost();
	
	void setLoginIPHost(List<Inet4Address> loginIPHost);	
	
	List<InetAddress> getLoginIPv6Host();
	
	void setLoginIPv6Host(List<Inet6Address> loginIPv6Host);	
	
	ByteBuf getLoginLATGroup();
	
	void setLoginLATGroup(ByteBuf loginLATGroup);	
	
	ByteBuf getLoginLATNode();
	
	void setLoginLATNode(ByteBuf loginLATNode);	
	
	ByteBuf getLoginLATPort();
	
	void setLoginLATPort(ByteBuf loginLATPort);	
	
	ByteBuf getLoginLATService();
	
	void setLoginLATService(ByteBuf loginLATService);	
	
	List<Tunneling> getTunneling();
	
	void setTunneling(List<Tunneling> tunneling);	
}