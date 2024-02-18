package com.mobius.software.telco.protocols.diameter.impl.primitives.s9;
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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ExperimentalResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ANGWAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.BearerControlModeImpl;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ExperimentalResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.common.ResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ANGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlMode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultEPSBearerQoS;
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
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionDecisionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s9.SubsessionId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class SubsessionDecisionInfoImpl extends DiameterGroupedAvpImpl implements SubsessionDecisionInfo
{
	private SubsessionId subsessionId;
	
	private List<ANGWAddress> anGWAddress;
	
	private ResultCode resultCode;
	
	private ExperimentalResultCode experimentalResultCode;
	
	private List<ChargingRuleRemove> chargingRuleRemove;
	
	private List<ChargingRuleInstall> chargingRuleInstall;
	
	private EventReportIndication eventReportIndication;
	
	private List<QoSRuleRemove> qosRuleRemove;
	
	private List<QoSRuleInstall> qosRuleInstall;
	
	private DefaultEPSBearerQoS defaultEPSBearerQoS;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private List<UsageMonitoringInformation> usageMonitoringInformation;
	
	private SessionReleaseCause sessionReleaseCause;
	
	private BearerControlMode bearerControlMode;
	
	private List<EventTrigger> eventTrigger;
	
	private RevalidationTime revalidationTime;
	
	private IPCANType defaultAccess;
	
	private NBIFOMMode nbifomMode;
	
	private NBIFOMSupport nbifomSupport;
		
	private RANRuleSupport ranRuleSupport;
	
	private List<RoutingRuleReport> routingRuleReport;
	
	private RemovalOfAccess removalOfAccess;
	
	private IPCANType ipcanType;
	
	private Online online;
	
	private Offline offline;
	
	private List<QoSInformation> qosInformation;
	
	protected SubsessionDecisionInfoImpl() 
	{
	}
	
	public SubsessionDecisionInfoImpl(Long subsessionId) throws MissingAvpException
	{
		setSubsessionId(subsessionId);
	}
	
	@Override
	public Long getSubsessionId()
	{
		if(subsessionId==null)
			return null;
		
		return subsessionId.getUnsigned();
	}
	
	@Override
	public void setSubsessionId(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Subsession-Id is required is required", Arrays.asList(new DiameterAvp[] { new SubsessionIdImpl() }));
		
		this.subsessionId = new SubsessionIdImpl(value, null, null);				
	}
	
	@Override
	public List<InetAddress> getANGWAddress()
	{
		if(anGWAddress==null || anGWAddress.size()==0)
			return null;
		
		List<InetAddress> result=new ArrayList<InetAddress>();
		for(ANGWAddress curr:anGWAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	@Override
	public void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException
	{
		if(value!=null && value.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(InetAddress curr:value)
				failedAvps.add(new ANGWAddressImpl(curr, null, null));
			
			throw new AvpOccursTooManyTimesException("Up to 2 AN-GW-Address allowed", failedAvps);
		}
		
		if(value==null)
			this.anGWAddress = null;
		else
		{
			this.anGWAddress = new ArrayList<ANGWAddress>();
			for(InetAddress curr:value)
				this.anGWAddress.add(new ANGWAddressImpl(curr, null, null));
		}
	}
	
	@Override
	public Long getResultCode()
	{
		if(this.resultCode==null)
			return null;
		
		return this.resultCode.getUnsigned();
	}
	
	@Override
	public void setResultCode(Long value)
	{
		if(value==null)
			this.resultCode = null;
		else
			this.resultCode = new ResultCodeImpl(value, null, null);
	}

	@Override
	public Long getExperimentalResultCode() 
	{
		if(experimentalResultCode == null)
			return null;
		
		return experimentalResultCode.getUnsigned();
	}

	@Override
	public void setExperimentalResultCode(Long value) 
	{
		if(value==null)
			this.experimentalResultCode = null;
		else
			this.experimentalResultCode = new ExperimentalResultCodeImpl(value, null, null);
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
	public List<QoSRuleRemove> getQoSRuleRemove()
	{
		return this.qosRuleRemove;
	}
	
	@Override
	public void setQoSRuleRemove(List<QoSRuleRemove> value)
	{
		this.qosRuleRemove = value;
	}
	
	@Override
	public List<QoSRuleInstall> getQoSRuleInstall()
	{
		return this.qosRuleInstall;
	}
	
	@Override
	public void setQoSRuleInstall(List<QoSRuleInstall> value)
	{
		this.qosRuleInstall = value;
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
	public ByteBuf getFramedIPv6Prefix()
	{
		if(framedIPv6Prefix==null)
			return null;
		
		return this.framedIPv6Prefix.getValue();
	}
	
	@Override
	public void setFramedIPv6Prefix(ByteBuf value)
	{
		if(value==null)
			this.framedIPv6Prefix = null;
		else
			this.framedIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);
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
			this.defaultAccess = new IPCANTypeImpl(value, null, null);
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(subsessionId==null)
			return new MissingAvpException("Subsession-Id is required is required", Arrays.asList(new DiameterAvp[] { new SubsessionIdImpl() }));
		
		if(anGWAddress!=null && anGWAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(anGWAddress);
			
			return new AvpOccursTooManyTimesException("Up to 2 AN-GW-Address allowed", failedAvps);
		}
		
		return null;
	}
}