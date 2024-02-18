package com.mobius.software.telco.protocols.diameter.commands.creditcontrol.huawei;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceInformation;

/**
*
* @author yulian oifa
*
*/
@DiameterCommandDefinition(applicationId = ApplicationIDs.CREDIT_CONTROL, commandCode = CommandCodes.CREDIT_CONTROL, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends AuthenticationAnswer
{
    CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException;
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value) throws MissingAvpException;
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	void setGrantedServiceUnit(GrantedServiceUnit value);
	
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value);
		
	public CcSessionFailoverEnum getCcSessionFailover();
	
	void setCcSessionFailover(CcSessionFailoverEnum value);
	
	public CreditControlFailureHandlingEnum getCreditControlFailureHandling();
	
	void setCreditControlFailureHandling(CreditControlFailureHandlingEnum value);
	
	public MultipleServicesIndicatorEnum getMultipleServicesIndicator();
	
	void setMultipleServicesIndicator(MultipleServicesIndicatorEnum value);
	
	public FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication value);
	
	public ServiceInformation getServiceInformation();
	
	void setServiceInformation(ServiceInformation value);

	public CostInformation getCostInformation();
	
	void setCostInformation(CostInformation value);
	
	public String getServiceContextId();
	
	void setServiceContextId(String value);
}