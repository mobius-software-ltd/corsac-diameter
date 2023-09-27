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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CalledPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantAccessPriority;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantAccessPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantGroup;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserParticipatingType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserParticipatingTypeEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1260L, vendorId = KnownVendorIDs.TGPP_ID)
public class ParticipantGroupImpl implements ParticipantGroup
{
	private CalledPartyAddress calledPartyAddress;
	private ParticipantAccessPriority participantAccessPriority;
	private UserParticipatingType userParticipatingType;
		
	public ParticipantGroupImpl()
	{
		
	}
	
	public String getCalledPartyAddress()
	{
		if(calledPartyAddress==null)
			return null;
		
		return calledPartyAddress.getString();
	}
	
	public void setCalledPartyAddress(String value)
	{
		if(value==null)
			this.calledPartyAddress = null;
		else
			this.calledPartyAddress = new CalledPartyAddressImpl(value, null, null);			
	}
	
	public ParticipantAccessPriorityEnum getParticipantAccessPriority()
	{
		if(participantAccessPriority==null)
			return null;
		
		return participantAccessPriority.getEnumerated(ParticipantAccessPriorityEnum.class);
	}
	
	public void setParticipantAccessPriority(ParticipantAccessPriorityEnum value)
	{
		if(value==null)
			this.participantAccessPriority = null;
		else
			this.participantAccessPriority = new ParticipantAccessPriorityImpl(value, null, null);			
	}
	
	public UserParticipatingTypeEnum getUserParticipatingType()
	{
		if(userParticipatingType==null)
			return null;
		
		return userParticipatingType.getEnumerated(UserParticipatingTypeEnum.class);
	}
	
	public void setUserParticipatingType(UserParticipatingTypeEnum value)
	{
		if(value==null)
			this.userParticipatingType = null;
		else
			this.userParticipatingType = new UserParticipatingTypeImpl(value, null, null);			
	}
}