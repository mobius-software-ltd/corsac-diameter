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
import com.mobius.software.telco.protocols.diameter.primitives.slg.CellPortionID;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ECGI;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ESMLCCellInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2552L, vendorId = KnownVendorIDs.TGPP_ID)
public class ESMLCCellInfoImpl extends DiameterGroupedAvpImpl implements ESMLCCellInfo
{
	private ECGI ecgi;
	
	private CellPortionID cellPortionID;
	
	public ESMLCCellInfoImpl()
	{
		
	}
	
	public ByteBuf getECGI()
	{
		if(ecgi==null)
			return null;
		
		return ecgi.getValue();
	}
	
	public void setECGI(ByteBuf value)
	{
		if(value==null)
			this.ecgi = null;
		else
			this.ecgi = new ECGIImpl(value, null, null);			
	}
	
	public Long getCellPortionID()
	{
		if(cellPortionID==null)
			return null;
		
		return cellPortionID.getUnsigned();
	}
	
	public void setCellPortionID(Long value)
	{
		if(value==null)
			this.cellPortionID = null;
		else
			this.cellPortionID = new CellPortionIDImpl(value, null, null);			
	}
}