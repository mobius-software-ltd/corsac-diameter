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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
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
@DiameterAvpImplementation(code = 3835L, vendorId = KnownVendorIDs.TGPP_ID)
public class ProSeAppCodeInfoImpl extends DiameterGroupedAvpImpl implements ProSeAppCodeInfo
{
	private ProSeAppCode proSeAppCode;
	private MIC mic;
	private UTCBasedCounter utcBasedCounter;
	 
	protected ProSeAppCodeInfoImpl() 
	{
	}
	
	public ProSeAppCodeInfoImpl(ByteBuf proSeAppCode,ByteBuf mic,Long utcBasedCounter)
	{
		if(proSeAppCode==null)
			throw new IllegalArgumentException("ProSe-App-Code is required");
		
		if(mic==null)
			throw new IllegalArgumentException("MIC is required");
		
		if(utcBasedCounter==null)
			throw new IllegalArgumentException("UTC-based-Counter is required");
		
		this.proSeAppCode = new ProSeAppCodeImpl(proSeAppCode, null, null);						
		
		this.mic = new MICImpl(mic, null, null);
		
		this.utcBasedCounter = new UTCBasedCounterImpl(utcBasedCounter, null, null);
	}
	
	public ByteBuf getProSeAppCode()
	{
		if(proSeAppCode==null)
			return null;
		
		return proSeAppCode.getValue();
	}
	
	public void setProSeAppCode(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("ProSe-App-Code is required");
		
		this.proSeAppCode = new ProSeAppCodeImpl(value, null, null);								
	}
	
	public ByteBuf getMIC()
	{
		if(mic==null)
			return null;
		
		return mic.getValue();
	}
	
	public void setMIC(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("MIC is required");
		
		this.mic = new MICImpl(value, null, null);
	}
	
	public Long getUTCBasedCounter()
	{
		if(utcBasedCounter==null)
			return null;
		
		return utcBasedCounter.getUnsigned();
	}
	
	public void setUTCBasedCounter(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("UTC-based-Counter is required");
		
		this.utcBasedCounter = new UTCBasedCounterImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(proSeAppCode==null)
			return "ProSe-App-Code is required";
		
		if(mic==null)
			return "MIC is required";
		
		if(utcBasedCounter==null)
			return "UTC-based-Counter is required";
		
		return null;
	}
}