package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.s6a.NotifyRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AlertReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ContextIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessionsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.NORFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UESRVCCCapabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MaximumUEAvailabilityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swm.EmergencyServicesImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AlertReason;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AlertReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessions;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessionsEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NORFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UESRVCCCapability;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UESRVCCCapabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MaximumUEAvailabilityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777251, commandCode = 323, request = true)
public class NotifyRequestImpl extends S6aRequestImpl implements NotifyRequest
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private TerminalInformation terminalInformation;
	
	private MIP6AgentInfo mip6AgentInfo;
	
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	
	private ContextIdentifier contextIdentifier;
	
	private ServiceSelection serviceSelection;
	
	private AlertReason alertReason;
	
	private UESRVCCCapability ueSRVCCCapability;
	
	private NORFlags norFlags;
	
	private HomogeneousSupportOfIMSVoiceOverPSSessions homogeneousSupportOfIMSVoiceOverPSSessions;
	
	private MaximumUEAvailabilityTime maximumUEAvailabilityTime;
	
	private List<MonitoringEventConfigStatus> monitoringEventConfigStatus;
	
	private EmergencyServices emergencyServices;
	
	protected NotifyRequestImpl() 
	{
		super();
	}
	
	public NotifyRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
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
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
	 
	@Override
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
	}
	
	@Override
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return this.mip6AgentInfo;
	}
	
	@Override
	public void setMIP6AgentInfo(MIP6AgentInfo value)
	{
		this.mip6AgentInfo = value;
	}
	
	@Override
	public ByteBuf getVisitedNetworkIdentifier()
	{
		if(visitedNetworkIdentifier == null)
			return null;
		
		return visitedNetworkIdentifier.getValue();
	}
	
	@Override
	public void setVisitedNetworkIdentifier(ByteBuf value)
	{
		if(value == null)
			this.visitedNetworkIdentifier = null;
		else
			this.visitedNetworkIdentifier = new VisitedNetworkIdentifierImpl(value, null, null);
	}
	
	@Override
	public Long getContextIdentifier()
	{
		if(contextIdentifier == null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	 
	@Override
	public void setContextIdentifier(Long value)
	{
		if(value == null)
			this.contextIdentifier = null;
		else
			this.contextIdentifier = new ContextIdentifierImpl(value, null, null);
	}
		
	@Override
	public String getServiceSelection()
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}
	
	@Override
	public void setServiceSelection(String value)
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}	
	
	@Override
	public AlertReasonEnum getAlertReason()
	{
		if(alertReason == null)
			return null;
		
		return alertReason.getEnumerated(AlertReasonEnum.class);
	}
	
	@Override
	public void setAlertReason(AlertReasonEnum value)
	{
		if(value == null)
			this.alertReason = null;
		else
			this.alertReason = new AlertReasonImpl(value, null, null);
	}	
	
	@Override
	public UESRVCCCapabilityEnum getUESRVCCCapability()
	{
		if(ueSRVCCCapability == null)
			return null;
		
		return ueSRVCCCapability.getEnumerated(UESRVCCCapabilityEnum.class);
	}
	
	@Override
	public void setUESRVCCCapability(UESRVCCCapabilityEnum value)
	{
		if(value == null)
			this.ueSRVCCCapability = null;
		else
			this.ueSRVCCCapability = new UESRVCCCapabilityImpl(value, null, null);
	}
	
	@Override
	public Long getNORFlags()
	{
		if(norFlags == null)
			return null;
		
		return norFlags.getUnsigned();
	}
	
	@Override
	public void setNORFlags(Long value)
	{
		if(value == null)
			this.norFlags = null;
		else
			this.norFlags = new NORFlagsImpl(value, null, null);
	}	
	
	@Override
	public HomogeneousSupportOfIMSVoiceOverPSSessionsEnum getHomogeneousSupportOfIMSVoiceOverPSSessions()
	{
		if(homogeneousSupportOfIMSVoiceOverPSSessions == null)
			return null;
		
		return homogeneousSupportOfIMSVoiceOverPSSessions.getEnumerated(HomogeneousSupportOfIMSVoiceOverPSSessionsEnum.class);
	}
	
	@Override
	public void setHomogeneousSupportOfIMSVoiceOverPSSessions(HomogeneousSupportOfIMSVoiceOverPSSessionsEnum value)
	{
		if(value == null)
			this.homogeneousSupportOfIMSVoiceOverPSSessions = null;
		else
			this.homogeneousSupportOfIMSVoiceOverPSSessions = new HomogeneousSupportOfIMSVoiceOverPSSessionsImpl(value, null, null);
	}
	
	@Override
	public Date getMaximumUEAvailabilityTime()
	{
		if(maximumUEAvailabilityTime == null)
			return null;
		
		return maximumUEAvailabilityTime.getDateTime();
	}
	
	@Override
	public void setMaximumUEAvailabilityTime(Date value)
	{
		if(value == null)
			this.maximumUEAvailabilityTime = null;
		else
			this.maximumUEAvailabilityTime = new MaximumUEAvailabilityTimeImpl(value, null, null);
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
	
	@Override
	public Long getEmergencyServices()
	{
		if(emergencyServices == null)
			return null;
		
		return emergencyServices.getUnsigned();
	}
	
	@Override
	public void setEmergencyServices(Long value)
	{
		if(value == null)
			this.emergencyServices = null;
		else
			this.emergencyServices = new EmergencyServicesImpl(value, null, null);
	}
}