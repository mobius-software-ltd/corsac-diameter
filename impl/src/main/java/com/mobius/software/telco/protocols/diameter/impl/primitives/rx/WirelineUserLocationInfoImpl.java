package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rx.GLIIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.HFCNodeIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.LineType;
import com.mobius.software.telco.protocols.diameter.primitives.rx.LineTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.WirelineUserLocationInfo;

import io.netty.buffer.ByteBuf;

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

/**
*
* @author yulian oifa
*
*/
public class WirelineUserLocationInfoImpl extends DiameterGroupedAvpImpl implements WirelineUserLocationInfo
{
	private HFCNodeIdentifier hfcNodeIdentifier;
	
	private GLIIdentifier gliIdentifier;
	
	private LineType lineType;
	
	public WirelineUserLocationInfoImpl()
	{
		
	}
	
	public ByteBuf getHFCNodeIdentifier()
	{
		if(hfcNodeIdentifier == null)
			return null;
		
		return hfcNodeIdentifier.getValue();
	}
	
	public void setHFCNodeIdentifier(ByteBuf value)
	{
		if(value==null)
			this.hfcNodeIdentifier = null;
		else
			this.hfcNodeIdentifier = new HFCNodeIdentifierImpl(value, null, null);	
	}
	
	public ByteBuf getGLIIdentifier()
	{
		if(gliIdentifier == null)
			return null;
		
		return gliIdentifier.getValue();
	}
	
	public void setGLIIdentifier(ByteBuf value)
	{
		if(value==null)
			this.gliIdentifier = null;
		else
			this.gliIdentifier = new GLIIdentifierImpl(value, null, null);	
	}
	
	public LineTypeEnum getLineType()
	{
		if(lineType == null)
			return null;
		
		return lineType.getEnumerated(LineTypeEnum.class);
	}
	
	public void setLineType(LineTypeEnum value)
	{
		if(value==null)
			this.lineType = null;
		else
			this.lineType = new LineTypeImpl(value, null, null);	
	}														
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(hfcNodeIdentifier);
		result.add(gliIdentifier);
		result.add(lineType);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}