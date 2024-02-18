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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNSPI;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPReplayMode;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPReplayModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPSessionKey;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class MIPHAtoMNMSAImpl extends DiameterGroupedAvpImpl implements MIPHAtoMNMSA
{
	private MIPHAtoMNSPI mipHAtoMNSPI;
	
	private MIPAlgorithmType mipAlgorithmType;
	
	private MIPReplayMode mipReplayMode;
	
	private MIPSessionKey mipSessionKey;
	
	protected MIPHAtoMNMSAImpl()
	{
		
	}
	
	public MIPHAtoMNMSAImpl(Long mipHAtoMNSPI,MIPAlgorithmTypeEnum mipAlgorithmType,MIPReplayModeEnum mipReplayMode, ByteBuf mipSessionKey) throws MissingAvpException
	{
		setMIPHAtoMNSPI(mipHAtoMNSPI);
		
		setMIPAlgorithmType(mipAlgorithmType);
		
		setMIPReplayMode(mipReplayMode);
		
		setMIPSessionKey(mipSessionKey);
	}
	
	public Long getMIPHAtoMNSPI()
	{
		if(mipHAtoMNSPI == null)
			return null;
		
		return mipHAtoMNSPI.getUnsigned();
	}
	
	public void setMIPHAtoMNSPI(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-HA-to-MN-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPHAtoMNSPIImpl() }));
		
		this.mipHAtoMNSPI = new MIPHAtoMNSPIImpl(value, null, null);		
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
		if(mipHAtoMNSPI==null)
			return new MissingAvpException("MIP-HA-to-MN-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPHAtoMNSPIImpl() }));
		
		if(mipAlgorithmType==null)
			return new MissingAvpException("MIP-Algorithm-Type is required", Arrays.asList(new DiameterAvp[] { new MIPAlgorithmTypeImpl() }));
		
		if(mipReplayMode==null)
			return new MissingAvpException("MIP-Replay-Mode is required", Arrays.asList(new DiameterAvp[] { new MIPReplayModeImpl() }));
		
		if(mipSessionKey==null)
			return new MissingAvpException("MIP-Session-Key is required", Arrays.asList(new DiameterAvp[] { new MIPSessionKeyImpl() }));
		
		return null;
	}
}