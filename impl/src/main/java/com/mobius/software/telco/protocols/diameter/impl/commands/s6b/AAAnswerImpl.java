package com.mobius.software.telco.protocols.diameter.impl.commands.s6b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6b.AAAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionTimeoutImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANTrustedImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionTimeout;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrusted;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;
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
public class AAAnswerImpl extends S6bAnswerWithIdImpl implements AAAnswer
{
	private AuthRequestType authRequestType;
	
	private ANTrusted anTrusted;
	
	private TraceInfo traceInfo;

	private OCSupportedFeatures ocSupportedFeatures;
	 
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private SessionTimeout sessionTimeout;
	
	private APNConfiguration apnConfiguration;
	
	private QoSResources qosResources;
	
	private List<SupportedFeatures> supportedFeatures;
			 
	private MIPSessionKey mipSessionKey;
	
	protected AAAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AAAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType) throws AvpNotSupportedException, MissingAvpException
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
	public ANTrustedEnum getANTrusted()
	{
		if(anTrusted==null)
			return null;
		
		return this.anTrusted.getEnumerated(ANTrustedEnum.class);
	}
	
	@Override
	public void setANTrusted(ANTrustedEnum value)
	{
		if(value==null)
			this.anTrusted = null;
		else
			this.anTrusted = new ANTrustedImpl(value, null, null);
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
	public QoSResources getQoSResources()
	{
		return this.qosResources;
	}
	
	@Override
	public void setQoSResources(QoSResources value)
	{
		this.qosResources = value;
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
	public ByteBuf getMIPSessionKey()
	{
		if(mipSessionKey==null)
			return null;
		
		return mipSessionKey.getValue();
	}
	
	@Override
	public void setMIPSessionKey(ByteBuf value)
	{
		if(value == null)
			this.mipSessionKey = null;
		else
			this.mipSessionKey = new MIPSessionKeyImpl(value, null, null);
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
		result.add(ocSupportedFeatures);
        result.add(ocOLR);
        
        if(load!=null)
			result.addAll(load);

        result.add(mip6FeatureVector);
        result.add(sessionTimeout);
        result.add(apnConfiguration);
        result.add(qosResources);
        result.add(anTrusted);
		  		
        if(redirectHost!=null)
        	result.addAll(redirectHost);
        
        result.add(traceInfo);
		
        if(supportedFeatures!=null)
        	result.addAll(supportedFeatures);
        
        result.add(mipSessionKey);
		
        if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}