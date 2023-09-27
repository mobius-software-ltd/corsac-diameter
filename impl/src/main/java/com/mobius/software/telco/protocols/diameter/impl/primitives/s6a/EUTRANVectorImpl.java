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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AUTN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EUTRANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ItemNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.KASME;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RAND;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.XRES;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1414L, vendorId = KnownVendorIDs.TGPP_ID)
public class EUTRANVectorImpl extends DiameterGroupedAvpImpl implements EUTRANVector
{
	private ItemNumber itemNumber;
	
	private RAND rand;
	
	private XRES xres;
	
	private AUTN autn;
	
	private KASME kasme;
	
	protected EUTRANVectorImpl() 
	{
	}
	
	public EUTRANVectorImpl(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf kasme)
	{
		if(rand==null)
			throw new IllegalArgumentException("RAND is required");
		
		if(xres==null)
			throw new IllegalArgumentException("XRES is required");
		
		if(autn==null)
			throw new IllegalArgumentException("AUTN is required");
		
		if(kasme==null)
			throw new IllegalArgumentException("KASME is required");
		
		this.rand = new RANDImpl(rand, null, null);				
		
		this.xres = new XRESImpl(xres, null, null);
		
		this.autn = new AUTNImpl(autn, null, null);
		
		this.kasme = new KASMEImpl(kasme, null, null);
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
	
	public ByteBuf getXRES()
	{
		if(xres==null)
			return null;
		
		return xres.getValue();
	}
	
	public void setXRES(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("XRES is required");
		
		this.xres = new XRESImpl(value, null, null);
	}
	
	public ByteBuf getAUTN()
	{
		if(autn==null)
			return null;
		
		return autn.getValue();
	}
	
	public void setAUTN(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("AUTN is required");
		
		this.autn = new AUTNImpl(value, null, null);
	}
	
	public ByteBuf getKASME()
	{
		if(kasme==null)
			return null;
		
		return kasme.getValue();
	}
	
	public void setKASME(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("KASME is required");
		
		this.kasme = new KASMEImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(rand==null)
			return "RAND is required";
		
		if(xres==null)
			return "XRES is required";
		
		if(autn==null)
			return "AUTN is required";
		
		if(kasme==null)
			return "KASME is required";
		
		return null;
	}
}