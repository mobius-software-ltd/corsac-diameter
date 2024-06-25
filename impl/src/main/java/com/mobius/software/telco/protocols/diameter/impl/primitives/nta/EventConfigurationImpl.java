package com.mobius.software.telco.protocols.diameter.impl.primitives.nta;

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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.MonitoringTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.nta.ExtendedSCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;

public class EventConfigurationImpl extends DiameterGroupedAvpImpl implements EventConfiguration
{
	private ExtendedSCEFReferenceID extendedSCEFReferenceID;
	
	private SCEFID scefID;
	
	private MonitoringType monitoringType;
	
	private LocationInformationConfiguration locationInformationConfiguration;
	
	public EventConfigurationImpl()
	{
		
	}
	
	public EventConfigurationImpl(Long extendedSCEFReferenceID, String scefID,MonitoringTypeEnum monitoringType) throws MissingAvpException
	{
		setExtendedSCEFReferenceID(extendedSCEFReferenceID);
		
		setSCEFID(scefID);
		
		setMonitoringType(monitoringType);
	}
	
	@Override
	public Long getExtendedSCEFReferenceID()
	{
		if( extendedSCEFReferenceID == null)
			return null;
		
		return extendedSCEFReferenceID.getLong();
	}
	 
	@Override
	public void setExtendedSCEFReferenceID(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("ExtendedSCEFReferenceID is required", Arrays.asList(new DiameterAvp[] { new ExtendedSCEFReferenceIDImpl() }));
			
		this.extendedSCEFReferenceID = new ExtendedSCEFReferenceIDImpl(value, null, null);
	}
	
	@Override
	public String getSCEFID()
	{
		if(scefID == null)
			return null;
		
		return scefID.getIdentity();
	}
	 
	@Override
	public void setSCEFID(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SCEF-ID is required", Arrays.asList(new DiameterAvp[] { new SCEFIDImpl() }));
			
		this.scefID = new SCEFIDImpl(value, null, null);
	}
	
	public MonitoringTypeEnum getMonitoringType()
	{
		if(monitoringType == null)
			return null;
		
		return monitoringType.getEnumerated(MonitoringTypeEnum.class);
	}
	
	public void setMonitoringType(MonitoringTypeEnum value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Monitoring-Type is required", Arrays.asList(new DiameterAvp[] { new MonitoringTypeImpl() }));
		
		this.monitoringType = new MonitoringTypeImpl(value, null, null);
	}	
	
	
	public LocationInformationConfiguration getLocationInformationConfiguration()
	{
		return locationInformationConfiguration;
	}
	
	public void setLocationInformationConfiguration(LocationInformationConfiguration value)
	{
		this.locationInformationConfiguration = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(extendedSCEFReferenceID==null)
			return new MissingAvpException("ExtendedSCEFReferenceID is required", Arrays.asList(new DiameterAvp[] { new ExtendedSCEFReferenceIDImpl() }));
		
		if(scefID==null)
			return new MissingAvpException("SCEFID is required", Arrays.asList(new DiameterAvp[] { new SCEFIDImpl() }));
		
		if(monitoringType==null)
			return new MissingAvpException("MonitoringType is required", Arrays.asList(new DiameterAvp[] { new MonitoringTypeImpl() }));
		
		return null;
	}

}
