package com.mobius.software.telco.protocols.diameter.impl.commands.sta;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sta.AAAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctInterimIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNOIReplacementImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ContextIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UEUsageTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctInterimInterval;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEUsageType;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

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
@DiameterCommandImplementation(applicationId = 16777250, commandCode = 271, request = false)
public class AAAnswerImpl extends StaAnswerWithIdImpl implements AAAnswer
{
	private AuthRequestType authRequestType;
	
	private SessionTimeout sessionTimeout;	
	
	private AcctInterimInterval accountingInterimInterval;
	
	private ContextIdentifier contextIdentifier;
	
	private APNOIReplacement apnOIReplacement;
	
	private List<APNConfiguration> apnConfiguration;
				
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	private TraceInfo traceInfo;

	private SubscriptionId subscriptionID;
	
	private OCSupportedFeatures ocSupportedFeatures;
	 
	private OCOLR ocOLR;
	
	private UEUsageType ueUsageType;
    
	private EmergencyInfo emergencyInfo;
    
	private List<Load> load;
	
	protected AAAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AAAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
		setAuthRequestType(authRequestType);
	}

	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");	
		
		this.authRequestType = new AuthRequestTypeImpl(value, null, null);
	}
	
	@Override
	public Long getSessionTimeout() 
	{
		if(sessionTimeout == null)
			return null;
		
		return sessionTimeout.getUnsigned();
	}
	
	@Override
	public void setSessionTimeout(Long value)
	{
		if(value==null)
			this.sessionTimeout = null;
		else
			this.sessionTimeout = new SessionTimeoutImpl(value, null, null);
	}
	
	@Override
	public Long getAccountingInterimInterval()
	{
		if(accountingInterimInterval==null)
			return null;
		
		return accountingInterimInterval.getUnsigned();
	}
	
	@Override
	public void setAccountingInterimInterval(Long value)
	{
		if(value == null)
			this.accountingInterimInterval = null;
		else
			this.accountingInterimInterval = new AcctInterimIntervalImpl(value, null, null);
	}	
	
	@Override
	public Long getContextIdentifier()
	{
		if(contextIdentifier==null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	
	@Override
	public void setContextIdentifier(Long value)
	{
		if(value == null)
			this.contextIdentifier = null;
		else
			this.contextIdentifier = new ContextIdentifierImpl(value, null, null);
	}
	
	@Override
	public String getAPNOIReplacement()
	{
		if(apnOIReplacement==null)
			return null;
		
		return apnOIReplacement.getString();
	}
	
	@Override
	public void setAPNOIReplacement(String value) 
	{
		if(value == null)
			this.apnOIReplacement = null;
		else
			this.apnOIReplacement = new APNOIReplacementImpl(value, null, null);
	}
	
	@Override
	public List<APNConfiguration> getAPNConfiguration()
	{
		return this.apnConfiguration;
	}
				
	@Override
	public void setAPNConfiguration(List<APNConfiguration> value)
	{
		this.apnConfiguration = value;
	}
	
	@Override
	public String getTGPPChargingCharacteristics() 
	{
		if(tgppChargingCharacteristics==null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}

	@Override
	public void setTGPPChargingCharacteristics(String value) 
	{
		if(value == null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);
	}
	
	@Override
	public TraceInfo getTraceInfo()
	{
		return traceInfo;
	}

	@Override
	public void setTraceInfo(TraceInfo value)
	{
		this.traceInfo = value;
	}
	
	@Override
	public SubscriptionId getSubscriptionID()
	{
		return subscriptionID;
	}
	
	@Override
	public void setSubscriptionID(SubscriptionId value)
	{
		this.subscriptionID = value;
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	 		
	@Override
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	 
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
	
	@Override
	public Long getUEUsageType()
	{
		if(ueUsageType==null)
			return null;
		
		return ueUsageType.getUnsigned();
	}
    
	@Override
	public void setUEUsageType(Long value)
	{
		if(value==null)
			this.ueUsageType = null;
		else
			this.ueUsageType = new UEUsageTypeImpl(value, null, null);
	}
	
    @Override
	public EmergencyInfo getEmergencyInfo()
	{
    	return this.emergencyInfo;
	}
    
	@Override
	public void setEmergencyInfo(EmergencyInfo value)
	{
		this.emergencyInfo = value;
	}
    
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
}