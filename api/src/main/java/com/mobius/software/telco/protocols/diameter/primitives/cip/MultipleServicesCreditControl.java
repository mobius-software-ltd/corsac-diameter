package com.mobius.software.telco.protocols.diameter.primitives.cip;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;

import io.netty.buffer.ByteBuf;

/*	4.3.1.1 Multiple-Services-Credit-Control AVP
	Multiple-Services-Credit-Control AVP (AVP Code 456) is of type Grouped and
	contains the AVPs related to the independent credit-control of multiple services
	feature.
	The Service-Session-Id AVP is used to identify a specific service session within
	an ongoing charging interrogation session. It is a local identifier used between
	CIP/IP Client and SDP.
	
	The Service-Identifier and the Rating-Group AVPs are used to associate the
	granted units to a given service or rating group.
	The Requested-Service-Unit AVP may contain the amount of requested
	service units or the requested monetary value. It must be present in the initial
	interrogation and within the intermediate interrogations in which new quota
	is requested for the service
	If the CIP/IP client does not include the Requested-Service-Unit AVP in a
	request command, the CIP/IP server will terminate the service and debit
	the used amount from the user's account. The Validity-Time, Result-Code,
	Result-Code-Extension, Cost-Information and Final-Unit-Indication AVPs may
	be present in an answer command.
	In CIP/IP, the Multiple-Services-Credit-Control AVP has the following ABNF
	grammar:
	
		Multiple-Services-Credit-Control ::= < AVP Header: 456 >
			{ Service-Session-Id }
	        [ Granted-Service-Unit ]
	        [ Requested-Service-Unit ]
	       *[ Used-Service-Unit ]
	        [ Service-Identifier ]
	        [ Rating-Group ]
	        [ Validity-Time ]
	        [ Result-Code ]
	        [ Result-Code-Extension ]
	        [ Cost-Information ]
	        [ Final-Unit-Indication ]
	        [ Charging-State-Information ]
	        [ CDR-Information ]
	        [ Service-Setup-Result ]
	        [ Service-Setup-Result-Requested ]
	        [ Subscriber-Information ]
	       *[ AVP ]
	
	When the Multiple-Services-Credit-Control AVP is used in a CIR the following
	AVPs are allowed:
	
		Multiple-Services-Credit-Control ::= < AVP Header: 456 >
			{ Service-Session-Id }
			[ Requested-Service-Unit ]
		   *[ Used-Service-Unit ]
			[ Service-Identifier ]
			[ Rating-Group ]
			[ Charging-State-Information ]
			[ Service-Setup-Result ]
		   *[ AVP ]
		  
 	When the Multiple-Services-Credit-Control AVP is used in a CIA the following
	AVPs are allowed:
	
		Multiple-Services-Credit-Control ::= < AVP Header: 456 >
			{ Service-Session-Id }
	        [ Granted-Service-Unit ]
	        [ Validity-Time ]
	        [ Result-Code ]
	        [ Result-Code-Extension ]
	        [ Cost-Information ]
	        [ Final-Unit-Indication ]
	        [ Charging-State-Information ]
	        [ CDR-Information ]
			[ Subscriber-Information ]
	        [ Service-Setup-Result-Requested ]
	       *[ AVP ]
		  
*/
@DiameterAvpDefinition(code = AvpCodes.MULTIPLE_SERVICES_CREDIT_CONTROL, vendorId = -1, name = "Multiple-Services-Credit-Control")
public interface MultipleServicesCreditControl extends DiameterGroupedAvp 
{
	String getServiceSessionId();
	
	void setServiceSessionId(String value);
	
	GrantedServiceUnit getGrantedServiceUnit();
	
	void setGrantedServiceUnit(GrantedServiceUnit value);
	
	RequestedServiceUnit getRequestedServiceUnit();
	
	void setRequestedServiceUnit(RequestedServiceUnit value);
	
	List<UsedServiceUnit> getUsedServiceUnit();
	
	void setUsedServiceUnit(List<UsedServiceUnit> value);
	
	Long getServiceIdentifier();
	
	void setServiceIdentifier(Long value);
	
	Long getRatingGroup();
	
	void setRatingGroup(Long value);	
	
	Long getValidityTime();
	
	void setValidityTime(Long value);	
	
	Long getResultCode();
	
	void setResultCode(Long value);	
	
	Long getResultCodeExtension();
	
	void setResultCodeExtension(Long value);
	
	CostInformation getCostInformation();
	
	void setCostInformation(CostInformation value);
	
	FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication value);	
	
	ByteBuf getChargingStateInformation();
	
	void setChargingStateInformation(ByteBuf value);
	
	ByteBuf getCDRInformation();
	
	void setCDRInformation(ByteBuf value);
	
	Long getServiceSetupResult();
	
	void setServiceSetupResult(Long value);
	
	ServiceSetupResultRequestedEnum getServiceSetupResultRequested();
	
	void setServiceSetupResultRequested(ServiceSetupResultRequestedEnum value);
	
	SubscriberInformation getSubscriberInformation();
	
	void setSubscriberInformation(SubscriberInformation value);
}