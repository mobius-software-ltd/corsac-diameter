package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.commons.VendorSpecificRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterRequestWithSessionAndRealmBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
public abstract class VendorSpecificRequestmpl extends DiameterRequestWithSessionAndRealmBase implements VendorSpecificRequest
{
	protected VendorSpecificApplicationId vendorSpecificApplicationId;
	
	protected List<RouteRecord> routeRecords;
	
	protected VendorSpecificRequestmpl() 
	{
		super();
		setDestinationHostAllowed(false);
	}
		
	public VendorSpecificRequestmpl(String originHost,String originRealm,String destinationRealm,Boolean isRetransmit, String sessonID) throws AvpNotSupportedException, MissingAvpException
	{
		super(originHost, originRealm,null,destinationRealm, isRetransmit, sessonID);
		setDestinationHostAllowed(false);
	}

	@Override
	public List<String> getRouteRecords() 
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value) 
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
	}

	@Override
	public VendorSpecificApplicationId getVendorSpecificApplicationId() 
	{
		return vendorSpecificApplicationId;
	}

	@Override
	public void setVendorSpecificApplicationId(VendorSpecificApplicationId value) 
	{
		this.vendorSpecificApplicationId = value;
	}
}