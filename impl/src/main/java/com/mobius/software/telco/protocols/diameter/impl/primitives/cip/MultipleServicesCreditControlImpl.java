package com.mobius.software.telco.protocols.diameter.impl.primitives.cip;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ericsson.ResultCodeExtensionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cip.CDRInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ChargingStateInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ServiceSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ServiceSetupResult;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ServiceSetupResultRequested;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ServiceSetupResultRequestedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cip.SubscriberInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.ResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.ResultCodeExtension;

import io.netty.buffer.ByteBuf;

public class MultipleServicesCreditControlImpl extends DiameterGroupedAvpImpl implements MultipleServicesCreditControl
{
	private ServiceSessionId serviceSessionId;
	private GrantedServiceUnit grantedServiceUnit;
	private RequestedServiceUnit requestedServiceUnit;
	private List<UsedServiceUnit> usedServiceUnit;
	private ServiceIdentifier serviceIdentifier;
	private RatingGroup ratingGroup;
	private ValidityTime validityTime;
	private ResultCode resultCode;
	private ResultCodeExtension resultCodeExtension;
	private CostInformation costInformation;
	private FinalUnitIndication finalUnitIndication;
	private ChargingStateInformation chargingStateInformation;
	private CDRInformation cdrInformation;
	private ServiceSetupResult serviceSetupResult;
	private ServiceSetupResultRequested serviceSetupResultRequested;
	private SubscriberInformation subscriberInformation;
	
	public MultipleServicesCreditControlImpl()
	{
		
	}
	
	public String getServiceSessionId()
	{
		if(serviceSessionId==null)
			return null;
		
		return serviceSessionId.getString();
	}
	
	public void setServiceSessionId(String value)
	{
		if(value==null)
			this.serviceSessionId = null;
		else
			this.serviceSessionId = new ServiceSessionIdImpl(value, null, null);			
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return this.grantedServiceUnit;
	}
	
	public void setGrantedServiceUnit(GrantedServiceUnit value)
	{
		this.grantedServiceUnit = value;
	}
	
	public RequestedServiceUnit getRequestedServiceUnit()	
	{
		return this.requestedServiceUnit;
	}
	
	public void setRequestedServiceUnit(RequestedServiceUnit value)
	{
		this.requestedServiceUnit = value;
	}
	
	public List<UsedServiceUnit> getUsedServiceUnit()
	{
		return this.usedServiceUnit;
	}

	public void setUsedServiceUnit(List<UsedServiceUnit> value)
	{
		this.usedServiceUnit = value;
	}
	
	public Long getServiceIdentifier()
	{
		if(serviceIdentifier==null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}
	
	public void setServiceIdentifier(Long value)
	{
		if(value==null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);			
	}
	
	public Long getRatingGroup()
	{
		if(this.ratingGroup == null)
			return null;
		
		return this.ratingGroup.getUnsigned();
	}

	public void setRatingGroup(Long value)
	{
		if(value == null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
	
	public Long getValidityTime()
	{
		if(this.validityTime == null)
			return null;
		
		return this.validityTime.getUnsigned();
	}

	public void setValidityTime(Long value)
	{
		if(value == null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	}
	
	public Long getResultCode()
	{
		if(this.resultCode == null)
			return null;
		
		return this.resultCode.getUnsigned();
	}

	public void setResultCode(Long value)
	{
		if(value == null)
			this.resultCode = null;
		else
			this.resultCode = new ResultCodeImpl(value, null, null);
	}
	
	public Long getResultCodeExtension()
	{
		if(this.resultCodeExtension == null)
			return null;
		
		return this.resultCodeExtension.getUnsigned();
	}

	public void setResultCodeExtension(Long value)
	{
		if(value == null)
			this.resultCodeExtension = null;
		else
			this.resultCodeExtension = new ResultCodeExtensionImpl(value, null, null);
	}
	
	public FinalUnitIndication getFinalUnitIndication()
	{
		return this.finalUnitIndication;
	}

	public void setFinalUnitIndication(FinalUnitIndication value)
	{
		this.finalUnitIndication = value;
	}
	
	public CostInformation getCostInformation()
	{
		return this.costInformation;
	}

	public void setCostInformation(CostInformation value)
	{
		this.costInformation = value;
	}
	
	public ByteBuf getChargingStateInformation()
	{
		if(this.chargingStateInformation == null)
			return null;
		
		return this.chargingStateInformation.getValue();
	}

	public void setChargingStateInformation(ByteBuf value)
	{
		if(value == null)
			this.chargingStateInformation = null;
		else
			this.chargingStateInformation = new ChargingStateInformationImpl(value, null, null);
	}
	
	public ByteBuf getCDRInformation()
	{
		if(this.cdrInformation == null)
			return null;
		
		return this.cdrInformation.getValue();
	}

	public void setCDRInformation(ByteBuf value)
	{
		if(value == null)
			this.cdrInformation = null;
		else
			this.cdrInformation = new CDRInformationImpl(value, null, null);
	}
	
	public Long getServiceSetupResult()
	{
		if(this.serviceSetupResult == null)
			return null;
		
		return this.serviceSetupResult.getUnsigned();
	}

	public void setServiceSetupResult(Long value)
	{
		if(value == null)
			this.serviceSetupResult = null;
		else
			this.serviceSetupResult = new ServiceSetupResultImpl(value, null, null);
	}
	
	public ServiceSetupResultRequestedEnum getServiceSetupResultRequested()
	{
		if(serviceSetupResultRequested==null)
			return null;
		
		return serviceSetupResultRequested.getEnumerated(ServiceSetupResultRequestedEnum.class);
	}
	
	public void setServiceSetupResultRequested(ServiceSetupResultRequestedEnum value)
	{
		if(value==null)
			this.serviceSetupResultRequested = null;
		else
			this.serviceSetupResultRequested = new ServiceSetupResultRequestedImpl(value, null, null);			
	}
	
	public SubscriberInformation getSubscriberInformation()
	{
		return this.subscriberInformation;
	}
	
	public void setSubscriberInformation(SubscriberInformation value)
	{
		this.subscriberInformation = value;
	}

}