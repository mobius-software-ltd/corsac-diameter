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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.134	Subscribed-Periodic-RAU-TAU-Timer
	The Subscribed-Periodic-RAU-TAU-Timer AVP is of type Unsigned32 and it shall contain the subscribed periodic RAU/TAU timer 
	value in seconds as specified in 3GPP TS 24.008 [31].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SUBSCRIBED_PERIOD_RAU_TAU_TIMER, vendorId = VendorIDs.TGPP_ID, must = false, name = "Subscribed-Periodic-RAU-TAU-Timer")
public interface SubscribedPeriodicRAUTAUTimer extends DiameterUnsigned32
{
}