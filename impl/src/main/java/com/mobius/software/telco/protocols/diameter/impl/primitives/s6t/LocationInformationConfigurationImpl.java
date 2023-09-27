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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.Accuracy;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AccuracyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MONTELocationType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MONTELocationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PeriodicTime;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3135L, vendorId = KnownVendorIDs.TGPP_ID)
public class LocationInformationConfigurationImpl extends DiameterGroupedAvpImpl implements LocationInformationConfiguration
{
	private MONTELocationType monteLocationType;
	
	private Accuracy accuracy;
	
	private PeriodicTime periodicTime;
	
	public LocationInformationConfigurationImpl()
	{
		
	}
	
	public MONTELocationTypeEnum getMONTELocationType()
	{
		if(monteLocationType == null)
			return null;
		
		return monteLocationType.getEnumerated(MONTELocationTypeEnum.class);
	}
	
	public void setMONTELocationType(MONTELocationTypeEnum value)
	{
		if(value == null)
			this.monteLocationType = null;
		else
			this.monteLocationType = new MONTELocationTypeImpl(value, null, null);
	}	
	
	public AccuracyEnum getAccuracy()
	{
		if(accuracy == null)
			return null;
		
		return accuracy.getEnumerated(AccuracyEnum.class);
	}
	
	public void setAccuracy(AccuracyEnum value)
	{
		if(value == null)
			this.accuracy = null;
		else
			this.accuracy = new AccuracyImpl(value, null, null);
	}	
	
	public Long getPeriodicTime()
	{
		if(periodicTime == null)
			return null;
		
		return periodicTime.getUnsigned();
	}
	
	public void setPeriodicTime(Long value)
	{
		if(value == null)
			this.periodicTime = null;
		else
			this.periodicTime = new PeriodicTimeImpl(value, null, null);
	}	
}