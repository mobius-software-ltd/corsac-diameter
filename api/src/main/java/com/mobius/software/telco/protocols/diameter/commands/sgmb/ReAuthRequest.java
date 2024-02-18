package com.mobius.software.telco.protocols.diameter.commands.sgmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistributionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSHCIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalM1Information;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSAccessIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSGWUDPPortIndicatorEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	20.4.1	Re-Auth-Request Command
	The Re-Auth-Request (RAR) command, defined in IETF RFC 6733 (DIAMETER BASE) [111], is indicated by the Command-Code set to 258 and the message flags’ ‘R’ bit set. 
	The relevant AVPs that are of use for the SGmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for SGmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate new optional AVPs for SGmb, or modified existing AVPs.
	Message Format:
      
    <RAR>  ::= < Diameter Header: 258, REQ, PXY >
                 	< Session-Id >
                 	{ Origin-Host }
                 	{ Origin-Realm }
                 	{ Destination-Realm }
                 	{ Destination-Host }
                 	{ Auth-Application-Id }
                 	{ Re-Auth-Request-Type }
                 	[ Called-Station-Id ]
                 	[ Framed-IP-Address]
                 	[ Framed-IPv6-Prefix ]
                 	[ Framed-Interface-Id ]
                 	[ MBMS-Access-Indicator ]
                 	[ MBMS-StartStop-Indication ]
                 	[ MBMS-Service-Area ]
                 	[ QoS-Information ]
                 	[ MBMS-Session-Duration ]
                 	[ MBMS-Session-Identity ]
                 	[ MBMS-Session-Repetition-number ]
                 	[ TMGI ]
                 * 	[ 3GPP-SGSN-Address ]           
                 * 	[ 3GPP-SGSN-IPv6-Address ]       
                 	[ MBMS-Time-To-Data-Transfer ]
                 	[ MBMS-Data-Transfer-Start ]
                 	[ MBMS-Data-Transfer-Stop ]
                 	[ MBMS-Flags ]
                 	[ MBMS-User-Data-Mode-Indication ]
                 	[ MBMS-BMSC-SSM-IP-Address ]
                 	[ MBMS-BMSC-SSM-IPv6-Address ]
                 	[ MBMS-Flow-Identifier ]
                 	[ CN-IP-Multicast-Distribution ]   
                 	[ MBMS-HC-Indicator ]
                 	[ MBMS-GW-UDP-Port-Indicator]	; for IP unicast encapsulated user data
                 	[ MBMS-GW-SSM-IP-Address ]		; for IP multicast encapsulated user data
                 	[ MBMS-GW-SSM-IPv6-Address ]	; for IP multicast encapsulated user data
                 	[ MBMS-BMSC-SSM-UDP-Port ]		; for IP multicast encapsulated user data
                 	[ MBMS-Cell-List ]
                 	[ Local-M1-Information ]
                 	[ Origin-State-Id ]
                 *	[ Proxy-Info ]
                 *	[ Route-Record ]
                 *	[ Supported-Features ]
                 	[ Restart-Counter ]

	For the MBMS Session Start procedure, RAR is sent by the BM-SC to the MBMS GW(s) that will deliver the MBMS service when it is ready to send data. This is a request to activate all necessary bearer resources in the network for the transfer of MBMS data. The RAR message contains either an IPv4 address included in 3GPP-SGSN-Address AVP or an IPv6 address included in 3GPP-SGSN-IPv6-Address AVP for each participating MBMS control plane nodes (MMEs, SGSNs). The MBMS-Time-to-Data-Transfer AVP shall be included to indicate the expected time between the reception of the MBMS Session Start and the transmission of MBMS data flows. For E-UTRAN access, the RAR message may also contain the MBMS-Data-Transfer-Start AVP containing the absolute time stamp of the data delivery start. The RAR message shall also contain the MBMS-Service-Area AVP. If the MBMS Cell List feature is supported, or if the BM-SC does not yet know whether the MBMS-GW supports this feature, the RAR may contain the MBMS-Cell-List AVP. For the distributed MCE architectures, i.e. when the MCE is part of eNB as described in clause 15.1.1 in TS 36.300 [98], the MBMS-Data-Transfer-Start AVP should be used at MBSFN operation mode to ensure synchronized session control and to facilitate a graceful reallocation of resources for the MBSFN when needed. The RAR message shall also contain the Local-M1-Information AVP if the BM-SC determines to use the local MBMS information as specified in 3GPP TS 23.285 [112].
	The MBMS-Flags AVP may provide specific control indications in relation to MBMS, e.g. whether the MBMS Session Start procedure is used to re-establish an MBMS session.
	For the MBMS Session Update procedure, RAR is sent by the BM-SC in order for the MBMS GW(s) to update their session attributes. If the MBMS service area or the MBMS cell list needs to be changed, the MBMS-Service-Area AVP shall be included in the RAR. If the MBMS Cell List feature is supported and the MBMS cell list needs to be changed, the MBMS-Cell-List AVP shall also be included. If the MBMS-Service-Area AVP but no MBMS-Cell-List AVP is included, this shall indicate that any MBMS Cell List included in a previous RAR does no longer apply. If the Access indicator needs to be updated, it shall be included in the MBMS-Access-Indicator AVP. For E-UTRAN access, the RAR message may also contain the MBMS-Data-Transfer-Start AVP containing the absolute time stamp of the data delivery start. For the distributed MCE architectures, i.e. when the MCE is part of eNB as described in clause 15.1.1 in TS 36.300 [98], the MBMS-Data-Transfer-Start AVP should be used at MBSFN operation mode to ensure synchronized session control and to facilitate a graceful reallocation of resources for the MBSFN when needed. The MBMS-StartStop-Indication AVP with the value UPDATE shall be included. The MBMS-Time-To-Data-Transfer with AVP the value set to 0 shall be included. The MBMS-Session-Duration AVP shall be included to indicate the duration of the remaining part of the MBMS session. The 3GPP-SGSN-Address AVP and the 3GPP-SGSN-IPv6-Address AVP shall be included if the related lists of MBMS control plane nodes (MMEs, SGSNs) in the MBMS GW(s) have changed. If the ARP needs to be changed, the QoS-Information AVP shall be included. The other bold marked AVPs shall be included as given by the previous, corresponding MBMS Session Start procedure.
	For the MBMS Session Stop procedure, RAR is sent by the BM-SC to the MBMS GW(s) when it considers the MBMS session to be terminated. The session is typically terminated when there is no more MBMS data expected to be transmitted for a sufficiently long period of time to justify a release of bearer plane resources in the network. For E-UTRAN access, the RAR message may also contain the MBMS-Data-Transfer-Stop AVP containing the absolute time stamp of the data delivery stop. The MBMS-Flags AVP may provide specific control indications, e.g. whether the MBMS Session Stop procedure is used to release the MBMS bearer context locally.
	For the MBMS Session Start procedure, the Qos-Information AVP indicates the QoS that is required for the MBMS bearer service for the actual MBMS session. Only the QoS-Class-Identifier AVP, Max-Requested-Bandwidth-DL AVP, Guaranteed-Bitrate-DL AVP and Allocation-Retention-Priority AVP within the QoS-Information AVP are applicable for the MBMS bearer service. The MBMS-Service-Area AVP is passed from BM-SC transparently through MBMS GW to the MMEs/SGSN(s) that are relevant for the actual MBMS bearer service. The MBMS-Cell-List AVP is also passed transparently through MBMS GW to the MMEs. The MBMS-Access-Indicator AVP indicates in which radio access types the MBMS bearer service shall be broadcasted, i.e UTRAN, or E-UTRAN, or both.
	The usage of MBMS-StartStop-Indication AVP, Session-Id AVP, Framed-IP-Address AVP, Framed-IPv6-Prefix AVP, Framed-Interface-Id AVP, Called-Station-Id AVP and MBMS-Flow-Identifier AVP can refer to Gmb interface as described in clause 17.6.5.
	If unicast mode is used, the MBMS GW shall select an IP unicast address and a destination UDP port that is unique within the MBMS GW or that IP unicast address.
	If IP multicast encapsulation of application IP multicast datagram is used over Sgi-mb, the BM-SC shall select a source UDP port that is unique within the BM-SC for that IP multicast address.
	For the MBMS Heartbeat procedure, RAR is sent by the BM-SC to the MBMS GW, or vice-versa. The RAR message shall contain the following AVPs: 
		-	the MBMS-StartStop-Indication AVP set to the value "heartbeat";
		-	the Restart-Counter AVP set to the local restart counter of the sender. 
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SGMB, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest
{
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);
	
	MBMSAccessIndicatorEnum getMBMSAccessIndicator();
	
	void setMBMSAccessIndicator(MBMSAccessIndicatorEnum value);
	
	MBMSStartStopIndicationEnum getMBMSStartStopIndication();
	
	void setMBMSStartStopIndication(MBMSStartStopIndicationEnum value);
	
	ByteBuf getMBMSServiceArea();
	
	void setMBMSServiceArea(ByteBuf value);
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	ByteBuf getMBMSSessionDuration();
	
	void setMBMSSessionDuration(ByteBuf value);
	
	ByteBuf getMBMSSessionIdentity();
	
	void setMBMSSessionIdentity(ByteBuf value);
	
	ByteBuf getMBMSSessionRepetitionNumber();
	
	void setMBMSSessionRepetitionNumber(ByteBuf value);
	
	ByteBuf getTMGI();	
	
	void setTMGI(ByteBuf value);
	
	List<ByteBuf> getTGPPSGSNAddress();
	
	void setTGPPSGSNAddress(List<ByteBuf> value);	

	List<ByteBuf> getTGPPSGSNIPv6Address();
	
	void setTGPPSGSNIPv6Address(List<ByteBuf> value);	

	ByteBuf getMBMSTimeToDataTransfer();	
	
	void setMBMSTimeToDataTransfer(ByteBuf value);
	
	Long getMBMSDataTransferStart();
	
	void setMBMSDataTransferStart(Long value);
	
	Long getMBMSDataTransferStop();
	
	void setMBMSDataTransferStop(Long value);
	
	MBMSFlags getMBMSFlags();
	
	void setMBMSFlags(MBMSFlags value);
	
	MBMSUserDataModeIndicationEnum getMBMSUserDataModeIndication();	
	
	void setMBMSUserDataModeIndication(MBMSUserDataModeIndicationEnum value);
	
	Inet4Address getMBMSBMSCSSMIPAddress();	
	
	void setMBMSBMSCSSMIPAddress(Inet4Address value);
	
	Inet6Address getMBMSBMSCSSMIPv6Address();	
	
	void setMBMSBMSCSSMIPv6Address(Inet6Address value);
	
	ByteBuf getMBMSFlowIdentifier();	
	
	void setMBMSFlowIdentifier(ByteBuf value);
	
	CNIPMulticastDistributionEnum getCNIPMulticastDistribution();	
	
	void setCNIPMulticastDistribution(CNIPMulticastDistributionEnum value);
	
	MBMSHCIndicatorEnum getMBMSHCIndicator();	
	
	void setMBMSHCIndicator(MBMSHCIndicatorEnum value);
	
	MBMSGWUDPPortIndicatorEnum getMBMSGWUDPPortIndicator();
	
	void setMBMSGWUDPPortIndicator(MBMSGWUDPPortIndicatorEnum value);	
	
	Inet4Address getMBMSGWSSMIPAddress();
	
	void setMBMSGWSSMIPAddress(Inet4Address value);	
	
	Inet6Address getMBMSGWSSMIPv6Address();
	
	void setMBMSGWSSMIPv6Address(Inet6Address value);	
	
	ByteBuf getMBMSBMSCSSMUDPPort();
	
	void setMBMSBMSCSSMUDPPort(ByteBuf value);	
	
	ByteBuf getMBMSCellList();
	
	void setMBMSCellList(ByteBuf value);	
	
	LocalM1Information getLocalM1Information();
	
	void setLocalM1Information(LocalM1Information value);	
	
	List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	Long getRestartCounter();
	
	void setRestartCounter(Long value);		
}