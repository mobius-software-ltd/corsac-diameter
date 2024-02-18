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
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
	
	public ProSeDiscoveryFilterImpl(ByteBuf filterId,String proSeAppId,Long proSeValidityTimer,ByteBuf proSeAppCode) throws MissingAvpException
	{
		setFilterId(filterId);
		
		setProSeAppId(proSeAppId);
		
		setProSeValidityTimer(proSeValidityTimer);
		
		setProSeAppCode(proSeAppCode);
	}
	
	public ByteBuf getFilterId()
	{
		if(filterId==null)
			return null;
		
		return filterId.getValue();
	}
	
	public void setFilterId(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Filter-Id is required is required", Arrays.asList(new DiameterAvp[] { new FilterIdImpl() }));
		
		this.filterId = new FilterIdImpl(value, null, null);
	}
	
	public String getProSeAppId()
	{
		if(proSeAppId==null)
			return null;
		
		return proSeAppId.getString();
	}
	
	public void setProSeAppId(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("ProSe-App-Id is required is required", Arrays.asList(new DiameterAvp[] { new ProSeAppIdImpl() }));
		
		this.proSeAppId = new ProSeAppIdImpl(value, null, null);
	}
	
	public Long getProSeValidityTimer()
	{
		if(proSeValidityTimer==null)
			return null;
		
		return proSeValidityTimer.getUnsigned();
	}
	
	public void setProSeValidityTimer(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("ProSe-Validity-Timer is required is required", Arrays.asList(new DiameterAvp[] { new ProSeValidityTimerImpl() }));

		this.proSeValidityTimer = new ProSeValidityTimerImpl(value, null, null);
	}
	
	public ByteBuf getProSeAppCode()
	{
		if(proSeAppCode==null)
			return null;
		
		return proSeAppCode.getValue();
	}
	
	public void setProSeAppCode(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("ProSe-App-Code is required is required", Arrays.asList(new DiameterAvp[] { new ProSeAppCodeImpl() }));
			
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
	public DiameterException validate()
	{
		if(filterId==null)
			return new MissingAvpException("Filter-Id is required is required", Arrays.asList(new DiameterAvp[] { new FilterIdImpl() }));
		
		if(proSeAppId==null)
			return new MissingAvpException("ProSe-App-Id is required is required", Arrays.asList(new DiameterAvp[] { new ProSeAppIdImpl() }));
		
		if(proSeValidityTimer==null)
			return new MissingAvpException("ProSe-Validity-Timer is required is required", Arrays.asList(new DiameterAvp[] { new ProSeValidityTimerImpl() }));
		
		if(proSeAppCode==null)
			return new MissingAvpException("ProSe-App-Code is required is required", Arrays.asList(new DiameterAvp[] { new ProSeAppCodeImpl() }));
		
		return null;
	}
}