package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.189	Service-Data-Container AVP
	The Service-Data-Container AVP (AVP code 2040) is of type Grouped. Its purpose is to allow the transmission of the container to be reported for Flow based Charging or application based charging. On encountering change on charging condition in Flow based Charging, this container  identifies the volume count (separated for uplink and downlink), elapsed time or number of events, per service data flow identified per rating group or combination of the rating group and service id within an IP-CAN bearer. On encountering change on charging condition in application based Charging, this container identifies the volume count (separated for uplink and downlink), elapsed time or number of events, per rating group or combination of the rating group and service identifier within a TDF session.
	It has the following ABNF grammar:
            
    Service-Data-Container :: =  < AVP Header: 2040>
		   	[ AF-Correlation-Information ]
		   	[ Charging-Rule-Base-Name ]
		   	[ Accounting-Input-Octets ]
		   	[ Accounting-Output-Octets ]
		   	[ Local-Sequence-Number ]
		   	[ QoS-Information ]
		   	[ Rating-Group ] 
		   	[ Change-Time ] 
		   	[ Service-Identifier ] 
		   	[ Service-Specific-Info ] 
			[ ADC-Rule-Base-Name ]
   			[ SGSN-Address ] 
   			[ Time-First-Usage ]
   			[ Time-Last-Usage ]
   			[ Time-Usage ]
 		*	[ Change-Condition]
   			[ 3GPP-User-Location-Info ]
   			[ 3GPP2-BSID ]
   			[ UWAN-User-Location-Info ] 
   			[ TWAN-User-Location-Info ]
   			[ Sponsor-Identity ]
   			[ Application-Service-Provider-Identity ] 
 		* 	[ Presence-Reporting-Area-Information]
   			[ Presence-Reporting-Area-Status ]
   			[ User-CSG-Information ]  
			[ 3GPP-RAT-Type ]
   			[ Related-Change-Condition-Information ]   
   			[ Serving-PLMN-Rate-Control ]
   			[ APN-Rate-Control ]
 			[ 3GPP-PS-Data-Off-Status ] 
			[Traffic-Steering-Policy-Identifier-DL]
 			[Traffic-Steering-Policy-Identifier-UL]
 			[VoLTE-Information] 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_DATA_CONTAINER, vendorId = VendorIDs.TGPP_ID, name = "Service-Data-Container")
public interface ServiceDataContainer extends DiameterAvp
{
	AFCorrelationInformation getAFCorrelationInformation();
	
	void setAFCorrelationInformation(AFCorrelationInformation value);
	
	String getChargingRuleBaseName();
	
	void setChargingRuleBaseName(String value);
	
	Long getAccountingInputOctets();
	
	void setAccountingInputOctets(Long value);
	
	Long getAccountingOutputOctets();
	
	void setAccountingOutputOctets(Long value);
	
	Long getLocalSequenceNumber();
	
	void setLocalSequenceNumber(Long value);
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	Long getRatingGroup();
	
	void setRatingGroup(Long value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
	
	Long getServiceIdentifier();
	
	void setServiceIdentifier(Long value);
	
	ServiceSpecificInfo getServiceSpecificInfo();
	
	void setServiceSpecificInfo(ServiceSpecificInfo value);
	
	String getADCRuleBaseName();
	
	void setADCRuleBaseName(String value);
	
	InetAddress getSGSNAddress();
	
	void setSGSNAddress(InetAddress value);
	
	Date getTimeFirstUsage();
	
	void setTimeFirstUsage(Date value);
	
	Date getTimeLastUsage();
	
	void setTimeLastUsage(Date value);
	
	Long getTimeUsage();
	
	void setTimeUsage(Long value);
	
	List<Long> getChangeCondition();
	
	void setChangeCondition(List<Long> value);
	
	ByteBuf get3GPPUserLocationInfo();
	
	void set3GPPUserLocationInfo(ByteBuf value);
	
	ByteBuf get3GPP2BSID();
	
	void set3GPP2BSID(ByteBuf value);
	
	UWANUserLocationInfo getUWANUserLocationInfo();
	
	void setUWANUserLocationInfo(UWANUserLocationInfo value);
	
	TWANUserLocationInfo getTWANUserLocationInfo();
	
	void setTWANUserLocationInfo(TWANUserLocationInfo value);
	
	String getSponsorIdentity();
	
	void setSponsorIdentity(String value);
	
	String getApplicationServiceProviderIdentity();
	
	void setApplicationServiceProviderIdentity(String value);
	
	List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation();
	
	void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value);
	
	PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus();
	
	void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value);
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
	
	ByteBuf get3GPPRATType();
	
	void set3GPPRATType(ByteBuf value);
	
	RelatedChangeConditionInformation getRelatedChangeConditionInformation();
	
	void setRelatedChangeConditionInformation(RelatedChangeConditionInformation value);
	
	ServingPLMNRateControl getServingPLMNRateControl();
	
	void setServingPLMNRateControl(ServingPLMNRateControl value);
	
	APNRateControl getAPNRateControl();
	
	void setAPNRateControl(APNRateControl value);
	
	TGPPPSDataOffStatusEnum get3GPPPSDataOffStatus();
	
	void set3GPPPSDataOffStatus(TGPPPSDataOffStatusEnum value);
	
	ByteBuf getTrafficSteeringPolicyIdentifierDL();
	
	void setTrafficSteeringPolicyIdentifierDL(ByteBuf value);
	
	ByteBuf getTrafficSteeringPolicyIdentifierUL();
	
	void setTrafficSteeringPolicyIdentifierUL(ByteBuf value);
	
	VoLTEInformation getVoLTEInformation();
	
	void setVoLTEInformation(VoLTEInformation value);
}