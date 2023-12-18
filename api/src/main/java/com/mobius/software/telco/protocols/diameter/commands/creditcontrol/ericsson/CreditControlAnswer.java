package com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterCommandDefinition(applicationId = 4, commandCode = 272, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends AuthenticationAnswer
{
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	void setGrantedServiceUnit(GrantedServiceUnit value);
	
	public MultipleServicesIndicatorEnum getMultipleServicesIndicator();
	
	void setMultipleServicesIndicator(MultipleServicesIndicatorEnum value);
	
	public CostInformation getCostInformation();
	
	void setCostInformation(CostInformation value);
	
	public FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication value);
	
	public CreditControlFailureHandlingEnum getCreditControlFailureHandling();
	
	void setCreditControlFailureHandling(CreditControlFailureHandlingEnum value);
	
	public Long getResultCodeExtension();
	
	void setResultCodeExtension(Long value);
	
	Long getTimeQuotaThreshold();
	
	void setTimeQuotaThreshold(Long value);      
	
	Long getVolumeQuotaThreshold();
	
	void setVolumeQuotaThreshold(Long value);      
	
	Long getUnitQuotaThreshold();
	
	void setUnitQuotaThreshold(Long value);      
	
	Long getValidityTime();
	
	void setValidityTime(Long value);
	
	public Long getServiceIdentifier();
	
	void setServiceIdentifier(Long value);
}