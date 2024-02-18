package com.mobius.software.telco.protocols.diameter.commands.gmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistributionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMS2G3GIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSCountingInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSHCIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndicationEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	17.6.5	Re-Auth-Request Command
	The Re-Auth-Request (RAR) command, defined in IETF RFC 6733 (DIAMETER BASE) [111], is indicated by the Command-Code set to 258 and the message flags’ ‘R’ bit set. 
	The relevant AVPs that are of use for the Gmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	The bold marked AVPs in the message format indicate new optional AVPs for Gmb, or modified existing AVPs.
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
                 	[ MBMS-StartStop-Indication ]
                 	[ MBMS-Service-Area ]
                 	[ MBMS-Required-QoS ]
                 	[ MBMS-Session-Duration ]
                 	[ MBMS-Service-Type ]
                 	[ MBMS-Counting-Information ]
                 	[ MBMS-Session-Identity ]
                 	[ MBMS-Session-Repetition-number ]
                 	[ TMGI ]
              *  	[ 3GPP-SGSN-Address ]            ; broadcast case only
              *  	[ 3GPP-SGSN-IPv6-Address ]       ; broadcast case only
                 	[ MBMS-2G-3G-Indicator ]
                 	[ MBMS-Time-To-Data-Transfer ]
                 	[ MBMS-User-Data-Mode-Indication ]
                 	[ MBMS-BMSC-SSM-IP-Address ]
                 	[ MBMS-BMSC-SSM-IPv6-Address ]
                 	[ MBMS-Flow-Identifier ]
                 	[ CN-IP-Multicast-Distribution ]   
                 	[ MBMS-HC-Indicator ]
                 	[ Origin-State-Id ]
                 *	[ Proxy-Info ]
                 *	[ Route-Record ]

	The MBMS-StartStop-Indication AVP will indicate if the command is indicating an MBMS Session Start procedure, an MBMS Session Update procedure or an MBMS Session Stop procedure. 
	The Diameter Session-Id is used in subsequent procedures to identify the corresponding MBMS session.
	In the multicast case, the BM-SC shall use the Diameter Session-Id that was received during the GGSN Registration procedure. In the broadcast case, the BM-SC shall allocate a Diameter Session-Id for the first RAR message that is used for the first MBMS Session Start procedure of the MBMS bearer service. Then this Diameter Session-Id will be used for the subsequent MBMS sessions of the same MBMS bearer service. The BM-SC will create a new Diameter Session-Id for a subsequent Session Start procedure if, in exceptional cases, the Diameter session for the MBMS bearer service has been deleted.
	BM-SC shall not initiate a new Session Start procedure for a certain MBMS bearer service until the previous MBMS session for that service has been stopped.
	For the MBMS Session Start procedure, RAR is sent by the BM-SC to the GGSN(s) that will deliver the MBMS service (e.g. in the multicast case these are the GGSNs that have previously registered for the corresponding multicast MBMS bearer service), when it is ready to send data. This is a request to activate all necessary bearer resources in the network for the transfer of MBMS data and to notify interested UEs of the imminent start of the transmission. For broadcast MBMS bearer services the RAR message contains either an IPv4 address or an IPv6 address for each participating SGSN.
	For the MBMS Session Update procedure, RAR is sent by the BM-SC in order for  the GGSN(s) to update their session attributes. The updated MBMS-Service-Area AVP shall be included. The MBMS-StartStop-Indication AVP with the value UPDATE shall be included. The MBMS-Time-To-Data-Transfer with the value set to 0 shall be included. The MBMS-Session-Duration AVP shall be included to indicate the duration of the remaining part of the MBMS session. The 3GPP-SGSN-Address AVP and the 3GPP-SGSN-IPv6-Address AVP shall be included if the related lists of downstream nodes in the GGSN(s) have changed. The other bold marked AVPs shall be included as given by the previous, corresponding MBMS Session Start procedure.
	For the MBMS Session Stop procedure, RAR is sent by the BM-SC to the GGSN(s) when it considers the MBMS session to be terminated. The session is typically terminated when there is no more MBMS data expected to be transmitted for a sufficiently long period of time to justify a release of bearer plane resources in the network. 
	For the MBMS Session Start procedure, the MBMS-Required-QoS indicates the QoS that is required for the MBMS bearer service for the actual MBMS session. The information of the MBMS-2G-3G-Indicator, the MBMS-Service-Area and the MBMS-Counting-Information is passed from BM-SC transparently through GGSN to the SGSN(s) that are relevant for the actual MBMS bearer service.
	According to 3GPP TS 23.246 [65], a specific MBMS bearer service is uniquely identified by its IP multicast address and an APN. For the MBMS Session Start procedure for broadcast  MBMS bearer services, the following AVPs are  included (either IPv4 or IPv6 address) to enable GGSN to relate incoming payload packets to the actual MBMS bearer service and distribute the packets to the downstream SGSNs related to this service:
	-	The Framed-IPv6-Prefix AVP contains the IPv6 prefix of the multicast address. 
	-	The Framed-Interface-Id AVP contains the IPv6 interface identifier of the multicast address.
	-	The Framed-IP-Address AVP contains the IPv4 multicast address.
	-	The Called-Station-Id AVP contains the Access Point Name (APN) for which the MBMS bearer service is defined.
	According to 3GPP TS 23.246 [65], the MBMS-Flow-Identifier is optional, used only for broadcast services with location dependent content. For such services, several sessions with the same TMGI, but different MBMS-Flow-Identifiers, may be going on in parallel. However, at any specific location only one version of the content may be available at any point in time. Hence, the MBMS-Service-Areas of the related MBMS bearer contexts shall not overlap.
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GMB, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Request")
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
	
	MBMSStartStopIndicationEnum getMBMSStartStopIndication();
	
	void setMBMSStartStopIndication(MBMSStartStopIndicationEnum value);
	
	ByteBuf getMBMSServiceArea();
	
	void setMBMSServiceArea(ByteBuf value);
	
	ByteBuf getMBMSRequiredQoS();
	
	void setMBMSRequiredQoS(ByteBuf value);
	
	ByteBuf getMBMSSessionDuration();
	
	void setMBMSSessionDuration(ByteBuf value);
	
	MBMSServiceTypeEnum getMBMSServiceType();
	
	void setMBMSServiceType(MBMSServiceTypeEnum value);
	
	MBMSCountingInformationEnum getMBMSCountingInformation();
	
	void setMBMSCountingInformation(MBMSCountingInformationEnum value);
	
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
	
	MBMS2G3GIndicatorEnum getMBMS2G3GIndicator();	
	
	void setMBMS2G3GIndicator(MBMS2G3GIndicatorEnum value);
	
	ByteBuf getMBMSTimeToDataTransfer();	
	
	void setMBMSTimeToDataTransfer(ByteBuf value);
	
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
}