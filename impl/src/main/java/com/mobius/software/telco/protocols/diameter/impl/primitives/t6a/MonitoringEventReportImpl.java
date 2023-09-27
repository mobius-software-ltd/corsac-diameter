package com.mobius.software.telco.protocols.diameter.impl.primitives.t6a;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MaximumUEAvailabilityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.LossOfConnectivityReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ReachabilityInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ReportingTimeStampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFReferenceIDExtImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFReferenceIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MaximumUEAvailabilityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LossOfConnectivityReason;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LossOfConnectivityReasonEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReportingTimeStamp;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDExt;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CommunicationFailureInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.IdleStatusIndication;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfUEPerLocationReport;
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
	private MonitoringType monitoringType;
	private ReachabilityInformation reachabilityInformation;
	private EPSLocationInformation epsLocationInformation;
	private CommunicationFailureInformation communicationFailureInformation;
	private List<NumberOfUEPerLocationReport> numberOfUEPerLocationReport;
	private LossOfConnectivityReason lossOfConnectivityReason;
	private VisitedPLMNId visitedPLMNId;
	private IdleStatusIndication idleStatusIndication;
	private ReportingTimeStamp reportingTimeStamp;
	private MaximumUEAvailabilityTime maximumUEAvailabilityTime;
	private List<PDNConnectivityStatusReport> pdnConnectivityStatusReport;
	private ReachabilityCause reachabilityCause;
		
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
	
	public EPSLocationInformation getEPSLocationInformation()
	{
		return epsLocationInformation;
	}
	
	public void setEPSLocationInformation(EPSLocationInformation value)
	{
		this.epsLocationInformation = value;
	}
	
	public CommunicationFailureInformation getCommunicationFailureInformation()
	{
		return communicationFailureInformation;
	}
	
	public void setCommunicationFailureInformation(CommunicationFailureInformation value)
	{
		this.communicationFailureInformation = value;
	}
	
	public List<NumberOfUEPerLocationReport> getNumberOfUEPerLocationReport()
	{
		return numberOfUEPerLocationReport;
	}
	
	public void setNumberOfUEPerLocationReport(List<NumberOfUEPerLocationReport> value)
	{
		this.numberOfUEPerLocationReport = value;		
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
	
	public List<PDNConnectivityStatusReport> getPDNConnectivityStatusReport()
	{
		return pdnConnectivityStatusReport;
	}
	
	public void setPDNConnectivityStatusReport(List<PDNConnectivityStatusReport> value)
	{
		this.pdnConnectivityStatusReport = value;		
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
	
	@DiameterValidate
	public String validate()
	{
		if(scefReferenceID==null)
			return "SCEF-Reference-ID is required";
		
		return null;
	}	
}