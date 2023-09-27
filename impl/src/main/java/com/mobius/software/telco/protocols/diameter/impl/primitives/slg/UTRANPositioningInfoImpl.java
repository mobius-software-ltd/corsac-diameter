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
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANAdditionalPositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANGANSSPositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANPositioningData;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANPositioningInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2527L, vendorId = KnownVendorIDs.TGPP_ID)
public class UTRANPositioningInfoImpl extends DiameterGroupedAvpImpl implements UTRANPositioningInfo
{
	private UTRANPositioningData utranPositioningData;
	
	private UTRANGANSSPositioningData utranGANSSPositioningData;
	
	private UTRANAdditionalPositioningData utranAdditionalPositioningData;
	
	public UTRANPositioningInfoImpl()
	{
		
	}
	
	public ByteBuf getUTRANPositioningData()
	{
		if(utranPositioningData==null)
			return null;
		
		return utranAdditionalPositioningData.getValue();
	}
	
	public void setUTRANPositioningData(ByteBuf value)
	{
		if(value==null)
			this.utranPositioningData = null;
		else
			this.utranPositioningData = new UTRANPositioningDataImpl(value, null, null);			
	}
	
	public ByteBuf getUTRANGANSSPositioningData()
	{
		if(utranGANSSPositioningData==null)
			return null;
		
		return utranGANSSPositioningData.getValue();
	}
	
	public void setUTRANGANSSPositioningData(ByteBuf value)
	{
		if(value==null)
			this.utranGANSSPositioningData = null;
		else
			this.utranGANSSPositioningData = new UTRANGANSSPositioningDataImpl(value, null, null);			
	}
	
	public ByteBuf getUTRANAdditionalPositioningData()
	{
		if(utranAdditionalPositioningData==null)
			return null;
		
		return utranAdditionalPositioningData.getValue();
	}
	
	public void setUTRANAdditionalPositioningData(ByteBuf value)
	{
		if(value==null)
			this.utranAdditionalPositioningData = null;
		else
			this.utranAdditionalPositioningData = new UTRANAdditionalPositioningDataImpl(value, null, null);			
	}
}