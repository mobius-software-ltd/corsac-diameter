package com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004;

import java.net.InetAddress;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.rfc4004.Rfc4004Request;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMobileNodeAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPRegRequestImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMobileNodeAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPOriginatingForeignAAA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPRegRequest;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
public abstract class Rfc4004RequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationRequestWithHostImpl implements Rfc4004Request
{
	protected MIPRegRequest mipRegRequest;
	
	protected MIPOriginatingForeignAAA mipOriginatingForeignAAA;
	
	protected MIPHomeAgentAddress mipHomeAgentAddress;
	
	protected MIPMobileNodeAddress mipMobileNodeAddress;
	
	protected Rfc4004RequestImpl() 
	{
		super();
	}
	
	public Rfc4004RequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, ByteBuf mipRegRequest) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setMIPRegRequest(mipRegRequest);		
	}
	
	@Override
	public ByteBuf getMIPRegRequest() 
	{
		if(mipRegRequest == null)
			return null;
		
		return mipRegRequest.getValue();
	}
	
	@Override
	public void setMIPRegRequest(ByteBuf value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("MIP-Reg-Request is required", Arrays.asList(new DiameterAvp[] { new MIPRegRequestImpl() }));
			
		this.mipRegRequest = new MIPRegRequestImpl(value, null, null);
	}
	
	@Override
	public MIPOriginatingForeignAAA getMIPOriginatingForeignAAA() 
	{
		return mipOriginatingForeignAAA;
	}
	
	@Override
	public void setMIPOriginatingForeignAAA(MIPOriginatingForeignAAA value)
	{
		this.mipOriginatingForeignAAA = value;
	}
	

	@Override
	public InetAddress getMIPMobileNodeAddress() 
	{
		if(mipMobileNodeAddress == null)
			return null;
		
		return mipMobileNodeAddress.getAddress();
	}
	
	@Override
	public void setMIPMobileNodeAddress(InetAddress value)
	{
		if(value == null)
			this.mipMobileNodeAddress = null;
		else
			this.mipMobileNodeAddress = new MIPMobileNodeAddressImpl(value, null, null);
	}
	
	@Override
	public InetAddress getMIPHomeAgentAddress() 
	{
		if(mipHomeAgentAddress == null)
			return null;
		
		return mipHomeAgentAddress.getAddress();
	}
	
	@Override
	public void setMIPHomeAgentAddress(InetAddress value)
	{
		if(value == null)
			this.mipHomeAgentAddress = null;
		else
			this.mipHomeAgentAddress = new MIPHomeAgentAddressImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mipRegRequest == null)
			return new MissingAvpException("MIP-Reg-Request is required", Arrays.asList(new DiameterAvp[] { new MIPRegRequestImpl() }));
		
		return super.validate();
	}
}