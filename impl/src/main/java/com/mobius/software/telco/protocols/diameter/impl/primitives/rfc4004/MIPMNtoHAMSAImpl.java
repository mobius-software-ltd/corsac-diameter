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
 * MERCMNNTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.MIPMNHASPIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPNonce;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPReplayMode;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPReplayModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPMNHASPI;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MIPMNtoHAMSAImpl extends DiameterGroupedAvpImpl implements MIPMNtoHAMSA
{
	private MIPMNHASPI mipMNtoHASPI;
	
	private MIPAlgorithmType mipAlgorithmType;
	
	private MIPReplayMode mipReplayMode;
	
	private MIPNonce mipNonce;
	
	protected MIPMNtoHAMSAImpl()
	{
		
	}
	
	public MIPMNtoHAMSAImpl(Long mipMNtoHASPI,MIPAlgorithmTypeEnum mipAlgorithmType,MIPReplayModeEnum mipReplayMode, ByteBuf mipNonce) throws MissingAvpException
	{
		setMIPMNHASPI(mipMNtoHASPI);
		
		setMIPAlgorithmType(mipAlgorithmType);
		
		setMIPReplayMode(mipReplayMode);
		
		setMIPNonce(mipNonce);
	}
	
	public Long getMIPMNHASPI()
	{
		if(mipMNtoHASPI == null)
			return null;
		
		return mipMNtoHASPI.getUnsigned();
	}
	
	public void setMIPMNHASPI(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-MN-to-HA-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPMNHASPIImpl() }));
		
		this.mipMNtoHASPI = new MIPMNHASPIImpl(value, null, null);		
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
	
	public MIPReplayModeEnum getMIPReplayMode()
	{
		if(mipReplayMode == null)
			return null;
		
		return mipReplayMode.getEnumerated(MIPReplayModeEnum.class);
	}
	
	public void setMIPReplayMode(MIPReplayModeEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-Replay-Mode is required", Arrays.asList(new DiameterAvp[] { new MIPReplayModeImpl() }));
		
		this.mipReplayMode = new MIPReplayModeImpl(value, null, null);
	}

	@Override
	public ByteBuf getMIPNonce() 
	{
		if(mipNonce == null)
			return null;
		
		return mipNonce.getValue();
	}

	@Override
	public void setMIPNonce(ByteBuf value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("MIP-Nonce is required", Arrays.asList(new DiameterAvp[] { new MIPNonceImpl() }));
		
		this.mipNonce = new MIPNonceImpl(value, null, null);
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mipMNtoHASPI==null)
			return new MissingAvpException("MIP-MN-to-HA-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPMNHASPIImpl() }));
		
		if(mipAlgorithmType==null)
			return new MissingAvpException("MIP-Algorithm-Type is required", Arrays.asList(new DiameterAvp[] { new MIPAlgorithmTypeImpl() }));
		
		if(mipReplayMode==null)
			return new MissingAvpException("MIP-Replay-Mode is required", Arrays.asList(new DiameterAvp[] { new MIPReplayModeImpl() }));
		
		if(mipNonce==null)
			return new MissingAvpException("MIP-Nonce is required", Arrays.asList(new DiameterAvp[] { new MIPNonceImpl() }));
		
		return null;
	}
}