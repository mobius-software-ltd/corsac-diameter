package com.mobius.software.telco.protocols.diameter.impl.commands.cip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.CDRInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.CIPIPVersionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.ChargingStateInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CheckBalanceResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ericsson.ResultCodeExtensionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.cip.CDRInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.CIPIPVersion;
import com.mobius.software.telco.protocols.diameter.primitives.cip.ChargingStateInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.cip.SubscriberInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CheckBalanceResult;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CheckBalanceResultEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.ResultCodeExtension;

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


public class ChargingInterrogationAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlAnswerImpl implements ChargingInterrogationAnswer
{
	protected VendorSpecificApplicationId vendorSpecificApplicationId;
	protected ResultCodeExtension resultCodeExtension;
	protected CostInformation costInformation;
	protected EventTimestamp eventTimestamp;
	protected ChargingStateInformation chargingStateInformation;
	protected CIPIPVersion cipIPVersion;
	protected SubscriberInformation subscriberInformation;
	protected List<MultipleServicesCreditControl> multipleServicesCreditControl;
	protected CheckBalanceResult checkBalanceResult;
    protected GrantedServiceUnit grantedServiceUnit;
    protected CDRInformation cdrInformation;
	
	protected ChargingInterrogationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
		setUsernameAllowed(false);
		setErrorMessageAllowed(false);
		setErrorReportingHostAllowed(false);
		setRedirectHostAllowed(false);
		setRedirectHostUsageAllowed(false);
		setRedirectMaxCacheTimeAllowed(false);
		setProxyInfoAllowed(false);
		
	}
	
	public ChargingInterrogationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID,ccRequestType, ccRequestNumber);
		setExperimentalResultAllowed(false);
		setUsernameAllowed(false);
		setErrorMessageAllowed(false);
		setErrorReportingHostAllowed(false);
		setRedirectHostAllowed(false);
		setRedirectHostUsageAllowed(false);
		setRedirectMaxCacheTimeAllowed(false);
		setProxyInfoAllowed(false);
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
	public Long getResultCodeExtension()
	{
		if(resultCodeExtension==null)
			return null;
		
		return resultCodeExtension.getUnsigned();
	}
	
	@Override
	public void setResultCodeExtension(Long value) 
	{
		if(value==null)
			this.resultCodeExtension = null;
		else
			this.resultCodeExtension = new ResultCodeExtensionImpl(value, null, null);
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
	public SubscriberInformation getSubscriberInformation() 
	{
		return subscriberInformation;
	}

	@Override
	public void setSubscriberInformation(SubscriberInformation value) 
	{
		this.subscriberInformation = value;
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
	public CheckBalanceResultEnum getCheckBalanceResult()  
	{
		if(checkBalanceResult==null)
			return null;
		
		return checkBalanceResult.getEnumerated(CheckBalanceResultEnum.class);
	}

	@Override
	public void setCheckBalanceResult(CheckBalanceResultEnum value)
	{
		if(value==null)
			this.checkBalanceResult = null;
		else
			this.checkBalanceResult = new CheckBalanceResultImpl(value, null, null);
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
	public ByteBuf getCDRInformation()
	{
		if(cdrInformation == null)
			return null;
		
		return cdrInformation.getValue();
	}
  	
	@Override
	public void setCDRInformation(ByteBuf value)
	{
		if(value == null)
			this.cdrInformation = null;
		else
			this.cdrInformation = new CDRInformationImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(vendorSpecificApplicationId);
		result.add(sessionId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(ccRequestNumber);
		result.add(ccRequestType);
		result.add(resultCodeExtension);
		result.add(originStateId);
		result.add(costInformation);
		result.add(eventTimestamp);
		result.add(chargingStateInformation);
		result.add(cipIPVersion);
		result.add(subscriberInformation);
		result.add(failedAvp);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(multipleServicesCreditControl!=null)
			result.addAll(multipleServicesCreditControl);
		
		result.add(checkBalanceResult);
		result.add(grantedServiceUnit);
		result.add(cdrInformation);
		
		return result;
	}
	
}
