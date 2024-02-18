package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MIC;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCode;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.UTCBasedCounter;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ProSeAppCodeInfoImpl extends DiameterGroupedAvpImpl implements ProSeAppCodeInfo
{
	private ProSeAppCode proSeAppCode;
	private MIC mic;
	private UTCBasedCounter utcBasedCounter;
	 
	protected ProSeAppCodeInfoImpl() 
	{
	}
	
	public ProSeAppCodeInfoImpl(ByteBuf proSeAppCode,ByteBuf mic,Long utcBasedCounter) throws MissingAvpException
	{
		setProSeAppCode(proSeAppCode);
		
		setMIC(mic);
		
		setUTCBasedCounter(utcBasedCounter);
	}
	
	public ByteBuf getProSeAppCode()
	{
		if(proSeAppCode==null)
			return null;
		
		return proSeAppCode.getValue();
	}
	
	public void setProSeAppCode(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("ProSe-App-Code is required is required", Arrays.asList(new DiameterAvp[] { new ProSeAppCodeImpl() }));
		
		this.proSeAppCode = new ProSeAppCodeImpl(value, null, null);								
	}
	
	public ByteBuf getMIC()
	{
		if(mic==null)
			return null;
		
		return mic.getValue();
	}
	
	public void setMIC(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIC is required is required", Arrays.asList(new DiameterAvp[] { new MICImpl() }));
		
		this.mic = new MICImpl(value, null, null);
	}
	
	public Long getUTCBasedCounter()
	{
		if(utcBasedCounter==null)
			return null;
		
		return utcBasedCounter.getUnsigned();
	}
	
	public void setUTCBasedCounter(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("UTC-based-Counter is required is required", Arrays.asList(new DiameterAvp[] { new UTCBasedCounterImpl() }));
		
		this.utcBasedCounter = new UTCBasedCounterImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(proSeAppCode==null)
			return new MissingAvpException("ProSe-App-Code is required is required", Arrays.asList(new DiameterAvp[] { new ProSeAppCodeImpl() }));
		
		if(mic==null)
			return new MissingAvpException("MIC is required is required", Arrays.asList(new DiameterAvp[] { new MICImpl() }));
		
		if(utcBasedCounter==null)
			return new MissingAvpException("UTC-based-Counter is required is required", Arrays.asList(new DiameterAvp[] { new UTCBasedCounterImpl() }));
		
		return null;
	}
}