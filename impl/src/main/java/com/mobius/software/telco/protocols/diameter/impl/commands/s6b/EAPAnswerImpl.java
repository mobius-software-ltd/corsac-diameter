package com.mobius.software.telco.protocols.diameter.impl.commands.s6b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6b.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPMasterSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5779.MobileNodeIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPMasterSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5779.MobileNodeIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
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
public class EAPAnswerImpl extends S6bAnswerWithIdImpl implements EAPAnswer
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;
	
	private EAPMasterSessionKey eapMasterSessionKey;
	
	private MobileNodeIdentifier mobileNodeIdentifier;
	
	private APNConfiguration apnConfiguration;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
    
	private List<QoSResources> qosResources;
	
	private TraceInfo traceInfo;

	private List<SupportedFeatures> supportedFeatures;
	
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
	public List<QoSResources> getQoSResources()
	{
		return this.qosResources;
	}
	
	@Override
	public void setQoSResources(List<QoSResources> value)
	{
		this.qosResources = value;
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
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;				
	}
			 
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
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
		result.add(username);
        result.add(eapPayload);
        result.add(eapMasterSessionKey);
        result.add(mobileNodeIdentifier);
        result.add(apnConfiguration);
        result.add(mip6AgentInfo);
        result.add(mip6FeatureVector);
        result.add(tgppChargingCharacteristics);
        
        if(qosResources!=null)
			result.addAll(qosResources);

        if(redirectHost!=null)
        	result.addAll(redirectHost);
        
        result.add(traceInfo);
        
        if(supportedFeatures!=null)
        	result.addAll(supportedFeatures);
        
        if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}