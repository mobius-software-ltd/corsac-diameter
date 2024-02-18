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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargedParty;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberOfParticipants;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantGroup;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantsInvolved;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCControllingAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCEventType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCEventTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCGroupName;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCServerRole;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCServerRoleEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCSessionInitiationType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCSessionInitiationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCSessionType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCSessionTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCUserRole;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TalkBurstExchange;

/**
*
* @author yulian oifa
*
*/
public class PoCInformationImpl implements PoCInformation
{
	private PoCServerRole pocServerRole;
	private PoCSessionType pocSessionType;
	private PoCUserRole pocUserRole;
	private PoCSessionInitiationType pocSessionInitiationType;
	private PoCEventType pocEventType;
	private NumberOfParticipants numberOfParticipants;
	private List<ParticipantsInvolved> participantsInvolved;
	private List<ParticipantGroup> participantGroup;
	private List<TalkBurstExchange> talkBurstExchange;
	private PoCControllingAddress pocControllingAddress; 
	private PoCGroupName pocGroupName;
	private PoCSessionId pocSessionId; 
	private ChargedParty chargedParty;
			
	public PoCInformationImpl()
	{
		
	}
	
	public PoCServerRoleEnum getPoCServerRole()
	{
		if(pocServerRole==null)
			return null;
		
		return pocServerRole.getEnumerated(PoCServerRoleEnum.class);
	}
	
	public void setPoCServerRole(PoCServerRoleEnum value)
	{
		if(value==null)
			this.pocServerRole = null;
		else
			this.pocServerRole = new PoCServerRoleImpl(value, null, null);			
	}
	
	public PoCSessionTypeEnum getPoCSessionType()
	{
		if(pocSessionType==null)
			return null;
		
		return pocSessionType.getEnumerated(PoCSessionTypeEnum.class);
	}
	
	public void setPoCSessionType(PoCSessionTypeEnum value)
	{
		if(value==null)
			this.pocSessionType = null;
		else
			this.pocSessionType = new PoCSessionTypeImpl(value, null, null);			
	}	
	
	public PoCUserRole getPoCUserRole()
	{
		return pocUserRole;
	}
	
	public void setPoCUserRole(PoCUserRole value)
	{
		this.pocUserRole = value;
	}
	
	public PoCSessionInitiationTypeEnum getPoCSessionInitiationType()
	{
		if(pocSessionInitiationType==null)
			return null;
		
		return pocSessionInitiationType.getEnumerated(PoCSessionInitiationTypeEnum.class);
	}
	
	public void setPoCSessionInitiationType(PoCSessionInitiationTypeEnum value)
	{
		if(value==null)
			this.pocSessionInitiationType = null;
		else
			this.pocSessionInitiationType = new PoCSessionInitiationTypeImpl(value, null, null);			
	}
	
	public PoCEventTypeEnum getPoCEventType()
	{
		if(pocEventType==null)
			return null;
		
		return pocEventType.getEnumerated(PoCEventTypeEnum.class);
	}
	
	public void setPoCEventType(PoCEventTypeEnum value)
	{
		if(value==null)
			this.pocEventType = null;
		else
			this.pocEventType = new PoCEventTypeImpl(value, null, null);			
	}
	
	public Long getNumberOfParticipants()
	{
		if(numberOfParticipants==null)
			return null;
		
		return numberOfParticipants.getUnsigned();
	}
	
	public void setNumberOfParticipants(Long value)
	{
		if(value==null)
			this.numberOfParticipants = null;
		else
			this.numberOfParticipants = new NumberOfParticipantsImpl(value, null, null);			
	}
	
	public List<String> getParticipantsInvolved()
	{
		if(participantsInvolved==null || participantsInvolved.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ParticipantsInvolved curr:participantsInvolved)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setParticipantsInvolved(List<String> value)
	{
		if(value==null || value.size()==0)
			this.participantsInvolved = null;
		else
		{
			this.participantsInvolved = new ArrayList<ParticipantsInvolved>();
			for(String curr: value)
				this.participantsInvolved.add(new ParticipantsInvolvedImpl(curr, null, null));			
		}
	}
	
	public List<ParticipantGroup> getParticipantGroup()
	{
		return this.participantGroup;
	}
	
	public void setParticipantGroup(List<ParticipantGroup> value)
	{
		this.participantGroup = value;
	}
	
	public List<TalkBurstExchange> getTalkBurstExchange()
	{
		return this.talkBurstExchange;
	}
	
	public void setTalkBurstExchange(List<TalkBurstExchange> value)
	{
		this.talkBurstExchange = value;
	}
	
	public String getPoCControllingAddress()
	{
		if(pocControllingAddress==null)
			return null;
		
		return pocControllingAddress.getString();
	}
	
	public void setPoCControllingAddress(String value)
	{
		if(value==null)
			this.pocControllingAddress = null;
		else
			this.pocControllingAddress = new PoCControllingAddressImpl(value, null, null);			
	}
	
	public String getPoCGroupName()
	{
		if(pocGroupName==null)
			return null;
		
		return pocGroupName.getString();
	}
	
	public void setPoCGroupName(String value)
	{
		if(value==null)
			this.pocGroupName = null;
		else
			this.pocGroupName = new PoCGroupNameImpl(value, null, null);			
	}
	
	public String getPoCSessionId()
	{
		if(pocSessionId==null)
			return null;
		
		return pocSessionId.getString();
	}
	
	public void setPoCSessionId(String value)
	{
		if(value==null)
			this.pocSessionId = null;
		else
			this.pocSessionId = new PoCSessionIdImpl(value, null, null);			
	}
	
	public String getChargedParty()
	{
		if(chargedParty==null)
			return null;
		
		return chargedParty.getString();
	}
	
	public void setChargedParty(String value)
	{
		if(value==null)
			this.chargedParty = null;
		else
			this.chargedParty = new ChargedPartyImpl(value, null, null);			
	}
}