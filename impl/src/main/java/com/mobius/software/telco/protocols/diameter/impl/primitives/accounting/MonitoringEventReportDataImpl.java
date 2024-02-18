package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.ReachabilityInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFReferenceIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargedParty;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringEventReportData;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringEventReportNumber;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReachabilityInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CommunicationFailureInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfUEPerLocationReport;

/**
*
* @author yulian oifa
*
*/
public class MonitoringEventReportDataImpl implements MonitoringEventReportData
{
	private EventTimestamp eventTimestamp;
	private SCEFReferenceID scefReferenceID;
	private SCEFID scefID;
	private MonitoringEventReportNumber monitoringEventReportNumber;
	private ChargedParty chargedParty;
	private SubscriptionId subscriptionId;
	private MonitoringType monitoringType;
	private ReachabilityInformation reachabilityInformation;
	private EPSLocationInformation epsLocationInformation;
	private CommunicationFailureInformation communicationFailureInformation;
	private List<NumberOfUEPerLocationReport> numberOfUEPerLocationReport;
		
	public MonitoringEventReportDataImpl()
	{
		
	}
	
	public Date getEventTimestamp()
	{
		if(eventTimestamp==null)
			return null;
		
		return eventTimestamp.getDateTime();
	}
	
	public void setEventTimestamp(Date value)
	{
		if(value==null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);			
	}
	
	public Long getSCEFReferenceID()
	{
		if(scefReferenceID==null)
			return null;
		
		return scefReferenceID.getUnsigned();
	}
	
	public void setSCEFReferenceID(Long value)
	{
		if(value==null)
			this.scefReferenceID = null;
		else
			this.scefReferenceID = new SCEFReferenceIDImpl(value, null, null);			
	}
	
	public String getSCEFID()
	{
		if(scefID==null)
			return null;
		
		return scefID.getIdentity();
	}
	
	public void setSCEFID(String value)
	{
		if(value==null)
			this.scefID = null;
		else
			this.scefID = new SCEFIDImpl(value, null, null);			
	}
	
	public Long getMonitoringEventReportNumber()
	{
		if(monitoringEventReportNumber==null)
			return null;
		
		return monitoringEventReportNumber.getUnsigned();
	}
	
	public void setMonitoringEventReportNumber(Long value)
	{
		if(value==null)
			this.monitoringEventReportNumber = null;
		else
			this.monitoringEventReportNumber = new MonitoringEventReportNumberImpl(value, null, null);			
	}

	public String getChargedParty()
	{
		if(chargedParty==null)
			return null;
		
		return chargedParty.getString();
	}
	
	public void setChargedParty(String value)
	{
		if(value==null)
			this.chargedParty = null;
		else
			this.chargedParty = new ChargedPartyImpl(value, null, null);			
	}
	
	public SubscriptionId getSubscriptionId()
	{
		return subscriptionId;
	}
	
	public void setSubscriptionId(SubscriptionId value)
	{
		this.subscriptionId = value;		
	}
	
	public MonitoringTypeEnum getMonitoringType()
	{
		if(monitoringType==null)
			return null;
		
		return monitoringType.getEnumerated(MonitoringTypeEnum.class);
	}
	
	public void setMonitoringType(MonitoringTypeEnum value)
	{
		if(value==null)
			this.monitoringType = null;
		else
			this.monitoringType = new MonitoringTypeImpl(value, null, null);			
	}
	
	public ReachabilityInformationEnum getReachabilityInformation()
	{
		if(reachabilityInformation==null)
			return null;
		
		return reachabilityInformation.getEnumerated(ReachabilityInformationEnum.class);
	}
	
	public void setReachabilityInformation(ReachabilityInformationEnum value)
	{
		if(value==null)
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
}