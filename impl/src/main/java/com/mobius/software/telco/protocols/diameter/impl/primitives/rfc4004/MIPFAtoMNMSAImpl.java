package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoMNSPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPSessionKey;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 326L, vendorId = -1L)
public class MIPFAtoMNMSAImpl extends DiameterGroupedAvpImpl implements MIPFAtoMNMSA
{
	private MIPFAtoMNSPI mipFAtoMNSPI;
	
	private MIPAlgorithmType mipAlgorithmType;
	
	private MIPSessionKey mipSessionKey;
	
	protected MIPFAtoMNMSAImpl()
	{
		
	}
	
	public MIPFAtoMNMSAImpl(Long mipFAtoMNSPI,MIPAlgorithmTypeEnum mipAlgorithmType,ByteBuf mipSessionKey)
	{
		if(mipFAtoMNSPI==null)
			throw new IllegalArgumentException("MIP-FA-to-MN-SPI is required");
		
		if(mipAlgorithmType==null)
			throw new IllegalArgumentException("MIP-Algorithm-Type is required");
		
		if(mipSessionKey==null)
			throw new IllegalArgumentException("MIP-Session-Key is required");
		
		this.mipFAtoMNSPI = new MIPFAtoMNSPIImpl(mipFAtoMNSPI, null, null);		
		
		this.mipAlgorithmType = new MIPAlgorithmTypeImpl(mipAlgorithmType, null, null);
		
		this.mipSessionKey = new MIPSessionKeyImpl(mipSessionKey, null, null);
	}
	
	public Long getMIPFAtoMNSPI()
	{
		if(mipFAtoMNSPI == null)
			return null;
		
		return mipFAtoMNSPI.getUnsigned();
	}
	
	public void setMIPFAtoMNSPI(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("MIP-FA-to-MN-SPI is required");
		
		this.mipFAtoMNSPI = new MIPFAtoMNSPIImpl(value, null, null);		
	}
	
	public MIPAlgorithmTypeEnum getMIPAlgorithmType()
	{
		if(mipAlgorithmType == null)
			return null;
		
		return mipAlgorithmType.getEnumerated(MIPAlgorithmTypeEnum.class);
	}
	
	public void setMIPAlgorithmType(MIPAlgorithmTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("MIP-Algorithm-Type is required");
		
		this.mipAlgorithmType = new MIPAlgorithmTypeImpl(value, null, null);
	}

	@Override
	public ByteBuf getMIPSessionKey() 
	{
		if(mipSessionKey == null)
			return null;
		
		return mipSessionKey.getValue();
	}

	@Override
	public void setMIPSessionKey(ByteBuf value) 
	{
		if(value==null)
			throw new IllegalArgumentException("MIP-Session-Key is required");
		
		this.mipSessionKey = new MIPSessionKeyImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(mipFAtoMNSPI==null)
			return "MIP-FA-to-MN-SPI is required";
		
		if(mipAlgorithmType==null)
			return "MIP-Algorithm-Type is required";
		
		if(mipSessionKey==null)
			return "MIP-Session-Key is required";
		
		return null;
	}
}