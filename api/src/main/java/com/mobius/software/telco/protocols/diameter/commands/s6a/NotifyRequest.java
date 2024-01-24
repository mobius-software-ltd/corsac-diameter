package com.mobius.software.telco.protocols.diameter.commands.s6a;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AlertReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessionsEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NORFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UESRVCCCapabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.17	Notify-Request (NOR) Command
	The Notify-Request (NOR) command, indicated by the Command-Code field set to 323 and the 'R' bit set in the Command Flags field, is sent from MME or SGSN to HSS.
	Message Format

	< Notify-Request> ::=	< Diameter Header: 323, REQ, PXY, 16777251 >
				 < Session-Id >
				 [ Vendor-Specific-Application-Id ]
				 [ DRMP ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				 { User-Name }
			 	 [ OC-Supported-Features ]
				*[ Supported-Features ]
				 [ Terminal-Information ]
				 [ MIP6-Agent-Info ]
				 [ Visited-Network-Identifier ]
				 [ Context-Identifier ]
				 [ Service-Selection]
				 [ Alert-Reason ]
				 [ UE-SRVCC-Capability ]
				 [ NOR-Flags ]
				 [ Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions ]
				 [ Maximum-UE-Availability-Time ]
				*[ Monitoring-Event-Config-Status ]
				 [ Emergency-Services ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777251, commandCode = 323, request = true, proxyable = true, name="Notify-Request")
public interface NotifyRequest extends S6aRequest
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);
	
	ByteBuf getVisitedNetworkIdentifier();
	
	void setVisitedNetworkIdentifier(ByteBuf value);	
	
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	AlertReasonEnum getAlertReason();
	
	void setAlertReason(AlertReasonEnum value);	
	
	UESRVCCCapabilityEnum getUESRVCCCapability();
	
	void setUESRVCCCapability(UESRVCCCapabilityEnum value);	
	
	NORFlags getNORFlags();
	
	void setNORFlags(NORFlags value);
	
	HomogeneousSupportOfIMSVoiceOverPSSessionsEnum getHomogeneousSupportOfIMSVoiceOverPSSessions();
	
	void setHomogeneousSupportOfIMSVoiceOverPSSessions(HomogeneousSupportOfIMSVoiceOverPSSessionsEnum value);	
	
	Date getMaximumUEAvailabilityTime();
	
	void setMaximumUEAvailabilityTime(Date value);	
	
	List<MonitoringEventConfigStatus> getMonitoringEventConfigStatus();
	
	void setMonitoringEventConfigStatus(List<MonitoringEventConfigStatus> value);
	
	EmergencyServices getEmergencyServices();
	
	void setEmergencyServices(EmergencyServices value);		
}