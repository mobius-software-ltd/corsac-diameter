package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.huawei;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.huawei.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSessionFailoverImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CreditControlFailureHandlingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.MultipleServicesIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceContextIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailover;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandling;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceContextId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceInformation;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 4, commandCode = 272, request = false)
public class CreditControlAnswerImpl extends AuthenticationAnswerImpl implements CreditControlAnswer
{
	private CcRequestType ccRequestType;
	
	private CcRequestNumber ccRequestNumber;
	
	private CcSessionFailover ccSessionFailover;
	
	private List<MultipleServicesCreditControl> multipleServicesCreditControl;
	
	private ServiceInformation serviceInformation;
	
	private CostInformation costInformation;
	
	private EventTimestamp eventTimestamp;
	
	private ServiceContextId serviceContextId;
	
	private FinalUnitIndication finalUnitIndication;
	
	private CreditControlFailureHandling creditControlFailureHandling;
	
	private GrantedServiceUnit grantedServiceUnit;
	
	private MultipleServicesIndicator multipleServicesIndicator;

	protected CreditControlAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, 4L);
		setExperimentalResultAllowed(false);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
	}
	
	//for overriding with different auth application ID
	protected CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
	}

	@Override
	public CcRequestTypeEnum getCcRequestType() 
	{
		if(ccRequestType==null)
			return null;
		
		return ccRequestType.getEnumerated(CcRequestTypeEnum.class);
	}

	@Override
	public void setCcRequestType(CcRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		this.ccRequestType = new CcRequestTypeImpl(value, null, null);
	}

	@Override
	public Long getCcRequestNumber() 
	{
		if(ccRequestNumber==null)
			return null;
		
		return ccRequestNumber.getUnsigned();
	}

	@Override
	public void setCcRequestNumber(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.ccRequestNumber = new CcRequestNumberImpl(value, null, null);
	}
	
	@Override
	public CcSessionFailoverEnum getCcSessionFailover() 
	{
		if(ccSessionFailover==null)
			return null;
		
		return ccSessionFailover.getEnumerated(CcSessionFailoverEnum.class);
	}

	@Override
	public void setCcSessionFailover(CcSessionFailoverEnum value) 
	{
		if(value==null)
			this.ccSessionFailover = null;
		else
			this.ccSessionFailover = new CcSessionFailoverImpl(value, null, null);
	}
	
	@Override
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl() 
	{
		return multipleServicesCreditControl;
	}

	@Override
	public void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value) 
	{
		this.multipleServicesCreditControl = value;
	}
	
	@Override
	public ServiceInformation getServiceInformation() 
	{
		return serviceInformation;
	}

	@Override
	public void setServiceInformation(ServiceInformation value) 
	{
		this.serviceInformation = value;
	}
	
	@Override
	public CostInformation getCostInformation() 
	{
		return costInformation;
	}

	@Override
	public void setCostInformation(CostInformation value) 
	{
		this.costInformation = value;
	}

	@Override
	public Date getEventTimestamp() 
	{
		if(eventTimestamp==null)
			return null;
		
		return eventTimestamp.getDateTime();
	}

	@Override
	public void setEventTimestamp(Date value) 
	{
		if(value==null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);
	}

	@Override
	public String getServiceContextId() 
	{
		if(serviceContextId==null)
			return null;
		
		return serviceContextId.getString();
	}

	@Override
	public void setServiceContextId(String value) 
	{
		if(value==null)
			this.serviceContextId = null;
		else
			this.serviceContextId = new ServiceContextIdImpl(value, null, null);
	}

	@Override
	public FinalUnitIndication getFinalUnitIndication() 
	{
		return finalUnitIndication;
	}

	@Override
	public void setFinalUnitIndication(FinalUnitIndication value) 
	{
		this.finalUnitIndication = value;
	}
	
	@Override
	public CreditControlFailureHandlingEnum getCreditControlFailureHandling() 
	{
		if(creditControlFailureHandling==null)
			return null;
		
		return creditControlFailureHandling.getEnumerated(CreditControlFailureHandlingEnum.class);
	}

	@Override
	public void setCreditControlFailureHandling(CreditControlFailureHandlingEnum value) 
	{
		if(value==null)
			this.creditControlFailureHandling = null;
		else
			this.creditControlFailureHandling = new CreditControlFailureHandlingImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(ccRequestType==null)
			return "CC-Request-Type is required";
		
		if(ccRequestNumber==null)
			return "CC-Request-Number is required";
		
		return super.validate();
	}

	@Override
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return grantedServiceUnit;
	}

	@Override
	public void setGrantedServiceUnit(GrantedServiceUnit value)
	{
		this.grantedServiceUnit = value;
	}

	@Override
	public MultipleServicesIndicatorEnum getMultipleServicesIndicator() 
	{
		if(multipleServicesIndicator == null)
			return null;
		
		return multipleServicesIndicator.getEnumerated(MultipleServicesIndicatorEnum.class);
	}

	@Override
	public void setMultipleServicesIndicator(MultipleServicesIndicatorEnum value) 
	{
		if(value == null)
			this.multipleServicesIndicator = null;
		else
			this.multipleServicesIndicator = new MultipleServicesIndicatorImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(authApplicationId);
		result.add(serviceContextId);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		
		result.add(username);
		result.add(ccSessionFailover);
		result.add(originStateId);
		result.add(eventTimestamp);
		
		result.add(grantedServiceUnit);
		
		if(multipleServicesCreditControl!=null)
			result.addAll(multipleServicesCreditControl);
		
		result.add(serviceInformation);
		result.add(costInformation);
		result.add(finalUnitIndication);
		result.add(creditControlFailureHandling);
		result.add(multipleServicesIndicator);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		result.add(failedAvp);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}