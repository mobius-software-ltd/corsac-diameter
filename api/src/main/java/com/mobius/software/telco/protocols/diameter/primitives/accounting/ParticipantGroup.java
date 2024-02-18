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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.131	Participant-Group AVP
	The Participant-Group AVP (AVP code 1260) is of type Grouped and holds detailed information, e.g. the address (Public User ID: SIP URI, Tel URI, MSISDN), the access priority parameters, etc, of the party who is involved into the PoC session.
	It has the following ABNF grammar:

	< Participant-Group > ::  =	< AVP Header: 1260>
		[ Called-Party-Address ]
		[ Participant-Access-Priority ]
		[ User-Participating-Type ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PARTICIPANT_GROUP, vendorId = VendorIDs.TGPP_ID, name = "Participant-Group")
public interface ParticipantGroup extends DiameterAvp
{
	String getCalledPartyAddress();
	
	void setCalledPartyAddress(String value);
	
	ParticipantAccessPriorityEnum getParticipantAccessPriority();
	
	void setParticipantAccessPriority(ParticipantAccessPriorityEnum value);	
	
	UserParticipatingTypeEnum getUserParticipatingType();
	
	void setUserParticipatingType(UserParticipatingTypeEnum value);
}