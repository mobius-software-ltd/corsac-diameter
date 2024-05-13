package com.mobius.software.telco.protocols.diameter.impl.commands.swm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swm.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPMasterSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5779.MobileNodeIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.APNOIReplacementImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CoreNetworkRestrictionsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UEUsageTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPMasterSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5779.MobileNodeIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CoreNetworkRestrictions;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EmergencyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEUsageType;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
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
public class EAPAnswerImpl extends SwmAnswerWithIdImpl implements EAPAnswer
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;
	
	private EAPMasterSessionKey eapMasterSessionKey;
	
	private APNOIReplacement apnOIReplacement;
	
	private APNConfiguration apnConfiguration;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private MobileNodeIdentifier mobileNodeIdentifier;
	
	private TraceInfo traceInfo;

	private SubscriptionId subscriptionID;
	
	private SessionTimeout sessionTimeout;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	
	private List<SupportedFeatures> supportedFeatures;
    
	private OCSupportedFeatures ocSupportedFeatures;
	 
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private AccessNetworkInfo accessNetworkInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	private UEUsageType ueUsageType;
    
	private EmergencyInfo emergencyInfo;
	
	private CoreNetworkRestrictions coreNetworkRestrictions;
	
	protected EAPAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public EAPAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType) throws MissingAvpException, AvpNotSupportedException
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
	public void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Auth-Request-Type is required", Arrays.asList(new DiameterAvp[] { new AuthRequestTypeImpl() }));	
		
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
	public APNConfiguration getAPNConfiguration()
	{
		return this.apnConfiguration;
	}
				
	@Override
	public void setAPNConfiguration(APNConfiguration value)
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
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return this.mip6AgentInfo;
	}
	
	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value)
	{
		this.mip6AgentInfo = value;
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
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
			 
	@Override
	public AccessNetworkInfo getAccessNetworkInfo()
	{
		return this.accessNetworkInfo;
	}
	
	@Override
	public void setAccessNetworkInfo(AccessNetworkInfo value)
	{
		this.accessNetworkInfo = value;
	}
	
	@Override
	public Date getUserLocationInfoTime() 
	{
		if(userLocationInfoTime == null)
			return null;
		
		return userLocationInfoTime.getDateTime();
	}
	
	@Override
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);
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
	public Long getCoreNetworkRestrictions()
	{
		if(coreNetworkRestrictions == null)
			return null;
		
		return coreNetworkRestrictions.getUnsigned();
	}
	
	@Override
	public void setCoreNetworkRestrictions(Long value)
	{
		if(value==null)
			this.coreNetworkRestrictions = null;
		else
			this.coreNetworkRestrictions = new CoreNetworkRestrictionsImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authRequestType==null)
			return new MissingAvpException("Auth-Request-Type is required", Arrays.asList(new DiameterAvp[] { new AuthRequestTypeImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(authRequestType);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(eapPayload);
        result.add(username);
        result.add(eapMasterSessionKey);
        result.add(apnOIReplacement);
        result.add(apnConfiguration);
        result.add(mip6FeatureVector);
        result.add(mobileNodeIdentifier);
        result.add(traceInfo);
        result.add(subscriptionID);
        result.add(sessionTimeout);
        result.add(mip6AgentInfo);
        result.add(tgppChargingCharacteristics);
        
        if(redirectHost!=null)
        	result.addAll(redirectHost);
        
        if(supportedFeatures!=null)
        	result.addAll(supportedFeatures);
        
        result.add(ocSupportedFeatures);
        result.add(ocOLR);
        
        if(load!=null)
        	result.addAll(load);
        
        result.add(accessNetworkInfo);
        result.add(userLocationInfoTime);
        result.add(ueUsageType);
        result.add(emergencyInfo);
        result.add(coreNetworkRestrictions);
        
        if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		return result;
	}
}