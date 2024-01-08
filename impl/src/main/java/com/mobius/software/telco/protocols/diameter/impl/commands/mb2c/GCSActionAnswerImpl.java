package com.mobius.software.telco.protocols.diameter.impl.commands.mb2c;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.GCSActionAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.RestartCounterImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIDeallocationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.RestartCounter;

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
@DiameterCommandImplementation(applicationId = 16777335, commandCode = 8388662, request = false)
public class GCSActionAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl implements GCSActionAnswer
{
	private DRMP drmp;
	
	private AuthSessionState authSessionState;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private TMGIAllocationResponse tmgiAllocationResponse;
	
	private TMGIDeallocationResponse tmgiDeallocationResponse;
	
	private List<MBMSBearerResponse> mbmsBearerResponse;
	
	private RestartCounter restartCounter;
	
	private List<Load> load;
	
	protected GCSActionAnswerImpl() 
	{
		super();
	}
	
	public GCSActionAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		
		setAuthSessionState(authSessionState);
	}

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}

	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState==null)
			throw new IllegalArgumentException("Auth-Session-State is required");
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) 
	{
		if(value == null)
			this.authSessionState = null;
		else
			this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}

	@Override
	public List<SupportedFeatures> getSupportedFeatures() 
	{
		return supportedFeatures;
	}

	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value) 
	{
		this.supportedFeatures = value;
	}

	@Override
	public TMGIAllocationResponse getTMGIAllocationResponse()
	{
		return this.tmgiAllocationResponse;
	}
	
	@Override
	public void setTMGIAllocationResponse(TMGIAllocationResponse value)
	{
		this.tmgiAllocationResponse = value;
	}
	
	@Override
	public TMGIDeallocationResponse getTMGIDeallocationResponse()
	{
		return this.tmgiDeallocationResponse;
	}
	
	@Override
	public void setTMGIDeallocationResponse(TMGIDeallocationResponse value)
	{
		this.tmgiDeallocationResponse = value;
	}
	
	@Override
	public List<MBMSBearerResponse> getMBMSBearerResponse()
	{
		return this.mbmsBearerResponse;
	}
	
	@Override
	public void setMBMSBearerResponse(List<MBMSBearerResponse> value)
	{
		this.mbmsBearerResponse = value;
	}
	
	@Override
	public Long getRestartCounter()
	{
		if(restartCounter==null)
			return null;
		
		return restartCounter.getUnsigned();
	}
	
	@Override
	public void setRestartCounter(Long value)
	{
		if(value==null)
			this.restartCounter = null;
		else
			this.restartCounter = new RestartCounterImpl(value, null, null);
	}
	
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authSessionState==null)
			return "Auth-Session-State is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(errorMessage);
        result.add(errorReportingHost);
        result.add(failedAvp);
        result.add(originStateId);
		
        if(redirectHost!=null)
			result.addAll(redirectHost);

        result.add(redirectHostUsage);
        result.add(redirectMaxCacheTime);
        
        if(proxyInfo!=null)
			result.addAll(proxyInfo);

        if(supportedFeatures!=null)
			result.addAll(supportedFeatures);

        result.add(tmgiAllocationResponse);
        result.add(tmgiDeallocationResponse);
        
        if(mbmsBearerResponse!=null)
			result.addAll(mbmsBearerResponse);

        result.add(restartCounter);
		
        if(load!=null)
			result.addAll(load);

        if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
        
		return result;
	}
}