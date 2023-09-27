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
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ConfidentialityKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.IntegrityKeyImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ConfidentialityKey;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.IntegrityKey;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AUTN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ItemNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RAND;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UTRANVector;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.XRES;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1415L, vendorId = KnownVendorIDs.TGPP_ID)
public class UTRANVectorImpl extends DiameterGroupedAvpImpl implements UTRANVector
{
	private ItemNumber itemNumber;
	
	private RAND rand;
	
	private XRES xres;
	
	private AUTN autn;
	
	private ConfidentialityKey confidentialityKey;
	
	private IntegrityKey integrityKey;
	
	protected UTRANVectorImpl() 
	{
	}
	
	public UTRANVectorImpl(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf confidentialityKey,ByteBuf integrityKey)
	{
		if(rand==null)
			throw new IllegalArgumentException("RAND is required");
		
		if(xres==null)
			throw new IllegalArgumentException("XRES is required");
		
		if(autn==null)
			throw new IllegalArgumentException("AUTN is required");
		
		if(confidentialityKey==null)
			throw new IllegalArgumentException("Confidentiality-Key is required");
		
		if(integrityKey==null)
			throw new IllegalArgumentException("Integrity-Key is required");
		
		this.rand = new RANDImpl(rand, null, null);				
		
		this.xres = new XRESImpl(xres, null, null);
		
		this.autn = new AUTNImpl(autn, null, null);
		
		this.confidentialityKey = new ConfidentialityKeyImpl(confidentialityKey, null, null);
		
		this.integrityKey = new IntegrityKeyImpl(integrityKey, null, null);
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
	
	public ByteBuf getConfidentialityKey()
	{
		if(confidentialityKey==null)
			return null;
		
		return confidentialityKey.getValue();
	}
	
	public void setConfidentialityKey(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Confidentiality-Key is required");
		
		this.confidentialityKey = new ConfidentialityKeyImpl(value, null, null);
	}
	
	public ByteBuf getIntegrityKey()
	{
		if(integrityKey==null)
			return null;
		
		return integrityKey.getValue();
	}
	
	public void setIntegrityKey(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Integrity-Key is required");
		
		this.integrityKey = new IntegrityKeyImpl(value, null, null);
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
		
		if(confidentialityKey==null)
			return "Confidentiality-Key is required";
		
		if(integrityKey==null)
			return "Integrity-Key is required";
		
		return null;
	}
}