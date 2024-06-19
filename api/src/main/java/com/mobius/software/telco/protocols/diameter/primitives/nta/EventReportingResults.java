package com.mobius.software.telco.protocols.diameter.primitives.nta;

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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/*
 * A.6.3.6	Event-Reporting-Results AVP
 * The Event-Reporting-Results AVP (AVP code 4214) is of type Unsigned32, 
 * it shall contain a bit mask. The bit 0 shall be the least significant bit. 
 * For example, to get the value of bit 0, a bit mask of 0x0001 should be used. 
 * The meaning of the bits shall be as defined below:
 * 
 *   Bit    Name           Description
 *    0  Final report    This bit, when set, indicates that this is the final report for the UE group; 
 *                       when not set, indicates that there are more reports pending for the UE group.
 *
 */

@DiameterAvpDefinition(code = TgppAvpCodes.EVENT_REPORTING_RESULTS, vendorId = VendorIDs.TGPP_ID, name = "Event-Reporting-Results")
public interface EventReportingResults extends DiameterUnsigned32
{
	
}


