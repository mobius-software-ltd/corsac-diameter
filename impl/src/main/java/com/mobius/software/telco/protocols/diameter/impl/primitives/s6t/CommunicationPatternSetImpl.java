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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.BatteryIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CommunicationDurationTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CommunicationPatternSet;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PeriodicCommunicationIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PeriodicCommunicationIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PeriodicTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ReferenceIDValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ScheduledCommunicationTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.StationaryIndication;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.StationaryIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.TrafficProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.TrafficProfileEnum;

/**
*
* @author yulian oifa
*
*/
public class CommunicationPatternSetImpl extends DiameterGroupedAvpImpl implements CommunicationPatternSet
{
	private PeriodicCommunicationIndicator periodicCommunicationIndicator;
	private CommunicationDurationTime communicationDurationTime;
	private PeriodicTime periodicTime;
	private List<ScheduledCommunicationTime> scheduledCommunicationTime;
	private StationaryIndication stationaryIndication;
	private ReferenceIDValidityTime referenceIDValidityTime;
	private TrafficProfile trafficProfile;
	private BatteryIndicator batteryIndicator;
		
	public CommunicationPatternSetImpl()
	{
		
	}
	
	public PeriodicCommunicationIndicatorEnum getPeriodicCommunicationIndicator()
	{
		if(periodicCommunicationIndicator == null)
			return null;
		
		return periodicCommunicationIndicator.getEnumerated(PeriodicCommunicationIndicatorEnum.class);
	}
	
	public void setPeriodicCommunicationIndicator(PeriodicCommunicationIndicatorEnum value)
	{
		if(value==null)
			this.periodicCommunicationIndicator = null;
		else
			this.periodicCommunicationIndicator = new PeriodicCommunicationIndicatorImpl(value, null, null);
	}
	
	public Long getCommunicationDurationTime()
	{
		if(communicationDurationTime == null)
			return null;
		
		return communicationDurationTime.getUnsigned();
	}
	
	public void setCommunicationDurationTime(Long value)
	{
		if(value==null)
			this.communicationDurationTime = null;
		else
			this.communicationDurationTime = new CommunicationDurationTimeImpl(value, null, null);
	}
	
	public Long getPeriodicTime()
	{
		if(periodicTime == null)
			return null;
		
		return periodicTime.getUnsigned();
	}
	
	public void setPeriodicTime(Long value)
	{
		if(value==null)
			this.periodicTime = null;
		else
			this.periodicTime = new PeriodicTimeImpl(value, null, null);
	}
	
	public List<ScheduledCommunicationTime> getScheduledCommunicationTime()
	{
		return scheduledCommunicationTime;
	}
	
	public void setScheduledCommunicationTime(List<ScheduledCommunicationTime> value)
	{
		this.scheduledCommunicationTime = value;
	}
	
	public StationaryIndicationEnum getStationaryIndication()
	{
		if(stationaryIndication == null)
			return null;
		
		return stationaryIndication.getEnumerated(StationaryIndicationEnum.class);
	}
	
	public void setStationaryIndication(StationaryIndicationEnum value)
	{
		if(value==null)
			this.stationaryIndication = null;
		else
			this.stationaryIndication = new StationaryIndicationImpl(value, null, null);
	}
	
	public Date getReferenceIDValidityTime()
	{
		if(referenceIDValidityTime == null)
			return null;
		
		return referenceIDValidityTime.getDateTime();
	}
	
	public void setReferenceIDValidityTime(Date value)
	{
		if(value==null)
			this.referenceIDValidityTime = null;
		else
			this.referenceIDValidityTime = new ReferenceIDValidityTimeImpl(value, null, null);
	}
	
	public TrafficProfileEnum getTrafficProfile()
	{
		if(trafficProfile == null)
			return null;
		
		return trafficProfile.getEnumerated(TrafficProfileEnum.class);
	}
	
	public void setTrafficProfile(TrafficProfileEnum value)
	{
		if(value==null)
			this.trafficProfile = null;
		else
			this.trafficProfile = new TrafficProfileImpl(value, null, null);
	}
	
	public Long getBatteryIndicator()
	{
		if(batteryIndicator == null)
			return null;
		
		return batteryIndicator.getUnsigned();
	}
	
	public void setBatteryIndicator(Long value)
	{
		if(value==null)
			this.batteryIndicator = null;
		else
			this.batteryIndicator = new BatteryIndicatorImpl(value, null, null);
	}
}