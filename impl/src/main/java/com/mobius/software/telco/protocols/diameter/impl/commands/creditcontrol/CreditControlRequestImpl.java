package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterRequestWithSessionAndRealmBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcCorrelationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.MultipleServicesIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RequestedActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceContextIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcCorrelationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSubSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceContextId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;

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
@DiameterCommandImplementation(applicationId = -1, commandCode = 272, request = true)
public class CreditControlRequestImpl extends DiameterRequestWithSessionAndRealmBase implements CreditControlRequest
{	
	private AuthApplicationId authApplicationId;
	
	private ServiceContextId serviceContextId;
	
	private CcRequestType ccRequestType;
	
	private CcRequestNumber ccRequestNumber;
	
	private CcSubSessionId accountingSubSessionId;
	
	private AcctMultiSessionId acctMultiSessionId;
	
	private EventTimestamp eventTimestamp;
	
	private List<SubscriptionId> subscriptionId;

	private List<SubscriptionIdExtension> subscriptionIdExtension;

	private ServiceIdentifier serviceIdentifier;

	private TerminationCause terminationCause;

	private RequestedServiceUnit requestedServiceUnit;

	private RequestedAction requestedAction;

	private List<UsedServiceUnit> usedServiceUnit;

	private MultipleServicesIndicator multipleServicesIndicator;

	private List<MultipleServicesCreditControl> multipleServicesCreditControl;
	
	private List<ServiceParameterInfo> serviceParameterInfo;
	
	private CcCorrelationId ccCorrelationId;

	private UserEquipmentInfo userEquipmentInfo;

	private UserEquipmentInfoExtension userEquipmentInfoExtension;
	
	public List<RouteRecord> routeRecords;
	
