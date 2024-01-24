package com.mobius.software.telco.protocols.diameter.impl.commands.s7a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s7a.UpdateVCSGLocationAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ErrorDiagnosticImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnostic;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UVAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNCSGSubscriptionData;

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
@DiameterCommandImplementation(applicationId = 16777308, commandCode = 8388638, request = false)
public class UpdateVCSGLocationAnswerImpl extends S7aAnswerImpl implements UpdateVCSGLocationAnswer
{
	private ErrorDiagnostic errorDiagnostic;
	
	private List<VPLMNCSGSubscriptionData> vplmnCSGSubscriptionData;
	
	private UVAFlags uvaFlags;
	
	protected UpdateVCSGLocationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public UpdateVCSGLocationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
		
	@Override
	public ErrorDiagnosticEnum getErrorDiagnostic()
	{
		if(errorDiagnostic==null)
			return null;
	
		return errorDiagnostic.getEnumerated(ErrorDiagnosticEnum.class);
	}
	
	@Override
	public void setErrorDiagnostic(ErrorDiagnosticEnum value)
	{
		if(value==null)
			this.errorDiagnostic = null;
		else
			this.errorDiagnostic = new ErrorDiagnosticImpl(value, null, null);
	}
	
	@Override
	public List<VPLMNCSGSubscriptionData> getVPLMNCSGSubscriptionData() 
	{
		return vplmnCSGSubscriptionData;
	}
	
	@Override
	public void setVPLMNCSGSubscriptionData(List<VPLMNCSGSubscriptionData> value)
	{
		this.vplmnCSGSubscriptionData = value;
	}
	
	@Override
	public UVAFlags getUVAFlags()
	{
		return uvaFlags;
	}
	
	@Override
	public void setUVAFlags(UVAFlags value)
	{
		this.uvaFlags = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(errorDiagnostic);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(vplmnCSGSubscriptionData!=null)
			result.addAll(vplmnCSGSubscriptionData);
		
		result.add(uvaFlags);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}