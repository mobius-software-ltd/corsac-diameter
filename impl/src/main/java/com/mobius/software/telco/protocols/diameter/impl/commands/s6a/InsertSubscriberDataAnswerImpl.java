package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6a.InsertSubscriberDataAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IDAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IMSVoiceOverPSSessionsSupportedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.LastUEActivityTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSUserState;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IDAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSVoiceOverPSSessionsSupported;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSVoiceOverPSSessionsSupportedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LastUEActivityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocalTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 319, request = false)
public class InsertSubscriberDataAnswerImpl extends S6aAnswerImpl implements InsertSubscriberDataAnswer
{
	private IMSVoiceOverPSSessionsSupported imsVoiceOverPSSessionsSupported;
	
	private LastUEActivityTime lastUEActivityTime;
	
	private RATType ratType;
	
	private IDAFlags idaFlags;
	
	private EPSUserState epsUserState;
	
	private EPSLocationInformation epsLocationInformation;
	 
	private LocalTimeZone localTimeZone;
	 
	private SupportedServices supportedServices;
	 
	private List<MonitoringEventReport> monitoringEventReport;
	 
	private List<MonitoringEventConfigStatus> monitoringEventConfigStatus;
	 
	protected InsertSubscriberDataAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public InsertSubscriberDataAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
		
	@Override
	public IMSVoiceOverPSSessionsSupportedEnum getIMSVoiceOverPSSessionsSupported()
	{
		if(imsVoiceOverPSSessionsSupported==null)
			return null;
	
		return imsVoiceOverPSSessionsSupported.getEnumerated(IMSVoiceOverPSSessionsSupportedEnum.class);
	}
	
	@Override
	public void setIMSVoiceOverPSSessionsSupported(IMSVoiceOverPSSessionsSupportedEnum value)
	{
		if(value==null)	
			this.imsVoiceOverPSSessionsSupported = null;
		else
			this.imsVoiceOverPSSessionsSupported = new IMSVoiceOverPSSessionsSupportedImpl(value, null, null);
	}
	
	@Override
	public Date getLastUEActivityTime()
	{
		if(this.lastUEActivityTime == null)
			return null;
		
		return this.lastUEActivityTime.getDateTime();
	}
	 
	@Override
	public void setLastUEActivityTime(Date value)
	{
		if(value == null)
			this.lastUEActivityTime = null;
		else			
			this.lastUEActivityTime = new LastUEActivityTimeImpl(value, null, null);
	}
	
	@Override
	public RATTypeEnum getRATType()
	{
		if(ratType == null)
			return null;
		
		return ratType.getEnumerated(RATTypeEnum.class);
	}
	
	@Override
	public void setRATType(RATTypeEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("RAT-Type is required");
		
		this.ratType = new RATTypeImpl(value, null, null);
	}
	
	@Override
	public Long getIDAFlags()
	{
		if(idaFlags==null)
			return null;
		
		return idaFlags.getUnsigned();
	}
	
	@Override
	public void setIDAFlags(Long value)
	{
		if(value==null)
			this.idaFlags = null;
		else
			this.idaFlags = new IDAFlagsImpl(value, null, null);
	}
	
	@Override
	public EPSUserState getEPSUserState() 
	{
		return epsUserState;
	}
	
	@Override
	public void setEPSUserState(EPSUserState value)
	{
		this.epsUserState = value;
	}
	 		
	@Override
	public EPSLocationInformation getEPSLocationInformation()
	{
		return this.epsLocationInformation;
	}
	 
	@Override
	public void setEPSLocationInformation(EPSLocationInformation value)
	{
		this.epsLocationInformation = value;
	}
	
	@Override
	public LocalTimeZone getLocalTimeZone()
	{
		return this.localTimeZone;
	}
	 
	@Override
	public void setLocalTimeZone(LocalTimeZone value)
	{
		this.localTimeZone = value;
	}
	
	@Override
	public SupportedServices getSupportedServices()
	{
		return this.supportedServices;
	}
	 
	@Override
	public void setSupportedServices(SupportedServices value)
	{
		this.supportedServices = value;
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
		result.add(vendorSpecificApplicationId);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(imsVoiceOverPSSessionsSupported);
		result.add(lastUEActivityTime);
		result.add(ratType);
		result.add(idaFlags);
		result.add(epsUserState);
		result.add(epsLocationInformation);
		result.add(localTimeZone);
		result.add(supportedServices);
		
		if(monitoringEventReport!=null)
			result.addAll(monitoringEventReport);
		
		if(monitoringEventConfigStatus!=null)
			result.addAll(monitoringEventConfigStatus);
		
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