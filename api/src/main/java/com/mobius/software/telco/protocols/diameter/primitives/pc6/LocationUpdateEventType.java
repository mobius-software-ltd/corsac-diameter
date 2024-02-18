package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.43	Location-Update-Event-Type
	The Location-Update-Event-Type AVP is of type Unsigned32 and contains an 32-bit address space representing types of events that will trigger a location update. The following values are defined:

	UE_AVAILABLE (0)
	This value shall be used to indicate that the location update trigger is any event in which the MSC/SGSN/MME has established a contact with the UE.

	CHANGE_OF_AREA (1)
	This value shall be used to indicate that the location update trigger is an event where the UE enters or leaves a pre-defined geographical area or if the UE is currently within the pre-defined geographical area.

	PERIODIC_LOCATION (2)
	This value shall be used to indicate that the location update trigger is an event where a defined periodic timer expires in the UE and activates a location report or a location request

	The types of event listed above are defined in the clause 4.4.2.1 of the 3GPP TS 23.271 [24] 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LOCATION_UPDATE_EVENT_TYPE, vendorId = VendorIDs.TGPP_ID, name = "Location-Update-Event-Type")
public interface LocationUpdateEventType extends DiameterEnumerated<LocationUpdateEventTypeEnum>
{
}