package com.mobius.software.telco.protocols.diameter.impl.commands.ro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.ro.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AoCRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcCorrelationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.MultipleServicesIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RequestedActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceContextIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPMultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcCorrelationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceContextId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

import io.netty.buffer.ByteBuf;

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
public class CreditControlRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlRequestImpl implements CreditControlRequest
{
	private ServiceContextId serviceContextId;
	private EventTimestamp eventTimestamp;
	private List<SubscriptionId> subscriptionId;
	private TerminationCause terminationCause;
	private RequestedAction requestedAction;
	private AoCRequestType aocRequestType;
	private MultipleServicesIndicator multipleServicesIndicator;
	private List<TGPPMultipleServicesCreditControl> tgppMultipleServicesCreditControl;
	protected CcCorrelationId ccCorrelationId;
	private UserEquipmentInfo userEquipmentInfo;
	private OCSupportedFeatures ocSupportedFeatures;
	private ServiceInformation serviceInformation;
	
	protected CreditControlRequestImpl() 
	{
		super();
		
	}
	
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, String serviceContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationRealm, isRetransmit, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
		
		setServiceContextId(serviceContextId);
	}

	@Override
	public String getServiceContextId() 
	{
		if(serviceContextId==null)
			return null;
		
		return serviceContextId.getString();
	}

	@Override
	public void setServiceContextId(String value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Service-Context-Id is required", Arrays.asList(new DiameterAvp[] { new ServiceContextIdImpl() }));
		
		this.serviceContextId = new ServiceContextIdImpl(value, null, null);		
	}

	@Override
	public Date getEventTimestamp() 
	{
		if(eventTimestamp == null)
			return null;
		
		return eventTimestamp.getDateTime();
	}

	@Override
	public void setEventTimestamp(Date value) 
	{
		if(value == null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);
	}
	
	@Override
	public List<SubscriptionId> getSubscriptionId() 
	{
		return subscriptionId;
	}

	@Override
	public void setSubscriptionId(List<SubscriptionId> value) 
	{
		this.subscriptionId = value;
	}
	@Override
	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}
	
	@Override
	public RequestedActionEnum getRequestedAction() 
	{
		if(requestedAction == null)
			return null;
		
		return requestedAction.getEnumerated(RequestedActionEnum.class);
	}

	@Override
	public void setRequestedAction(RequestedActionEnum value) 
	{
		if(value == null)
			this.requestedAction = null;
		else
			this.requestedAction = new RequestedActionImpl(value, null, null);
	}

	@Override
	public void setTerminationCause(TerminationCauseEnum value) 
	{
		if(value == null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(value, null, null);
	}
	
	@Override
	public AoCRequestTypeEnum getAoCRequestType()
	{
		if(this.aocRequestType==null)
			return null;
		
		return aocRequestType.getEnumerated(AoCRequestTypeEnum.class);
	}
	
	@Override
	public void setAoCRequestType(AoCRequestTypeEnum value)
	{
		if(value==null)
			this.aocRequestType = null;
		else
			this.aocRequestType = new AoCRequestTypeImpl(value, null, null);
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
	
	public ByteBuf getCcCorrelationId() 
	{
		if(this.ccCorrelationId == null)
			return null;
		
		return ccCorrelationId.getValue();
	}

	public void setCcCorrelationId(ByteBuf value) 
	{
		if(value == null)
			this.ccCorrelationId = null;
		else
			this.ccCorrelationId = new CcCorrelationIdImpl(value, null, null);
	}

	@Override
	public List<TGPPMultipleServicesCreditControl> getMultipleServicesCreditControl() 
	{
		return tgppMultipleServicesCreditControl;
	}

	@Override
	public void setMultipleServicesCreditControl(List<TGPPMultipleServicesCreditControl> value) 
	{
		this.tgppMultipleServicesCreditControl = value;
	}
	
	public UserEquipmentInfo getUserEquipmentInfo() 
	{
		return userEquipmentInfo;
	}

	public void setUserEquipmentInfo(UserEquipmentInfo value) 
	{
		this.userEquipmentInfo = value;
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public ServiceInformation getServiceInformation() 
	{
		return this.serviceInformation;
	}

	@Override
	public void setServiceInformation(ServiceInformation value) 
	{
		this.serviceInformation = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(serviceContextId==null)
			return new MissingAvpException("Service-Context-Id is required", Arrays.asList(new DiameterAvp[] { new ServiceContextIdImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(authApplicationId);
		result.add(serviceContextId);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		result.add(destinationHost);
		result.add(username);
		
		result.add(originStateId);
		result.add(eventTimestamp);
		
		if(subscriptionId!=null)
			result.addAll(subscriptionId);
		
		result.add(terminationCause);
		result.add(requestedAction);
		result.add(aocRequestType);
		
		result.add(multipleServicesIndicator);
		
		if(tgppMultipleServicesCreditControl!=null)
			result.addAll(tgppMultipleServicesCreditControl);
		
		result.add(ccCorrelationId);
		result.add(userEquipmentInfo);
		result.add(ocSupportedFeatures);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		result.add(serviceInformation);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}