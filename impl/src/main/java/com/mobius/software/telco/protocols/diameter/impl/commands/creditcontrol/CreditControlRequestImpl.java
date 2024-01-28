package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
@DiameterCommandImplementation(applicationId = 4, commandCode = 272, request = true)
public class CreditControlRequestImpl extends DiameterRequestWithSessionAndRealmBase implements CreditControlRequest
{	
	protected AuthApplicationId authApplicationId;
	
	protected ServiceContextId serviceContextId;
	
	protected CcRequestType ccRequestType;
	
	protected CcRequestNumber ccRequestNumber;
	
	protected CcSubSessionId ccSubSessionId;
	
	protected AcctMultiSessionId acctMultiSessionId;
	
	protected EventTimestamp eventTimestamp;
	
	protected List<SubscriptionId> subscriptionId;

	protected List<SubscriptionIdExtension> subscriptionIdExtension;

	protected ServiceIdentifier serviceIdentifier;

	protected TerminationCause terminationCause;

	protected RequestedServiceUnit requestedServiceUnit;

	protected RequestedAction requestedAction;

	protected List<UsedServiceUnit> usedServiceUnit;

	protected MultipleServicesIndicator multipleServicesIndicator;

	protected List<MultipleServicesCreditControl> multipleServicesCreditControl;
	
	protected List<ServiceParameterInfo> serviceParameterInfo;
	
	protected CcCorrelationId ccCorrelationId;

	protected UserEquipmentInfo userEquipmentInfo;

	protected UserEquipmentInfoExtension userEquipmentInfoExtension;
	
	protected List<RouteRecord> routeRecords;
	
	private boolean ccSubSessionIdAllowed = true;
	private boolean acctMultiSessionIdAllowed = true;
	private boolean subscriptionIdExtensionAllowed = true;
	private boolean serviceIdentifierAllowed = true;
	private boolean requestedServiceUnitAllowed = true;
	private boolean usedServiceUnitAllowed = true;
	private boolean serviceParameterInfoAllowed = true;
	private boolean userEquipmentInfoExtensionAllowed = true;
	
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
		
