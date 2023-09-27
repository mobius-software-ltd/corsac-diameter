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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AgeOfLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CellGlobalIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CurrentLocationRetrieved;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CurrentLocationRetrievedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GeodeticInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.GeographicalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LocationAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RoutingAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ServiceAreaIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1601L, vendorId = KnownVendorIDs.TGPP_ID)
public class SGSNLocationInformationImpl extends DiameterGroupedAvpImpl implements SGSNLocationInformation
{
	private CellGlobalIdentity cellGlobalIdentity;
	private LocationAreaIdentity locationAreaIdentity;
	private ServiceAreaIdentity serviceAreaIdentity;
	private RoutingAreaIdentity routingAreaIdentity;
	private GeographicalInformation geographicalInformation;
	private GeodeticInformation geodeticInformation;
	private CurrentLocationRetrieved currentLocationRetrieved;
	private AgeOfLocationInformation ageOfLocationInformation;
	private UserCSGInformation userCSGInformation;
	
	public SGSNLocationInformationImpl()
	{
		
	}
	
	public ByteBuf getCellGlobalIdentity()
	{
		if(cellGlobalIdentity == null)
			return null;
		
		return cellGlobalIdentity.getValue();
	}
	
	public void setCellGlobalIdentity(ByteBuf value)
	{
		if(value == null)
			this.cellGlobalIdentity = null;
		else
			this.cellGlobalIdentity = new CellGlobalIdentityImpl(value, null, null);
	}
	
	public ByteBuf getLocationAreaIdentity()
	{
		if(locationAreaIdentity == null)
			return null;
		
		return locationAreaIdentity.getValue();
	}
	
	public void setLocationAreaIdentity(ByteBuf value)
	{
		if(value == null)
			this.locationAreaIdentity = null;
		else
			this.locationAreaIdentity = new LocationAreaIdentityImpl(value, null, null);
	}
	
	public ByteBuf getServiceAreaIdentity()
	{
		if(serviceAreaIdentity == null)
			return null;
		
		return serviceAreaIdentity.getValue();
	}
	
	public void setServiceAreaIdentity(ByteBuf value)
	{
		if(value == null)
			this.serviceAreaIdentity = null;
		else
			this.serviceAreaIdentity = new ServiceAreaIdentityImpl(value, null, null);
	}
	
	public ByteBuf getRoutingAreaIdentity()
	{
		if(routingAreaIdentity == null)
			return null;
		
		return routingAreaIdentity.getValue();
	}
	
	public void setRoutingAreaIdentity(ByteBuf value)
	{
		if(value == null)
			this.routingAreaIdentity = null;
		else
			this.routingAreaIdentity = new RoutingAreaIdentityImpl(value, null, null);
	}
	
	public ByteBuf getGeographicalInformation()
	{
		if(geographicalInformation == null)
			return null;
		
		return geographicalInformation.getValue();
	}
	
	public void setGeographicalInformation(ByteBuf value)
	{
		if(value == null)
			this.geographicalInformation = null;
		else
			this.geographicalInformation = new GeographicalInformationImpl(value, null, null);
	}
	
	public ByteBuf getGeodeticInformation()
	{
		if(geodeticInformation == null)
			return null;
		
		return geodeticInformation.getValue();
	}
	
	public void setGeodeticInformation(ByteBuf value)
	{
		if(value == null)
			this.geodeticInformation = null;
		else
			this.geodeticInformation = new GeodeticInformationImpl(value, null, null);
	}
	
	public CurrentLocationRetrievedEnum getCurrentLocationRetrieved()
	{
		if(currentLocationRetrieved == null)
			return null;
		
		return currentLocationRetrieved.getEnumerated(CurrentLocationRetrievedEnum.class);
	}
	
	public void setCurrentLocationRetrieved(CurrentLocationRetrievedEnum value)
	{
		if(value == null)
			this.currentLocationRetrieved = null;
		else
			this.currentLocationRetrieved = new CurrentLocationRetrievedImpl(value, null, null);
	}
	
	public Long getAgeOfLocationInformation()
	{
		if(ageOfLocationInformation == null)
			return null;
		
		return ageOfLocationInformation.getUnsigned();
	}
	
	public void setAgeOfLocationInformation(Long value)
	{
		if(value == null)
			this.ageOfLocationInformation = null;
		else
			this.ageOfLocationInformation = new AgeOfLocationInformationImpl(value, null, null);
	}
	
	public UserCSGInformation getUserCSGInformation()
	{
		return userCSGInformation;
	}
	
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
}