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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.TMGIExpiry;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3515L, vendorId = KnownVendorIDs.TGPP_ID)
public class TMGIExpiryImpl extends DiameterGroupedAvpImpl implements TMGIExpiry
{
	private List<TMGI> tmgi;
	
	protected TMGIExpiryImpl()
	{
		
	}
	
	public TMGIExpiryImpl(List<ByteBuf> tmgi)
	{
		if(tmgi==null || tmgi.size()==0)
			throw new IllegalArgumentException("TMGI is required");
		
		this.tmgi = new ArrayList<TMGI>();
		for(ByteBuf curr:tmgi)
			this.tmgi.add(new TMGIImpl(curr, null, null));	
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
			throw new IllegalArgumentException("TMGI is required");
		
		this.tmgi = new ArrayList<TMGI>();
		for(ByteBuf curr:value)
			this.tmgi.add(new TMGIImpl(curr, null, null));
	}
	
	@DiameterValidate
	public String validate()
	{
		if(tmgi==null || tmgi.size()==0)
			return "TMGI is required";
		
		return null;
	}
}