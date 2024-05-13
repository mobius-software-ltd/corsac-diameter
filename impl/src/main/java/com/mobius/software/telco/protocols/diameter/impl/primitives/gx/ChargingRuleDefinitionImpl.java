package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.CallingPartyAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFChargingIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFSignallingProtocolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ApplicationServiceProviderIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ContentVersionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RequiredAccessInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SharingKeyDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SharingKeyULImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SponsorIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CallingPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultBearerIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gx.DefaultBearerIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MaxPLRDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MaxPLRUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MeteringMethod;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MeteringMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringKey;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MuteNotification;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MuteNotificationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Offline;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OfflineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Online;
import com.mobius.software.telco.protocols.diameter.primitives.gx.OnlineEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PSToCSSessionContinuity;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PSToCSSessionContinuityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Precedence;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ReportingLevel;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ReportingLevelEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFApplicationIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TrafficSteeringPolicyIdentifierDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TrafficSteeringPolicyIdentifierUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFSignallingProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFSignallingProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ApplicationServiceProviderIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ContentVersion;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatus;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SharingKeyDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SharingKeyUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsorIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ChargingRuleDefinitionImpl extends DiameterGroupedAvpImpl implements ChargingRuleDefinition
{
	private ChargingRuleName chargingRuleName;
	private ServiceIdentifier serviceIdentifier;
	private RatingGroup ratingGroup;
	private List<FlowInformation> flowInformation;
	private DefaultBearerIndication defaultBearerIndication;
	private TDFApplicationIdentifier tdfApplicationIdentifier;
	private FlowStatus flowStatus;
	private QoSInformation qoSInformation;
	private PSToCSSessionContinuity psToCSSessionContinuity;
	private ReportingLevel reportingLevel;
	private Online online;
	private Offline offline;
	private MaxPLRDL maxPLRDL;
	private MaxPLRUL maxPLRUL;
	private MeteringMethod meteringMethod;
	private Precedence precedence;
	private AFChargingIdentifier afChargingIdentifier;
	private List<Flows> flows;
	private MonitoringKey monitoringKey;
	private List<RedirectInformation> redirectInformation;
	private MuteNotification muteNotification;
	private AFSignallingProtocol afSignallingProtocol;
	private SponsorIdentity sponsorIdentity;
	private ApplicationServiceProviderIdentity applicationServiceProviderIdentity;
	private List<RequiredAccessInfo> requiredAccessInfo;
	private SharingKeyDL sharingKeyDL;
	private SharingKeyUL sharingKeyUL;
	private TrafficSteeringPolicyIdentifierDL trafficSteeringPolicyIdentifierDL;
	private TrafficSteeringPolicyIdentifierUL trafficSteeringPolicyIdentifierUL;
	private ContentVersion contentVersion;
	private List<CallingPartyAddress> callingPartyAddress;
	private CalleeInformation calleeInformation;
		
	protected ChargingRuleDefinitionImpl()
	{
		
	}
	
	public ChargingRuleDefinitionImpl(ByteBuf chargingRuleName) throws MissingAvpException
	{
		setChargingRuleName(chargingRuleName);
	}
	
	public ByteBuf getChargingRuleName()
	{
		if(chargingRuleName==null)
			return null;
		
		return chargingRuleName.getValue();
	}
	
	public void setChargingRuleName(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Charging-Rule-Name is required", Arrays.asList(new DiameterAvp[] { new ChargingRuleNameImpl() }));
			
		this.chargingRuleName = new ChargingRuleNameImpl(value, null, null);				
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
	
	public List<FlowInformation> getFlowInformation()
	{
		return flowInformation;
	}
	
	public void setFlowInformation(List<FlowInformation> value)
	{
		this.flowInformation = value;
	}
	
	public DefaultBearerIndicationEnum getDefaultBearerIndication()
	{
		if(defaultBearerIndication==null)
			return null;
		
		return defaultBearerIndication.getEnumerated(DefaultBearerIndicationEnum.class);
	}
	
	public void setDefaultBearerIndication(DefaultBearerIndicationEnum value)
	{
		if(value==null)
			this.defaultBearerIndication = null;
		else
			this.defaultBearerIndication = new DefaultBearerIndicationImpl(value, null, null);			
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
	
	public PSToCSSessionContinuityEnum getPSToCSSessionContinuity()
	{
		if(psToCSSessionContinuity==null)
			return null;
		
		return psToCSSessionContinuity.getEnumerated(PSToCSSessionContinuityEnum.class);
	}
	
	public void setPSToCSSessionContinuity(PSToCSSessionContinuityEnum value)
	{
		if(value==null)
			this.psToCSSessionContinuity = null;
		else
			this.psToCSSessionContinuity = new PSToCSSessionContinuityImpl(value, null, null);			
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
	
	public Long getMaxPLRDL()
	{
		if(maxPLRDL==null)
			return null;
		
		return maxPLRDL.getUnsigned();
	}
	
	public void setMaxPLRDL(Long value)
	{
		if(value==null)
			this.maxPLRDL = null;
		else
			this.maxPLRDL = new MaxPLRDLImpl(value, null, null);			
	}
	
	public Long getMaxPLRUL()
	{
		if(maxPLRUL==null)
			return null;
		
		return maxPLRUL.getUnsigned();
	}
	
	public void setMaxPLRUL(Long value)
	{
		if(value==null)
			this.maxPLRUL = null;
		else
			this.maxPLRUL = new MaxPLRULImpl(value, null, null);			
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
	
	public ByteBuf getAFChargingIdentifier()
	{
		if(afChargingIdentifier==null)
			return null;
		
		return afChargingIdentifier.getValue();
	}
	
	public void setAFChargingIdentifier(ByteBuf value)
	{
		if(value==null)
			this.afChargingIdentifier = null;
		else
			this.afChargingIdentifier = new AFChargingIdentifierImpl(value, null, null);			
	}
	
	public List<Flows> getFlows()
	{
		return flows;
	}
	
	public void setFlows(List<Flows> value)
	{
		this.flows = value;
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
	
	public AFSignallingProtocolEnum getAFSignallingProtocol()
	{
		if(afSignallingProtocol==null)
			return null;
		
		return afSignallingProtocol.getEnumerated(AFSignallingProtocolEnum.class);
	}
	
	public void setAFSignallingProtocol(AFSignallingProtocolEnum value)
	{
		if(value==null)
			this.afSignallingProtocol = null;
		else
			this.afSignallingProtocol = new AFSignallingProtocolImpl(value, null, null);			
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
	
	public List<RequiredAccessInfoEnum> getRequiredAccessInfo()
	{
		if(requiredAccessInfo==null || requiredAccessInfo.size()==0)
			return null;
		
		List<RequiredAccessInfoEnum> result=new ArrayList<RequiredAccessInfoEnum>();
		for(RequiredAccessInfo curr:requiredAccessInfo)
			result.add(curr.getEnumerated(RequiredAccessInfoEnum.class));
		
		return result;
	}
	
	public void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value)
	{
		if(value==null || value.size()==0)
			this.requiredAccessInfo = new ArrayList<RequiredAccessInfo>();
		else
		{
			this.requiredAccessInfo = new ArrayList<RequiredAccessInfo>();
			for(RequiredAccessInfoEnum curr:value)
				this.requiredAccessInfo.add(new RequiredAccessInfoImpl(curr, null, null));
		}
	}
	
	public Long getSharingKeyDL()
	{
		if(sharingKeyDL==null)
			return null;
		
		return sharingKeyDL.getUnsigned();
	}
	
	public void setSharingKeyDL(Long value)
	{
		if(value==null)
			this.sharingKeyDL = null;
		else
			this.sharingKeyDL = new SharingKeyDLImpl(value, null, null);			
	}
	
	public Long getSharingKeyUL()
	{
		if(sharingKeyUL==null)
			return null;
		
		return sharingKeyUL.getUnsigned();
	}
	
	public void setSharingKeyUL(Long value)
	{
		if(value==null)
			this.sharingKeyUL = null;
		else
			this.sharingKeyUL = new SharingKeyULImpl(value, null, null);			
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
	
	public Long getContentVersion()
	{
		if(contentVersion==null)
			return null;
		
		return contentVersion.getLong();
	}
	
	public void setContentVersion(Long value)
	{
		if(value==null)
			this.contentVersion = null;
		else
			this.contentVersion = new ContentVersionImpl(value, null, null);			
	}
	
	public List<String> getCallingPartyAddress()
	{
		if(callingPartyAddress==null || callingPartyAddress.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(CallingPartyAddress curr:callingPartyAddress)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setCallingPartyAddress(List<String> value)
	{
		if(value==null || value.size()==0)
			this.callingPartyAddress = null;
		else
		{
			this.callingPartyAddress = new ArrayList<CallingPartyAddress>();
			for(String curr:value)
				this.callingPartyAddress.add(new CallingPartyAddressImpl(curr, null, null));			
		}
	}
	
	public CalleeInformation getCalleeInformation()
	{
		return calleeInformation;
	}
	
	public void setCalleeInformation(CalleeInformation value)
	{
		this.calleeInformation = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(chargingRuleName==null)
			return new MissingAvpException("Charging-Rule-Name is required", Arrays.asList(new DiameterAvp[] { new ChargingRuleNameImpl() }));
		
		return null;
	} 		  
}