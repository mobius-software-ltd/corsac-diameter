package com.mobius.software.telco.protocols.diameter.impl.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPAlgorithm;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPAuth;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPIdent;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CHAPResponse;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 402L, vendorId = -1L)
public class CHAPAuthImpl extends DiameterGroupedAvpImpl implements CHAPAuth
{
	private CHAPAlgorithm chapAlgorithm;
	
	private CHAPIdent chapIdent;
	
	private CHAPResponse chapResponse;
	
	protected CHAPAuthImpl() 
	{
		super();
	}
	
	public CHAPAuthImpl(ByteBuf chapAlgorithm, ByteBuf chapIdent, ByteBuf chapResponse)
	{
		super();
		
		if(chapAlgorithm==null)
			throw new IllegalArgumentException("CHAP-Algorithm is required");
		
		if(chapIdent==null)
			throw new IllegalArgumentException("CHAP-Ident is required");
		
		this.chapAlgorithm = new CHAPAlgorithmImpl(chapAlgorithm, null, null);
		
		this.chapIdent = new CHAPIdentImpl(chapIdent, null, null);
		
		if(chapResponse!=null)
			this.chapResponse = new CHAPResponseImpl(chapResponse, null, null);			
	}
	
	public ByteBuf getCHAPAlgorithm() 
	{
		if(chapAlgorithm == null)
			return null;
		
		return chapAlgorithm.getValue();
	}
	
	public void setCHAPAlgorithm(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("CHAP-Algorithm is required");
		
		this.chapAlgorithm = new CHAPAlgorithmImpl(value, null, null);		
	}
	
	public ByteBuf getCHAPIdent()
	{
		if(chapIdent == null)
			return null;
		
		return chapIdent.getValue();
	}
	
	public void setCHAPIdent(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("CHAP-Ident is required");
		
		this.chapIdent = new CHAPIdentImpl(value, null, null);
	}
	
	public ByteBuf getCHAPResponse()
	{
		if(chapResponse == null)
			return null;
		
		return chapResponse.getValue();
	}
	
	public void setCHAPResponse(ByteBuf value)
	{
		if(value!=null)
			this.chapResponse = new CHAPResponseImpl(value, null, null);	
		else
			this.chapResponse = null;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(chapAlgorithm==null)
			return "CHAP-Algorithm is required";
		
		if(chapIdent==null)
			return "CHAP-Ident is required";
		
		return null;
	}
}