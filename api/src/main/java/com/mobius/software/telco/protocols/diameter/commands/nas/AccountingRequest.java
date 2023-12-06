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
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingAuthMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctAuthenticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRoutingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginServiceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
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
 * The ACR message [RFC6733] is sent by the NAS to report its session
   information to a target server downstream.

   The Acct-Application-Id AVP MUST be present.

   The AVPs listed in the Diameter Base protocol specification [RFC6733]
   MUST be assumed to be present, as appropriate.  NAS service-specific
   accounting AVPs SHOULD be present as described in Section 4.6 and the
   rest of this specification.

      Message Format

         <AC-Request> ::= < Diameter Header: 271, REQ, PXY >
                         < Session-Id >
                         { Origin-Host }
                         { Origin-Realm }
                         { Destination-Realm }
                         { Accounting-Record-Type }
                         { Accounting-Record-Number }
                         { Acct-Application-Id }
                         [ User-Name ]
                         [ Accounting-Sub-Session-Id ]
                         [ Acct-Session-Id ]
                         [ Acct-Multi-Session-Id ]
                         [ Origin-AAA-Protocol ]
                         [ Origin-State-Id ]
                         [ Destination-Host ]
                         [ Event-Timestamp ]
                         [ Acct-Delay-Time ]
                         [ NAS-Identifier ]
                         [ NAS-IP-Address ]
                         [ NAS-IPv6-Address ]
                         [ NAS-Port ]
                         [ NAS-Port-Id ]
                         [ NAS-Port-Type ]
                       * [ Class ]
                         [ Service-Type ]
                         [ Termination-Cause ]
                         [ Accounting-Input-Octets ]
                         [ Accounting-Input-Packets ]
                         [ Accounting-Output-Octets ]
                         [ Accounting-Output-Packets ]
                         [ Acct-Authentic ]
                         [ Accounting-Auth-Method ]
                         [ Acct-Link-Count ]
                         [ Acct-Session-Time ]
                         [ Acct-Tunnel-Connection ]
                         [ Acct-Tunnel-Packets-Lost ]
                         [ Callback-Id ]
                         [ Callback-Number ]
                         [ Called-Station-Id ]
                         [ Calling-Station-Id ]
                       * [ Connection-Info ]
                         [ Originating-Line-Info ]
                         [ Authorization-Lifetime ]
                         [ Session-Timeout ]
                         [ Idle-Timeout ]
                         [ Port-Limit ]
                         [ Accounting-Realtime-Required ]
                         [ Acct-Interim-Interval ]
                       * [ Filter-Id ]
                       * [ NAS-Filter-Rule ]
                       * [ QoS-Filter-Rule ]
                         [ Framed-Appletalk-Link ]
                         [ Framed-Appletalk-Network ]
                         [ Framed-Appletalk-Zone ]
                         [ Framed-Compression ]
                         [ Framed-Interface-Id ]
                         [ Framed-IP-Address ]
                         [ Framed-IP-Netmask ]
                       * [ Framed-IPv6-Prefix ]
                         [ Framed-IPv6-Pool ]
                       * [ Framed-IPv6-Route ]
                         [ Framed-IPX-Network ]
                         [ Framed-MTU ]
                         [ Framed-Pool ]
                         [ Framed-Protocol ]
                       * [ Framed-Route ]
                         [ Framed-Routing ]
                       * [ Login-IP-Host ]
                       * [ Login-IPv6-Host ]
                         [ Login-LAT-Group ]
                         [ Login-LAT-Node ]
                         [ Login-LAT-Port ]
                         [ Login-LAT-Service ]
                         [ Login-Service ]
                         [ Login-TCP-Port ]
                       * [ Tunneling ]
                       * [ Proxy-Info ]
                       * [ Route-Record ]
                       * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 271, request = true, proxyable = true, name="Accounting-Request")
public interface AccountingRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest
{	
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum value);	
	
	Long getAcctDelayTime();
	
	void setAcctDelayTime(Long value);	
	
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
	
	List<ByteBuf> getDiameterClass();
	
	void setDiameterClass(List<ByteBuf> value);	
	
	ServiceTypeEnum getServiceType();
	
	void setServiceType(ServiceTypeEnum value);	
	
	TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);	
	
	Long getAccountingInputOctets();
	
	void setAccountingInputOctets(Long value);	
	
	Long getAccountingInputPackets();
	
	void setAccountingInputPackets(Long value);	
	
	Long getAccountingOutputOctets();
	
	void setAccountingOutputOctets(Long value);	
	
	Long getAccountingOutputPackets();
	
	void setAccountingOutputPackets(Long value);	
	
	AcctAuthenticEnum getAcctAuthentic();
	
	void setAcctAuthentic(AcctAuthenticEnum value);	
	
	AccountingAuthMethodEnum getAccountingAuthMethod();
	
	void setAccountingAuthMethod(AccountingAuthMethodEnum value);	
	
	Long getAcctLinkCount();
	
	void setAcctLinkCount(Long value);	
	
	Long getAcctSessionTime();
	
	void setAcctSessionTime(Long value);	
	
	ByteBuf getAcctTunnelConnection();
	
	void setAcctTunnelConnection(ByteBuf value);	

	Long getAcctTunnelPacketsLost();
	
	void setAcctTunnelPacketsLost(Long value);	
	
	String getCallbackId();
	
	void setCallbackId(String value);	
	
	String getCallbackNumber();
	
	void setCallbackNumber(String value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	String getCallingStationId();
	
	void setCallingStationId(String value);
	
	List<String> getConnectionInfo();
	
	void setConnectionInfo(List<String> value);	
	
	ByteBuf getOriginatingLineInfo();
	
	void setOriginatingLineInfo(ByteBuf value);	

	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);	
	
	Long getIdleTimeout();
	
	void setIdleTimeout(Long value);	
	
	Long getPortLimit();
	
	void setPortLimit(Long value);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> value);	
	
	List<NASFilterRule> getNASFilterRule();
	
	void setNASFilterRule(List<NASFilterRule> value);	
	
	List<DiameterQosFilterRule> getQosFilterRule();
	
	void setQosFilterRule(List<DiameterQosFilterRule> value);	
	
	Long getFramedAppletalkLink();
	
	void setFramedAppletalkLink(Long value);	
	
	Long getFramedAppletalkNetwork();
	
	void setFramedAppletalkNetwork(Long value);	
	
	ByteBuf getFramedAppletalkZone();
	
	void setFramedAppletalkZone(ByteBuf value);	
	
	FramedCompressionEnum getFramedCompression();
	
	void setFramedCompression(FramedCompressionEnum value);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPNetmask();
	
	void setFramedIPNetmask(ByteBuf value);	
	
	List<ByteBuf> getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(List<ByteBuf> value);	
	
	ByteBuf getFramedIPv6Pool();
	
	void setFramedIPv6Pool(ByteBuf value);	
	
	List<String> getFramedIPv6Route();
	
	void setFramedIPv6Route(List<String> value);	
	
	Long getFramedIPXNetwork();
	
	void setFramedIPXNetwork(Long value);	
	
	Long getFramedMTU();
	
	void setFramedMTU(Long value);	
	
	ByteBuf getFramedPool();
	
	void setFramedPool(ByteBuf value);	
	
	FramedProtocolEnum getFramedProtocol();
	
	void setFramedProtocol(FramedProtocolEnum value);	
	
	List<ByteBuf> getFramedRoute();
	
	void setFramedRoute(List<ByteBuf> value);	
	
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
	
	List<Tunneling> getTunneling();
	
	void setTunneling(List<Tunneling> value);	
}