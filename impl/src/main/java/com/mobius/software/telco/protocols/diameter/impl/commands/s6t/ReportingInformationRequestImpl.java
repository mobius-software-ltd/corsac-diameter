package com.mobius.software.telco.protocols.diameter.impl.commands.s6t;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ReportingInformationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UpdatedNetworkConfiguration;

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
@DiameterCommandImplementation(applicationId = 16777345, commandCode = 8388719, request = true)
public class ReportingInformationRequestImpl extends S6tRequestImpl implements ReportingInformationRequest
{
	private UserIdentifier userIdentifier;
	
	private List<MonitoringEventReport> monitoringEventReport;
	
	private List<GroupReport> groupReport;
	
	private UpdatedNetworkConfiguration updatedNetworkConfiguration;
	
	private RIRFlags rirFlags;
	
	private List<SupportedServices> supportedServices;
	
	protected ReportingInformationRequestImpl() 
	{
		super();
	}
	
	public ReportingInformationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
	}
	
	@Override
	public UserIdentifier getUserIdentifier()
	{
		if(userIdentifier == null)
			return null;
		
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			this.userIdentifier = null;
		else
			this.userIdentifier = value;
	}	
	
	@Override
	public List<MonitoringEventReport> getMonitoringEventReport()
	{
		return this.monitoringEventReport;
	}
	
	@Override
	public void setMonitoringEventReport(List<MonitoringEventReport> value)
	{
		this.monitoringEventReport = value;
	}	
	
	@Override
	public List<GroupReport> getGroupReport()
	{
		return this.groupReport;
	}
	
	@Override
	public void setGroupReport(List<GroupReport> value)
	{
		this.groupReport = value;
	}
	
	@Override
	public UpdatedNetworkConfiguration getUpdatedNetworkConfiguration()
	{
		return this.updatedNetworkConfiguration;
	}
	
	@Override
	public void setUpdatedNetworkConfiguration(UpdatedNetworkConfiguration value)
	{
		this.updatedNetworkConfiguration = value;
	}
	
	@Override
	public RIRFlags getRIRFlags()
	{
		return rirFlags;
	}
	
	@Override
	public void setRIRFlags(RIRFlags value)
	{
		this.rirFlags = value;
	}
	
	@Override
	public List<SupportedServices> getSupportedServices()
	{
		return this.supportedServices;
	}
	 
	@Override
	public void setSupportedServices(List<SupportedServices> value)
	{
		this.supportedServices = value;
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
		result.add(destinationHost);
		result.add(destinationRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(userIdentifier);
		
		if(monitoringEventReport!=null)
			result.addAll(monitoringEventReport);
		
		if(groupReport!=null)
			result.addAll(groupReport);
		
		result.add(updatedNetworkConfiguration);
		result.add(rirFlags);
		
		if(supportedServices!=null)
			result.addAll(supportedServices);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}