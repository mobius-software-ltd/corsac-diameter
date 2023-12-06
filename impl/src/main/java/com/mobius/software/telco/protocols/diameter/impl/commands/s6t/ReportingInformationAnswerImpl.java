package com.mobius.software.telco.protocols.diameter.impl.commands.s6t;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ReportingInformationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReportStatus;

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
@DiameterCommandImplementation(applicationId = 16777345, commandCode = 8388719, request = false)
public class ReportingInformationAnswerImpl extends S6tAnswerImpl implements ReportingInformationAnswer
{
	private List<MonitoringEventReportStatus> monitoringEventReportStatus;
	
	protected ReportingInformationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public ReportingInformationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	@Override
	public List<MonitoringEventReportStatus> getMonitoringEventReportStatus() 
	{
		return monitoringEventReportStatus;
	}
	
	@Override
	public void setMonitoringEventReportStatus(List<MonitoringEventReportStatus> value)
	{
		this.monitoringEventReportStatus = value;
	}
}