package com.mobius.software.telco.protocols.diameter.impl.commands.cip;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.CIPIPVersionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.ChargingContextIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.ChargingStateInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RequestedActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceContextIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.cip.AccessInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.CIPIPVersion;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ChargingContextId;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ChargingStateInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceContextId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;

import io.netty.buffer.ByteBuf;


public class ChargingInterrogationRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlRequestImpl implements ChargingInterrogationRequest
{
	protected VendorSpecificApplicationId vendorSpecificApplicationId;
	protected ChargingContextId chargingContextId; 
	protected List<SubscriptionId> subscriptionId;
	protected ServiceContextId serviceContextId;
	protected EventTimestamp eventTimestamp;
	protected TerminationCause terminationCause;
	protected UserEquipmentInfo userEquipmentInfo;
	protected AccessInformation accessInformation;
	protected ChargingStateInformation chargingStateInformation;
	protected CIPIPVersion cipIPVersion;
	protected TGPPMSTimeZone tgppMSTimeZone;
	protected List<MultipleServicesCreditControl> multipleServicesCreditControl;
	protected RequestedServiceUnit requestedServiceUnit;
	protected RequestedAction requestedAction;
	protected ServiceIdentifier serviceIdentifier;
	
	protected ChargingInterrogationRequestImpl() 
	{
		super();
		setDestinationHostAllowed(false);
		setUsernameAllowed(false);
		setProxyInfoAllowed(false);
		setRouteRecordsAllowed(false);
	}
	public ChargingInterrogationRequestImpl(String originHost,String originRealm, String destinationRealm,Boolean isRetransmit, String sessonID,String chargingContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber,List<SubscriptionId> subscriptionId) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, null, destinationRealm, isRetransmit, sessonID, ccRequestType, ccRequestNumber);
		
		setChargingContextId(chargingContextId);
		setSubscriptionId(subscriptionId);
		setDestinationHostAllowed(false);
		setUsernameAllowed(false);
		setProxyInfoAllowed(false);
		setRouteRecordsAllowed(false);
	}
	
	@Override
	public VendorSpecificApplicationId getVendorSpecificApplicationId()
	{
		if(vendorSpecificApplicationId==null)
			return null;
		else
			return vendorSpecificApplicationId; 
	}

	@Override
	public void setVendorSpecificApplicationId(VendorSpecificApplicationId value) 
	{
		this.vendorSpecificApplicationId = value;
	}
	
	@Override
	public String getChargingContextId() 
	{
		if(chargingContextId==null)
			return null;
		
		return chargingContextId.getString();
	}

	@Override
	public void setChargingContextId(String value) throws MissingAvpException
	{
		if(value==null)
			this.chargingContextId = null;
		else
			this.chargingContextId = new ChargingContextIdImpl(value, null, null);		
	}
	
	@Override
	public List<SubscriptionId> getSubscriptionId() 
	{
		return subscriptionId;
	}
	
	@Override
	public void setSubscriptionId(List<SubscriptionId> value) throws MissingAvpException
	{
		this.subscriptionId = value;
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
	public AccessInformation getAccessInformation() 
	{
		return accessInformation;
	}

	@Override
	public void setAccessInformation(AccessInformation value) 
	{
		this.accessInformation = value;
	}
	
	@Override
	public ByteBuf getChargingStateInformation()
	{
		if(chargingStateInformation == null)
			return null;
		
		return chargingStateInformation.getValue();
	}
  	
	@Override
	public void setChargingStateInformation(ByteBuf value)
	{
		if(value == null)
			this.chargingStateInformation = null;
		else
			this.chargingStateInformation = new ChargingStateInformationImpl(value, null, null);
	}
	
	@Override
	public String getCIPIPVersion()
	{
		if(cipIPVersion == null)
			return null;
		
		return cipIPVersion.getString();
	}
  	
	@Override
	public void setCIPIPVersion(String value)
	{
		if(value == null)
			this.cipIPVersion = null;
		else
			this.cipIPVersion = new CIPIPVersionImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPPMSTimeZone()
	{
		if(tgppMSTimeZone == null)
			return null;
		
		return tgppMSTimeZone.getValue();
	}
	
	@Override
	public void setTGPPMSTimeZone(ByteBuf value)
	{
		if(value == null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(chargingContextId==null)
			return new MissingAvpException("Charging-Context-Id is required",Arrays.asList(new DiameterAvp[] { new ChargingContextIdImpl() } ));
		
		if(subscriptionId==null)
			return new MissingAvpException("Charging-Context-Id is required",Arrays.asList(new DiameterAvp[] { new SubscriptionIdImpl() } ));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(vendorSpecificApplicationId);
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		result.add(chargingContextId);
		
		if(subscriptionId!=null)
			result.addAll(subscriptionId);
		
		result.add(serviceContextId);
		result.add(destinationHost);
		result.add(originStateId);
		result.add(eventTimestamp);
		result.add(terminationCause);
		result.add(userEquipmentInfo);
		result.add(accessInformation);
		result.add(chargingStateInformation);
		result.add(cipIPVersion);
		result.add(tgppMSTimeZone);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(multipleServicesCreditControl!=null)
			result.addAll(multipleServicesCreditControl);
		
		result.add(requestedAction);
		result.add(requestedServiceUnit);
		result.add(serviceIdentifier);
		
		return result;	
	}
}