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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.AccuracyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MONTELocationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MaximumDetectionTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MaximumNumberOfReportsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringDurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFReferenceIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargedParty;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringEventConfigurationActivity;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringEventConfigurationActivityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringEventFunctionality;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringEventFunctionalityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MonitoringEventInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.Accuracy;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AccuracyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MONTELocationType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MONTELocationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MaximumDetectionTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MaximumNumberOfReports;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringDuration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UEReachabilityConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.NumberOfUEPerLocationConfiguration;

/**
*
* @author yulian oifa
*
*/
public class MonitoringEventInformationImpl extends DiameterAvpImpl implements MonitoringEventInformation
{
	private MonitoringEventFunctionality monitoringEventFunctionality;
	private EventTimestamp eventTimestamp;
	private MonitoringEventConfigurationActivity monitoringEventConfigurationActivity;
	private SCEFReferenceID scefReferenceID;
	private SCEFID scefID;
	private MonitoringType monitoringType;
	private MaximumNumberOfReports maximumNumberofReports;
	private MonitoringDuration monitoringDuration;
	private ChargedParty chargedParty;
	private MaximumDetectionTime maximumDetectionTime; 
	private UEReachabilityConfiguration ueReachabilityConfiguration;
	private MONTELocationType monteLocationType;
	private Accuracy accuracy;
	private List<NumberOfUEPerLocationConfiguration> numberOfUEPerLocationConfiguration;
	private List<MonitoringEventReport> monitoringEventReport;
				
	public MonitoringEventInformationImpl()
	{
		
	}
	
	public MonitoringEventFunctionalityEnum getMonitoringEventFunctionality()
	{
		if(monitoringEventFunctionality==null)
			return null;
		
		return monitoringEventFunctionality.getEnumerated(MonitoringEventFunctionalityEnum.class);
	}
	
	public void setMonitoringEventFunctionality(MonitoringEventFunctionalityEnum value)
	{
		if(value==null)
			this.monitoringEventFunctionality = null;
		else
			this.monitoringEventFunctionality = new MonitoringEventFunctionalityImpl(value, null, null);			
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
	
	public MonitoringEventConfigurationActivityEnum getMonitoringEventConfigurationActivity()
	{
		if(monitoringEventConfigurationActivity==null)
			return null;
		
		return monitoringEventConfigurationActivity.getEnumerated(MonitoringEventConfigurationActivityEnum.class);
	}
	
	public void setMonitoringEventConfigurationActivity(MonitoringEventConfigurationActivityEnum value)
	{
		if(value==null)
			this.monitoringEventConfigurationActivity = null;
		else
			this.monitoringEventConfigurationActivity = new MonitoringEventConfigurationActivityImpl(value, null, null);			
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

	public Long getMaximumNumberOfReports()
	{
		if(maximumNumberofReports==null)
			return null;
		
		return maximumNumberofReports.getUnsigned();
	}
	
	public void setMaximumNumberOfReports(Long value)
	{
		if(value==null)
			this.maximumNumberofReports = null;
		else
			this.maximumNumberofReports = new MaximumNumberOfReportsImpl(value, null, null);			
	}
	
	public Date getMonitoringDuration()
	{
		if(monitoringDuration==null)
			return null;
		
		return monitoringDuration.getDateTime();
	}
	
	public void setMonitoringDuration(Date value)
	{
		if(value==null)
			this.monitoringDuration = null;
		else
			this.monitoringDuration = new MonitoringDurationImpl(value, null, null);			
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
	
	public Long getMaximumDetectionTime()
	{
		if(maximumDetectionTime==null)
			return null;
		
		return maximumDetectionTime.getUnsigned();
	}
	
	public void setMaximumDetectionTime(Long value)
	{
		if(value==null)
			this.maximumDetectionTime = null;
		else
			this.maximumDetectionTime = new MaximumDetectionTimeImpl(value, null, null);			
	}
	
	public UEReachabilityConfiguration getUEReachabilityConfiguration()
	{
		return ueReachabilityConfiguration;
	}
	
	public void setUEReachabilityConfiguration(UEReachabilityConfiguration value)
	{
		this.ueReachabilityConfiguration = value;		
	}
	
	public MONTELocationTypeEnum getMONTELocationType()
	{
		if(monteLocationType==null)
			return null;
		
		return monteLocationType.getEnumerated(MONTELocationTypeEnum.class);
	}
	
	public void setMONTELocationType(MONTELocationTypeEnum value)
	{
		if(value==null)
			this.monteLocationType = null;
		else
			this.monteLocationType = new MONTELocationTypeImpl(value, null, null);			
	}
	
	public AccuracyEnum getAccuracy()
	{
		if(accuracy==null)
			return null;
		
		return accuracy.getEnumerated(AccuracyEnum.class);
	}
	
	public void setAccuracy(AccuracyEnum value)
	{
		if(value==null)
			this.accuracy = null;
		else
			this.accuracy = new AccuracyImpl(value, null, null);			
	}
	
	public List<NumberOfUEPerLocationConfiguration> getNumberOfUEPerLocationConfiguration()
	{
		return numberOfUEPerLocationConfiguration;
	}
	
	public void setNumberOfUEPerLocationConfiguration(List<NumberOfUEPerLocationConfiguration> value)
	{
		this.numberOfUEPerLocationConfiguration = value;
	}
	
	public List<MonitoringEventReport> getMonitoringEventReport()
	{
		return monitoringEventReport;
	}
	
	public void setMonitoringEventReport(List<MonitoringEventReport> value)
	{
		this.monitoringEventReport = value;
	}
}