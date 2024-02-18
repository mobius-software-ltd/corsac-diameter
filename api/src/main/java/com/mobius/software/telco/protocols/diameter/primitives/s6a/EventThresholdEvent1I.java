package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.173	Event-Threshold-Event-1I
	The Event-Threshold-Event-1I AVP is of type Integer32. See 3GPP TS 32.422 [23] for allowed values
 */
@DiameterAvpDefinition(code = TgppAvpCodes.EVENT_THRESHOLD_EVENT_1I, vendorId = VendorIDs.TGPP_ID, must = false, name = "Event-Threshold-Event-1I")
public interface EventThresholdEvent1I extends DiameterInteger32
{
}