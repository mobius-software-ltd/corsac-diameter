package com.mobius.software.telco.protocols.diameter.impl.commands.tsp;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.tsp.DeviceActionAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.FeatureSupportedInFinalTargetImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.DeviceNotification;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.FeatureSupportedInFinalTarget;

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
public class DeviceActionAnswerImpl extends TspAnswerImpl implements DeviceActionAnswer
{
	private DeviceNotification deviceNotification;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private FeatureSupportedInFinalTarget featureSupportedInFinalTarget;
	
	private List<Load> load;
	
	protected DeviceActionAnswerImpl() 
	{
		super();
	}
	
	public DeviceActionAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, AuthSessionStateEnum authSessionState) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId, authSessionState);
	}

	@Override
	public DeviceNotification getDeviceNotification() 
	{
		return deviceNotification;
	}

	@Override
	public void setDeviceNotification(DeviceNotification value) 
	{
		this.deviceNotification = value;
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
	public Long getFeatureSupportedInFinalTarget() 
	{
		if(this.featureSupportedInFinalTarget==null)
			return null;
		
		return this.featureSupportedInFinalTarget.getUnsigned();
	}

	@Override
	public void setFeatureSupportedInFinalTarget(Long value) 
	{
		if(value == null)
			this.featureSupportedInFinalTarget = null;
		else
			this.featureSupportedInFinalTarget = new FeatureSupportedInFinalTargetImpl(value, null, null);
	}
	
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
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
		result.add(deviceNotification);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(featureSupportedInFinalTarget);
		
		if(load!=null)
			result.addAll(load);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}