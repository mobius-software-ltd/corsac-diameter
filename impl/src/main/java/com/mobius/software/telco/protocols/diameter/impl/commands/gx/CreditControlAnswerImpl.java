package com.mobius.software.telco.protocols.diameter.impl.commands.gx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerControlModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerUsageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.CSGInformationReportingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.DefaultAccessImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.EventTriggerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.IPCANTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NBIFOMModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NBIFOMSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OfflineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OnlineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RANRuleSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RemovalOfAccessImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RevalidationTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.SessionReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlMode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerUsage;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReporting;
import com.mobius.software.telco.protocols.diameter.primitives.gx.CSGInformationReportingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalPolicyInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultAccess;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultQoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTrigger;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMMode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Offline;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Online;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRAInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PRARemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANRuleSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANRuleSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RemovalOfAccess;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RemovalOfAccessEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RevalidationTime;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RoutingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

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
public class CreditControlAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlAnswerImpl implements CreditControlAnswer
{
	private DRMP drmp;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private BearerControlMode bearerControlMode;
	
	private List<EventTrigger> eventTrigger;
	
	private EventReportIndication eventReportIndication;
	
	private List<ChargingRuleRemove> chargingRuleRemove;
	
	private List<ChargingRuleInstall> chargingRuleInstall;
	
	private ChargingInformation chargingInformation;
	
	private Online online;
	
	private Offline offline;
	
	private List<QoSInformation> qosInformation;
	
	private RevalidationTime revalidationTime;
	
	private DefaultEPSBearerQoS defaultEPSBearerQoS;
	
	private DefaultQoSInformation defaultQoSInformation;
	
	private BearerUsage bearerUsage;
	
	private List<UsageMonitoringInformation> usageMonitoringInformation;
	
	private List<CSGInformationReporting> csgInformationReporting;
	
	private UserCSGInformation userCSGInformation;
	
	private PRAInstall praInstall;
	
	private PRARemove praRemove;
	
	private PresenceReportingAreaInformation presenceReportingAreaInformation;
	
	private SessionReleaseCause sessionReleaseCause;
	
	private NBIFOMSupport nbifomSupport;
	
	private NBIFOMMode nbifomMode;
	
	private DefaultAccess defaultAccess;
	
	private RANRuleSupport ranRuleSupport;
	
	private List<RoutingRuleReport> routingRuleReport;
	
	private List<ConditionalPolicyInformation> conditionalPolicyInformation;
	
	private RemovalOfAccess removalOfAccess;
	
	private IPCANType ipcanType;
	
	protected List<RouteRecord> routeRecords;
	
	private List<Load> load;
	
