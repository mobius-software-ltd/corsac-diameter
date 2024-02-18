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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingAuthMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AcctAuthenticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedCompressionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedRoutingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.LoginServiceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;
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
 * 	16a.4.3	ACR Command
	The ACR command, defined in IETF RFC 6733 (Diameter Base) [111], is indicated by the Command-Code field set to 271 and the ‘R’ bit set in the Command Flags field. It is sent by the GGSN/P-GW to the Diameter server to report accounting information for a certain IP-CAN bearer (e.g. PDP context) or an IP-CAN session of a certain user.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate optional AVPs for Gi/Sgi, or modified existing AVPs. For Sgi, some of the optional 3GPP vendor-specific AVPs listed in the message format below are not applicable. See table 9a in subclause 16a.5 to see the ones that are applicable.
	Message Format:
	<AC-Request> ::= < Diameter Header: 271, REQ, PXY >
                      	< Session-Id >
                      	{ Origin-Host }
                      	{ Origin-Realm }
                      	{ Destination-Realm }
                      	{ Accounting-Record-Type }
                      	{ Accounting-Record-Number }
                      	[ Acct-Application-Id ]
                      	[ User-Name ]
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
                      *	[ Class ]
                      	[ Service-Type ]
                      	[ Accounting-Input-Octets ]
                      	[ Accounting-Input-Packets ]
                      	[ Accounting-Output-Octets ]
                      	[ Accounting-Output-Packets ]
                      	[ Acct-Authentic ]
                      	[ Accounting-Auth-Method ]
                      	[ Acct-Session-Time ]
                      	[ Acct-Tunnel-Connection ]
                      	[ Acct-Tunnel-Packets-Lost ]
                      	[ Callback-Id ]
                      	[ Callback-Number ]
                      	[ Called-Station-Id ]
                      	[ Calling-Station-Id ]
                      *	[ Connection-Info ]
                      	[ Originating-Line-Info ]
                      	[ Authorization-Lifetime ]
                      	[ Session-Timeout ]
                      	[ Idle-Timeout ]
                      	[ Port-Limit ]
                      	[ Accounting-Realtime-Required ]
                      	[ Acct-Interim-Interval ]
                      *	[ Filter-Id ]
                      *	[ NAS-Filter-Rule ]
                      *	[ Qos-Filter-Rule ]
                      	[ Framed-Compression ]
                      	[ Framed-Interface-Id ]
                      	[ Framed-IP-Address ]
                      	[ Framed-IP-Netmask ]
                      *	[ Framed-IPv6-Prefix ]
                      	[ Framed-IPv6-Pool ]
                      *	[ Framed-IPv6-Route ] 
                      *	[ Delegated-IPv6-Prefix ]
                      	[ Framed-IPX-Network ]
                      	[ Framed-MTU ]
                      	[ Framed-Pool ]
                      	[ Framed-Protocol ]
                      *	[ Framed-Route ]
                      	[ Framed-Routing ]
                      *	[ Login-IP-Host ]
                      *	[ Login-IPv6-Host ]
                      	[ Login-LAT-Group ]
                      	[ Login-LAT-Node ]
                      	[ Login-LAT-Port ]
                      	[ Login-LAT-Service ]
                      	[ Login-Service ]
                      	[ Login-TCP-Port ]
                      *	[ Tunneling ]
                      *	[ Proxy-Info ]
                      *	[ Route-Record ]
                      	[ 3GPP-IMSI]
                      	[ External-Identifier]
                      	[ 3GPP-Charging-ID ]
                      	[ 3GPP-PDP-Type ]
                      	[ 3GPP-CG-Address ]
                      	[ 3GPP-GPRS-Negotiated-QoS-Profile ]
                      	[ 3GPP-SGSN-Address ]
                      	[ 3GPP-GGSN-Address ]
                      	[ 3GPP-IMSI-MCC-MNC ]
                      	[ 3GPP-GGSN-MCC-MNC ]
                      	[ 3GPP-NSAPI ]
                      	[ 3GPP-Selection-Mode ]
                      	[ 3GPP-Charging-Characteristics ]
                      	[ 3GPP-CG-IPv6-Address ]
                      	[ 3GPP-SGSN-IPv6-Address ]
                      	[ 3GPP-GGSN-IPv6-Address ]
                      	[ 3GPP-SGSN-MCC-MNC ]
                      	[ 3GPP-IMEISV ]
                      	[ 3GPP-RAT-Type ]
                      	[ 3GPP-User-Location-Info ]
                      	[ 3GPP-MS-Time-Zone ]
                      	[ 3GPP-CAMEL-Charging-Info ]
                      	[ 3GPP-Packet-Filter ]
                      	[ 3GPP-Negotiated-DSCP ]
                      	[ TWAN-Identifier ]
                      	[ 3GPP-User-Location-Info-Time ]
                     *	[ 3GPP-Secondary-RAT-Usage ]
                      	[ 3GPP-UE-Local-IP-Address ]
                      	[ 3GPP-UE-Source-Port ]
                     *	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NASREQ, commandCode = CommandCodes.ACCOUNTING, request = true, proxyable = true, name="Accounting-Request")
