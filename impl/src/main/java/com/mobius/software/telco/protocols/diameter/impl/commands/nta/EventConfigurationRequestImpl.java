package com.mobius.software.telco.protocols.diameter.impl.commands.nta;

/*
 * Mobius Software LTD
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.nta.EventConfigurationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.GroupReportingGuardTimerImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReportingGuardTimer;


public class EventConfigurationRequestImpl extends NtaRequestImpl implements EventConfigurationRequest
{
	protected List<ExternalIdentifier> externalIdentifier;
	
	protected EventConfiguration eventConfiguration;
	
	protected GroupReportingGuardTimer groupReportingGuardTimer;
	
	protected List<SupportedFeatures> supportedFeatures;
	
	protected EventConfigurationRequestImpl() 
	{
		super();
			
	}
		
	protected EventConfigurationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessonID, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationRealm, sessonID, isRetransmit, sessonID, authSessionState);	
		
		
		
		
	}
	
	@Override
	public List<String> getExternalIdentifier() 
	{
		if(externalIdentifier==null || externalIdentifier.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ExternalIdentifier curr:externalIdentifier)
			result.add(curr.getString());
		
		return result;
	}

	@Override
	public void setExternalIdentifier(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.externalIdentifier = null;
		else
		{
			this.externalIdentifier = new ArrayList<ExternalIdentifier>();
			for(String curr:value)
				this.externalIdentifier.add(new ExternalIdentifierImpl(curr, null, null));
		}
	}
	
	@Override
	public EventConfiguration getEventConfiguration()
	{
		return this.eventConfiguration;
	}
	
	@Override
	public void setEventConfiguration(EventConfiguration value)
	{
		this.eventConfiguration = value;
	}
	
	
	@Override
	public Long getGroupReportingGuardTimer()
	{
		if(groupReportingGuardTimer == null)
			return null;
		
		return groupReportingGuardTimer.getUnsigned();
	}
	 
	@Override
	public void setGroupReportingGuardTimer(Long value)
	{
		if(value == null)
			this.groupReportingGuardTimer = null;
		else
			this.groupReportingGuardTimer = new GroupReportingGuardTimerImpl(value, null, null);
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(externalIdentifier==null)
			return new MissingAvpException("External-Identifieris required", Arrays.asList(new DiameterAvp[] { new ExternalIdentifierImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(ocSupportedFeatures);
		
		if(externalIdentifier !=null)
		    result.addAll(externalIdentifier);
		
		result.add(eventConfiguration);
		result.add(groupReportingGuardTimer);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}

	
	
}