		setServiceContextId(serviceContextId);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);		
	}
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, String serviceContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm,destinationHost,destinationRealm, isRetransmit, sessionID);
		setDestinationHostAllowed(false);
		
		if(authApplicationId == null)
			this.authApplicationId = new AuthApplicationIdImpl(4L, null, null);
		else
			this.authApplicationId = new AuthApplicationIdImpl(authApplicationId, null, null);
		
		setServiceContextId(serviceContextId);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
	}

	protected void setCCSubSessionIdAllowed(boolean allowed) 
	{
		this.ccSubSessionIdAllowed = allowed;
	}
	
	protected void setAcctMultiSessionIdAllowed(boolean allowed) 
	{
		this.acctMultiSessionIdAllowed = allowed;
	}
	
	protected void setSubscriptionIdExtensionAllowed(boolean allowed) 
	{
		this.subscriptionIdExtensionAllowed = allowed;
	}
	
	protected void setServiceIdentifierAllowed(boolean allowed) 
	{
		this.serviceIdentifierAllowed = allowed;
	}
	
	protected void setRequestedServiceUnitAllowed(boolean allowed) 
	{
		this.requestedServiceUnitAllowed = allowed;
	}
	
	protected void setUsedServiceUnitAllowed(boolean allowed) 
	{
		this.usedServiceUnitAllowed = allowed;
	}
	
	protected void setServiceParameterInfoAllowed(boolean allowed) 
	{
		this.serviceParameterInfoAllowed = allowed;
	}
	
	protected void setUserEquipmentInfoExtensionAllowed(boolean allowed) 
	{
		this.userEquipmentInfoExtensionAllowed = allowed;
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
			throw new IllegalArgumentException("Service-Context-Id is required");
		
		this.serviceContextId = new ServiceContextIdImpl(value, null, null);		
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
	public Long getAuthApplicationId() 
	{
		if(authApplicationId==null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public Long getCcSubSessionId() throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(this.ccSubSessionId==null)
			return null;
		
		return this.ccSubSessionId.getLong();
	}

	@Override
	public void setCcSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.ccSubSessionId = null;
		else
			this.ccSubSessionId = new CcSubSessionIdImpl(value, null, null);
	}

	@Override
	public String getAcctMultiSessionId() throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value) throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
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

	public void setSubscriptionId(List<SubscriptionId> value) 
	{
		this.subscriptionId = value;
	}

	public List<SubscriptionIdExtension> getSubscriptionIdExtension() throws AvpNotSupportedException
	{
		if(!subscriptionIdExtensionAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return subscriptionIdExtension;
	}

	public void setSubscriptionIdExtension(List<SubscriptionIdExtension> value) throws AvpNotSupportedException
	{
		if(!subscriptionIdExtensionAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		this.subscriptionIdExtension = value;
	}

	public Long getServiceIdentifier() throws AvpNotSupportedException
	{
		if(!serviceIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(serviceIdentifier == null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}

	public void setServiceIdentifier(Long value) throws AvpNotSupportedException
	{
		if(!serviceIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);
	}

	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	public void setTerminationCause(TerminationCauseEnum value) 
	{
		if(value == null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(value, null, null);
	}

	public RequestedServiceUnit getRequestedServiceUnit() throws AvpNotSupportedException 
	{
		if(!requestedServiceUnitAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return requestedServiceUnit;
	}

	public void setRequestedServiceUnit(RequestedServiceUnit value) throws AvpNotSupportedException
	{
		if(!requestedServiceUnitAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		this.requestedServiceUnit = value;
	}

	public RequestedActionEnum getRequestedAction() 
	{
		if(requestedAction == null)
			return null;
		
		return requestedAction.getEnumerated(RequestedActionEnum.class);
	}

	public void setRequestedAction(RequestedActionEnum value) 
	{
		if(value == null)
			this.requestedAction = null;
		else
			this.requestedAction = new RequestedActionImpl(value, null, null);
	}

	public List<UsedServiceUnit> getUsedServiceUnit() throws AvpNotSupportedException 
	{
		if(!usedServiceUnitAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return usedServiceUnit;
	}

	public void setUsedServiceUnit(List<UsedServiceUnit> value) throws AvpNotSupportedException
	{
		if(!usedServiceUnitAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		this.usedServiceUnit = value;
	}

	public MultipleServicesIndicatorEnum getMultipleServicesIndicator() 
	{
		if(multipleServicesIndicator == null)
			return null;
		
		return multipleServicesIndicator.getEnumerated(MultipleServicesIndicatorEnum.class);
	}

	public void setMultipleServicesIndicator(MultipleServicesIndicatorEnum value) 
	{
		if(value == null)
			this.multipleServicesIndicator = null;
		else
			this.multipleServicesIndicator = new MultipleServicesIndicatorImpl(value, null, null);
	}

	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl() 
	{
		return multipleServicesCreditControl;
	}

	public void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value) 
	{
		this.multipleServicesCreditControl = value;
	}

	public List<ServiceParameterInfo> getServiceParameterInfo() throws AvpNotSupportedException
	{
		if(!serviceParameterInfoAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return serviceParameterInfo;
	}

	public void setServiceParameterInfo(List<ServiceParameterInfo> value) throws AvpNotSupportedException
	{
		if(!serviceParameterInfoAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		this.serviceParameterInfo = value;
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

	public UserEquipmentInfo getUserEquipmentInfo() 
	{
		return userEquipmentInfo;
	}

	public void setUserEquipmentInfo(UserEquipmentInfo value) 
	{
		this.userEquipmentInfo = value;
	}

	public UserEquipmentInfoExtension getUserEquipmentInfoExtension() throws AvpNotSupportedException
	{
		if(!userEquipmentInfoExtensionAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return userEquipmentInfoExtension;
	}

	public void setUserEquipmentInfoExtension(UserEquipmentInfoExtension value) throws AvpNotSupportedException
	{
		if(!userEquipmentInfoExtensionAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		this.userEquipmentInfoExtension = value;
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
		result.add(ccSubSessionId);
		result.add(acctMultiSessionId);
		
		result.add(originStateId);
		result.add(eventTimestamp);
		
		if(subscriptionId!=null)
			result.addAll(subscriptionId);
		
		if(subscriptionIdExtension!=null)
			result.addAll(subscriptionIdExtension);
		
		result.add(serviceIdentifier);
		result.add(terminationCause);
		result.add(requestedServiceUnit);
		result.add(requestedAction);
		
		if(usedServiceUnit!=null)
			result.addAll(usedServiceUnit);
		
		result.add(multipleServicesIndicator);
		
		if(multipleServicesCreditControl!=null)
			result.addAll(multipleServicesCreditControl);
		
		if(serviceParameterInfo!=null)
			result.addAll(serviceParameterInfo);
		
		result.add(ccCorrelationId);
		result.add(userEquipmentInfo);
		result.add(userEquipmentInfoExtension);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}