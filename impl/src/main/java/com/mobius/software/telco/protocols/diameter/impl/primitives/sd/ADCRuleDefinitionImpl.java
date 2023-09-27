package com.mobius.software.telco.protocols.diameter.impl.primitives.sd;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MeteringMethodImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MonitoringKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.MuteNotificationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OfflineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.OnlineImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PrecedenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ReportingLevelImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TDFApplicationIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ToSTrafficClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TrafficSteeringPolicyIdentifierDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TrafficSteeringPolicyIdentifierULImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ApplicationServiceProviderIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SponsorIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MeteringMethod;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MeteringMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringKey;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MuteNotification;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MuteNotificationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Offline;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Online;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Precedence;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ReportingLevel;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ReportingLevelEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFApplicationIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ToSTrafficClass;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TrafficSteeringPolicyIdentifierDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TrafficSteeringPolicyIdentifierUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ApplicationServiceProviderIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatus;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsorIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleName;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1094L, vendorId = KnownVendorIDs.TGPP_ID)
public class ADCRuleDefinitionImpl extends DiameterGroupedAvpImpl implements ADCRuleDefinition
{
	private ADCRuleName adcRuleName;
	private TDFApplicationIdentifier tdfApplicationIdentifier;
	private List<FlowInformation> flowInformation;
	private ServiceIdentifier serviceIdentifier;
	private RatingGroup ratingGroup;
	private ReportingLevel reportingLevel;
	private Online online;
	private Offline offline;
	private MeteringMethod meteringMethod;
	private Precedence precedence;
	private FlowStatus flowStatus;
	private QoSInformation qoSInformation;
	private MonitoringKey monitoringKey;
	private SponsorIdentity sponsorIdentity;
	private ApplicationServiceProviderIdentity applicationServiceProviderIdentity;
	private List<RedirectInformation> redirectInformation;
	private MuteNotification muteNotification;
	private TrafficSteeringPolicyIdentifierDL trafficSteeringPolicyIdentifierDL;
	private TrafficSteeringPolicyIdentifierUL trafficSteeringPolicyIdentifierUL;
	private ToSTrafficClass toSTrafficClass;
	
	protected ADCRuleDefinitionImpl()
	{
		
	}
	
	public ADCRuleDefinitionImpl(ByteBuf adcRuleName)
	{
		if(adcRuleName==null)
			throw new IllegalArgumentException("ADC-Rule-Name is required");
		
		this.adcRuleName = new ADCRuleNameImpl(adcRuleName, null, null);				
	}
	
	public ByteBuf getADCRuleName()
	{
		if(adcRuleName==null)
			return null;
		
		return adcRuleName.getValue();
	}
	
	public void setADCRuleName(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("ADC-Rule-Name is required");
		
		this.adcRuleName = new ADCRuleNameImpl(value, null, null);				
	}
	
	public ByteBuf getTDFApplicationIdentifier()
	{
		if(tdfApplicationIdentifier==null)
			return null;
		
		return tdfApplicationIdentifier.getValue();
	}
	
	public void setTDFApplicationIdentifier(ByteBuf value)
	{
		if(value==null)
			this.tdfApplicationIdentifier = null;
		else
			this.tdfApplicationIdentifier = new TDFApplicationIdentifierImpl(value, null, null);			
	}
	
	public List<FlowInformation> getFlowInformation()
	{
		return flowInformation;
	}
	
	public void setFlowInformation(List<FlowInformation> value)
	{
		this.flowInformation = value;
	}
	