	protected CreditControlRequestImpl() 
	{
		super();
		setDestinationHostAllowed(false);
	}
		
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, String serviceContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm,destinationHost,destinationRealm, isRetransmit, sessionID);
		setDestinationHostAllowed(false);
		
		this.authApplicationId = new AuthApplicationIdImpl(4L, null, null);
		if(serviceContextId==null)
			throw new IllegalArgumentException("Service-Context-Id is required");
		
		if(ccRequestType==null)
			throw new IllegalArgumentException("Accounting-Record-Type is required");
		
		if(ccRequestNumber==null)
			throw new IllegalArgumentException("Accounting-Record-Number is required");	
		
		this.serviceContextId = new ServiceContextIdImpl(serviceContextId, null, null);
		
		this.ccRequestType = new CcRequestTypeImpl(ccRequestType, null, null);
		
		this.ccRequestNumber = new CcRequestNumberImpl(ccRequestNumber, null, null);
	}
	
	protected CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, String serviceContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm,destinationHost,destinationRealm, isRetransmit, sessionID);
		setDestinationHostAllowed(false);
		
		if(authApplicationId == null)
			this.authApplicationId = new AuthApplicationIdImpl(4L, null, null);
		else
			this.authApplicationId = new AuthApplicationIdImpl(authApplicationId, null, null);
		
		if(serviceContextId==null)
			throw new IllegalArgumentException("Service-Context-Id is required");
		
		if(ccRequestType==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		if(ccRequestNumber==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.serviceContextId = new ServiceContextIdImpl(serviceContextId, null, null);
		
		this.ccRequestType = new CcRequestTypeImpl(ccRequestType, null, null);
		
		this.ccRequestNumber = new CcRequestNumberImpl(ccRequestNumber, null, null);
	}

	@Override
	public String getServiceContextId() 
	{
		if(serviceContextId==null)
			return null;
		
		return serviceContextId.getString();
	}

	@Override
	public void setServiceContextId(String serviceContextId) 
	{
		if(serviceContextId==null)
			throw new IllegalArgumentException("Service-Context-Id is required");
		
		this.serviceContextId = new ServiceContextIdImpl(serviceContextId, null, null);		
	}

	@Override
	public CcRequestTypeEnum getCcRequestType() 
	{
		if(ccRequestType==null)
			return null;
		
		return ccRequestType.getEnumerated(CcRequestTypeEnum.class);
	}

	@Override
	public void setCcRequestType(CcRequestTypeEnum ccRequestType) 
	{
		if(ccRequestType==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		this.ccRequestType = new CcRequestTypeImpl(ccRequestType, null, null);		
	}

	@Override
	public Long getCcRequestNumber() 
	{
		if(ccRequestNumber==null)
			return null;
		
		return ccRequestNumber.getUnsigned();
	}

	@Override
	public void setCcRequestNumber(Long ccRequestNumber) 
	{
		if(ccRequestNumber==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.ccRequestNumber = new CcRequestNumberImpl(ccRequestNumber, null, null);
	}

	@Override
	public Long getAuthApplicationId() 
	{
		if(authApplicationId==null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public Long getCcSubSessionId() throws AvpNotSupportedException
	{
		if(this.accountingSubSessionId==null)
			return null;
		
		return this.accountingSubSessionId.getLong();
	}

	@Override
	public void setCcSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(value == null)
			this.accountingSubSessionId = null;
		else
			this.accountingSubSessionId = new CcSubSessionIdImpl(value, null, null);
	}

	@Override
	public String getAcctMultiSessionId() throws AvpNotSupportedException
	{
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value) throws AvpNotSupportedException
	{
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);			
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

	public List<SubscriptionId> getSubscriptionId() 
	{
		return subscriptionId;
	}

	public void setSubscriptionId(List<SubscriptionId> subscriptionId) 
	{
		this.subscriptionId = subscriptionId;
	}

	public List<SubscriptionIdExtension> getSubscriptionIdExtension() 
	{
		return subscriptionIdExtension;
	}

	public void setSubscriptionIdExtension(List<SubscriptionIdExtension> subscriptionIdExtension) 
	{
		this.subscriptionIdExtension = subscriptionIdExtension;
	}

	public Long getServiceIdentifier() 
	{
		if(serviceIdentifier == null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}

	public void setServiceIdentifier(Long serviceIdentifier) 
	{
		if(serviceIdentifier == null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(serviceIdentifier, null, null);
	}

	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	public void setTerminationCause(TerminationCauseEnum terminationCause) 
	{
		if(terminationCause == null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(terminationCause, null, null);
	}

	public RequestedServiceUnit getRequestedServiceUnit() 
	{
		return requestedServiceUnit;
	}

	public void setRequestedServiceUnit(RequestedServiceUnit requestedServiceUnit) 
	{
		this.requestedServiceUnit = requestedServiceUnit;
	}

	public RequestedActionEnum getRequestedAction() 
	{
		if(requestedAction == null)
			return null;
		
		return requestedAction.getEnumerated(RequestedActionEnum.class);
	}

	public void setRequestedAction(RequestedActionEnum requestedAction) 
	{
		if(requestedAction == null)
			this.requestedAction = null;
		else
			this.requestedAction = new RequestedActionImpl(requestedAction, null, null);
	}

	public List<UsedServiceUnit> getUsedServiceUnit() 
	{
		return usedServiceUnit;
	}

	public void setUsedServiceUnit(List<UsedServiceUnit> usedServiceUnit) 
	{
		this.usedServiceUnit = usedServiceUnit;
	}

	public MultipleServicesIndicatorEnum getMultipleServicesIndicator() 
	{
		if(multipleServicesIndicator == null)
			return null;
		
		return multipleServicesIndicator.getEnumerated(MultipleServicesIndicatorEnum.class);
	}

	public void setMultipleServicesIndicator(MultipleServicesIndicatorEnum multipleServicesIndicator) 
	{
		if(multipleServicesIndicator == null)
			this.multipleServicesIndicator = null;
		else
			this.multipleServicesIndicator = new MultipleServicesIndicatorImpl(multipleServicesIndicator, null, null);
	}

	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl() 
	{
		return multipleServicesCreditControl;
	}

	public void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> multipleServicesCreditControl) {
		this.multipleServicesCreditControl = multipleServicesCreditControl;
	}

	public List<ServiceParameterInfo> getServiceParameterInfo() 
	{
		return serviceParameterInfo;
	}

	public void setServiceParameterInfo(List<ServiceParameterInfo> serviceParameterInfo) 
	{
		this.serviceParameterInfo = serviceParameterInfo;
	}

	public ByteBuf getCcCorrelationId() 
	{
		if(this.ccCorrelationId == null)
			return null;
		
		return ccCorrelationId.getValue();
	}

	public void setCcCorrelationId(ByteBuf ccCorrelationId) 
	{
		if(ccCorrelationId == null)
			this.ccCorrelationId = null;
		else
			this.ccCorrelationId = new CcCorrelationIdImpl(ccCorrelationId, null, null);
	}

	public UserEquipmentInfo getUserEquipmentInfo() 
	{
		return userEquipmentInfo;
	}

	public void setUserEquipmentInfo(UserEquipmentInfo userEquipmentInfo) 
	{
		this.userEquipmentInfo = userEquipmentInfo;
	}

	public UserEquipmentInfoExtension getUserEquipmentInfoExtension() 
	{
		return userEquipmentInfoExtension;
	}

	public void setUserEquipmentInfoExtension(UserEquipmentInfoExtension userEquipmentInfoExtension) 
	{
		this.userEquipmentInfoExtension = userEquipmentInfoExtension;
	}

	@Override
	public List<String> getRouteRecords() 
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(serviceContextId==null)
			return "Service-Context-Id is required";
		
		if(ccRequestType==null)
			return "CC-Request-Type is required";
		
		if(ccRequestNumber==null)
			return "CC-Request-Request is required";
		
		return super.validate();
	}
}