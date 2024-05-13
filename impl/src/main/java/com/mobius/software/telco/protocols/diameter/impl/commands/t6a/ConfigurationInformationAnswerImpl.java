package com.mobius.software.telco.protocols.diameter.impl.commands.t6a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.t6a.ConfigurationInformationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;

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
public class ConfigurationInformationAnswerImpl extends T6aAnswerImpl implements ConfigurationInformationAnswer
{
	private List<MonitoringEventReport> monitoringEventReport;
	
	private List<MonitoringEventConfigStatus> monitoringEventConfigStatus;
	
	protected ConfigurationInformationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public ConfigurationInformationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
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
	public List<MonitoringEventConfigStatus> getMonitoringEventConfigStatus()
	{
		return this.monitoringEventConfigStatus;
	}
	
	@Override
	public void setMonitoringEventConfigStatus(List<MonitoringEventConfigStatus> value)
	{
		this.monitoringEventConfigStatus = value;
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
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(monitoringEventReport!=null)
			result.addAll(monitoringEventReport);
		
		if(monitoringEventConfigStatus!=null)
			result.addAll(monitoringEventConfigStatus);
		
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}