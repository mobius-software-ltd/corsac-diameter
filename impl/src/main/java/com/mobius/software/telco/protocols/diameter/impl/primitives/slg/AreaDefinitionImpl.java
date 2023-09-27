package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AdditionalArea;
import com.mobius.software.telco.protocols.diameter.primitives.slg.Area;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaDefinition;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2534L, vendorId = KnownVendorIDs.TGPP_ID)
public class AreaDefinitionImpl extends DiameterGroupedAvpImpl implements AreaDefinition
{
	private List<Area> area;
	
	private List<AdditionalArea> additionalArea;
	
	protected AreaDefinitionImpl() 
	{
	}
	
	public AreaDefinitionImpl(List<Area> area)
	{
		if(area==null || area.size()==0)
			throw new IllegalArgumentException("Area is required");
		
		if(area.size()>10)
			throw new IllegalArgumentException("Up to 10 Area allowed");
		
		this.area = area;
	}
	
	public List<Area> getArea()
	{
		return area;
	}
	
	public void setArea(List<Area> value)
	{
		if(value==null || value.size()==0)
			throw new IllegalArgumentException("Area is required");
		
		if(value.size()>10)
			throw new IllegalArgumentException("Up to 10 Area allowed");
		
		this.area = value;
	}
	
	public List<AdditionalArea> getAdditionalArea()
	{
		return additionalArea;
	}
	
	public void setAdditionalArea(List<AdditionalArea> value)
	{
		if(value!=null && value.size()>240)
			throw new IllegalArgumentException("Up to 240 Additional-Area allowed");
		
		this.additionalArea = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(area==null || area.size()==0)
			return "Area is required";
		
		if(area.size()>10)
			return "Up to 10 Area allowed";
		
		if(additionalArea!=null && additionalArea.size()>240)
			return "Up to 240 Additional-Area allowed";
		
		return null;
	}
}