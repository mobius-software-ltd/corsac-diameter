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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class GERANVectorImpl extends DiameterGroupedAvpImpl implements GERANVector
{
	private ItemNumber itemNumber;
	
	private RAND rand;
	
	private SRES sres;
	
	private Kc kc;
	
	protected GERANVectorImpl() 
	{
	}
	
	public GERANVectorImpl(ByteBuf rand,ByteBuf sres,ByteBuf kc) throws MissingAvpException
	{
		setRAND(rand);
		
		setSRES(sres);
		
		setKc(kc);
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
	
	public void setRAND(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("RAND is required", Arrays.asList(new DiameterAvp[] { new RANDImpl() }));
			
		this.rand = new RANDImpl(value, null, null);	
	}
	
	public ByteBuf getSRES()
	{
		if(sres==null)
			return null;
		
		return sres.getValue();
	}
	
	public void setSRES(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SRES is required", Arrays.asList(new DiameterAvp[] { new SRESImpl() }));
			
		this.sres = new SRESImpl(value, null, null);
	}
	
	public ByteBuf getKc()
	{
		if(kc==null)
			return null;
		
		return kc.getValue();
	}
	
	public void setKc(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Kc is required", Arrays.asList(new DiameterAvp[] { new KcImpl() }));
		
		this.kc = new KcImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(rand==null)
			return new MissingAvpException("RAND is required", Arrays.asList(new DiameterAvp[] { new RANDImpl() }));
		
		if(sres==null)
			return new MissingAvpException("SRES is required", Arrays.asList(new DiameterAvp[] { new SRESImpl() }));
		
		if(kc==null)
			return new MissingAvpException("Kc is required", Arrays.asList(new DiameterAvp[] { new KcImpl() }));
		
		return null;
	}
}