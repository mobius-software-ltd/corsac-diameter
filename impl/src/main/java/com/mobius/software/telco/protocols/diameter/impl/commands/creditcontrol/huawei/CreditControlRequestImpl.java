package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.huawei;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.huawei.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterRequestWithSessionAndRealmBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.MultipleServicesIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RequestedActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceContextIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;

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
	private AuthApplicationId authApplicationId;
	
	private ServiceContextId serviceContextId;
	
	private CcRequestType ccRequestType;
	
	private CcRequestNumber ccRequestNumber;
	
	private CcSubSessionId accountingSubSessionId;
	
	private EventTimestamp eventTimestamp;
	
	private List<SubscriptionId> subscriptionId;

	private ServiceIdentifier serviceIdentifier;

	private RequestedServiceUnit requestedServiceUnit;
	
	private TerminationCause terminationCause;

	private RequestedAction requestedAction;

	private List<UsedServiceUnit> usedServiceUnit;

	private MultipleServicesIndicator multipleServicesIndicator;

	private List<MultipleServicesCreditControl> multipleServicesCreditControl;
	
	private UserEquipmentInfo userEquipmentInfo;

	private ServiceInformation serviceInformation;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
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
		
		setServiceContextId(serviceContextId);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);		
	}
	
	protected CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, String serviceContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
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
	public Long getCcSubSessionId()
	{
		if(this.accountingSubSessionId==null)
			return null;
		
		return this.accountingSubSessionId.getLong();
	}

	@Override
	public void setCcSubSessionId(Long value)
	{
		if(value == null)
			this.accountingSubSessionId = null;
		else
			this.accountingSubSessionId = new CcSubSessionIdImpl(value, null, null);
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
	public Long getServiceIdentifier()
	{
		if(serviceIdentifier == null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}

	@Override
	public void setServiceIdentifier(Long value)
	{
		if(value == null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);
	}

	@Override
	public RequestedServiceUnit getRequestedServiceUnit() 
	{
		return requestedServiceUnit;
	}

	@Override
	public void setRequestedServiceUnit(RequestedServiceUnit value) 
	{
		this.requestedServiceUnit = value;
	}

	@Override
	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
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
	public List<UsedServiceUnit> getUsedServiceUnit() 
	{
		return usedServiceUnit;
	}

	@Override
	public void setUsedServiceUnit(List<UsedServiceUnit> value)
	{
		this.usedServiceUnit = value;
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
	public UserEquipmentInfo getUserEquipmentInfo() 
	{
		return userEquipmentInfo;
	}

	@Override
	public void setUserEquipmentInfo(UserEquipmentInfo value) 
	{
		this.userEquipmentInfo = value;
	}

	@Override
	public String getTGPPSGSNMCCMNC() 
	{
		if(tgppSGSNMCCMNC == null)
			return null;
		
		return tgppSGSNMCCMNC.getString();
	}

	@Override
	public void setTGPPSGSNMCCMNC(String value) 
	{
		if(value == null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);
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