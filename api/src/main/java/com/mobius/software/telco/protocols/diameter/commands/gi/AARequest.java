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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPAuth;
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
 * 	16a.4.1	AAR Command
	The AAR command, defined in Diameter NASREQ (IETF RFC 7155 [120]), is indicated by the Command-Code field set to 265 and the ‘R’ bit set in the Command Flags field. It may be sent by the GGSN to a Diameter server, during Primary PDP Context activation only, in order to request user authentication and authorization. In the case of P-GW, the AAR may be sent upon reception of an initial access request (e.g. Create Session Request or Proxy Binding Update) message for a given APN to request user authentication and authorization.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate optional AVPs for Gi/Sgi, or modified existing AVPs. For Sgi, some of the optional 3GPP vendor-specific AVPs listed in the message format below are not applicable. See table 9a in subclause 16a.5 to see the list of vendor-specific AVPs that are applicable to the GGSN and the P-GW.
	Message Format:
	<AA-Request> ::= < Diameter Header: 265, REQ, PXY >
                        < Session-Id >
                       	{ Auth-Application-Id }
                       	{ Origin-Host }
                       	{ Origin-Realm }
                       	{ Destination-Realm }
                       	{ Auth-Request-Type }
                       	[ Destination-Host ]
                       	[ NAS-Port ]
                       	[ NAS-Port-Id ]
                       	[ NAS-Port-Type ]
                       	[ Origin-State-Id ]
                       	[ Port-Limit ]
                       	[ User-Name ]
                       	[ User-Password ]
                       	[ Service-Type ]
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
                      *	[ Framed-Compression ]
                       	[ Framed-Interface-Id ]
                       	[ Framed-IP-Address ]
                      *	[ Framed-IPv6-Prefix ] 
                      *	[ Delegated-IPv6-Prefix ]
                       	[ Framed-IP-Netmask ]
                       	[ Framed-MTU ]
                       	[ Framed-Protocol ]
                      *	[ Login-IP-Host ]
                      *	[ Login-IPv6-Host ]
                       	[ Login-LAT-Group ]
                       	[ Login-LAT-Node ]
                       	[ Login-LAT-Port ]
                       	[ Login-LAT-Service ]
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
                       	[ 3GPP-User-Location-Info ]
                       	[ 3GPP-RAT-Type ]
                       	[ 3GPP-CAMEL-Charging-Info ]
                       	[ 3GPP-Negotiated-DSCP ]
                       	[ 3GPP-Allocate-IP-Type ]
                       	[ TWAN-Identifier ]
                       	[ 3GPP-UE-Local-IP-Address ]
                       	[ 3GPP-UE-Source-Port ]
                      *	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 265, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends AuthenticationRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);				
	
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
	
	ServiceTypeEnum getServiceType();
	
	void setServiceType(ServiceTypeEnum value);	
	
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
	
	CHAPAuth getCHAPAuth();
	
	void setCHAPAuth(CHAPAuth value);	
	
	ByteBuf getCHAPChallenge();
	
	void setCHAPChallenge(ByteBuf value);	
	
	List<FramedCompressionEnum> getFramedCompression();
	
	void setFramedCompression(List<FramedCompressionEnum> value);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	List<ByteBuf> getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(List<ByteBuf> value);			
	
	List<ByteBuf> getDelegatedIPv6Prefix();
	
	void setDelegatedIPv6Prefix(List<ByteBuf> value);	
	
	ByteBuf getFramedIPNetmask();
	
	void setFramedIPNetmask(ByteBuf value);	
	
	Long getFramedMTU();
	
	void setFramedMTU(Long value);	
	
	FramedProtocolEnum getFramedProtocol();
	
	void setFramedProtocol(FramedProtocolEnum value);	
	
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
	 
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);	
	 
	ByteBuf getTGPPRATType();
	
	void setTGPPRATType(ByteBuf value);	
	
	ByteBuf getTGPPCAMELChargingInfo();
	
	void setTGPPCAMELChargingInfo(ByteBuf value);	
	 
	ByteBuf getTGPPNegotiatedDSCP();
	
	void setTGPPNegotiatedDSCP(ByteBuf value);	
	
	ByteBuf getTGPPAllocateIPType();
	
	void setTGPPAllocateIPType(ByteBuf value);	
	
	ByteBuf getTWANIdentifier();
	
	void setTWANIdentifier(ByteBuf value);	
	
	ByteBuf getTGPPUELocalIPAddress();
	
	void setTGPPUELocalIPAddress(ByteBuf value);	
	
	ByteBuf getTGPPUESourcePort();
	
	void setTGPPUESourcePort(ByteBuf value);
}