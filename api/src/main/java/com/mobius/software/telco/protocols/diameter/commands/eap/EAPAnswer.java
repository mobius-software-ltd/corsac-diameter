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
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRoutingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.Tunneling;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  The Diameter-EAP-Answer (DEA) message, indicated by the Command-Code
   field set to 268 and the 'R' bit cleared in the Command Flags field,
   is sent by the Diameter server to the client for one of the following
   reasons:

   1.  The message is part of a multi-round authentication exchange, and
       the server is expecting a subsequent Diameter-EAP-Request.  This
       is indicated by setting the Result-Code to
       DIAMETER_MULTI_ROUND_AUTH, and MAY include zero or more State
       AVPs.

   2.  The EAP client has been successfully authenticated and
       authorized, in which case the message MUST include the
       Result-Code AVP indicating success, and SHOULD include an
       EAP-Payload of type EAP-Success.  This event MUST cause the
       access device to provide service to the EAP client.

   3.  The EAP client has not been successfully authenticated and/or
       authorized, and the Result-Code AVP is set to indicate failure.
       This message SHOULD include an EAP-Payload, but this AVP is not
       used to determine whether service is to be provided.

   If the message from the Diameter client included a request for
   authorization, a successful response MUST include the authorization
   AVPs that are relevant to the service being provided.

   Message format

      <Diameter-EAP-Answer> ::= < Diameter Header: 268, PXY >
                                < Session-Id >
                                { Auth-Application-Id }
                                { Auth-Request-Type }
                                { Result-Code }
                                { Origin-Host }
                                { Origin-Realm }
                                [ User-Name ]
                                [ EAP-Payload ]
                                [ EAP-Reissued-Payload ]
                                [ EAP-Master-Session-Key ]
                                [ EAP-Key-Name ]
                                [ Multi-Round-Time-Out ]
                                [ Accounting-EAP-Auth-Method ]
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
                                [ Session-Timeout ]
                                [ State ]
                              * [ Reply-Message ]
                                [ Origin-State-Id ]
                              * [ Filter-Id ]
                                [ Port-Limit ]
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
                              * [ NAS-Filter-Rule ]
                              * [ QoS-Filter-Rule ]
                              * [ Tunneling ]
                              * [ Redirect-Host ]
                                [ Redirect-Host-Usage ]
                                [ Redirect-Max-Cache-Time ]
                              * [ Proxy-Info ]
                              * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.EAP, commandCode = CommandCodes.EAP, request = false, proxyable = true, name="EAP-Answer")
public interface EAPAnswer extends AuthenticationAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
	ByteBuf getEAPReissuedPayload();
	
	void setEAPReissuedPayload(ByteBuf value);	
	
	ByteBuf getEAPMasterSessionKey();
	
	void setEAPMasterSessionKey(ByteBuf value);	
	
	ByteBuf getEAPKeyName();
	
	void setEAPKeyName(ByteBuf value);	
	        		  
	Long getMultiRoundTimeOut();
	
	void setMultiRoundTimeOut(Long value);	
	
	public Long getAccountingEAPAuthMethod();
	
	void setAccountingEAPAuthMethod(Long value);
	
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
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);	
	
	ByteBuf getState();
	
	void setState(ByteBuf value);	
	
	List<String> getReplyMessage();

	void setReplyMessage(List<String> value);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> value);	
	
	Long getPortLimit();
	
	void setPortLimit(Long value);	
	
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
	
	List<NASFilterRule> getNASFilterRule();
	
	void setNASFilterRule(List<NASFilterRule> value);	
	
	List<DiameterQosFilterRule> getQosFilterRule();
	
	void setQosFilterRule(List<DiameterQosFilterRule> value);		
	
	List<Tunneling> getTunneling();
	
	void setTunneling(List<Tunneling> value);					
}