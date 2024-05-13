package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.ericsson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TimeQuotaThresholdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UnitQuotaThresholdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.VolumeQuotaThresholdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CreditControlFailureHandlingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.MultipleServicesIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ericsson.ResultCodeExtensionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeQuotaThreshold;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnitQuotaThreshold;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VolumeQuotaThreshold;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandling;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.ResultCodeExtension;

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
public class CreditControlAnswerImpl extends AuthenticationAnswerImpl implements CreditControlAnswer
{
	private CcRequestType ccRequestType;
	
	private CcRequestNumber ccRequestNumber;
	
	private GrantedServiceUnit grantedServiceUnit;
	
	private MultipleServicesIndicator multipleServicesIndicator;

	private CostInformation costInformation;
	
	private FinalUnitIndication finalUnitIndication;
	
	private CreditControlFailureHandling creditControlFailureHandling;
	
	private ResultCodeExtension resultCodeExtension;
	
	private TimeQuotaThreshold timeQuotaThreshold;
	
	private VolumeQuotaThreshold volumeQuotaThreshold;
	
	private UnitQuotaThreshold unitQuotaThreshold;
	
	private ValidityTime validityTime;
	
	private ServiceIdentifier serviceIdentifier; 
	
	protected CreditControlAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, 4L);
		setExperimentalResultAllowed(false);
		
		setCcRequestNumber(ccRequestNumber);
	}
	
	//for overriding with different auth application ID
	protected CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, long authApplicationId, Long ccRequestNumber) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
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
	public void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("CC-Request-Type is required", Arrays.asList(new DiameterAvp[] { new CcRequestTypeImpl() }));
		
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
	public void setCcRequestNumber(Long value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("CC-Request-Number is required", Arrays.asList(new DiameterAvp[] { new CcRequestNumberImpl() }));	
		
		this.ccRequestNumber = new CcRequestNumberImpl(value, null, null);
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
	public Long getTimeQuotaThreshold()
	{
		if(this.timeQuotaThreshold == null)
			return null;
		
		return this.timeQuotaThreshold.getUnsigned();
	}
	
	@Override
	public void setTimeQuotaThreshold(Long value)
	{
		if(value == null)
			this.timeQuotaThreshold = null;
		else
			this.timeQuotaThreshold = new TimeQuotaThresholdImpl(value, null, null);
	}     
	
	@Override
	public Long getVolumeQuotaThreshold()
	{
		if(this.volumeQuotaThreshold == null)
			return null;
		
		return this.volumeQuotaThreshold.getUnsigned();
	}
	
	@Override
	public void setVolumeQuotaThreshold(Long value)
	{
		if(value == null)
			this.volumeQuotaThreshold = null;
		else
			this.volumeQuotaThreshold = new VolumeQuotaThresholdImpl(value, null, null);
	}        
	
	@Override
	public Long getUnitQuotaThreshold()
	{
		if(this.unitQuotaThreshold == null)
			return null;
		
		return this.unitQuotaThreshold.getUnsigned();
	}
	
	@Override
	public void setUnitQuotaThreshold(Long value)
	{
		if(value == null)
			this.unitQuotaThreshold = null;
		else
			this.unitQuotaThreshold = new UnitQuotaThresholdImpl(value, null, null);
	}  
	
	@Override
	public Long getValidityTime()
	{
		if(this.validityTime == null)
			return null;
		
		return this.validityTime.getUnsigned();
	}

	@Override
	public void setValidityTime(Long value)
	{
		if(value == null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	} 
	
	@Override
	public Long getServiceIdentifier()
	{
		if(serviceIdentifier==null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}
	
	@Override
	public void setServiceIdentifier(Long value)
	{
		if(value==null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);			
	}        
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(ccRequestType==null)
			return new MissingAvpException("CC-Request-Type is required", Arrays.asList(new DiameterAvp[] { new CcRequestTypeImpl() }));
			
		if(ccRequestNumber==null)
			return new MissingAvpException("CC-Request-Number is required", Arrays.asList(new DiameterAvp[] { new CcRequestNumberImpl() }));	
		
		return super.validate();
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
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		
		result.add(username);
		result.add(originStateId);
		result.add(grantedServiceUnit);
		result.add(multipleServicesIndicator);
		result.add(costInformation);
		result.add(finalUnitIndication);
		result.add(creditControlFailureHandling);
		result.add(resultCodeExtension);
		result.add(timeQuotaThreshold);
		result.add(volumeQuotaThreshold);
		result.add(unitQuotaThreshold);
		result.add(validityTime);
		result.add(serviceIdentifier);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		result.add(failedAvp);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}