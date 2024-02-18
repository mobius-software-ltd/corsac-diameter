package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.30	Event-Report-Indication AVP (All access types)
	The Event-Report-Indication AVP (AVP code 1033) is of type Grouped. When sent from the PCRF to the PCEF, it is used to report an event coming from the Access Network GW (BBERF) and relevant info to the PCEF. When sent from the PCEF to the PCRF, it is used to provide the information about the required event triggers to the PCRF. Only Event-Trigger AVP will be supplied in this case.
	The PCEF may require adding new event triggers or removing the already provided ones. In order to do so, the PCEF shall provide the new complete list of applicable event triggers within the Event-Trigger AVP included in the Event-Report-Indication AVP to the PCRF.
	The PCEF may require removing all previously provided event triggers by providing the Event-Trigger AVP set to the value NO_EVENT_TRIGGERS included in the Event-Report-Indication AVP to the PCRF.
	If the event triggers required by the PCEF are associated with certain parameter values, the PCRF shall provide those values to the PCEF.
	Whenever the PCEF subscribes to an event report indication by using the CCR command, the PCRF shall only send the corresponding currently applicable values which have been updated (e.g. 3GPP-User-Location-Info, 3GPP2-BSID, etc.) to the PCEF in the CCA if available. In this case, the Event-Trigger AVPs shall not be included.

	NOTE 1:	The PCRF can get the currently applicable values during the IP-CAN session establishment procedure or during the information reporting from the BBERF when the BBERF gets event subscription from the PCRF as defined in clause 5.3.7.

	The PCEF may subscribe to different or common set of event triggers at different BBERFs by including the Routing-IP-Address AVP in the Event-Report-Indication AVP to the PCRF.
	The PCEF may provide the following Event-Trigger values to the PCRF: RAI_CHANGE, RAT_CHANGE, USER_LOCATION_CHANGE, UE_TIME_ZONE_CHANGE, USER_CSG_INFORMATION_CHANGE, USER_CSG_HYBRID_SUBSCRIBED_INFORMATION_CHANGE, USER_CSG_ HYBRID_UNSUBSCRIBED_INFORMATION_CHANGE, TAI_CHANGE, ECGI_CHANGE and ENODEB_CHANGE.
	Applicability of the Event-Triggers to the different accesses is defined in clause 5.3.7.
	AVP Format:

	Event-Report-Indication ::= < AVP Header: 1033 >
		 	[ AN-Trusted ]
		*	[ Event-Trigger ]
		 	[ User-CSG-Information ] 
		 	[ IP-CAN-Type ]
		0*2 [ AN-GW-Address ]
			[ 3GPP-SGSN-Address ]
			[ 3GPP-SGSN-Ipv6-Address ]
			[ 3GPP-SGSN-MCC-MNC ] 
			[ Framed-IP-Address ] 
			[ RAT-Type ]
			[ RAI ]
			[ 3GPP-User-Location-Info ]
			[ Trace-Data ]
			[ Trace-Reference ]
			[ 3GPP2-BSID ]
			[ 3GPP-MS-TimeZone ]
			[ Routing-IP-Address ]
			[ UE-Local-IP-Address ]
			[ HeNB-Local-IP-Address ]
			[ UDP-Source-Port ]
			[ Presence-Reporting-Area-Information ]
		*	[ AVP ]

	NOTE 2:	The IP-CAN-Type, AN-GW-Address, AN-Trusted, 3GPP-SGSN-Address, 3GPP-SGSN-Ipv6-Address, 3GPP-SGSN-MCC-MNC, Framed-IP-Address, UE-Local-IP-Address, HeNB-Local-IP-Address and UDP-Source-Port, Presence-Reporting-Area-Information AVPs are not applicable to the Gx interface.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.EVENT_REPORT_INDICATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "Event-Report-Indication")
public interface EventReportIndication extends DiameterGroupedAvp
{
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);		
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);	
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;
	
	ByteBuf get3GPPSGSNAddress();
	
	void set3GPPSGSNAddress(ByteBuf value);
	
	ByteBuf get3GPPSGSNIpv6Address();
	
	void set3GPPSGSNIpv6Address(ByteBuf value);
	
	String get3GPPSGSNMCCMNC();
	
	void set3GPPSGSNMCCMNC(String value);
	
	Inet4Address getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	String getRAI();
	
	void setRAI(String value);
	
	ByteBuf get3GPPUserLocationInfo();
	
	void set3GPPUserLocationInfo(ByteBuf value);
	
	TraceData getTraceData();
	
	void setTraceData(TraceData value);
	
	ByteBuf getTraceReference();
	
	void setTraceReference(ByteBuf value);
	
	ByteBuf getTGPP2BSID();
	
	void setTGPP2BSID(ByteBuf value);
	
	ByteBuf get3GPPMSTimeZone();
	
	void set3GPPMSTimeZone(ByteBuf value);
	
	InetAddress getRoutingIPAddress();
	
	void setRoutingIPAddress(InetAddress value);
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);
	
	InetAddress getHeNBLocalIPAddress();
	
	void setHeNBLocalIPAddress(InetAddress value);
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);
	
	PresenceReportingAreaInformation getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(PresenceReportingAreaInformation value);
}