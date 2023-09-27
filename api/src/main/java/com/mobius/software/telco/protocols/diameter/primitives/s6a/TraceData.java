package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.63	Trace-Data AVP
	The Trace-Data AVP is of type Grouped. This AVP shall contain the information related to trace function.
	AVP format

	Trace-Data ::= <AVP header: 1458 10415>
			 {Trace-Reference}
			 {Trace-Depth}
			 {Trace-NE-Type-List}
			 [Trace-Interface-List]
			 {Trace-Event-List}
			 [OMC-Id]
			 {Trace-Collection-Entity}
			 [MDT-Configuration]
			*[AVP]
 */
@DiameterAvpDefinition(code = 1458L, vendorId = KnownVendorIDs.TGPP_ID, name = "Trace-Data")
public interface TraceData extends DiameterGroupedAvp
{
	ByteBuf getTraceReference();
	
	void setTraceReference(ByteBuf value);	
	
	TraceDepthEnum getTraceDepth();
	
	void setTraceDepth(TraceDepthEnum value);
	
	ByteBuf getTraceNETypeList();
	
	void setTraceNETypeList(ByteBuf value);
	
	ByteBuf getTraceInterfaceList();
	
	void setTraceInterfaceList(ByteBuf value);
	
	ByteBuf getTraceEventList();
	
	void setTraceEventList(ByteBuf value);
	
	ByteBuf getOMCId();
	
	void setOMCId(ByteBuf value);
	
	InetAddress getTraceCollectionEntity();
	
	void setTraceCollectionEntity(InetAddress value);

	MDTConfiguration getMDTConfiguration();
	
	void setMDTConfiguration(MDTConfiguration value);
}