	protected CreditControlAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(true);
		setUsernameAllowed(false);
	}
	
	protected CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(true);	
		setUsernameAllowed(false);
		
		setCcRequestNumber(ccRequestNumber);
		
		setCcRequestType(ccRequestType);
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
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public BearerControlModeEnum getBearerControlMode()
	{
		if(bearerControlMode==null)
			return null;
		
		return bearerControlMode.getEnumerated(BearerControlModeEnum.class);
	}
	
	@Override
	public void setBearerControlMode(BearerControlModeEnum value)
	{
		if(value==null)
			this.bearerControlMode = null;
		else
			this.bearerControlMode = new BearerControlModeImpl(value, null, null);			
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
	public ChargingInformation getChargingInformation()
	{
		return this.chargingInformation;
	}
	
	@Override
	public void setChargingInformation(ChargingInformation value)
	{
		this.chargingInformation = value;
	}
	
	@Override
	public OnlineEnum getOnline()
	{
		if(online==null)
			return null;
		
		return online.getEnumerated(OnlineEnum.class);
	}
	
	@Override
	public void setOnline(OnlineEnum value)
	{
		if(value==null)
			this.online = null;
		else
			this.online = new OnlineImpl(value, null, null);			
	}
	
	@Override
	public OfflineEnum getOffline()
	{
		if(offline==null)
			return null;
		
		return offline.getEnumerated(OfflineEnum.class);
	}
	
	@Override
	public void setOffline(OfflineEnum value)
	{
		if(value==null)
			this.offline = null;
		else
			this.offline = new OfflineImpl(value, null, null);			
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
	public BearerUsageEnum getBearerUsage()
	{
		if(bearerUsage==null)
			return null;
		
		return bearerUsage.getEnumerated(BearerUsageEnum.class);
	}
	
	@Override
	public void setBearerUsage(BearerUsageEnum value)
	{
		if(value==null)
			this.bearerUsage = null;
		else
			this.bearerUsage = new BearerUsageImpl(value, null, null);
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
	
	@Override
	public UserCSGInformation getUserCSGInformation()
	{
		return userCSGInformation;
	}
	
	@Override
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
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
	public PresenceReportingAreaInformation getPresenceReportingAreaInformation()
	{
		return this.presenceReportingAreaInformation;
	}	
	
	@Override
	public void setPresenceReportingAreaInformation(PresenceReportingAreaInformation value)
	{
		this.presenceReportingAreaInformation = value;
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
	public NBIFOMSupportEnum getNBIFOMSupport()
	{
		if(nbifomSupport==null)
			return null;
		
		return nbifomSupport.getEnumerated(NBIFOMSupportEnum.class);
	}
	
	@Override
	public void setNBIFOMSupport(NBIFOMSupportEnum value)
	{
		if(value==null)
			this.nbifomSupport = null;
		else
			this.nbifomSupport = new NBIFOMSupportImpl(value, null, null);			
	}
	
	@Override
	public NBIFOMModeEnum getNBIFOMMode()
	{
		if(nbifomMode==null)
			return null;
		
		return nbifomMode.getEnumerated(NBIFOMModeEnum.class);
	}
	
	@Override
	public void setNBIFOMMode(NBIFOMModeEnum value)
	{
		if(value==null)
			this.nbifomMode = null;
		else
			this.nbifomMode = new NBIFOMModeImpl(value, null, null);			
	}		
	
	@Override
	public IPCANTypeEnum getDefaultAccess()
	{
		if(defaultAccess==null)
			return null;
		
		return defaultAccess.getEnumerated(IPCANTypeEnum.class);
	}
	
	@Override
	public void setDefaultAccess(IPCANTypeEnum value)
	{
		if(value==null)
			this.defaultAccess = null;
		else
			this.defaultAccess = new DefaultAccessImpl(value, null, null);
	}
	
	@Override
	public RANRuleSupportEnum getRANRuleSupport()
	{
		if(ranRuleSupport==null)
			return null;
		
		return ranRuleSupport.getEnumerated(RANRuleSupportEnum.class);
	}
	
	@Override
	public void setRANRuleSupport(RANRuleSupportEnum value)
	{
		if(value==null)
			this.ranRuleSupport = null;
		else
			this.ranRuleSupport = new RANRuleSupportImpl(value, null, null);			
	}
	
	@Override
	public List<RoutingRuleReport> getRoutingRuleReport()
	{
		return routingRuleReport;
	}
	
	@Override
	public void setRoutingRuleReport(List<RoutingRuleReport> value)
	{
		this.routingRuleReport = value;
	}
	
	@Override
	public List<ConditionalPolicyInformation> getConditionalPolicyInformation()
	{
		return this.conditionalPolicyInformation;
	}
	
	@Override
	public void setConditionalPolicyInformation(List<ConditionalPolicyInformation> value) throws AvpOccursTooManyTimesException
	{
		if(value!=null && value.size()>4)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(value);
			throw new AvpOccursTooManyTimesException("Up to 4 Conditional-Policy-Information allowed", failedAvps);
		}
		
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(conditionalPolicyInformation!=null && conditionalPolicyInformation.size()>4)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(conditionalPolicyInformation);
			return new AvpOccursTooManyTimesException("Up to 4 Conditional-Policy-Information allowed", failedAvps);
		}
		
		return super.validate();
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
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(bearerControlMode);
		
		if(eventTrigger!=null)
			result.addAll(eventTrigger);
		
		result.add(eventReportIndication);
		result.add(originStateId);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(chargingRuleRemove!=null)
			result.addAll(chargingRuleRemove);
		
		if(chargingRuleInstall!=null)
			result.addAll(chargingRuleInstall);
		
		result.add(chargingInformation);
		result.add(online);
		result.add(offline);
		
		if(qosInformation!=null)
			result.addAll(qosInformation);
		
		result.add(revalidationTime);
		result.add(defaultEPSBearerQoS);
		result.add(defaultQoSInformation);
		result.add(bearerUsage);
		
		if(usageMonitoringInformation!=null)
			result.addAll(usageMonitoringInformation);
		
		if(csgInformationReporting!=null)
			result.addAll(csgInformationReporting);
		
		result.add(userCSGInformation);
		result.add(praInstall);
		result.add(praRemove);
		result.add(presenceReportingAreaInformation);
		result.add(sessionReleaseCause);
		result.add(nbifomSupport);
		result.add(nbifomMode);
		result.add(defaultAccess);
		result.add(ranRuleSupport);
		
		if(routingRuleReport!=null)
			result.addAll(routingRuleReport);
		
		if(conditionalPolicyInformation!=null)
			result.addAll(conditionalPolicyInformation);
		
		result.add(removalOfAccess);
		result.add(ipcanType);
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(ranRuleSupport);
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(load!=null)
			result.addAll(load);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}