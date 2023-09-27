package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.220	Talk-Burst-Exchange AVP
	The Talk-Burst-Exchange AVP (AVP code 1255) is of type Grouped and holds the talk burst related charging data.
	It has the following ABNF grammar:
	 
	Talk-Burst-Exchange ::	=	< AVP Header: 1255 >
		{ PoC-Change-Time }
		[ Number-Of-Talk-Bursts ]
		[ Talk-Burst-Volume ]
		[ Talk-Burst-Time ]
		[ Number-Of-Received-Talk-Bursts ]
		[ Received-Talk-Burst-Volume ]
		[ Received-Talk-Burst-Time ]
		[ Number-Of-Participants ]
		[ PoC-Change-Condition ]
 */
@DiameterAvpDefinition(code = 1255L, vendorId = KnownVendorIDs.TGPP_ID, name = "Talk-Burst-Exchange")
public interface TalkBurstExchange extends DiameterAvp
{
	Date getPoCChangeTime();
	
	void setPoCChangeTime(Date value);
	
	Long getNumberOfTalkBursts();
	
	void setNumberOfTalkBursts(Long value);
	
	Long getTalkBurstVolume();
	
	void setTalkBurstVolume(Long value);
	
	Long getTalkBurstTime();
	
	void setTalkBurstTime(Long value);
	
	Long getNumberOfReceivedTalkBursts();
	
	void setNumberOfReceivedTalkBursts(Long value);
	
	Long getReceivedTalkBurstVolume();
	
	void setReceivedTalkBurstVolume(Long value);
	
	Long getReceivedTalkBurstTime();
	
	void setReceivedTalkBurstTime(Long value);
	
	Long getNumberOfParticipants();
	
	void setNumberOfParticipants(Long value);
	
	PoCChangeConditionEnum getPoCChangeCondition();
	
	void setPoCChangeCondition(PoCChangeConditionEnum value);
}