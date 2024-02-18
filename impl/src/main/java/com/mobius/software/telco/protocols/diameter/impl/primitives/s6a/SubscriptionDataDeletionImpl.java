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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionDataDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceReference;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class SubscriptionDataDeletionImpl extends DiameterGroupedAvpImpl implements SubscriptionDataDeletion
{
	private DSRFlags dsrFlags;
	
	private SCEFID scefid;
	
	private List<ContextIdentifier> contextIdentifier;
	
	private TraceReference traceReference;
	
	private List<TSCode> tsCode;
	
	private List<SSCode> ssCode;
	
	protected SubscriptionDataDeletionImpl()
	{
		
	}
	
	public SubscriptionDataDeletionImpl(DSRFlags dsrFlags) throws MissingAvpException
	{
		setDSRFlags(dsrFlags);
	}
	
	public DSRFlags getDSRFlags()
	{
		return dsrFlags;
	}
	
	public void setDSRFlags(DSRFlags value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("DSR-Flags is required is required", Arrays.asList(new DiameterAvp[] { new DSRFlagsImpl() }));
		
		this.dsrFlags = value;
	}
	
	public String getSCEFID()
	{
		if(scefid == null)
			return null;
		
		return scefid.getIdentity();
	}
	
	public void setSCEFID(String value)
	{
		if(value == null)
			this.scefid = null;
		else
			this.scefid = new SCEFIDImpl(value, null, null);
	}
	
	public List<Long> getContextIdentifier()
	{
		if(contextIdentifier == null || contextIdentifier.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(ContextIdentifier curr:contextIdentifier)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setContextIdentifier(List<Long> value)
	{
		if(value == null || value.size()==0)
			this.contextIdentifier = null;
		else
		{
			this.contextIdentifier = new ArrayList<ContextIdentifier>();
			for(Long curr:value)
				this.contextIdentifier.add(new ContextIdentifierImpl(curr, null, null));					
		}
	}
	
	public ByteBuf getTraceReference()
	{
		if(traceReference == null)
			return null;
		
		return traceReference.getValue();
	}
	
	public void setTraceReference(ByteBuf value)
	{
		if(value == null)
			this.traceReference = null;
		else
			this.traceReference = new TraceReferenceImpl(value, null, null);
	}
	
	public List<ByteBuf> getTSCode()
	{
		if(tsCode == null || tsCode.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TSCode curr:tsCode)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setTSCode(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.tsCode = null;
		else
		{
			this.tsCode = new ArrayList<TSCode>();
			for(ByteBuf curr:value)
				this.tsCode.add(new TSCodeImpl(curr, null, null));					
		}
	}
	
	public List<ByteBuf> getSSCode()
	{
		if(ssCode == null || ssCode.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(SSCode curr:ssCode)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setSSCode(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.ssCode = null;
		else
		{
			this.ssCode = new ArrayList<SSCode>();
			for(ByteBuf curr:value)
				this.ssCode.add(new SSCodeImpl(curr, null, null));					
		}
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(dsrFlags==null)
			return new MissingAvpException("DSR-Flags is required is required", Arrays.asList(new DiameterAvp[] { new DSRFlagsImpl() }));
		
		return null;
	}
}