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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.219	Supplementary-Service AVP
	The Supplementary-Service AVP (AVP code 2048) is of type Grouped and holds the specific supplementary service details for one MMTel supplementary service.
	It has the following ABNF grammar:

	Supplementary-Service :: =   < AVP Header: 2048>
			[ MMTel-SService-Type ]
			[ Service-Mode ]
			[ Number-Of-Diversions ]
			[ Associated-Party-Address ]
			[ Service-ID ]
			[ Change-Time ]
			[ Number-Of-Participants ]
			[ Participant-Action-Type ]
			[ CUG-Information ]
			[ AoC-Information ]
 */
@DiameterAvpDefinition(code = 2048L, vendorId = KnownVendorIDs.TGPP_ID, name = "Supplementary-Service")
public interface SupplementaryService extends DiameterAvp
{
	MMTelSServiceTypeEnum getMMTelSServiceType();
	
	void setMMTelSServiceType(MMTelSServiceTypeEnum value);
	
	ServiceModeEnum getServiceMode();
	
	void setServiceMode(ServiceModeEnum value);
	
	Long getNumberOfDiversions();
	
	void setNumberOfDiversions(Long value);
	
	String getAssociatedPartyAddress();
	
	void setAssociatedPartyAddress(String value);
	
	String getServiceID();
	
	void setServiceID(String value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
	
	Long getNumberOfParticipants();
	
	void setNumberOfParticipants(Long value);
	
	ParticipantActionTypeEnum getParticipantActionType();
	
	void setParticipantActionType(ParticipantActionTypeEnum value);
	
	ByteBuf getCUGInformation();
	
	void setCUGInformation(ByteBuf value);
	
	AoCInformation getAoCInformation();
	
	void setAoCInformation(AoCInformation value);
}