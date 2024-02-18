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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AreaScope;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CellGlobalIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EUTRANCellGlobalIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocationAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RoutingAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TrackingAreaIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AreaScopeImpl extends DiameterGroupedAvpImpl implements AreaScope
{
	private List<CellGlobalIdentity> cellGlobalIdentity;
	
	private List<EUTRANCellGlobalIdentity> eutranCellGlobalIdentity;
	
	private List<RoutingAreaIdentity> routingAreaIdentity;
	
	private List<LocationAreaIdentity> locationAreaIdentity;
	
	private List<TrackingAreaIdentity> trackingAreaIdentity;
	
	public AreaScopeImpl()
	{
		
	}
	
	public List<ByteBuf> getCellGlobalIdentity()
	{
		if(cellGlobalIdentity==null)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(CellGlobalIdentity curr:this.cellGlobalIdentity)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setCellGlobalIdentity(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.cellGlobalIdentity = null;
		else
		{
			this.cellGlobalIdentity = new ArrayList<CellGlobalIdentity>();
			for(ByteBuf curr:value)
				this.cellGlobalIdentity.add(new CellGlobalIdentityImpl(curr, null, null));			
		}
	}
	
	public List<ByteBuf> getEUTRANCellGlobalIdentity()
	{
		if(eutranCellGlobalIdentity==null)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(EUTRANCellGlobalIdentity curr:this.eutranCellGlobalIdentity)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setEUTRANCellGlobalIdentity(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.eutranCellGlobalIdentity = null;
		else
		{
			this.eutranCellGlobalIdentity = new ArrayList<EUTRANCellGlobalIdentity>();
			for(ByteBuf curr:value)
				this.eutranCellGlobalIdentity.add(new EUTRANCellGlobalIdentityImpl(curr, null, null));			
		}
	}
	
	public List<ByteBuf> getRoutingAreaIdentity()
	{
		if(routingAreaIdentity==null)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(RoutingAreaIdentity curr:this.routingAreaIdentity)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setRoutingAreaIdentity(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.routingAreaIdentity = null;
		else
		{
			this.routingAreaIdentity = new ArrayList<RoutingAreaIdentity>();
			for(ByteBuf curr:value)
				this.routingAreaIdentity.add(new RoutingAreaIdentityImpl(curr, null, null));			
		}
	}
	
	public List<ByteBuf> getLocationAreaIdentity()
	{
		if(locationAreaIdentity==null)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(LocationAreaIdentity curr:this.locationAreaIdentity)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setLocationAreaIdentity(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.locationAreaIdentity = null;
		else
		{
			this.locationAreaIdentity = new ArrayList<LocationAreaIdentity>();
			for(ByteBuf curr:value)
				this.locationAreaIdentity.add(new LocationAreaIdentityImpl(curr, null, null));			
		}
	}
	
	public List<ByteBuf> getTrackingAreaIdentity()
	{
		if(trackingAreaIdentity==null)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TrackingAreaIdentity curr:this.trackingAreaIdentity)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setTrackingAreaIdentity(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.trackingAreaIdentity = null;
		else
		{
			this.trackingAreaIdentity = new ArrayList<TrackingAreaIdentity>();
			for(ByteBuf curr:value)
				this.trackingAreaIdentity.add(new TrackingAreaIdentityImpl(curr, null, null));			
		}
	}
}