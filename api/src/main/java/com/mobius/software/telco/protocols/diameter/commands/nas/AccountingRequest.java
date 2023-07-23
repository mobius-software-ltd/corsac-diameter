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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccountingAuthMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AcctAuthenticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
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
@DiameterCommandDefinition(applicationId = 1, commandCode = 257, request = true, proxyable = true, name="Accounting-Request")
public interface AccountingRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest
{	
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum originAAAProtocol);	
	
	Long getAcctDelayTime();
	
	void setAcctDelayTime(Long acctDelayTime);	
	
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
	
	List<ByteBuf> getDiameterClass();
	
	void setDiameterClass(List<ByteBuf> diameterClass);	
	
	ServiceTypeEnum getServiceType();
	
	void setServiceType(ServiceTypeEnum serviceType);	
	
	TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum terminationCauseEnum);	
	
	Long getAccountingInputOctets();
	
	void setAccountingInputOctets(Long accountingInputOctets);	
	
	Long getAccountingInputPackets();
	
	void setAccountingInputPackets(Long accountingInputPackets);	
	
	Long getAccountingOutputOctets();
	
	void setAccountingOutputOctets(Long accountingOutputOctets);	
	
	Long getAccountingOutputPackets();
	
	void setAccountingOutputPackets(Long accountingOutputPackets);	
	
	AcctAuthenticEnum getAcctAuthentic();
	
	void setAcctAuthentic(AcctAuthenticEnum acctAuthentic);	
	
	AccountingAuthMethodEnum getAccountingAuthMethod();
	
	void setAccountingAuthMethod(AccountingAuthMethodEnum accountingAuthMethod);	
	
	Long getAcctLinkCount();
	
	void setAcctLinkCount(Long acctLinkCount);	
	
	Long getAcctSessionTime();
	
	void setAcctSessionTime(Long acctSessionTime);	
	
	ByteBuf getAcctTunnelConnection();
	
	void setAcctTunnelConnection(ByteBuf tunnelConnection);	

	Long getAcctTunnelPacketsLost();
	
	void setAcctTunnelPacketsLost(Long tunnelPacketsLost);	
	
	String getCallbackId();
	
	void setCallbackId(String callbackId);	
	
	String getCallbackNumber();
	
	void setCallbackNumber(String callbackNumber);	
	
	String getCalledStationId();
	
	void setCalledStationId(String calledStationId);	
	
	String getCallingStationId();
	
	void setCallingStationId(String callingStationId);
	
	List<String> getConnectionInfo();
	
	void setConnectionInfo(List<String> connectionInfo);	
	
	ByteBuf getOriginatingLineInfo();
	
	void setOriginatingLineInfo(ByteBuf originatingLineInfo);	

	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long authorizationLifetime);	
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long sessionTimeout);	
	
	Long getIdleTimeout();
	
	void setIdleTimeout(Long idleTimeout);	
	
	Long getPortLimit();
	
	void setPortLimit(Long portLimit);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> filterId);	
	
	List<NASFilterRule> getNASFilterRule();
	
	void setNASFilterRule(List<NASFilterRule> nasFilterRule);	
	
	List<DiameterQosFilterRule> getQosFilterRule();
	
	void setQosFilterRule(List<DiameterQosFilterRule> qosFilterRule);	
	
	Long getFramedAppletalkLink();
	
	void setFramedAppletalkLink(Long framedAppletalkLink);	
	
	Long getFramedAppletalkNetwork();
	
	void setFramedAppletalkNetwork(Long framedAppletalkNetwork);	
	
	ByteBuf getFramedAppletalkZone();
	
	void setFramedAppletalkZone(ByteBuf framedAppletalkZone);	
	
	FramedCompressionEnum getFramedCompression();
	
	void setFramedCompression(FramedCompressionEnum framedCompression);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long framedInterfaceId);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address framedIPAddress);	
	
	ByteBuf getFramedIPNetmask();
	
	void setFramedIPNetmask(ByteBuf framedIPNetmask);	
	
	List<ByteBuf> getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(List<ByteBuf> framedIPv6Prefix);	
	
	ByteBuf getFramedIPv6Pool();
	
	void setFramedIPv6Pool(ByteBuf framedIPv6Pool);	
	
	List<String> getFramedIPv6Route();
	
	void setFramedIPv6Route(List<String> framedIPv6Route);	
	
	Long getFramedIPXNetwork();
	
	void setFramedIPXNetwork(Long framedIPXNetwork);	
	
	Long getFramedMTU();
	
	void setFramedMTU(Long framedMTU);	
	
	ByteBuf getFramedPool();
	
	void setFramedPool(ByteBuf framedPool);	
	
	FramedProtocolEnum getFramedProtocol();
	
	void setFramedProtocol(FramedProtocolEnum framedProtocol);	
	
	List<ByteBuf> getFramedRoute();
	
	void setFramedRoute(List<ByteBuf> framedRoute);	
	
	FramedRoutingEnum getFramedRouting();
	
	void setFramedRouting(FramedRoutingEnum framedRouting);	
	
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
	
	LoginServiceEnum getLoginService();
	
	void setLoginService(LoginServiceEnum loginService);	
	
	Long getLoginTCPPort();
	
	void setLoginTCPPort(Long loginTCPPort);	
	
	List<Tunneling> getTunneling();
	
	void setTunneling(List<Tunneling> tunneling);	
}