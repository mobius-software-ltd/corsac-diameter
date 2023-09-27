package com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSSessionDurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionDuration;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIAllocationResult;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3510L, vendorId = KnownVendorIDs.TGPP_ID)
public class TMGIAllocationResponseImpl extends DiameterGroupedAvpImpl implements TMGIAllocationResponse
{
	private List<TMGI> tmgi;
	
	private MBMSSessionDuration mbmsSessionDuration;
	
	private TMGIAllocationResult tmgiAllocationResult;
	
	public TMGIAllocationResponseImpl()
	{
		
	}
	
	public List<ByteBuf> getTMGI()
	{
		if(tmgi==null || tmgi.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TMGI curr:tmgi)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setTMGI(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.tmgi = null;
		else
		{
			this.tmgi = new ArrayList<TMGI>();
			for(ByteBuf curr:value)
				this.tmgi.add(new TMGIImpl(curr,null,null));
		}
	}
	
	public ByteBuf getMBMSSessionDuration()
	{
		if(mbmsSessionDuration==null)
			return null;
		
		return mbmsSessionDuration.getValue();
	}
	
	public void setMBMSSessionDuration(ByteBuf value)
	{
		if(value==null)
			this.mbmsSessionDuration = null;
		else
			this.mbmsSessionDuration = new MBMSSessionDurationImpl(value, null, null);			
	}
	
	public Long getTMGIAllocationResult()
	{
		if(tmgiAllocationResult==null)
			return null;
		
		return tmgiAllocationResult.getUnsigned();
	}
	
	public void setTMGIAllocationResult(Long value)
	{
		if(value==null)
			this.tmgiAllocationResult = null;
		else
			this.tmgiAllocationResult = new TMGIAllocationResultImpl(value, null, null);			
	}
}