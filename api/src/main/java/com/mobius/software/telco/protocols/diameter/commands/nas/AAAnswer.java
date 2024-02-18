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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ARAPZoneAccessEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRoutingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginServiceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.PromptEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *   The AA-Answer (AAA) message is indicated by setting the Command Code
   field to 265 and clearing the 'R' bit in the Command Flags field.  It
   is sent in response to the AA-Request (AAR) message.  If
   authorization was requested, a successful response will include the
   authorization AVPs appropriate for the service being provided, as
   defined in Section 4.4.

   For authentication exchanges requiring more than a single round trip,
   the server MUST set the Result-Code AVP to DIAMETER_MULTI_ROUND_AUTH.

   An AAA message with this result code MAY include one Reply-Message or
   more and MAY include zero or one State AVPs.

   If the Reply-Message AVP was present, the network access server
   SHOULD send the text to the user's client to display to the user,
   instructing the client to prompt the user for a response.  For
   example, this can be achieved in PPP via PAP.  If it is impossible to
   deliver the text prompt to the user, the Diameter NAS Application
   client MUST treat the AA-Answer (AAA) with the Reply-Message AVP as
   an error and deny access.

      Message Format

         <AA-Answer> ::= < Diameter Header: 265, PXY >
                         < Session-Id >
                         { Auth-Application-Id }
                         { Auth-Request-Type }
                         { Result-Code }
                         { Origin-Host }
                         { Origin-Realm }
                         [ User-Name ]
                         [ Service-Type ]
                       * [ Class ]
                       * [ Configuration-Token ]
                         [ Acct-Interim-Interval ]
                         [ Error-Message ]
                         [ Error-Reporting-Host ]
                       * [ Failed-AVP ]
                         [ Idle-Timeout ]
                         [ Authorization-Lifetime ]
                         [ Auth-Grace-Period ]
                         [ Auth-Session-State ]
                         [ Re-Auth-Request-Type ]
                         [ Multi-Round-Time-Out ]
                         [ Session-Timeout ]
                         [ State ]
                       * [ Reply-Message ]
                         [ Origin-AAA-Protocol ]
                         [ Origin-State-Id ]
                       * [ Filter-Id ]
                         [ Password-Retry ]
                         [ Port-Limit ]
                         [ Prompt ]
                         [ ARAP-Challenge-Response ]
                         [ ARAP-Features ]
                         [ ARAP-Security ]
                       * [ ARAP-Security-Data ]
                         [ ARAP-Zone-Access ]
                         [ Callback-Id ]
                         [ Callback-Number ]
                         [ Framed-Appletalk-Link ]
                       * [ Framed-Appletalk-Network ]
                         [ Framed-Appletalk-Zone ]
                       * [ Framed-Compression ]
                         [ Framed-Interface-Id ]
                         [ Framed-IP-Address ]
                       * [ Framed-IPv6-Prefix ]
                         [ Framed-IPv6-Pool ]
                       * [ Framed-IPv6-Route ]
                         [ Framed-IP-Netmask ]
                       * [ Framed-Route ]
                         [ Framed-Pool ]
                         [ Framed-IPX-Network ]
                         [ Framed-MTU ]
                         [ Framed-Protocol ]
                         [ Framed-Routing ]
                       * [ Login-IP-Host ]
                       * [ Login-IPv6-Host ]
                         [ Login-LAT-Group ]
                         [ Login-LAT-Node ]
                         [ Login-LAT-Port ]
                         [ Login-LAT-Service ]
                         [ Login-Service ]
                         [ Login-TCP-Port ]
                       * [ NAS-Filter-Rule ]
                       * [ QoS-Filter-Rule ]
                       * [ Tunneling ]
                       * [ Redirect-Host ]
                         [ Redirect-Host-Usage ]
                         [ Redirect-Max-Cache-Time ]
                       * [ Proxy-Info ]
                       * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NASREQ, commandCode = CommandCodes.AAA, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends AuthenticationAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	ServiceTypeEnum getServiceType();		
	
	void setServiceType(ServiceTypeEnum value);
	
	List<ByteBuf> getDiameterClass();	
	
	void setDiameterClass(List<ByteBuf> value);			
	
	List<ByteBuf> getConfigurationToken();

	void setConfigurationToken(List<ByteBuf> value);	
	
	public Long getAcctInterimInterval();
	
	void setAcctInterimInterval(Long value);
	
	Long getIdleTimeout();
	
	void setIdleTimeout(Long value);	
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);	
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);	
	
	public ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value);		
	
	Long getMultiRoundTimeOut();
	
	void setMultiRoundTimeOut(Long value);	
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);	
	
	ByteBuf getState();
	
	void setState(ByteBuf value);	
	
	List<String> getReplyMessage();

	void setReplyMessage(List<String> value);	
	
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum value);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> value);	
	
	Long getPasswordRetry();
	
	void setPasswordRetry(Long value);	
	
	Long getPortLimit();
	
	void setPortLimit(Long value);	
	
	PromptEnum getPrompt();
	
	void setPrompt(PromptEnum value);	
	
	ByteBuf getARAPChallengeResponse();
	
	void setARAPChallengeResponse(ByteBuf value);	
	
	Long getARAPSecurity();
	
	void setARAPSecurity(Long value);	
	
	List<ByteBuf> getARAPSecurityData();
	
	void setARAPSecurityData(List<ByteBuf> value);	
	
	ByteBuf getARAPFeatures();
	
	void setARAPFeatures(ByteBuf value);	
	
	ARAPZoneAccessEnum getARAPZoneAccess();
	
	void setARAPZoneAccess(ARAPZoneAccessEnum value);	
            		 
	String getCallbackId();
	
	void setCallbackId(String value);	
	
	String getCallbackNumber();
	
	void setCallbackNumber(String value);	
	
	Long getFramedAppletalkLink();
	
	void setFramedAppletalkLink(Long value);	
	
	List<Long> getFramedAppletalkNetwork();
	
	void setFramedAppletalkNetwork(List<Long> value);	
	
	ByteBuf getFramedAppletalkZone();
	
	void setFramedAppletalkZone(ByteBuf value);	
	
	List<FramedCompressionEnum> getFramedCompression();
	
	void setFramedCompression(List<FramedCompressionEnum> value);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	List<ByteBuf> getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(List<ByteBuf> value);	
	
	ByteBuf getFramedIPv6Pool();
	
	void setFramedIPv6Pool(ByteBuf value);	
	
	List<String> getFramedIPv6Route();
	
	void setFramedIPv6Route(List<String> value);	
	
	ByteBuf getFramedIPNetmask();
	
	void setFramedIPNetmask(ByteBuf value);	
	
	List<ByteBuf> getFramedRoute();
	
	void setFramedRoute(List<ByteBuf> value);	
	
	ByteBuf getFramedPool();
	
	void setFramedPool(ByteBuf value);	
	
	Long getFramedIPXNetwork();
	
	void setFramedIPXNetwork(Long value);	
	
	Long getFramedMTU();
	
	void setFramedMTU(Long value);	
	
	FramedProtocolEnum getFramedProtocol();
	
	void setFramedProtocol(FramedProtocolEnum value);	
	
	FramedRoutingEnum getFramedRouting();
	
	void setFramedRouting(FramedRoutingEnum value);	
	
	List<InetAddress> getLoginIPHost();
	
	void setLoginIPHost(List<Inet4Address> value);	
	
	List<InetAddress> getLoginIPv6Host();
	
	void setLoginIPv6Host(List<Inet6Address> value);	
	
	ByteBuf getLoginLATGroup();
	
	void setLoginLATGroup(ByteBuf value);	
	
	ByteBuf getLoginLATNode();
	
	void setLoginLATNode(ByteBuf value);	
	
	ByteBuf getLoginLATPort();
	
	void setLoginLATPort(ByteBuf value);	
	
	ByteBuf getLoginLATService();
	
	void setLoginLATService(ByteBuf value);	
	
	LoginServiceEnum getLoginService();
	
	void setLoginService(LoginServiceEnum value);	
	
	Long getLoginTCPPort();
	
	void setLoginTCPPort(Long value);	
	
	List<NASFilterRule> getNASFilterRule();
	
	void setNASFilterRule(List<NASFilterRule> value);	
	
	List<DiameterQosFilterRule> getQosFilterRule();
	
	void setQosFilterRule(List<DiameterQosFilterRule> value);		
	
	List<Tunneling> getTunneling();
	
	void setTunneling(List<Tunneling> value);					
}