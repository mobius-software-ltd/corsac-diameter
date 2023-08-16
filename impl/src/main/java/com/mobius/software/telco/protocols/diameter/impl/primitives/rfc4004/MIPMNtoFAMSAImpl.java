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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNFASPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPNonce;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 325L, vendorId = -1L)
public class MIPMNtoFAMSAImpl extends DiameterGroupedAvpImpl implements MIPMNtoFAMSA
{
	private MIPMNFASPI mipMNtoFASPI;
	
	private MIPAlgorithmType mipAlgorithmType;
	
	private MIPNonce mipNonce;
	
	public MIPMNtoFAMSAImpl(Long mipMNtoFASPI,MIPAlgorithmTypeEnum mipAlgorithmType,ByteBuf mipNonce)
	{
		if(mipMNtoFASPI==null)
			throw new IllegalArgumentException("MIP-MN-to-FA-SPI is required");
		
		if(mipAlgorithmType==null)
			throw new IllegalArgumentException("MIP-Algorithm-Type is required");
		
		if(mipNonce==null)
			throw new IllegalArgumentException("MIP-Nonce is required");
		
		this.mipMNtoFASPI = new MIPMNFASPIImpl(mipMNtoFASPI, null, null);		
		
		this.mipAlgorithmType = new MIPAlgorithmTypeImpl(mipAlgorithmType, null, null);
		
		this.mipNonce = new MIPNonceImpl(mipNonce, null, null);
	}
	
	public Long getMIPMNFASPI()
	{
		if(mipMNtoFASPI == null)
			return null;
		
		return mipMNtoFASPI.getUnsigned();
	}
	
	public void setMIPMNFASPI(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("MIP-MN-to-FA-SPI is required");
		
		this.mipMNtoFASPI = new MIPMNFASPIImpl(value, null, null);		
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
	public ByteBuf getMIPNonce() 
	{
		if(mipNonce == null)
			return null;
		
		return mipNonce.getValue();
	}

	@Override
	public void setMIPNonce(ByteBuf value) 
	{
		if(value==null)
			throw new IllegalArgumentException("MIP-Nonce is required");
		
		this.mipNonce = new MIPNonceImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(mipMNtoFASPI==null)
			return "MIP-MN-to-FA-SPI is required";
		
		if(mipAlgorithmType==null)
			return "MIP-Algorithm-Type is required";
		
		if(mipNonce==null)
			return "MIP-Nonce is required";
		
		return null;
	}
}