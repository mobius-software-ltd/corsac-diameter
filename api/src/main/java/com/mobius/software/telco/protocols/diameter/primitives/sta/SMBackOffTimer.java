package com.mobius.software.telco.protocols.diameter.primitives.sta;
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
	5.2.3.32	SM-Back-Off-Timer
	The SM-Back-Off-Timer AVP is of type Unsigned32 and it shall contain the session management back-off timer value in seconds. The session management back-off timer is provided to the UE as specified in clause 8.1.4.16 of 3GPP TS 24.302 [26].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SM_BACK_OFF_TIMER, vendorId = VendorIDs.TGPP_ID, must = false, name = "SM-Back-Off-Timer")
public interface SMBackOffTimer extends DiameterUnsigned32
{
}