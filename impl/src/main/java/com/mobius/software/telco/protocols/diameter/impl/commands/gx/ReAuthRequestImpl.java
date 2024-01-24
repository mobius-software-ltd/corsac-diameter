package com.mobius.software.telco.protocols.diameter.impl.commands.gx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gx.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CSGInformationReportingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PCSCFRestorationIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RemovalOfAccessImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RevalidationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.SessionReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReporting;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalPolicyInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCSCFRestorationIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PCSCFRestorationIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRAInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRARemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RemovalOfAccess;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RemovalOfAccessEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RevalidationTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

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
@DiameterCommandImplementation(applicationId = 16777238, commandCode = 258, request = true)
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestmpl implements ReAuthRequest
{
	private DRMP drmp;
	
	private SessionReleaseCause sessionReleaseCause;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<EventTrigger> eventTrigger;
	
	private EventReportIndication eventReportIndication;
	
	private List<ChargingRuleRemove> chargingRuleRemove;
	
	private List<ChargingRuleInstall> chargingRuleInstall;
	
	private DefaultEPSBearerQoS defaultEPSBearerQoS;
	
	private List<QoSInformation> qosInformation;
	
	private DefaultQoSInformation defaultQoSInformation;
	
	private RevalidationTime revalidationTime;
	
	private List<UsageMonitoringInformation> usageMonitoringInformation;
	
	private PCSCFRestorationIndication pcscfRestorationIndication;
	
	private List<ConditionalPolicyInformation> conditionalPolicyInformation;
	
	private RemovalOfAccess removalOfAccess;
	
	private IPCANType ipcanType;
	
	private PRAInstall praInstall;
	
	private PRARemove praRemove;
	
	private List<CSGInformationReporting> csgInformationReporting;
	
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
	public List<ChargingRuleRemove> getChargingRuleRemove()
	{
		return this.chargingRuleRemove;
	}
	
	@Override
	public void setChargingRuleRemove(List<ChargingRuleRemove> value)
	{
		this.chargingRuleRemove = value;
	}
	
	@Override
	public List<ChargingRuleInstall> getChargingRuleInstall()
	{
		return this.chargingRuleInstall;
	}
	
	@Override
	public void setChargingRuleInstall(List<ChargingRuleInstall> value)
	{
		this.chargingRuleInstall = value;
	}
	
	@Override
	public DefaultEPSBearerQoS getDefaultEPSBearerQoS()
	{
		return this.defaultEPSBearerQoS;
	}
	
	@Override
	public void setDefaultEPSBearerQoS(DefaultEPSBearerQoS value)
	{
		this.defaultEPSBearerQoS = value;
	}
	
	@Override
	public List<QoSInformation> getQoSInformation()
	{
		return this.qosInformation;
	}
	
	@Override
	public void setQoSInformation(List<QoSInformation> value)
	{
		this.qosInformation = value;
	}
	
	@Override
	public DefaultQoSInformation getDefaultQoSInformation()
	{
		return this.defaultQoSInformation;
	}
	
	@Override
	public void setDefaultQoSInformation(DefaultQoSInformation value)
	{
		this.defaultQoSInformation = value;
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
	
	@Override
	public PCSCFRestorationIndicationEnum getPCSCFRestorationIndication()
	{
		if(pcscfRestorationIndication==null)
			return null;
		
		return pcscfRestorationIndication.getEnumerated(PCSCFRestorationIndicationEnum.class);
	}
	
	@Override
	public void setPCSCFRestorationIndication(PCSCFRestorationIndicationEnum value)
	{
		if(value==null)
			this.pcscfRestorationIndication = null;
		else
			this.pcscfRestorationIndication = new PCSCFRestorationIndicationImpl(value, null, null);			
	}
	
	@Override
	public List<ConditionalPolicyInformation> getConditionalPolicyInformation()
	{
		return this.conditionalPolicyInformation;
	}
	
	@Override
	public void setConditionalPolicyInformation(List<ConditionalPolicyInformation> value)
	{
		this.conditionalPolicyInformation = value;
	}
	
	@Override
	public RemovalOfAccessEnum getRemovalOfAccess()
	{
		if(removalOfAccess==null)
			return null;
		
		return removalOfAccess.getEnumerated(RemovalOfAccessEnum.class);
	}
	
	@Override
	public void setRemovalOfAccess(RemovalOfAccessEnum value)
	{
		if(value==null)
			this.removalOfAccess = null;
		else
			this.removalOfAccess = new RemovalOfAccessImpl(value, null, null);			
	}
	
	@Override
	public IPCANTypeEnum getIPCANType()
	{
		if(ipcanType==null)
			return null;
		
		return this.ipcanType.getEnumerated(IPCANTypeEnum.class);
	}
	
	@Override
	public void setIPCANType(IPCANTypeEnum value)
	{
		if(value==null)
			this.ipcanType = null;
		else
			this.ipcanType = new IPCANTypeImpl(value, null, null);
	}	
	
	@Override
	public PRAInstall getPRAInstall()
	{
		return this.praInstall;
	}
	
	@Override
	public void setPRAInstall(PRAInstall value)
	{
		this.praInstall = value;
	}
	
	@Override
	public PRARemove getPRARemove()
	{
		return this.praRemove;
	}
	
	@Override
	public void setPRARemove(PRARemove value)
	{
		this.praRemove = value;
	}
	
	@Override
	public List<CSGInformationReportingEnum> getCSGInformationReporting()
	{
		if(this.csgInformationReporting==null || this.csgInformationReporting.size()==0)
			return null;
		
		List<CSGInformationReportingEnum> result=new ArrayList<CSGInformationReportingEnum>();
		for(CSGInformationReporting curr:this.csgInformationReporting)
			result.add(curr.getEnumerated(CSGInformationReportingEnum.class));
		
		return result;
	}
	
	@Override
	public void setCSGInformationReporting(List<CSGInformationReportingEnum> value)
	{
		if(value==null || value.size()==0)
			this.csgInformationReporting = null;
		else
		{
			this.csgInformationReporting = new ArrayList<CSGInformationReporting>();
			for(CSGInformationReportingEnum curr:value)
				this.csgInformationReporting.add(new CSGInformationReportingImpl(curr, null, null));
		}
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(reAuthRequestType);
		result.add(sessionReleaseCause);
		result.add(originStateId);
		result.add(ocSupportedFeatures);
		
		if(eventTrigger!=null)
			result.addAll(eventTrigger);
		
		result.add(eventReportIndication);
		
		if(chargingRuleRemove!=null)
			result.addAll(chargingRuleRemove);
			
		if(chargingRuleInstall!=null)
			result.addAll(chargingRuleInstall);
			
		result.add(defaultEPSBearerQoS);
		result.add(revalidationTime);
		
		if(usageMonitoringInformation!=null)
			result.addAll(usageMonitoringInformation);
		
		result.add(pcscfRestorationIndication);
		
		if(conditionalPolicyInformation!=null)
			result.addAll(conditionalPolicyInformation);
		
		result.add(removalOfAccess);
		result.add(ipcanType);
		result.add(praInstall);
		result.add(praRemove);
		
		if(csgInformationReporting!=null)
			result.addAll(csgInformationReporting);
		
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