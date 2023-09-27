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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.144	PoC-Information AVP
	The PoC-Information AVP (AVP code 879) is of type Grouped. Its purpose is to allow the transmission of additional PoC service specific information elements. 
	It has the following ABNF grammar:

	PoC-Information :: = 		  < AVP Header: 879>
			[ PoC-Server-Role ]
			[ PoC-Session-Type ]
			[ PoC-User-Role ]
			[ PoC-Session-Initiation-type ]
			[ PoC-Event-Type ]
			[ Number-Of-Participants ]
		* 	[ Participants-Involved ]
		* 	[ Participant-Group ]
		* 	[ Talk-Burst-Exchange ]
			[ PoC-Controlling-Address ] 
			[ PoC-Group-Name ]
			[ PoC-Session-Id ] 
			[ Charged-Party ]

	NOTE:	In the ABNF definition of PoC-Information AVP, the Participants-Involved AVP is kept only for backward compatibility with Releases before the 3GPP Release 7.
 */
@DiameterAvpDefinition(code = 879L, vendorId = KnownVendorIDs.TGPP_ID, name = "PoC-Information")
public interface PoCInformation extends DiameterAvp
{
	PoCServerRoleEnum getPoCServerRole();
	
	void setPoCServerRole(PoCServerRoleEnum value);
	
	PoCSessionTypeEnum getPoCSessionType();
	
	void setPoCSessionType(PoCSessionTypeEnum value);	
	
	PoCUserRole getPoCUserRole();
	
	void setPoCUserRole(PoCUserRole value);
	
	PoCSessionInitiationTypeEnum getPoCSessionInitiationType();
	
	void setPoCSessionInitiationType(PoCSessionInitiationTypeEnum value);
	
	PoCEventTypeEnum getPoCEventType();
	
	void setPoCEventType(PoCEventTypeEnum value);
	
	Long getNumberOfParticipants();
	
	void setNumberOfParticipants(Long value);
	
	List<String> getParticipantsInvolved();
	
	void setParticipantsInvolved(List<String> value);
	
	List<ParticipantGroup> getParticipantGroup();
	
	void setParticipantGroup(List<ParticipantGroup> value);
	
	List<TalkBurstExchange> getTalkBurstExchange();
	
	void setTalkBurstExchange(List<TalkBurstExchange> value);
	
	String getPoCControllingAddress();
	
	void setPoCControllingAddress(String value);
	
	String getPoCGroupName();
	
	void setPoCGroupName(String value);
	
	String getPoCSessionId();
	
	void setPoCSessionId(String value);
	
	String getChargedParty();
	
	void setChargedParty(String value);	
}