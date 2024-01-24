package com.mobius.software.telco.protocols.diameter.commands.gi;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRoutingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginServiceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
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
 *  16a.4.2	AAA Command
	The AAA command, defined in Diameter NASREQ (IETF RFC 7155 [120]), is indicated by the Command-Code field set to 265 and the ‘R’ bit cleared in the Command Flags field., It is sent by the Diameter server to the GGSN/P-GW in response to the AAR command.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The "Tunneling" AVP may include the "Tunnel-Type" with value 3 to represent L2TP tunnel type, "Tunnel-Medium-Type" and "Tunnel-Server-Endpoint" AVPs. If more than one set of these "Tunneling" AVPs are provided, the optional "Tunnel-Preference" AVP may be provided in each set to identify the relative preference. The Tunnel-Password AVP may be used to authenticate to a remote server.
	NOTE:	The other optional AVPs within the "Tunneling" AVPs not listed in the above description, can be referred to the IETF RFC 7155 [120] with implementation specific.
	The bold marked AVPs in the message format indicate optional AVPs for Gi/Sgi, or modified existing AVPs.
	Message Format:
	<AA-Answer> ::= < Diameter Header: 265, PXY >
                      	< Session-Id >
                      	{ Auth-Application-Id }
                      	{ Auth-Request-Type }
                      	{ Result-Code }
                      	{ Origin-Host }
                      	{ Origin-Realm }
                      	[ User-Name ]
                      	[ Service-Type ]
                      *	[ Class ]
                      	[ Acct-Interim-Interval ]
                      	[ Error-Message ]
                      	[ Error-Reporting-Host ]
                       	[ Failed-AVP ]
                      	[ Idle-Timeout ]
                      	[ Authorization-Lifetime ]
                      	[ Auth-Grace-Period ]
                      	[ Auth-Session-State ]
                      	[ Re-Auth-Request-Type ]
                      	[ Multi-Round-Time-Out ]
                      	[ Session-Timeout ]
                      *	[ Reply-Message ]
                      	[ Origin-State-Id ]
                      *	[ Filter-Id ]
                      	[ Port-Limit ]
                      	[ Prompt ]
                      	[ Callback-Id ]
                      	[ Callback-Number ]
                      *	[ Framed-Compression ]
                      	[ Framed-Interface-Id ]
                      	[ Framed-IP-Address ]
                      *	[ Framed-IPv6-Prefix ]
                      	[ Framed-IPv6-Pool ]
                      *	[ Framed-IPv6-Route ]
                      *	[ Delegated-IPv6-Prefix ]
                     	[ Framed-IP-Netmask ]
                      *	[ Framed-Route ]
                      	[ Framed-Pool ]
                      	[ Framed-IPX-Network ]
                      	[ Framed-MTU ]
                      	[ Framed-Protocol ]
                      	[ Framed-Routing ]
                      *	[ Login-IP-Host ]
                      *	[ Login-IPv6-Host ]
                      	[ Login-LAT-Group ]
                      	[ Login-LAT-Node ]
                      	[ Login-LAT-Port ]
                      	[ Login-LAT-Service ]
                      	[ Login-Service ]
                      	[ Login-TCP-Port ]
                      *	[ NAS-Filter-Rule ]
                      *	[ QoS-Filter-Rule ]
                      *	[ Tunneling ]
                      *	[ Redirect-Host ]
                      	[ Redirect-Host-Usage ]
                      	[ Redirect-Max-Cache-Time ]
                      *	[ Proxy-Info ]
                      	[ 3GPP-IPv6-DNS-Servers ]
                      *	[ External-Identifier]
                      *	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 265, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends AuthenticationAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	ServiceTypeEnum getServiceType();		
	
	void setServiceType(ServiceTypeEnum value);
	
	List<ByteBuf> getDiameterClass();	
	
	void setDiameterClass(List<ByteBuf> value);			
	
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
	
	List<String> getReplyMessage();

	void setReplyMessage(List<String> value);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> value);	
	
	Long getPortLimit();
	
	void setPortLimit(Long value);	
	
	PromptEnum getPrompt();
	
	void setPrompt(PromptEnum value);	
	
	String getCallbackId();
	
	void setCallbackId(String value);	
	
	String getCallbackNumber();
	
	void setCallbackNumber(String value);	
	
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
	
	List<ByteBuf> getDelegatedIPv6Prefix();
	
	void setDelegatedIPv6Prefix(List<ByteBuf> value);	
	
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
	
	ByteBuf getTGPPIPv6DNSServers();
	
	void setTGPPIPv6DNSServers(ByteBuf value);	
	
	List<String> getExternalIdentifier();
	
	void setExternalIdentifier(List<String> value);		
}