package com.mobius.software.telco.protocols.diameter.impl.primitives.swx;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TraceReferenceImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TraceReference;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TraceInfoImpl extends DiameterGroupedAvpImpl implements TraceInfo
{
	private TraceData traceData;
	
	private TraceReference traceReference;
	
	public TraceInfoImpl()
	{
		
	}
	
	public TraceData getTraceData()
	{
		return traceData;
	}
	
	public void setTraceData(TraceData value)
	{
		this.traceData = value;				
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
}