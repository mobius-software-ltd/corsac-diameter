package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6a.DeleteSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ContextIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.DSRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SSCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TSCodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceReferenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXRelatedRAT;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TSCode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceReference;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;

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
@DiameterCommandImplementation(applicationId = 16777251, commandCode = 320, request = true)
public class DeleteSubscriberDataRequestImpl extends S6aRequestImpl implements DeleteSubscriberDataRequest
{
	private DSRFlags dsrFlags;
	
	private SCEFID scefID;
	
	private List<ContextIdentifier> contextIdentifier;
	
	private TraceReference traceReference;
	
	private List<TSCode> tsCode;
	
	private List<SSCode> ssCode;
	
	private EDRXRelatedRAT edrxRelatedRAT;
	
	private List<ExternalIdentifier> externalIdentifier;
	
	protected DeleteSubscriberDataRequestImpl() 
	{
		super();
	}
	
	public DeleteSubscriberDataRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,Long dsrFlags)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setDSRFlags(dsrFlags);
	}
	
	@Override
	public Long getDSRFlags()
	{
		if(dsrFlags == null)
			return null;
		
		return dsrFlags.getUnsigned();
	}
	
	@Override
	public void setDSRFlags(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("DSR-Flags is required");
		
		this.dsrFlags = new DSRFlagsImpl(value, null, null);
	}
	
	@Override
	public String getSCEFID()
	{
		if(scefID == null)
			return null;
		
		return scefID.getIdentity();
	}
	 
	@Override
	public void setSCEFID(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("SCEF-ID is required");
		
		this.scefID = new SCEFIDImpl(value, null, null);
	}
		
	@Override
	public List<Long> getContextIdentifier()
	{
		if(contextIdentifier==null || contextIdentifier.size()==0)
			return null;
	
		List<Long> result = new ArrayList<Long>();
		for(ContextIdentifier curr: contextIdentifier)
			result.add(curr.getUnsigned());
	
		return result;
	}
	
	@Override
	public void setContextIdentifier(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.contextIdentifier = null;
		else
		{	
			this.contextIdentifier = new ArrayList<ContextIdentifier>();
			for(Long curr:value)
				this.contextIdentifier.add(new ContextIdentifierImpl(curr, null, null));
		}
	}
	
	@Override
	public ByteBuf getTraceReference()
	{
		if(traceReference == null)
			return null;
		
		return traceReference.getValue();
	}
	
	@Override
	public void setTraceReference(ByteBuf value)
	{
		if(value == null)
			this.traceReference = null;
		else
			this.traceReference = new TraceReferenceImpl(value, null, null);
	}
		
	@Override
	public List<ByteBuf> getTSCode()
	{
		if(tsCode==null || tsCode.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TSCode curr: tsCode)
			result.add(curr.getValue());
		
		return result;
	}
	
	@Override
	public void setTSCode(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.tsCode = null;
		else
		{	
			this.tsCode = new ArrayList<TSCode>();
			for(ByteBuf curr:value)
				this.tsCode.add(new TSCodeImpl(curr, null, null));
		}
	}
		
	@Override
	public List<ByteBuf> getSSCode()
	{
		if(ssCode==null || ssCode.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(SSCode curr: ssCode)
			result.add(curr.getValue());
		
		return result;
	}
	
	@Override
	public void setSSCode(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.ssCode = null;
		else
		{	
			this.ssCode = new ArrayList<SSCode>();
			for(ByteBuf curr:value)
				this.ssCode.add(new SSCodeImpl(curr, null, null));
		}
	}
	
	@Override
	public EDRXRelatedRAT getEDRXRelatedRAT()
	{
		return this.edrxRelatedRAT;
	}
	 
	@Override
	public void setEDRXRelatedRAT(EDRXRelatedRAT value)
	{
		this.edrxRelatedRAT = value;
	}
	
	@Override
	public List<String> getExternalIdentifier()
	{
		if(externalIdentifier==null || externalIdentifier.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ExternalIdentifier curr: externalIdentifier)
			result.add(curr.getString());
		
		return result;
	}
	
	@Override
	public void setExternalIdentifier(List<String> value)
	{
		if(value==null || value.size()==0)
			this.externalIdentifier = null;
		else
		{	
			this.externalIdentifier = new ArrayList<ExternalIdentifier>();
			for(String curr:value)
				this.externalIdentifier.add(new ExternalIdentifierImpl(curr, null, null));
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		if(dsrFlags == null)
			return "DSR-Flags is required";
		
		return super.validate();
	}	
}