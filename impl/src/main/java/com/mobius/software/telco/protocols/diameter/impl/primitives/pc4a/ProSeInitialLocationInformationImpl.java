package com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.AgeOfLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EUTRANCellGlobalIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.TrackingAreaIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MMENameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeInitialLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AgeOfLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EUTRANCellGlobalIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TrackingAreaIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMEName;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ProSeInitialLocationInformationImpl extends DiameterGroupedAvpImpl implements ProSeInitialLocationInformation
{
	private MMEName mmeName;
	
	private EUTRANCellGlobalIdentity eutranCellGlobalIdentity;
	
	private TrackingAreaIdentity trackingAreaIdentity;
	
	private AgeOfLocationInformation ageOfLocationInformation;
	
	public ProSeInitialLocationInformationImpl()
	{
		super();
	}
	
	public String getMMEName()
	{
		if(mmeName == null)
			return null;
		
		return mmeName.getIdentity();
	}
	
	public void setMMEName(String value)
	{
		if(value == null)
			this.mmeName = null;
		else
			this.mmeName = new MMENameImpl(value, null, null);
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
}