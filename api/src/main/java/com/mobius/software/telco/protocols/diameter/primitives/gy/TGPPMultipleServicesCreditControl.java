package com.mobius.software.telco.protocols.diameter.primitives.gy;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AFCorrelationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReportingReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Trigger;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolReference;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;

import io.netty.buffer.ByteBuf;

/*
 	Table E.3.1: Structure of the Multiple Unit Operation in message request for inter-PLMN
	 
		 <Multiple-Services-Credit-Control> ::= < AVP Header: 456 >
				  [ Requested-Service-Unit ]
				* [ Used-Service-Unit ]
				  [ Rating-Group ]
				* [ Reporting-Reason ]
				  [ Trigger ]
				* [ AF-Correlation-Information]
				  [ QoS-Information ]
			  
	 Table E.3.3: Structure of the Multiple Unit Operation in message response for inter-PLMN
			  	  [ Granted-Service-Unit ]
			  	  [ Rating-Group ]
			  	  [ Validity-Time ]
			      [ Operation-Result ]
			      [ Final-Unit-Indication ]
			      [ Time-Quota-Threshold ]
			      [ Volume-Quota-Threshold ]
			      [ Quota-Holding-Time ]
			      [ Quota-Consumption-Time ]
			      [ Trigger ]
 */
@DiameterAvpDefinition(code = AvpCodes.MULTIPLE_SERVICES_CREDIT_CONTROL, vendorId = -1, name = "Multiple-Services-Credit-Control")
public interface TGPPMultipleServicesCreditControl extends DiameterAvp 
{
	GrantedServiceUnit getGrantedServiceUnit();

	void setGrantedServiceUnit(GrantedServiceUnit value);
	
	RequestedServiceUnit getRequestedServiceUnit();
	
	void setRequestedServiceUnit(RequestedServiceUnit value);
	
	List<UsedServiceUnit> getUsedServiceUnit();
	
	void setUsedServiceUnit(List<UsedServiceUnit> value);
	
	List<Long> getServiceIdentifier();
	
	void setServiceIdentifier(List<Long> value);	
	
	Long getRatingGroup();
	
	void setRatingGroup(Long value);	
			
	List<GSUPoolReference> getGSUPoolReference();
	
	void setGSUPoolReference(List<GSUPoolReference> value);	
	
	Long getValidityTime();
	
	void setValidityTime(Long value);	
			
	Long getResultCode();
	
	void setResultCode(Long value);	
			
	FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication value);      
	
	Long getTimeQuotaThreshold();
	
	void setTimeQuotaThreshold(Long value);      
	
	Long getVolumeQuotaThreshold();
	
	void setVolumeQuotaThreshold(Long value);      
	
	Long getUnitQuotaThreshold();
	
	void setUnitQuotaThreshold(Long value);      
	
	Long getQuotaHoldingTime();
	
	void setQuotaHoldingTime(Long value);      
	
	Long getQuotaConsumptionTime();
	
	void setQuotaConsumptionTime(Long value);      
		
	List<ReportingReasonEnum> getReportingReason();
	
	void setReportingReason(List<ReportingReasonEnum> value);      
		
	Trigger getTrigger();
	
	void setTrigger(Trigger value);      
	
	List<AFCorrelationInformation> getAFCorrelationInformation();
	
	void setAFCorrelationInformation(List<AFCorrelationInformation> value);          
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);          
	
	ByteBuf getTGPPRATType();
	
	void setTGPPRATType(ByteBuf value);      
	
}