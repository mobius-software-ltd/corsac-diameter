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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterCommandDefinition(applicationId = 4, commandCode = 272, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends DiameterRequest
{
	public Long getAuthApplicationId();
	
	public String getServiceContextId();
	
	void setServiceContextId(String value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	public Long getServiceIdentifier() throws AvpNotSupportedException;
	
	void setServiceIdentifier(Long value) throws AvpNotSupportedException;			
	
	public RequestedServiceUnit getRequestedServiceUnit();
	
	void setRequestedServiceUnit(RequestedServiceUnit value);
	
	public RequestedActionEnum getRequestedAction();
	
	void setRequestedAction(RequestedActionEnum value);
	
	public UsedServiceUnit getUsedServiceUnit();
	
	void setUsedServiceUnit(UsedServiceUnit value);
	
	public MultipleServicesIndicatorEnum getMultipleServicesIndicator();
	
	void setMultipleServicesIndicator(MultipleServicesIndicatorEnum value);
	
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value);
	
	public List<ServiceParameterInfo> getServiceParameterInfo();
	
	void setServiceParameterInfo(List<ServiceParameterInfo> value);

	public Long getAccountLocation();		
	
	void setAccountLocation(Long value);

	public String getSubscriptionIdLocation();
	
	void setSubscriptionIdLocation(String value);
	
	public OtherPartyId getOtherPartyId();
	
	void setOtherPartyId(OtherPartyId value);
	
	public String getServiceProviderId();
	
	void setServiceProviderId(String value);
	
	public ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);
	
	public Long getTrafficCase();
	
	void setTrafficCase(Long value);
	
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	public List<String> getRouteRecords();
	
	void setRouteRecords(List<String> value);	  	
}