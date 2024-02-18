package com.mobius.software.telco.protocols.diameter.commands.eap;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * The Diameter-EAP-Request (DER) command, indicated by the Command-Code
   field set to 268 and the 'R' bit set in the Command Flags field, is
   sent by a Diameter client to a Diameter server, and conveys an
   EAP-Response from the EAP client.  The Diameter-EAP-Request MUST
   contain one EAP-Payload AVP containing the actual EAP payload.  An
   EAP-Payload AVP with no data MAY be sent to the Diameter server to
   initiate an EAP authentication session.

   The DER message MAY be the result of a multi-round authentication
   exchange that occurs when the DEA is received with the Result-Code
   AVP set to DIAMETER_MULTI_ROUND_AUTH [BASE].  A subsequent DER
   message MUST include any State AVPs [NASREQ] that were present in the
   DEA.  For re-authentication, it is recommended that the Identity
   request be skipped in order to reduce the number of authentication
   round trips.  This is only possible when the user's identity is
   already known by the home Diameter server.

   Message format

      <Diameter-EAP-Request> ::= < Diameter Header: 268, REQ, PXY >
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
                                 [ Origin-State-Id ]
                                 [ Port-Limit ]
                                 [ User-Name ]
                                 { EAP-Payload }
                                 [ EAP-Key-Name ]
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
                               * [ Framed-Compression ]
                                 [ Framed-Interface-Id ]
                                 [ Framed-IP-Address ]
                               * [ Framed-IPv6-Prefix ]
                                 [ Framed-IP-Netmask ]
                                 [ Framed-MTU ]
                                 [ Framed-Protocol ]
                               * [ Tunneling ]
                               * [ Proxy-Info ]
                               * [ Route-Record ]
                               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.EAP, commandCode = CommandCodes.EAP, request = true, proxyable = true, name="EAP-Request")
public interface EAPRequest extends AuthenticationRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	String getNASIdentifier();
	
	void setNASIdentifier(String value);	
	
	InetAddress getNASIPAddress();
	
	void setNASIPAddress(Inet4Address value);	
	
	InetAddress getNASIPv6Address();
	
	void setNASIPv6Address(Inet6Address value);	
	
	Long getNASPort();
	
	void setNASPort(Long value);	
	
	String getNASPortId();
	
	void setNASPortId(String value);	
	
	NASPortTypeEnum getNASPortType();
	
	void setNASPortType(NASPortTypeEnum value);	
	
	Long getPortLimit();
	
	void setPortLimit(Long value);	
	
	ByteBuf getUserPassword();
	
	void setUserPassword(ByteBuf value);	
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value) throws MissingAvpException;	
	
	ByteBuf getEAPKeyName();
	
	void setEAPKeyName(ByteBuf value);	
	
	ServiceTypeEnum getServiceType();
	
	void setServiceType(ServiceTypeEnum value);	
	
	ByteBuf getState();
	
	void setState(ByteBuf value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	String getCallbackNumber();
	
	void setCallbackNumber(String value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	String getCallingStationId();
	
	void setCallingStationId(String value);
	
	ByteBuf getOriginatingLineInfo();
	
	void setOriginatingLineInfo(ByteBuf value);	

	String getConnectInfo();
	
	void setConnectInfo(String value);	
	
	List<FramedCompressionEnum> getFramedCompression();
	
	void setFramedCompression(List<FramedCompressionEnum> value);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	List<ByteBuf> getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(List<ByteBuf> value);	
	
	ByteBuf getFramedIPNetmask();
	
	void setFramedIPNetmask(ByteBuf value);	
	
	Long getFramedMTU();
	
	void setFramedMTU(Long value);	
	
	FramedProtocolEnum getFramedProtocol();
	
	void setFramedProtocol(FramedProtocolEnum value);	
	
	List<Tunneling> getTunneling();
	
	void setTunneling(List<Tunneling> value);	
}