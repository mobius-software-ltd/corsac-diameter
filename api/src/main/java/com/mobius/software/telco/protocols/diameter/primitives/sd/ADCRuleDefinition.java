package com.mobius.software.telco.protocols.diameter.primitives.sd;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MeteringMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MuteNotificationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ReportingLevelEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatusEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.3.3	ADC-Rule-Definition AVP
	The ADC-Rule-Definition AVP (AVP code 1094) is of type Grouped, and it defines the ADC rule sent by the PCRF. The ADC-Rule-Name AVP uniquely identifies the ADC rule and it is used to reference to an ADC rule in communication between the PCRF and the TDF within one TDF session. The TDF Application Identifier AVP(s) or the Flow-Information AVP(s) determines the traffic that belongs to the application.
	If optional AVP(s) within an ADC-Rule-Definition AVP are omitted, but corresponding information has been provided in previous Sd messages, the previous information remains valid.
	Monitoring-Key AVP contains the monitoring key that may apply to the ADC rule.
	Sponsor-Identity AVP and Application-Service-Provider-Identity AVP shall be included if the Reporting-Level AVP is set to the value SPONSORED_CONNECTIVITY_LEVEL for the service data flow.
	Mute-Notification status shall not be changed during the lifetime of the ADC rules.
	Traffic-Steering-Policy-Identifier-UL AVP and/or Traffic-Steering-Policy-Identifier-DL AVP may appear if the traffic steering control is required for the service data flow or application. If the traffic steering policies are identical in both downlink and uplink directions, the values of the Traffic-Steering-Policy-Identifier-UL AVP and the Traffic-Steering-Policy-Identifier-DL AVP shall be identical.
	AVP Format: 

	ADC-Rule-Definition ::= < AVP Header: 1094 >
							 { ADC-Rule-Name }
							 [ TDF-Application-Identifier ]
							*[ Flow-Information ]
							 [ Service-Identifier ]
							 [ Rating-Group ]
							 [ Reporting-Level ]
							 [ Online ]
							 [ Offline ]
							 [ Metering-Method ]
							 [ Precedence ]
							 [ Flow-Status ]
							 [ QoS-Information ]
							 [ Monitoring-Key ]
							 [ Sponsor-Identity ]
							 [ Application-Service-Provider-Identity ]
						0*2	 [ Redirect-Information ]
							 [ Mute-Notification ] 
							 [ Traffic-Steering-Policy-Identifier-DL ]
							 [ Traffic-Steering-Policy-Identifier-UL ]
							 [ ToS-Traffic-Class ]
							*[ AVP ]
*/
@DiameterAvpDefinition(code = TgppAvpCodes.ADC_RULE_DEFINITION, vendorId = VendorIDs.TGPP_ID, name = "ADC-Rule-Definition")
public interface ADCRuleDefinition extends DiameterGroupedAvp
{
	ByteBuf getADCRuleName();
	
	void setADCRuleName(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getTDFApplicationIdentifier();
	
	void setTDFApplicationIdentifier(ByteBuf value);	
	
	List<FlowInformation> getFlowInformation();
	
	void setFlowInformation(List<FlowInformation> value);	
	
	Long getServiceIdentifier();
	
	void setServiceIdentifier(Long value);	
	
	Long getRatingGroup();
	
	void setRatingGroup(Long value);	
	
	ReportingLevelEnum getReportingLevel();
	
	void setReportingLevel(ReportingLevelEnum value);	
	
	OnlineEnum getOnline();
	
	void setOnline(OnlineEnum value);	
	
	OfflineEnum getOffline();
	
	void setOffline(OfflineEnum value);	
	
	MeteringMethodEnum getMeteringMethod();
	
	void setMeteringMethod(MeteringMethodEnum value);	
	
	Long getPrecedence();
	
	void setPrecedence(Long value);	
	
	FlowStatusEnum getFlowStatus();
	
	void setFlowStatus(FlowStatusEnum value);	
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);	
	
	ByteBuf getMonitoringKey();
	
	void setMonitoringKey(ByteBuf value);	
	
	String getSponsorIdentity();
	
	void setSponsorIdentity(String value);	
	
	String getApplicationServiceProviderIdentity();
	
	void setApplicationServiceProviderIdentity(String value);
	
	List<RedirectInformation> getRedirectInformation();
	
	void setRedirectInformation(List<RedirectInformation> value);	
	
	MuteNotificationEnum getMuteNotification();
	
	void setMuteNotification(MuteNotificationEnum value);	
	
	ByteBuf getTrafficSteeringPolicyIdentifierDL();
	
	void setTrafficSteeringPolicyIdentifierDL(ByteBuf value);	
	
	ByteBuf getTrafficSteeringPolicyIdentifierUL();
	
	void setTrafficSteeringPolicyIdentifierUL(ByteBuf value);
	
	ByteBuf getToSTrafficClass();
	
	void setToSTrafficClass(ByteBuf value);
}