public interface AccountingRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest
{	
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
	
	List<ByteBuf> getDelegatedIPv6Prefix();
	
	void setDelegatedIPv6Prefix(List<ByteBuf> value);	
	
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

	String getTGPPIMSI();
	
	void setTGPPIMSI(String value);	
	
	String getExternalIdentifier();
	
	void setExternalIdentifier(String value);	

	ByteBuf getTGPPChargingId();
	
	void setTGPPChargingId(ByteBuf value);	

	TGPPPDPTypeEnum getTGPPPDPType();
	
	void setTGPPPDPType(TGPPPDPTypeEnum value);	
	
	ByteBuf getTGPPCGAddress();
	
	void setTGPPCGAddress(ByteBuf value);	

	String getTGPPGPRSNegotiatedQoSProfile();
	
	void setTGPPGPRSNegotiatedQoSProfile(String value);	

	ByteBuf getTGPPSGSNAddress();
	
	void setTGPPSGSNAddress(ByteBuf value);	

	ByteBuf getTGPPGGSNAddress();
	
	void setTGPPGGSNAddress(ByteBuf value);	

	String getTGPPIMSIMCCMNC();
	
	void setTGPPIMSIMCCMNC(String value);	
	       	
	String getTGPPGGSNMCCMNC();
	
	void setTGPPGGSNMCCMNC(String value);	
	 
	ByteBuf getTGPPNSAPI();
	
	void setTGPPNSAPI(ByteBuf value);	
	 
	String getTGPPSelectionMode();
	
	void setTGPPSelectionMode(String value);	
	 
	String getTGPPChargingCharacteristics();
	
	void setTGPPChargingCharacteristics(String value);	
	 
	ByteBuf getTGPPCGIPv6Address();
	
	void setTGPPCGIPv6Address(ByteBuf value);	
	 
	ByteBuf getTGPPSGSNIPv6Address();
	
	void setTGPPSGSNIPv6Address(ByteBuf value);	
	 
	ByteBuf getTGPPGGSNIPv6Address();
	
	void setTGPPGGSNIPv6Address(ByteBuf value);	
	 
	String getTGPPSGSNMCCMNC();
	
	void setTGPPSGSNMCCMNC(String value);	
	 
	ByteBuf getTGPPIMEISV();
	
	void setTGPPIMEISV(ByteBuf value);	
	
	ByteBuf getTGPPRATType();
	
	void setTGPPRATType(ByteBuf value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);	
	 
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	
	 
	ByteBuf getTGPPCAMELChargingInfo();
	
	void setTGPPCAMELChargingInfo(ByteBuf value);	
	 
	ByteBuf getTGPPPacketFilter();
	
	void setTGPPPacketFilter(ByteBuf value);
			
	ByteBuf getTGPPNegotiatedDSCP();
	
	void setTGPPNegotiatedDSCP(ByteBuf value);	
	
	ByteBuf getTGPPAllocateIPType();
	
	void setTGPPAllocateIPType(ByteBuf value);	
	
	ByteBuf getTWANIdentifier();
	
	void setTWANIdentifier(ByteBuf value);	
	
	ByteBuf getTGPPUserLocationInfoTime();
	
	void setTGPPUserLocationInfoTime(ByteBuf value);	
	 
	List<ByteBuf> getTGPPSecondaryRATUsage();
	
	void setTGPPSecondaryRATUsage(List<ByteBuf> value);	
 		 
	ByteBuf getTGPPUELocalIPAddress();
	
	void setTGPPUELocalIPAddress(ByteBuf value);	
	
	ByteBuf getTGPPUESourcePort();
	
	void setTGPPUESourcePort(ByteBuf value);	
}