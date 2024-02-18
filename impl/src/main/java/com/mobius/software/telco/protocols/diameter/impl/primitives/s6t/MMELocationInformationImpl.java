package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.ENodeBIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.ExtendedENodeBIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AgeOfLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CurrentLocationRetrievedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EUTRANCellGlobalIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TrackingAreaIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.np.ENodeBId;
import com.mobius.software.telco.protocols.diameter.primitives.np.ExtendedENodeBId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AgeOfLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CurrentLocationRetrieved;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CurrentLocationRetrievedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EUTRANCellGlobalIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TrackingAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MMELocationInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

public class MMELocationInformationImpl extends DiameterGroupedAvpImpl implements MMELocationInformation
{
	private EUTRANCellGlobalIdentity eutranCellGlobalIdentity;
	private TrackingAreaIdentity trackingAreaIdentity;
	private CurrentLocationRetrieved currentLocationRetrieved;
	private AgeOfLocationInformation ageOfLocationInformation;
	private UserCSGInformation userCSGInformation;
	private ENodeBId eNodeBID;
	private ExtendedENodeBId extendedeNodeBID;
	
	public MMELocationInformationImpl()
	{
		
	}
	
	public ByteBuf getEUTRANCellGlobalIdentity()
	{
		if(eutranCellGlobalIdentity == null)
			return null;
		
		return eutranCellGlobalIdentity.getValue();
	}
	
	public void setEUTRANCellGlobalIdentity(ByteBuf value)
	{
		if(value == null)
			this.eutranCellGlobalIdentity = null;
		else
			this.eutranCellGlobalIdentity = new EUTRANCellGlobalIdentityImpl(value, null, null);
	}
	
	public ByteBuf getTrackingAreaIdentity()
	{
		if(trackingAreaIdentity == null)
			return null;
		
		return trackingAreaIdentity.getValue();
	}
	
	public void setTrackingAreaIdentity(ByteBuf value)
	{
		if(value == null)
			this.trackingAreaIdentity = null;
		else
			this.trackingAreaIdentity = new TrackingAreaIdentityImpl(value, null, null);
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
	
	public ByteBuf getENodeBId()
	{
		if(eNodeBID == null)
			return null;
		
		return eNodeBID.getValue();
	}
	
	public void setENodeBId(ByteBuf value)
	{
		if(value == null)
			this.eNodeBID = null;
		else
			this.eNodeBID = new ENodeBIdImpl(value, null, null);
	}
	
	public ByteBuf getExtendedENodeBId()
	{
		if(extendedeNodeBID == null)
			return null;
		
		return extendedeNodeBID.getValue();
	}
	
	public void setExtendedENodeBId(ByteBuf value)
	{
		if(value == null)
			this.extendedeNodeBID = null;
		else
			this.extendedeNodeBID = new ExtendedENodeBIdImpl(value, null, null);
	}
}