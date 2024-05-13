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

import java.util.Arrays;
import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberOfParticipants;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberOfReceivedTalkBursts;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberOfTalkBursts;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCChangeCondition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCChangeConditionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReceivedTalkBurstTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReceivedTalkBurstVolume;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TalkBurstExchange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TalkBurstTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TalkBurstVolume;

/**
*
* @author yulian oifa
*
*/
public class TalkBurstExchangeImpl extends DiameterAvpImpl implements TalkBurstExchange
{
	private PoCChangeTime pocChangeTime;
	private NumberOfTalkBursts numberOfTalkBursts;
	private TalkBurstVolume talkBurstVolume;
	private TalkBurstTime talkBurstTime;
	private NumberOfReceivedTalkBursts numberOfReceivedTalkBursts;
	private ReceivedTalkBurstVolume receivedTalkBurstVolume;
	private ReceivedTalkBurstTime receivedTalkBurstTime;
	private NumberOfParticipants numberOfParticipants;
	private PoCChangeCondition pocChangeCondition;
	
	protected TalkBurstExchangeImpl() 
	{
	}
	
	public TalkBurstExchangeImpl(Date pocChangeTime) throws MissingAvpException
	{
		setPoCChangeTime(pocChangeTime);
	}
			
	public Date getPoCChangeTime()
	{
		if(pocChangeTime==null)
			return null;
		
		return pocChangeTime.getDateTime();
	}
	
	public void setPoCChangeTime(Date value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("PoC-Change-Time is required is required", Arrays.asList(new DiameterAvp[] { new PoCChangeTimeImpl() }));
		
		this.pocChangeTime = new PoCChangeTimeImpl(value, null, null);		
	}
	
	public Long getNumberOfTalkBursts()
	{
		if(numberOfTalkBursts==null)
			return null;
		
		return numberOfTalkBursts.getUnsigned();
	}
	
	public void setNumberOfTalkBursts(Long value)
	{
		if(value==null)
			this.numberOfTalkBursts = null;
		else
			this.numberOfTalkBursts = new NumberOfTalkBurstsImpl(value, null, null);			
	}
	
	public Long getTalkBurstVolume()
	{
		if(talkBurstVolume==null)
			return null;
		
		return talkBurstVolume.getUnsigned();
	}
	
	public void setTalkBurstVolume(Long value)
	{
		if(value==null)
			this.talkBurstVolume = null;
		else
			this.talkBurstVolume = new TalkBurstVolumeImpl(value, null, null);			
	}
	
	public Long getTalkBurstTime()
	{
		if(talkBurstTime==null)
			return null;
		
		return talkBurstTime.getUnsigned();
	}
	
	public void setTalkBurstTime(Long value)
	{
		if(value==null)
			this.talkBurstTime = null;
		else
			this.talkBurstTime = new TalkBurstTimeImpl(value, null, null);			
	}
	
	public Long getNumberOfReceivedTalkBursts()
	{
		if(numberOfReceivedTalkBursts==null)
			return null;
		
		return numberOfReceivedTalkBursts.getUnsigned();
	}
	
	public void setNumberOfReceivedTalkBursts(Long value)
	{
		if(value==null)
			this.numberOfReceivedTalkBursts = null;
		else
			this.numberOfReceivedTalkBursts = new NumberOfReceivedTalkBurstsImpl(value, null, null);			
	}
	
	public Long getReceivedTalkBurstVolume()
	{
		if(receivedTalkBurstVolume==null)
			return null;
		
		return receivedTalkBurstVolume.getUnsigned();
	}
	
	public void setReceivedTalkBurstVolume(Long value)
	{
		if(value==null)
			this.receivedTalkBurstVolume = null;
		else
			this.receivedTalkBurstVolume = new ReceivedTalkBurstVolumeImpl(value, null, null);			
	}
	
	public Long getReceivedTalkBurstTime()
	{
		if(receivedTalkBurstTime==null)
			return null;
		
		return receivedTalkBurstTime.getUnsigned();
	}
	
	public void setReceivedTalkBurstTime(Long value)
	{
		if(value==null)
			this.receivedTalkBurstTime = null;
		else
			this.receivedTalkBurstTime = new ReceivedTalkBurstTimeImpl(value, null, null);			
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
	
	public PoCChangeConditionEnum getPoCChangeCondition()
	{
		if(pocChangeCondition==null)
			return null;
		
		return pocChangeCondition.getEnumerated(PoCChangeConditionEnum.class);
	}
	
	public void setPoCChangeCondition(PoCChangeConditionEnum value)
	{
		if(value==null)
			this.pocChangeCondition = null;
		else
			this.pocChangeCondition = new PoCChangeConditionImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(pocChangeTime==null)
			return new MissingAvpException("PoC-Change-Time is required is required", Arrays.asList(new DiameterAvp[] { new PoCChangeTimeImpl() }));
		
		return null;
	}
}