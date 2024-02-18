package com.mobius.software.telco.protocols.diameter.primitives.gq;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.9 Reservation-Priority AVP
	The Reservation-Priority AVP (AVP code 458) is of type Enumerated. The following values are specified:
	
	DEFAULT (0): This is the lowest level of priority. If no Reservation-Priority AVP is specified in the AA-Request, this
	is the priority associated with the reservation.

	PRIORITY-ONE (1)
	PRIORITY-TWO (2)
	PRIORITY-THREE (3)
	PRIORITY-FOUR (4)
	PRIORITY-FIVE (5)
	PRIORITY-SIX (6)
	PRIORITY-SEVEN (7)
	PRIORITY-EIGHT (8)
	PRIORITY-NINE (9)
	PRIORITY-TEN(10)
	PRIORITY-ELEVEN (11)
	PRIORITY-TWELVE (12)
	PRIORITY-THIRTEEN (13) 
	PRIORITY-FOURTEEN (14)
	PRIORITY-FIFTEEN (15)
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.RESERVATION_PRIORITY, vendorId = VendorIDs.ETSI_ID, must = false, name = "Reservation-Priority")
public interface ReservationPriority extends DiameterEnumerated<ReservationPriorityEnum>
{
}