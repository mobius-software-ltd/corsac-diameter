package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GERANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ItemNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.Kc;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RAND;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SRES;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1416L, vendorId = KnownVendorIDs.TGPP_ID)
public class GERANVectorImpl extends DiameterGroupedAvpImpl implements GERANVector
{
	private ItemNumber itemNumber;
	
	private RAND rand;
	
	private SRES sres;
	
	private Kc kc;
	
	protected GERANVectorImpl() 
	{
	}
	
	public GERANVectorImpl(ByteBuf rand,ByteBuf sres,ByteBuf kc)
	{
		if(rand==null)
			throw new IllegalArgumentException("RAND is required");
		
		if(sres==null)
			throw new IllegalArgumentException("SRES is required");
		
		if(kc==null)
			throw new IllegalArgumentException("Kc is required");
		
		this.rand = new RANDImpl(rand, null, null);				
		
		this.sres = new SRESImpl(sres, null, null);
		
		this.kc = new KcImpl(kc, null, null);		
	}
	
	public Long getItemNumber()
	{
		if(itemNumber==null)
			return null;
		
		return itemNumber.getUnsigned();
	}
	
	public void setItemNumber(Long value)
	{
		if(value == null)
			this.itemNumber = null;
		else 
			this.itemNumber = new ItemNumberImpl(value, null, null);
	}
	
	public ByteBuf getRAND()
	{
		if(rand==null)
			return null;
		
		return rand.getValue();
	}
	
	public void setRAND(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("RAND is required");
		
		this.rand = new RANDImpl(value, null, null);	
	}
	
	public ByteBuf getSRES()
	{
		if(sres==null)
			return null;
		
		return sres.getValue();
	}
	
	public void setSRES(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("SRES is required");
		
		this.sres = new SRESImpl(value, null, null);
	}
	
	public ByteBuf getKc()
	{
		if(kc==null)
			return null;
		
		return kc.getValue();
	}
	
	public void setKc(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Kc is required");
		
		this.kc = new KcImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(rand==null)
			return "RAND is required";
		
		if(sres==null)
			return "SRES is required";
		
		if(kc==null)
			return "Kc is required";
		
		return null;
	}
}