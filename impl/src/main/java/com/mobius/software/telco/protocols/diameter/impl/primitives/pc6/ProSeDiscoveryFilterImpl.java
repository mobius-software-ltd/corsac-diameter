package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.FilterId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCode;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppMask;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeDiscoveryFilter;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeValidityTimer;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3813L, vendorId = KnownVendorIDs.TGPP_ID)
public class ProSeDiscoveryFilterImpl extends DiameterGroupedAvpImpl implements ProSeDiscoveryFilter
{
	private FilterId filterId;
	private ProSeAppId proSeAppId;
	private ProSeValidityTimer proSeValidityTimer;
	private ProSeAppCode proSeAppCode;
	private List<ProSeAppMask> proSeAppMask;
			
	protected ProSeDiscoveryFilterImpl() 
	{
	}
	
	public ProSeDiscoveryFilterImpl(ByteBuf filterId,String proSeAppId,Long proSeValidityTimer,ByteBuf proSeAppCode)
	{
		if(filterId==null)
			throw new IllegalArgumentException("Filter-Id is required");
		
		if(proSeAppId==null)
			throw new IllegalArgumentException("ProSe-App-Id is required");
		
		if(proSeValidityTimer==null)
			throw new IllegalArgumentException("ProSe-Validity-Timer is required");
		
		if(proSeAppCode==null)
			throw new IllegalArgumentException("ProSe-App-Code is required");
		
		this.filterId = new FilterIdImpl(filterId, null, null);
		
		this.proSeAppId = new ProSeAppIdImpl(proSeAppId, null, null);
		
		this.proSeValidityTimer = new ProSeValidityTimerImpl(proSeValidityTimer, null, null);
		
		this.proSeAppCode = new ProSeAppCodeImpl(proSeAppCode, null, null);
	}
	
	public ByteBuf getFilterId()
	{
		if(filterId==null)
			return null;
		
		return filterId.getValue();
	}
	
	public void setFilterId(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Filter-Id is required");
		
		this.filterId = new FilterIdImpl(value, null, null);
	}
	
	public String getProSeAppId()
	{
		if(proSeAppId==null)
			return null;
		
		return proSeAppId.getString();
	}
	
	public void setProSeAppId(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("ProSe-App-Id is required");
		
		this.proSeAppId = new ProSeAppIdImpl(value, null, null);
	}
	
	public Long getProSeValidityTimer()
	{
		if(proSeValidityTimer==null)
			return null;
		
		return proSeValidityTimer.getUnsigned();
	}
	
	public void setProSeValidityTimer(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("ProSe-Validity-Timer is required");

		this.proSeValidityTimer = new ProSeValidityTimerImpl(value, null, null);
	}
	
	public ByteBuf getProSeAppCode()
	{
		if(proSeAppCode==null)
			return null;
		
		return proSeAppCode.getValue();
	}
	
	public void setProSeAppCode(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("ProSe-App-Code is required");
		
		this.proSeAppCode = new ProSeAppCodeImpl(value, null, null);
	}
	
	public List<ByteBuf> getProSeAppMask()
	{
		if(proSeAppMask==null || proSeAppMask.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ProSeAppMask curr:proSeAppMask)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setProSeAppMask(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.proSeAppMask = null;
		else
		{
			this.proSeAppMask = new ArrayList<ProSeAppMask>();
			for(ByteBuf curr:value)
				this.proSeAppMask.add(new ProSeAppMaskImpl(curr, null, null));
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		if(filterId==null)
			return "Filter-Id is required";
		
		if(proSeAppId==null)
			return "ProSe-App-Id is required";
		
		if(proSeValidityTimer==null)
			return "ProSe-Validity-Timer is required";
		
		if(proSeAppCode==null)
			return "ProSe-App-Code is required";
		
		return null;
	}
}