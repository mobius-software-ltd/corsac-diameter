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
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSUserState;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IDAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSVoiceOverPSSessionsSupportedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;

/**
*
* @author yulian oifa
*
*/

/*
 * 	Insert-Subscriber-Data-Answer (IDA) Command
	The Insert-Subscriber-Data-Answer (IDA) command, indicated by the Command-Code field set to 319 and the 'R' bit cleared in the Command Flags field, is sent from MME or SGSN to HSS or CSS.
	Message Format when used over the S6a or S6d application:
	
	< Insert-Subscriber-Data-Answer> ::=	< Diameter Header: 319, PXY, 16777251 >
					< Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					*[ Supported-Features ]
					 [ Result-Code ]
					 [ Experimental-Result ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 [ IMS-Voice-Over-PS-Sessions-Supported ]
					 [ Last-UE-Activity-Time ]
					 [ RAT-Type ]
					 [ IDA-Flags ]
					 [ EPS-User-State ]
					 [ EPS-Location-Information ]
					 [ Local-Time-Zone ]
					 [ Supported-Services ]
					*[ Monitoring-Event-Report ]
					*[ Monitoring-Event-Config-Status ]
					*[ AVP ]
					 [ Failed-AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777251, commandCode = 319, request = false, proxyable = true, name="Insert-Subscriber-Data-Answer")
public interface InsertSubscriberDataAnswer extends S6aAnswer
{
	IMSVoiceOverPSSessionsSupportedEnum getIMSVoiceOverPSSessionsSupported();
	 
	void setIMSVoiceOverPSSessionsSupported(IMSVoiceOverPSSessionsSupportedEnum value);
	
	Date getLastUEActivityTime();
	 
	void setLastUEActivityTime(Date value);
	 		
	RATTypeEnum getRATType();
	 
	void setRATType(RATTypeEnum value);
	
	IDAFlags getIDAFlags();
	
	void setIDAFlags(IDAFlags value);
		
	EPSUserState getEPSUserState();
	 
	void setEPSUserState(EPSUserState value);
		
	EPSLocationInformation getEPSLocationInformation();
	 
	void setEPSLocationInformation(EPSLocationInformation value);
	
	LocalTimeZone getLocalTimeZone();
	 
	void setLocalTimeZone(LocalTimeZone value);
	
	SupportedServices getSupportedServices();
	 
	void setSupportedServices(SupportedServices value);
	
	List<MonitoringEventReport> getMonitoringEventReport();
	 
	void setMonitoringEventReport(List<MonitoringEventReport> value);
	
	List<MonitoringEventConfigStatus> getMonitoringEventConfigStatus();
	 
	void setMonitoringEventConfigStatus(List<MonitoringEventConfigStatus> value);
}