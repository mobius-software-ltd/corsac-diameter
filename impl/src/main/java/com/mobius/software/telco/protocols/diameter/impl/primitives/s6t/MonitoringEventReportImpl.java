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
import com.mobius.software.telco.protocols.diameter.impl.primitives.t6a.ReachabilityCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MaximumUEAvailabilityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EventHandling;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EventHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.IMEIChange;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LossOfConnectivityReason;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LossOfConnectivityReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RoamingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RoamingInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletionExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceReport;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ReachabilityCause;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ReachabilityCauseEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3123L, vendorId = KnownVendorIDs.TGPP_ID)
public class MonitoringEventReportImpl extends DiameterGroupedAvpImpl implements MonitoringEventReport
{
	private SCEFReferenceID scefReferenceID;
	private SCEFReferenceIDExt scefReferenceIDExt;
	private SCEFID scefID;
	private List<SCEFReferenceIDForDeletion> scefReferenceIDForDeletion;
	private List<SCEFReferenceIDForDeletionExt> scefReferenceIDForDeletionExt;
	private VisitedPLMNId visitedPLMNId;
	private RoamingInformation roamingInformation;
	private IMEIChange imeiChange;
	private TerminalInformation terminalInformation;
	private ReachabilityInformation reachabilityInformation;
	private ReachabilityCause reachabilityCause;
	private MaximumUEAvailabilityTime maximumUEAvailabilityTime;
	private EPSLocationInformation epsLocationInformation;
	private MonitoringType monitoringType;
	private EventHandling eventHandling;
	private List<ServiceReport> serviceReport;
	private LossOfConnectivityReason lossOfConnectivityReason;
	private IdleStatusIndication idleStatusIndication;
	private List<PDNConnectivityStatusReport> pdnConnectivityStatusReport;
	
	protected MonitoringEventReportImpl() 
	{
	}
	
	public MonitoringEventReportImpl(Long scefReferenceID)
	{
		if(scefReferenceID==null)
			throw new IllegalArgumentException("SCEF-Reference-ID is required");
		
		this.scefReferenceID = new SCEFReferenceIDImpl(scefReferenceID, null, null);						
	}
	
	public Long getSCEFReferenceID()
	{
		if(scefReferenceID == null)
			return null;
		
		return scefReferenceID.getUnsigned();
	}
	
	public void setSCEFReferenceID(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("SCEF-Reference-ID is required");
		
		this.scefReferenceID = new SCEFReferenceIDImpl(value, null, null);						
	}
	
	public Long getSCEFReferenceIDExt()
	{
		if(scefReferenceIDExt == null)
			return null;
		
		return scefReferenceIDExt.getLong();
	}
	
	public void setSCEFReferenceIDExt(Long value)
	{
		if(value == null)
			this.scefReferenceIDExt = null;
		else
			this.scefReferenceIDExt = new SCEFReferenceIDExtImpl(value, null, null);
	}
	
	public String getSCEFID()
	{
		if(scefID == null)
			return null;
		
		return scefID.getIdentity();
	}
	
	public void setSCEFID(String value)
	{
		if(value == null)
			this.scefID = null;
		else
			this.scefID = new SCEFIDImpl(value, null, null);
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
	
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
	
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
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
	
	public ReachabilityCauseEnum getReachabilityCause()
	{
		if(reachabilityCause == null)
			return null;
		
		return reachabilityCause.getEnumerated(ReachabilityCauseEnum.class);
	}
	
	public void setReachabilityCause(ReachabilityCauseEnum value)
	{
		if(value == null)
			this.reachabilityCause = null;
		else
			this.reachabilityCause = new ReachabilityCauseImpl(value, null, null);
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
	
	public List<ServiceReport> getServiceReport()
	{
		return this.serviceReport;
	}
	
	public void setServiceReport(List<ServiceReport> value)
	{
		this.serviceReport = value;
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
	
	public IdleStatusIndication getIdleStatusIndication()
	{
		return idleStatusIndication;
	}
	
	public void setIdleStatusIndication(IdleStatusIndication value)
	{
		this.idleStatusIndication = value;	
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
		if(scefReferenceID==null)
			return "SCEF-Reference-ID is required";
		
		return null;
	}	
}