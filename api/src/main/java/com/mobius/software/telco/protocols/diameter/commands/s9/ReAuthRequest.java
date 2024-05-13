package com.mobius.software.telco.protocols.diameter.commands.s9;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionDecisionInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.5.4	Re-Auth-Request (RAR) Command
	The RAR command, indicated by the Command-Code field set to 258 and the 'R' bit set in the Command Flags field, is sent by the H-PCRF to the V-PCRF in order to provision QoS/PCC rules and event triggers for the subsession/session.
	Message Format:

	<RA-Request> ::= < Diameter Header: 258, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Destination-Host }
				 { Re-Auth-Request-Type }
				 [ Origin-State-Id ]
				 [ OC-Supported-Features ]
				*[ QoS-Rule-Install ]
				*[ QoS-Rule-Remove ]
				*[ QoS-Information ]
				*[ Event-Trigger ]
				*[ Subsession-Decision-Info ]
			  0*2[ AN-GW-Address ]
				 [ Session-Release-Cause ]
				 [ HeNB-Local-IP-Address ]
				 [ UE-Local-IP-Address ]
				 [ UDP-Source-Port ]
				*[ Proxy-Info ]
				 [ Called-Station-Id ]
				*[ Route-Record ]
				*[ AVP]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S9, commandCode = CommandCodes.REAUTH, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value) throws MissingAvpException;
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	List<QoSRuleRemove> getQoSRuleRemove();
	
	void setQoSRuleRemove(List<QoSRuleRemove> value);	
	
	List<QoSRuleInstall> getQoSRuleInstall();
	
	void setQoSRuleInstall(List<QoSRuleInstall> value);	
	
	List<QoSInformation> getQoSInformation();
	
	void setQoSInformation(List<QoSInformation> value);	
	
	List<EventTriggerEnum> getEventTrigger();
	
	void setEventTrigger(List<EventTriggerEnum> value);	
	
	List<SubsessionDecisionInfo> getSubsessionDecisionInfo();
	
	void setSubsessionDecisionInfo(List<SubsessionDecisionInfo> value);	
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;
	
	SessionReleaseCauseEnum getSessionReleaseCause();
	
	void setSessionReleaseCause(SessionReleaseCauseEnum value);
	
	InetAddress getHeNBLocalIPAddress();
	
	void setHeNBLocalIPAddress(InetAddress value);	
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);		
}