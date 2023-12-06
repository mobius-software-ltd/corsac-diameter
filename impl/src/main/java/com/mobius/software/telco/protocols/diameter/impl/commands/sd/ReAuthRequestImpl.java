package com.mobius.software.telco.protocols.diameter.impl.commands.sd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.sd.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RevalidationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.SessionReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReporting;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RevalidationTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleRemove;

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
@DiameterCommandImplementation(applicationId = 16777303, commandCode = 258, request = true)
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestmpl implements ReAuthRequest
{
	private DRMP drmp;
	
	private SessionReleaseCause sessionReleaseCause;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private QoSInformation qosInformation;
	
	private List<EventTrigger> eventTrigger;
	
	private List<CSGInformationReporting> csgInformationReporting;
	
	private EventReportIndication eventReportIndication;
	
	private List<ADCRuleRemove> adcRuleRemove;
	
	private List<ADCRuleInstall> adcRuleInstall;
	
	private RevalidationTime revalidationTime;
	
	private List<UsageMonitoringInformation> usageMonitoringInformation;
	
	protected ReAuthRequestImpl() 
	{
		super();		
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType)
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID, reAuthRequestType);		
	}
	
	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}
	
	@Override
	public SessionReleaseCauseEnum getSessionReleaseCause()
	{
		if(sessionReleaseCause==null)
			return null;
		
		return sessionReleaseCause.getEnumerated(SessionReleaseCauseEnum.class);
	}
	
	@Override
	public void setSessionReleaseCause(SessionReleaseCauseEnum value)
	{
		if(value==null)
			this.sessionReleaseCause = null;
		else
			this.sessionReleaseCause = new SessionReleaseCauseImpl(value, null, null);			
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
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	@Override
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	@Override
	public List<EventTriggerEnum> getEventTrigger()
	{
		if(eventTrigger==null || eventTrigger.size()==0)
			return null;
		
		List<EventTriggerEnum> result = new ArrayList<EventTriggerEnum>();
		for(EventTrigger curr:eventTrigger)
			result.add(curr.getEnumerated(EventTriggerEnum.class));
		
		return result;
	}
	
	@Override
	public void setEventTrigger(List<EventTriggerEnum> value)
	{
		if(value==null || value.size()==0)
			this.eventTrigger = null;
		else
		{
			this.eventTrigger = new ArrayList<EventTrigger>();
			for(EventTriggerEnum curr:value)
				this.eventTrigger.add(new EventTriggerImpl(curr, null, null));			
		}
	}
	
	@Override
	public List<CSGInformationReporting> getCSGInformationReporting()
	{
		return this.csgInformationReporting;
	}
	
	@Override
	public void setCSGInformationReporting(List<CSGInformationReporting> value)
	{
		this.csgInformationReporting = value;
	}
	
	@Override
	public EventReportIndication getEventReportIndication()
	{
		return this.eventReportIndication;
	}
	
	@Override
	public void setEventReportIndication(EventReportIndication value)
	{
		this.eventReportIndication = value;
	}
	
	@Override
	public List<ADCRuleRemove> getADCRuleRemove()
	{
		return this.adcRuleRemove;
	}
	
	@Override
	public void setADCRuleRemove(List<ADCRuleRemove> value)
	{
		this.adcRuleRemove = value;
	}
	
	@Override
	public List<ADCRuleInstall> getADCRuleInstall()
	{
		return this.adcRuleInstall;
	}
	
	@Override
	public void setADCRuleInstall(List<ADCRuleInstall> value)
	{
		this.adcRuleInstall = value;
	}
	
	@Override
	public Date getRevalidationTime()
	{
		if(revalidationTime==null)
			return null;
		
		return revalidationTime.getDateTime();
	}
	
	@Override
	public void setRevalidationTime(Date value)
	{
		if(value==null)
			this.revalidationTime = null;
		else
			this.revalidationTime = new RevalidationTimeImpl(value, null, null);			
	}
	
	@Override
	public List<UsageMonitoringInformation> getUsageMonitoringInformation()
	{
		return this.usageMonitoringInformation;
	}
	
	@Override
	public void setUsageMonitoringInformation(List<UsageMonitoringInformation> value)
	{
		this.usageMonitoringInformation = value;
	}
}