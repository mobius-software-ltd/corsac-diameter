package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.IdentityWithEmergencyRegistration;

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
public class RegistrationTerminationAnswerImpl extends CxDxAnswerImpl implements RegistrationTerminationAnswer
{
	private AssociatedIdentities associatedIdentities;
	
	private List<IdentityWithEmergencyRegistration> identityWithEmergencyRegistration;
	
	public List<RouteRecord> routeRecords;
	
	protected RegistrationTerminationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public RegistrationTerminationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	public AssociatedIdentities getAssociatedIdentities()
	{
		return associatedIdentities;
	}
	 
	public void setAssociatedIdentities(AssociatedIdentities value)
	{
		this.associatedIdentities = value;				
	}
	
	public List<IdentityWithEmergencyRegistration> getIdentityWithEmergencyRegistration()
	{
		return this.identityWithEmergencyRegistration;
	}
	 
	public void setIdentityWithEmergencyRegistration(List<IdentityWithEmergencyRegistration> value)
	{
		this.identityWithEmergencyRegistration = value;
	}

	@Override
	public List<String> getRouteRecords() 
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value)
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
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
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(associatedIdentities);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(identityWithEmergencyRegistration!=null)
			result.addAll(identityWithEmergencyRegistration);
		
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