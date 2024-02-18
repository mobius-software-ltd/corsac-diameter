package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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

/**
*
* @author yulian oifa
*
*/

/*
	8.4.81	Battery-Indicator
	The Battery-Indicator AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits shall be as defined in table 8.4.81-1:
	Table 8.4.81-1: Battery-Indicator

	Bit Name
	Description

	0 NO_BATTERY
	When this bit is set it indicates that UE is not battery powered.

	1 BATTERY_REPLACEABLE_INDICATION
	When this bit is set it indicates that battery of the UE is replaceable, when this bit is not set it indicates that battery of UE is not replaceable.

	2 BATTERY_RECHARGEABLE_INDICATION
	When this bit is set it indicates that the battery of the UE is rechargeable, when this bit is not set it indicates that battery of the UE is not  rechargeable.

	NOTE1:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.

	NOTE2:	If bit 0 is set, bit 1 and bit 2 shall be cleared.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.BATTERY_INDICATOR, vendorId = VendorIDs.TGPP_ID,must = false, name = "Battery-Indicator")
public interface BatteryIndicator extends DiameterUnsigned32
{
}