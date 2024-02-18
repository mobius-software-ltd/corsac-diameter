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
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ConfidentialityKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.IntegrityKeyImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
	
	public UTRANVectorImpl(ByteBuf rand,ByteBuf xres,ByteBuf autn,ByteBuf confidentialityKey,ByteBuf integrityKey) throws MissingAvpException
	{
		setRAND(rand);
		
		setXRES(xres);
		
		setAUTN(autn);
		
		setConfidentialityKey(confidentialityKey);
		
		setIntegrityKey(integrityKey);		
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
			throw new MissingAvpException("RAND is required is required", Arrays.asList(new DiameterAvp[] { new RANDImpl() }));
		
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
			throw new MissingAvpException("XRES is required is required", Arrays.asList(new DiameterAvp[] { new XRESImpl() }));
			
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
			throw new MissingAvpException("AUTN is required is required", Arrays.asList(new DiameterAvp[] { new AUTNImpl() }));
		
		this.autn = new AUTNImpl(value, null, null);
	}
	
	public ByteBuf getConfidentialityKey()
	{
		if(confidentialityKey==null)
			return null;
		
		return confidentialityKey.getValue();
	}
	
	public void setConfidentialityKey(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Confidentiality-Key is required is required", Arrays.asList(new DiameterAvp[] { new ConfidentialityKeyImpl() }));
			
		this.confidentialityKey = new ConfidentialityKeyImpl(value, null, null);
	}
	
	public ByteBuf getIntegrityKey()
	{
		if(integrityKey==null)
			return null;
		
		return integrityKey.getValue();
	}
	
	public void setIntegrityKey(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Integrity-Key is required is required", Arrays.asList(new DiameterAvp[] { new IntegrityKeyImpl() }));
		
		this.integrityKey = new IntegrityKeyImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(rand==null)
			return new MissingAvpException("RAND is required is required", Arrays.asList(new DiameterAvp[] { new RANDImpl() }));
		
		if(xres==null)
			return new MissingAvpException("XRES is required is required", Arrays.asList(new DiameterAvp[] { new XRESImpl() }));
		
		if(autn==null)
			return new MissingAvpException("AUTN is required is required", Arrays.asList(new DiameterAvp[] { new AUTNImpl() }));
		
		if(confidentialityKey==null)
			return new MissingAvpException("Confidentiality-Key is required is required", Arrays.asList(new DiameterAvp[] { new ConfidentialityKeyImpl() }));
		
		if(integrityKey==null)
			return new MissingAvpException("Integrity-Key is required is required", Arrays.asList(new DiameterAvp[] { new IntegrityKeyImpl() }));
		
		return null;
	}
}