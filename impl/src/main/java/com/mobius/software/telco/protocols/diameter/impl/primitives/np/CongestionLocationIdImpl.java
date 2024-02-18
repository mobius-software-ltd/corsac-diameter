package com.mobius.software.telco.protocols.diameter.impl.primitives.np;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLocationId;
import com.mobius.software.telco.protocols.diameter.primitives.np.ENodeBId;
import com.mobius.software.telco.protocols.diameter.primitives.np.ExtendedENodeBId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class CongestionLocationIdImpl extends DiameterGroupedAvpImpl implements CongestionLocationId
{
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private ENodeBId eNodeBId;
	
	private ExtendedENodeBId extendedENodeBId;
	
	public CongestionLocationIdImpl()
	{
		
	}
	
	public ByteBuf getTGPPUserLocationInfo()
	{
		if(tgppUserLocationInfo == null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void setTGPPUserLocationInfo(ByteBuf value)
	{
		if(value == null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);
	}
	
	public ByteBuf getENodeBId()
	{
		if(eNodeBId == null)
			return null;
		
		return eNodeBId.getValue();
	}
	
	public void setENodeBId(ByteBuf value)
	{
		if(value == null)
			this.eNodeBId = null;
		else
			this.eNodeBId = new ENodeBIdImpl(value, null, null);
	}
	
	public ByteBuf getExtendedENodeBId()
	{
		if(extendedENodeBId == null)
			return null;
		
		return extendedENodeBId.getValue();
	}
	
	public void setExtendedENodeBId(ByteBuf value)
	{
		if(value == null)
			this.extendedENodeBId = null;
		else
			this.extendedENodeBId = new ExtendedENodeBIdImpl(value, null, null);
	}
}