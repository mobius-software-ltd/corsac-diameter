package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANGANSSPositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANPositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANPositioningInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2524L, vendorId = KnownVendorIDs.TGPP_ID)
public class GERANPositioningInfoImpl extends DiameterGroupedAvpImpl implements GERANPositioningInfo
{
	private GERANPositioningData geranPositioningData;
	
	private GERANGANSSPositioningData geranGANSSPositioningData;
	
	public GERANPositioningInfoImpl()
	{
		
	}
	
	public ByteBuf getGERANPositioningData()
	{
		if(geranPositioningData==null)
			return null;
		
		return geranPositioningData.getValue();
	}
	
	public void setGERANPositioningData(ByteBuf value)
	{
		if(value==null)
			this.geranPositioningData = null;
		else
			this.geranPositioningData = new GERANPositioningDataImpl(value, null, null);			
	}
	
	public ByteBuf getGERANGANSSPositioningData()
	{
		if(geranGANSSPositioningData==null)
			return null;
		
		return geranGANSSPositioningData.getValue();
	}
	
	public void setGERANGANSSPositioningData(ByteBuf value)
	{
		if(value==null)
			this.geranGANSSPositioningData = null;
		else
			this.geranGANSSPositioningData = new GERANGANSSPositioningDataImpl(value, null, null);			
	}
}