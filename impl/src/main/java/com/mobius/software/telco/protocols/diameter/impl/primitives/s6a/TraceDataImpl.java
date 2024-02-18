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

import java.net.InetAddress;
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MDTConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.OMCId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceCollectionEntity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepth;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceDepthEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceEventList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceInterfaceList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceNETypeList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceReference;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TraceDataImpl extends DiameterGroupedAvpImpl implements TraceData
{
	private TraceReference traceReference;
	
	private TraceDepth traceDepth;
	
	private TraceNETypeList traceNETypeList;
	
	private TraceInterfaceList traceInterfaceList;
	
	private TraceEventList traceEventList;
	
	private OMCId omcId;
	
	private TraceCollectionEntity traceCollectionEntity;
	
	private MDTConfiguration mdtConfiguration;
	
	protected TraceDataImpl()
	{
		
	}
	
	public TraceDataImpl(ByteBuf traceReference,TraceDepthEnum traceDepth,ByteBuf traceNETypeList,ByteBuf traceEventList,InetAddress traceCollectionEntity) throws MissingAvpException
	{
		setTraceReference(traceReference);
		
		setTraceDepth(traceDepth);
		
		setTraceNETypeList(traceNETypeList);
		
		setTraceEventList(traceEventList);
		
		setTraceCollectionEntity(traceCollectionEntity);
	}
	
	public ByteBuf getTraceReference()
	{
		if(traceReference==null)
			return null;
		
		return traceReference.getValue();
	}
	
	public void setTraceReference(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Trace-Reference is required is required", Arrays.asList(new DiameterAvp[] { new TraceReferenceImpl() }));
		
		this.traceReference = new TraceReferenceImpl(value, null, null);	
	}	
	
	public TraceDepthEnum getTraceDepth()
	{
		if(traceDepth==null)
			return null;
		
		return traceDepth.getEnumerated(TraceDepthEnum.class);
	}
	
	public void setTraceDepth(TraceDepthEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Trace-Depth is required is required", Arrays.asList(new DiameterAvp[] { new TraceDepthImpl() }));
		
		this.traceDepth = new TraceDepthImpl(value, null, null);
	}
	
	public ByteBuf getTraceNETypeList()
	{
		if(traceNETypeList==null)
			return null;
		
		return traceNETypeList.getValue();
	}
	
	public void setTraceNETypeList(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Trace-NE-Type-List is required is required", Arrays.asList(new DiameterAvp[] { new TraceNETypeListImpl() }));
		
		this.traceNETypeList = new TraceNETypeListImpl(value, null, null);
	}
	
	public ByteBuf getTraceInterfaceList()
	{
		if(traceInterfaceList==null)
			return null;
		
		return traceInterfaceList.getValue();
	}
	
	public void setTraceInterfaceList(ByteBuf value)
	{
		if(value == null)
			this.traceInterfaceList = null;
		else
			this.traceInterfaceList = new TraceInterfaceListImpl(value, null, null);
	}
	
	public ByteBuf getTraceEventList()
	{
		if(traceEventList==null)
			return null;
		
		return traceEventList.getValue();
	}
	
	public void setTraceEventList(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Trace-Event-List is required is required", Arrays.asList(new DiameterAvp[] { new TraceEventListImpl() }));
		
		this.traceEventList = new TraceEventListImpl(value, null, null);
	}
	
	public ByteBuf getOMCId()
	{
		if(omcId==null)
			return null;
		
		return omcId.getValue();
	}
	
	public void setOMCId(ByteBuf value)
	{
		if(value == null)
			this.omcId = null;
		else
			this.omcId = new OMCIdImpl(value, null, null);
	}
	
	public InetAddress getTraceCollectionEntity()
	{
		if(traceCollectionEntity==null)
			return null;
		
		return traceCollectionEntity.getAddress();
	}
	
	public void setTraceCollectionEntity(InetAddress value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Trace-Collection-Entity is required is required", Arrays.asList(new DiameterAvp[] { new TraceCollectionEntityImpl() }));
			
		this.traceCollectionEntity = new TraceCollectionEntityImpl(value, null, null);
	}

	public MDTConfiguration getMDTConfiguration()
	{
		return mdtConfiguration;
	}
	
	public void setMDTConfiguration(MDTConfiguration value)
	{
		this.mdtConfiguration = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(traceReference==null)
			return new MissingAvpException("Trace-Reference is required is required", Arrays.asList(new DiameterAvp[] { new TraceReferenceImpl() }));
		
		if(traceDepth==null)
			return new MissingAvpException("Trace-Depth is required is required", Arrays.asList(new DiameterAvp[] { new TraceDepthImpl() }));
		
		if(traceNETypeList==null)
			return new MissingAvpException("Trace-NE-Type-List is required is required", Arrays.asList(new DiameterAvp[] { new TraceNETypeListImpl() }));
		
		if(traceEventList==null)
			return new MissingAvpException("Trace-Event-List is required is required", Arrays.asList(new DiameterAvp[] { new TraceEventListImpl() }));
		
		if(traceCollectionEntity==null)
			return new MissingAvpException("Trace-Collection-Entity is required is required", Arrays.asList(new DiameterAvp[] { new TraceCollectionEntityImpl() }));
		
		return null;
	}
}