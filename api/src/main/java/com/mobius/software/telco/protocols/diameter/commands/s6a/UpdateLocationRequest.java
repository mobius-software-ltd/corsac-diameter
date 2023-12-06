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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ActiveAPN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdjacentPLMNs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EquivalentPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessionsEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SMSRegisterRequestEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UESRVCCCapabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.3	Update-Location-Request (ULR) Command
	The Update-Location-Request (ULR) command, indicated by the Command-Code field set to 316 and the "R" bit set in the Command Flags field, is sent from MME or SGSN to HSS.
	Message Format

	< Update-Location-Request> ::=	< Diameter Header: 316, REQ, PXY, 16777251 >
					 < Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 [ Destination-Host ]
					 { Destination-Realm }
					 { User-Name }
					 [ OC-Supported-Features ]
					*[ Supported-Features ]
					 [ Terminal-Information ]
					 { RAT-Type }
					 { ULR-Flags }
					 [ UE-SRVCC-Capability ]
					 { Visited-PLMN-Id }
					 [ SGSN-Number ]
					 [ Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions ]
					 [ GMLC-Address ]
					*[ Active-APN ]
					 [ Equivalent-PLMN-List ]
					 [ MME-Number-for-MT-SMS ]
					 [ SMS-Register-Request ]
					 [ SGs-MME-Identity ]
					 [ Coupled-Node-Diameter-ID ]
					 [ Adjacent-PLMNs ]
					 [ Supported-Services ]
					*[ AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777251, commandCode = 316, request = true, proxyable = true, name="Update-Location-Request")
public interface UpdateLocationRequest extends S6aRequest
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	TerminalInformation getTerminalInformation();
	
	void setTerminalInformation(TerminalInformation value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	Long getULRFlags();
	
	void setULRFlags(Long value);
	
	UESRVCCCapabilityEnum getUESRVCCCapability();
	
	void setUESRVCCCapability(UESRVCCCapabilityEnum value);	
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);	
	
	String getSGSNNumber();
	
	void setSGSNNumber(String value);	
	
	HomogeneousSupportOfIMSVoiceOverPSSessionsEnum getHomogeneousSupportOfIMSVoiceOverPSSessions();
	
	void setHomogeneousSupportOfIMSVoiceOverPSSessions(HomogeneousSupportOfIMSVoiceOverPSSessionsEnum value);	
	
	InetAddress getGMLCAddress();
	
	void setGMLCAddress(InetAddress value);	
	
	List<ActiveAPN> getActiveAPN();
	
	void setActiveAPN(List<ActiveAPN> value);
	
	EquivalentPLMNList getEquivalentPLMNList();
	
	void setEquivalentPLMNList(EquivalentPLMNList value);	
	
	String getMMENumberForMTSMS();
	
	void setMMENumberForMTSMS(String value);	
	
	SMSRegisterRequestEnum getSMSRegisterRequest();
	
	void setSMSRegisterRequest(SMSRegisterRequestEnum value);			
	
	String getSGsMMEIdentity();
	
	void setSGsMMEIdentity(String value);	
	
	String getCoupledNodeDiameterID();
	
	void setCoupledNodeDiameterID(String value);	
	
	AdjacentPLMNs getAdjacentPLMNs();
	
	void setAdjacentPLMNs(AdjacentPLMNs value);	
	
	SupportedServices getSupportedServices();
	
	void setSupportedServices(SupportedServices value);			
}