	public Long getServiceIdentifier()
	{
		if(serviceIdentifier==null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}
	
	public void setServiceIdentifier(Long value)
	{
		if(value==null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);			
	}
	
	public Long getRatingGroup()
	{
		if(ratingGroup==null)
			return null;
		
		return ratingGroup.getUnsigned();
	}
	
	public void setRatingGroup(Long value)
	{
		if(value==null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);			
	}
	
	public ReportingLevelEnum getReportingLevel()
	{
		if(reportingLevel==null)
			return null;
		
		return reportingLevel.getEnumerated(ReportingLevelEnum.class);
	}
	
	public void setReportingLevel(ReportingLevelEnum value)
	{
		if(value==null)
			this.reportingLevel = null;
		else
			this.reportingLevel = new ReportingLevelImpl(value, null, null);			
	}
	
	public OnlineEnum getOnline()
	{
		if(online==null)
			return null;
		
		return online.getEnumerated(OnlineEnum.class);
	}
	
	public void setOnline(OnlineEnum value)
	{
		if(value==null)
			this.online = null;
		else
			this.online = new OnlineImpl(value, null, null);			
	}
	
	public OfflineEnum getOffline()
	{
		if(offline==null)
			return null;
		
		return offline.getEnumerated(OfflineEnum.class);
	}
	
	public void setOffline(OfflineEnum value)
	{
		if(value==null)
			this.offline = null;
		else
			this.offline = new OfflineImpl(value, null, null);			
	}
	
	public MeteringMethodEnum getMeteringMethod()
	{
		if(meteringMethod==null)
			return null;
		
		return meteringMethod.getEnumerated(MeteringMethodEnum.class);
	}
	
	public void setMeteringMethod(MeteringMethodEnum value)
	{
		if(value==null)
			this.meteringMethod = null;
		else
			this.meteringMethod = new MeteringMethodImpl(value, null, null);			
	}
	
	public Long getPrecedence()
	{
		if(precedence==null)
			return null;
		
		return precedence.getUnsigned();
	}
	
	public void setPrecedence(Long value)
	{
		if(value==null)
			this.precedence = null;
		else
			this.precedence = new PrecedenceImpl(value, null, null);			
	}
	
	public FlowStatusEnum getFlowStatus()
	{
		if(flowStatus==null)
			return null;
		
		return flowStatus.getEnumerated(FlowStatusEnum.class);
	}
	
	public void setFlowStatus(FlowStatusEnum value)
	{
		if(value==null)
			this.flowStatus = null;
		else
			this.flowStatus = new FlowStatusImpl(value, null, null);			
	}
	
	public QoSInformation getQoSInformation()
	{
		return qoSInformation;
	}
	
	public void setQoSInformation(QoSInformation value)
	{
		this.qoSInformation = value;
	}
	
	public ByteBuf getMonitoringKey()
	{
		if(monitoringKey==null)
			return null;
		
		return monitoringKey.getValue();
	}
	
	public void setMonitoringKey(ByteBuf value)
	{
		if(value==null)
			this.monitoringKey = null;
		else
			this.monitoringKey = new MonitoringKeyImpl(value, null, null);			
	}
	
	public String getSponsorIdentity()
	{
		if(sponsorIdentity==null)
			return null;
		
		return sponsorIdentity.getString();
	}
	
	public void setSponsorIdentity(String value)
	{
		if(value==null)
			this.sponsorIdentity = null;
		else
			this.sponsorIdentity = new SponsorIdentityImpl(value, null, null);			
	}
	
	public String getApplicationServiceProviderIdentity()
	{
		if(applicationServiceProviderIdentity==null)
			return null;
		
		return applicationServiceProviderIdentity.getString();
	}
	
	public void setApplicationServiceProviderIdentity(String value)
	{
		if(value==null)
			this.applicationServiceProviderIdentity = null;
		else
			this.applicationServiceProviderIdentity = new ApplicationServiceProviderIdentityImpl(value, null, null);			
	}
	
	public List<RedirectInformation> getRedirectInformation()
	{
		return redirectInformation;
	}
	
	public void setRedirectInformation(List<RedirectInformation> value)
	{
		this.redirectInformation = value;
	}
	

	
	public MuteNotificationEnum getMuteNotification()
	{
		if(muteNotification==null)
			return null;
		
		return muteNotification.getEnumerated(MuteNotificationEnum.class);
	}
	
	public void setMuteNotification(MuteNotificationEnum value)
	{
		if(value==null)
			this.muteNotification = null;
		else
			this.muteNotification = new MuteNotificationImpl(value, null, null);			
	}
	
	public ByteBuf getTrafficSteeringPolicyIdentifierDL()
	{
		if(trafficSteeringPolicyIdentifierDL==null)
			return null;
		
		return trafficSteeringPolicyIdentifierDL.getValue();
	}
	
	public void setTrafficSteeringPolicyIdentifierDL(ByteBuf value)
	{
		if(value==null)
			this.trafficSteeringPolicyIdentifierDL = null;
		else
			this.trafficSteeringPolicyIdentifierDL = new TrafficSteeringPolicyIdentifierDLImpl(value, null, null);			
	}
	
	public ByteBuf getTrafficSteeringPolicyIdentifierUL()
	{
		if(trafficSteeringPolicyIdentifierUL==null)
			return null;
		
		return trafficSteeringPolicyIdentifierUL.getValue();
	}
	
	public void setTrafficSteeringPolicyIdentifierUL(ByteBuf value)
	{
		if(value==null)
			this.trafficSteeringPolicyIdentifierUL = null;
		else
			this.trafficSteeringPolicyIdentifierUL = new TrafficSteeringPolicyIdentifierULImpl(value, null, null);			
	}
	
	public ByteBuf getToSTrafficClass()
	{
		if(toSTrafficClass==null)
			return null;
		
		return toSTrafficClass.getValue();
	}
	
	public void setToSTrafficClass(ByteBuf value)
	{
		if(value==null)
			this.toSTrafficClass = null;
		else
			this.toSTrafficClass = new ToSTrafficClassImpl(value, null, null);			
	}		  
}