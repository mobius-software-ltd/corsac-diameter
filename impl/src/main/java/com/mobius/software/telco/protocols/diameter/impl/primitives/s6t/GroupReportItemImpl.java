package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MaximumUEAvailabilityTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MaximumUEAvailabilityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EventHandling;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EventHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReportItem;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IMEIChange;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LossOfConnectivityReason;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LossOfConnectivityReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReportingTimeStamp;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RoamingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RoamingInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.S6tHSSCause;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletionExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UpdatedNetworkConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3166L, vendorId = KnownVendorIDs.TGPP_ID)
public class GroupReportItemImpl extends DiameterGroupedAvpImpl implements GroupReportItem
{
	private UserIdentifier userIdentifier;
	private VisitedPLMNId visitedPLMNId;
	private RoamingInformation roamingInformation;
	private IMEIChange imeiChange;
	private ReachabilityInformation reachabilityInformation;
	private MaximumUEAvailabilityTime maximumUEAvailabilityTime;
	private EPSLocationInformation epsLocationInformation;
	private MonitoringType monitoringType;
	private List<ServiceReport> serviceReport;
	private S6tHSSCause s6tHSSCause;
	private IdleStatusIndication idleStatusIndication;
	private ReportingTimeStamp reportingTimeStamp;
	private UpdatedNetworkConfiguration updatedNetworkConfiguration;
	private List<SCEFReferenceIDForDeletion> scefReferenceIDForDeletion;
	private List<SCEFReferenceIDForDeletionExt> scefReferenceIDForDeletionExt;
	private EventHandling eventHandling;
	private LossOfConnectivityReason lossOfConnectivityReason;
	private List<PDNConnectivityStatusReport> pdnConnectivityStatusReport;
	
	protected GroupReportItemImpl()
	{
		 
	}
	 
	public GroupReportItemImpl(UserIdentifier userIdentifier) 
	{
		if(userIdentifier==null)
			throw new IllegalArgumentException("User-Identifier is required");
		
		this.userIdentifier = userIdentifier;
	}
	 
	public UserIdentifier getUserIdentifier()
	{
		return userIdentifier;
	}
	
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			throw new IllegalArgumentException("User-Identifier is required");
		
