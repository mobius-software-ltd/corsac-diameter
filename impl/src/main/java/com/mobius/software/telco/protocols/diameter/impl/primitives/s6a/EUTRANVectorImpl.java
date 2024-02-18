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
	
	public EUTRANVectorImpl(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf kasme) throws MissingAvpException
	{
		setRAND(rand);
		
		setXRES(xres);
		
		setAUTN(autn);
		
		setKASME(kasme);
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
	
	public ByteBuf getXRES()
	{
		if(xres==null)
			return null;
		
		return xres.getValue();
	}
	
	public void setXRES(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("XRES is required", Arrays.asList(new DiameterAvp[] { new XRESImpl() }));
			
		this.xres = new XRESImpl(value, null, null);
	}
	
	public ByteBuf getAUTN()
	{
		if(autn==null)
			return null;
		
		return autn.getValue();
	}
	
	public void setAUTN(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("AUTN is required", Arrays.asList(new DiameterAvp[] { new AUTNImpl() }));
			
		this.autn = new AUTNImpl(value, null, null);
	}
	
	public ByteBuf getKASME()
	{
		if(kasme==null)
			return null;
		
		return kasme.getValue();
	}
	
	public void setKASME(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("KASME is required", Arrays.asList(new DiameterAvp[] { new KASMEImpl() }));
			
		this.kasme = new KASMEImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(rand==null)
			return new MissingAvpException("RAND is required", Arrays.asList(new DiameterAvp[] { new RANDImpl() }));
		
		if(xres==null)
			return new MissingAvpException("XRES is required", Arrays.asList(new DiameterAvp[] { new XRESImpl() }));
		
		if(autn==null)
			return new MissingAvpException("AUTN is required", Arrays.asList(new DiameterAvp[] { new AUTNImpl() }));
		
		if(kasme==null)
			return new MissingAvpException("KASME is required", Arrays.asList(new DiameterAvp[] { new KASMEImpl() }));
		
		return null;
	}
}