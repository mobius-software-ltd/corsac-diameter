package com.mobius.software.telco.protocols.diameter.impl.commands.s6m;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6m.SubscriberInformationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

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
public class SubscriberInformationAnswerImpl extends S6mAnswerImpl implements SubscriberInformationAnswer
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private List<UserIdentifier> userIdentifier;
	
	private ServiceData serviceData;
	
	protected SubscriberInformationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public SubscriberInformationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
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
	public List<UserIdentifier> getUserIdentifier() 
	{
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(List<UserIdentifier> value)
	{
		this.userIdentifier = value;
	}
	
	@Override
	public ServiceData getServiceData() 
	{
		return serviceData;
	}
	
	@Override
	public void setServiceData(ServiceData value)
	{
		this.serviceData = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(userIdentifier!=null)
			result.addAll(userIdentifier);
		
		result.add(serviceData);
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}