		this.userIdentifier = value;
	}
	
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value == null)
			this.visitedPLMNId = null;
		else
			this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);
	}	
	
	public RoamingInformationEnum getRoamingInformation()
	{
		if(roamingInformation == null)
			return null;
		
		return roamingInformation.getEnumerated(RoamingInformationEnum.class);
	}
	
	public void setRoamingInformation(RoamingInformationEnum value)
	{
		if(value == null)
			this.roamingInformation = null;
		else
			this.roamingInformation = new RoamingInformationImpl(value, null, null);
	}	
	
	public IMEIChange getIMEIChange()
	{
		return imeiChange;
	}
	
	public void setIMEIChange(IMEIChange value)
	{
		this.imeiChange = value;
	}	
	
	public ReachabilityInformationEnum getReachabilityInformation()
	{
		if(reachabilityInformation == null)
			return null;
		
		return reachabilityInformation.getEnumerated(ReachabilityInformationEnum.class);
	}
	
	public void setReachabilityInformation(ReachabilityInformationEnum value)
	{
		if(value == null)
			this.reachabilityInformation = null;
		else
			this.reachabilityInformation = new ReachabilityInformationImpl(value, null, null);
	}	
	
	public Date getMaximumUEAvailabilityTime()
	{
		if(maximumUEAvailabilityTime == null)
			return null;
		
		return maximumUEAvailabilityTime.getDateTime();
	}
	
	public void setMaximumUEAvailabilityTime(Date value)
	{
		if(value == null)
			this.maximumUEAvailabilityTime = null;
		else
			this.maximumUEAvailabilityTime = new MaximumUEAvailabilityTimeImpl(value, null, null);
	}	
	
	public EPSLocationInformation getEPSLocationInformation()
	{
		return epsLocationInformation;
	}
	
	public void setEPSLocationInformation(EPSLocationInformation value)
	{
		this.epsLocationInformation = value;
	}	
	
	public MonitoringTypeEnum getMonitoringType()
	{
		if(monitoringType == null)
			return null;
		
		return monitoringType.getEnumerated(MonitoringTypeEnum.class);
	}
	
	public void setMonitoringType(MonitoringTypeEnum value)
	{
		if(value == null)
			this.monitoringType = null;
		else
			this.monitoringType = new MonitoringTypeImpl(value, null, null);
	}	
	
	public List<ServiceReport> getServiceReport()
	{
		return serviceReport;
	}
	
	public void setServiceReport(List<ServiceReport> value)
	{
		this.serviceReport = value;
	}	
	
	public Long getS6tHSSCause()
	{
		if(s6tHSSCause == null)
			return null;
		
		return s6tHSSCause.getUnsigned();
	}
	
	public void setS6tHSSCause(Long value)
	{
		if(value == null)
			this.s6tHSSCause = null;
		else
			this.s6tHSSCause = new S6tHSSCauseImpl(value, null, null);
	}	
	
	public IdleStatusIndication getIdleStatusIndication()
	{
		return idleStatusIndication;
	}
	
	public void setIdleStatusIndication(IdleStatusIndication value)
	{
		this.idleStatusIndication = value;
	}	
	
	public Date getReportingTimeStamp()
	{
		if(reportingTimeStamp == null)
			return null;
		
		return reportingTimeStamp.getDateTime();
	}
	
	public void setReportingTimeStamp(Date value)
	{
		if(value == null)
			this.reportingTimeStamp = null;
		else
			this.reportingTimeStamp = new ReportingTimeStampImpl(value, null, null);
	}	
	
	public UpdatedNetworkConfiguration getUpdatedNetworkConfiguration()
	{
		return updatedNetworkConfiguration;
	}
	
	public void setUpdatedNetworkConfiguration(UpdatedNetworkConfiguration value)
	{
		this.updatedNetworkConfiguration = value;
	}	
	
	public List<Long> getSCEFReferenceIDForDeletion()
	{
		if(scefReferenceIDForDeletion == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletion curr:scefReferenceIDForDeletion)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletion(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletion = null;
		else
		{
			this.scefReferenceIDForDeletion = new ArrayList<SCEFReferenceIDForDeletion>();
			for(Long curr:value)
				this.scefReferenceIDForDeletion.add(new SCEFReferenceIDForDeletionImpl(curr, null, null));			
		}
	}
	
	public List<Long> getSCEFReferenceIDForDeletionExt()
	{
		if(scefReferenceIDForDeletionExt == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletionExt curr:scefReferenceIDForDeletionExt)
			result.add(curr.getLong());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletionExt(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletionExt = null;
		else
		{
			this.scefReferenceIDForDeletionExt = new ArrayList<SCEFReferenceIDForDeletionExt>();
			for(Long curr:value)
				this.scefReferenceIDForDeletionExt.add(new SCEFReferenceIDForDeletionExtImpl(curr, null, null));			
		}
	}
	
	public EventHandlingEnum getEventHandling()
	{
		if(eventHandling == null)
			return null;
		
		return eventHandling.getEnumerated(EventHandlingEnum.class);
	}
	
	public void setEventHandling(EventHandlingEnum value)
	{
		if(value == null)
			this.eventHandling = null;
		else
			this.eventHandling = new EventHandlingImpl(value, null, null);
	}	
	
	public LossOfConnectivityReasonEnum getLossOfConnectivityReason()
	{
		if(lossOfConnectivityReason == null)
			return null;
		
		return lossOfConnectivityReason.getEnumerated(LossOfConnectivityReasonEnum.class);
	}
	
	public void setLossOfConnectivityReason(LossOfConnectivityReasonEnum value)
	{
		if(value == null)
			this.lossOfConnectivityReason = null;
		else
			this.lossOfConnectivityReason = new LossOfConnectivityReasonImpl(value, null, null);
	}	
	
	public List<PDNConnectivityStatusReport> getPDNConnectivityStatusReport()
	{
		return pdnConnectivityStatusReport;
	}
	
	public void setPDNConnectivityStatusReport(List<PDNConnectivityStatusReport> value)
	{
		this.pdnConnectivityStatusReport = value;
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(userIdentifier==null)
			return "User-Identifier is required";
		
		return null;
	}
}