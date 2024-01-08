package com.mobius.software.telco.protocols.diameter.impl.commands.swd;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swd.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctInterimIntervalImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPMasterSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5779.MobileNodeIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc6942.ERPRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNOIReplacementImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ContextIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.DEAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.TWANConnectionModeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctInterimInterval;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPMasterSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5779.MobileNodeIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.Key;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6942.ERPRealm;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sta.DEAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectivityParameters;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

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
@DiameterCommandImplementation(applicationId = 16777250, commandCode = 268, request = false)
public class EAPAnswerImpl extends SwdAnswerImpl implements EAPAnswer
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;
	
	private SessionTimeout sessionTimeout;
	
	private AcctInterimInterval accountingInterimInterval;
	
	private EAPMasterSessionKey eapMasterSessionKey;
	
	private ContextIdentifier contextIdentifier;
	
	private APNOIReplacement apnOIReplacement;
	
	private List<APNConfiguration> apnConfiguration;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private MobileNodeIdentifier mobileNodeIdentifier;
	
	private TraceInfo traceInfo;

	private SubscriptionId subscriptionID;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private DEAFlags deaFlags;
	
	private TWANConnectionMode twanConnectionMode;
	
	private TWANConnectivityParameters twanConnectivityParameters;
	
	private TerminalInformation terminalInformation;
    
	private Key key;
    
	private ERPRealm erpRealm;
	
	protected EAPAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public EAPAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType)
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
	public ByteBuf getEAPPayload() 
	{
		if(eapPayload==null)
			return null;
		
		return eapPayload.getValue();
	}

	@Override
	public void setEAPPayload(ByteBuf value) 
	{
		if(value == null)
			this.eapPayload = null;
		else
			this.eapPayload = new EAPPayloadImpl(value, null, null);
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
	public ByteBuf getEAPMasterSessionKey() 
	{
		if(eapMasterSessionKey==null)
			return null;
		
		return eapMasterSessionKey.getValue();
	}

	@Override
	public void setEAPMasterSessionKey(ByteBuf value) 
	{
		if(value == null)
			this.eapMasterSessionKey = null;
		else
			this.eapMasterSessionKey = new EAPMasterSessionKeyImpl(value, null, null);
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
	public Long getMIP6FeatureVector() 
	{
		if(mip6FeatureVector==null)
			return null;
		
		return mip6FeatureVector.getLong();
	}

	@Override
	public void setMIP6FeatureVector(Long value) 
	{
		if(value == null)
			this.mip6FeatureVector = null;
		else
			this.mip6FeatureVector = new MIP6FeatureVectorImpl(value, null, null);
	}
	
	@Override
	public String getMobileNodeIdentifier()
	{
		if(mobileNodeIdentifier==null)
			return null;
		
		return mobileNodeIdentifier.getString();
	}
	
	@Override
	public void setMobileNodeIdentifier(String value)
	{
		if(value == null)
			this.mobileNodeIdentifier = null;
		else
			this.mobileNodeIdentifier = new MobileNodeIdentifierImpl(value, null, null);
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
		return this.subscriptionID;
	}
	
	@Override
	public void setSubscriptionID(SubscriptionId value)
	{
		this.subscriptionID = value;
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;				
	}
			 
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public Long getDEAFlags()
	{
		if(deaFlags == null)
			return null;
		
		return deaFlags.getUnsigned();
	}
	
	@Override
	public void setDEAFlags(Long value)
	{
		if(value==null)
			this.deaFlags = null;
		else
			this.deaFlags = new DEAFlagsImpl(value, null, null);
	}
	
	@Override
	public Long getTWANConnectionMode()
	{
		if(twanConnectionMode == null)
			return null;
		
		return twanConnectionMode.getUnsigned();
	}
	
	@Override
	public void setTWANConnectionMode(Long value)
	{
		if(value==null)
			this.twanConnectionMode = null;
		else
			this.twanConnectionMode = new TWANConnectionModeImpl(value, null, null);
	}
	
	@Override
	public TWANConnectivityParameters getTWANConnectivityParameters()
	{
		return this.twanConnectivityParameters;
	}
	
	@Override
	public void setTWANConnectivityParameters(TWANConnectivityParameters value)
	{
		this.twanConnectivityParameters = value;
	}
	
	@Override
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
    
	@Override
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
	}
    
	@Override
	public Key getKey()
	{
		return this.key;
	}
    
	@Override
	public void setKey(Key value)
	{
		this.key = value;
	}
    
	@Override
	public String getERPRealm()
	{
		if(erpRealm == null)
			return null;
		
		return erpRealm.getIdentity();
	}
    
	@Override
	public void setERPRealm(String value)
	{
		if(value==null)
			this.erpRealm = null;
		else
			this.erpRealm = new ERPRealmImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			return "Auth-Request-Type is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(resultCode);
		result.add(experimentalResult);
        result.add(originHost);
		result.add(originRealm);
		result.add(authRequestType);
		result.add(eapPayload);
        result.add(username);
        result.add(sessionTimeout);
        result.add(accountingInterimInterval);
        result.add(eapMasterSessionKey);
        result.add(contextIdentifier);
        result.add(apnOIReplacement);
        
        if(apnConfiguration!=null)
        	result.addAll(apnConfiguration);
        
        result.add(mip6FeatureVector);
        result.add(mobileNodeIdentifier);
        
        if(redirectHost!=null)
        	result.addAll(redirectHost);
        
        result.add(traceInfo);
        result.add(subscriptionID);
        
        if(supportedFeatures!=null)
        	result.addAll(supportedFeatures);
        
        result.add(deaFlags);
        result.add(twanConnectionMode);
        result.add(twanConnectivityParameters);
        result.add(terminalInformation);
        result.add(key);
        result.add(erpRealm);
        
        if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		return result;
	}
}