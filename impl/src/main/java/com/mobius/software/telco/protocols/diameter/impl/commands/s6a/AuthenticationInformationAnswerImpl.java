package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6a.AuthenticationInformationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ErrorDiagnosticImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UEUsageTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnostic;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UEUsageType;

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
public class AuthenticationInformationAnswerImpl extends S6aAnswerImpl implements AuthenticationInformationAnswer
{
	private ErrorDiagnostic errorDiagnostic;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private AuthenticationInfo authenticationInfo;
	
	private UEUsageType ueUsageType;
	
	protected AuthenticationInformationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public AuthenticationInformationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
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
	public AuthenticationInfo getAuthenticationInfo() 
	{
		return authenticationInfo;
	}
	
	@Override
	public void setAuthenticationInfo(AuthenticationInfo value)
	{
		this.authenticationInfo = value;
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
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(authenticationInfo);
		result.add(ueUsageType);
		
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