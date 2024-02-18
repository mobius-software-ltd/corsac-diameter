package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessNetworkInfoChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessNetworkInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CellularNetworkInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeTime;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AccessNetworkInfoChangeImpl implements AccessNetworkInfoChange
{
	private List<AccessNetworkInformation> accessNetworkInformation;
	private CellularNetworkInformation cellularNetworkInformation;
	private ChangeTime changeTime;
		
	public AccessNetworkInfoChangeImpl()
	{
		
	}
	
	public List<ByteBuf> getAccessNetworkInformation()
	{
		if(accessNetworkInformation==null || accessNetworkInformation.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(AccessNetworkInformation curr:accessNetworkInformation)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setAccessNetworkInformation(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.accessNetworkInformation = null;
		else
		{
			this.accessNetworkInformation = new ArrayList<AccessNetworkInformation>();
			for(ByteBuf curr:value)
				this.accessNetworkInformation.add(new AccessNetworkInformationImpl(curr, null, null));
		}
	}
	
	public ByteBuf getCellularNetworkInformation()
	{
		if(cellularNetworkInformation==null)
			return null;
		
		return cellularNetworkInformation.getValue();
	}
	
	public void setCellularNetworkInformation(ByteBuf value)
	{
		if(value==null)
			this.cellularNetworkInformation = null;
		else
			this.cellularNetworkInformation = new CellularNetworkInformationImpl(value, null, null);			
	}
	
	public Date getChangeTime()
	{
		if(changeTime==null)
			return null;
		
		return changeTime.getDateTime();
	}
	
	public void setChangeTime(Date value)
	{
		if(value==null)
			this.changeTime = null;
		else
			this.changeTime = new ChangeTimeImpl(value, null, null);			
	}
}