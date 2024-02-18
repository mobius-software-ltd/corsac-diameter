package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gx.APNAggregateMaxBitrateDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.APNAggregateMaxBitrateUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedAPNAMBRDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ExtendedAPNAMBRUL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;

/**
*
* @author yulian oifa
*
*/
public class ConditionalAPNAggregateMaxBitrateImpl extends DiameterGroupedAvpImpl implements ConditionalAPNAggregateMaxBitrate
{
	private APNAggregateMaxBitrateUL apnAggregateMaxBitrateUL;
	private APNAggregateMaxBitrateDL apnAggregateMaxBitrateDL;
	private ExtendedAPNAMBRUL extendedAPNAMBRUL;
	private ExtendedAPNAMBRDL extendedAPNAMBRDL;
	private List<IPCANType> ipcanType;
	private List<RATType> ratType;
		
	public ConditionalAPNAggregateMaxBitrateImpl()
	{
		
	}
	
	public Long getAPNAggregateMaxBitrateUL()
	{
		if(apnAggregateMaxBitrateUL==null)
			return null;
		
		return apnAggregateMaxBitrateUL.getUnsigned();
	}
	
	public void setAPNAggregateMaxBitrateUL(Long value)
	{
		if(value==null)
			this.apnAggregateMaxBitrateUL = null;
		else
			this.apnAggregateMaxBitrateUL = new APNAggregateMaxBitrateULImpl(value, null, null);			
	}
	
	public Long getAPNAggregateMaxBitrateDL()
	{
		if(apnAggregateMaxBitrateDL==null)
			return null;
		
		return apnAggregateMaxBitrateDL.getUnsigned();
	}
	
	public void setAPNAggregateMaxBitrateDL(Long value)
	{
		if(value==null)
			this.apnAggregateMaxBitrateDL = null;
		else
			this.apnAggregateMaxBitrateDL = new APNAggregateMaxBitrateDLImpl(value, null, null);			
	}
	
	public Long getExtendedAPNAMBRUL()
	{
		if(extendedAPNAMBRUL==null)
			return null;
		
		return extendedAPNAMBRUL.getUnsigned();
	}
	
	public void setExtendedAPNAMBRUL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRUL = null;
		else
			this.extendedAPNAMBRUL = new ExtendedAPNAMBRULImpl(value, null, null);			
	}
	
	public Long getExtendedAPNAMBRDL()
	{
		if(extendedAPNAMBRDL==null)
			return null;
		
		return extendedAPNAMBRDL.getUnsigned();
	}
	
	public void setExtendedAPNAMBRDL(Long value)
	{
		if(value==null)
			this.extendedAPNAMBRDL = null;
		else
			this.extendedAPNAMBRDL = new ExtendedAPNAMBRDLImpl(value, null, null);			
	}
	
	public List<IPCANTypeEnum> getIPCANType()
	{
		if(ipcanType==null || ipcanType.size()==0)
			return null;
		
		List<IPCANTypeEnum> result = new ArrayList<IPCANTypeEnum>();
		for(IPCANType curr:ipcanType)
			result.add(curr.getEnumerated(IPCANTypeEnum.class));
		
		return result;
	}
	
	public void setIPCANType(List<IPCANTypeEnum> value)
	{
		if(value==null || value.size()==0)
			this.ipcanType = null;
		else
		{
			this.ipcanType = new ArrayList<IPCANType>();
			for(IPCANTypeEnum curr:value)
				this.ipcanType.add(new IPCANTypeImpl(curr, null, null));			
		}
	}
	
	public List<RATTypeEnum> getRATType()
	{
		if(ratType==null || ratType.size()==0)
			return null;
		
		List<RATTypeEnum> result = new ArrayList<RATTypeEnum>();
		for(RATType curr:ratType)
			result.add(curr.getEnumerated(RATTypeEnum.class));
		
		return result;
	}
	
	public void setRATType(List<RATTypeEnum> value)
	{
		if(value==null || value.size()==0)
			this.ratType = null;
		else
		{
			this.ratType = new ArrayList<RATType>();
			for(RATTypeEnum curr:value)
				this.ratType.add(new RATTypeImpl(curr, null, null));			
		}
	}
}