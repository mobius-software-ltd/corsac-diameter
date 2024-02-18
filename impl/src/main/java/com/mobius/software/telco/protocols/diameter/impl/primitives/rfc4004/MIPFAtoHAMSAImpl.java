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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoHASPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPSessionKey;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MIPFAtoHAMSAImpl extends DiameterGroupedAvpImpl implements MIPFAtoHAMSA
{
	private MIPFAtoHASPI mipFAtoHASPI;
	
	private MIPAlgorithmType mipAlgorithmType;
	
	private MIPSessionKey mipSessionKey;
	
	protected MIPFAtoHAMSAImpl()
	{
		
	}
	
	public MIPFAtoHAMSAImpl(Long mipFAtoHASPI,MIPAlgorithmTypeEnum mipAlgorithmType,ByteBuf mipSessionKey) throws MissingAvpException
	{
		setMIPFAtoHASPI(mipFAtoHASPI);
		
		setMIPAlgorithmType(mipAlgorithmType);
		
		setMIPSessionKey(mipSessionKey);
	}
	
	public Long getMIPFAtoHASPI()
	{
		if(mipFAtoHASPI == null)
			return null;
		
		return mipFAtoHASPI.getUnsigned();
	}
	
	public void setMIPFAtoHASPI(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-FA-to-HA-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPFAtoHASPIImpl() }));
			
		this.mipFAtoHASPI = new MIPFAtoHASPIImpl(value, null, null);		
	}
	
	public MIPAlgorithmTypeEnum getMIPAlgorithmType()
	{
		if(mipAlgorithmType == null)
			return null;
		
		return mipAlgorithmType.getEnumerated(MIPAlgorithmTypeEnum.class);
	}
	
	public void setMIPAlgorithmType(MIPAlgorithmTypeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-Algorithm-Type is required", Arrays.asList(new DiameterAvp[] { new MIPAlgorithmTypeImpl() }));
			
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
	public void setMIPSessionKey(ByteBuf value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("MIP-Session-Key is required", Arrays.asList(new DiameterAvp[] { new MIPSessionKeyImpl() }));
			
		this.mipSessionKey = new MIPSessionKeyImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mipFAtoHASPI==null)
			return new MissingAvpException("MIP-FA-to-HA-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPFAtoHASPIImpl() }));
		
		if(mipAlgorithmType==null)
			return new MissingAvpException("MIP-Algorithm-Type is required", Arrays.asList(new DiameterAvp[] { new MIPAlgorithmTypeImpl() }));
		
		if(mipSessionKey==null)
			return new MissingAvpException("MIP-Session-Key is required", Arrays.asList(new DiameterAvp[] { new MIPSessionKeyImpl() }));
		
		return null;
	}
}