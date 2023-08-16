package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/

/*
	4.2.9.  Absolute-End-Time AVP

   	The Time-Of-Day-End AVP (AVP Code 568) is of type Time.  The value of
   	this AVP specifies the time in seconds since January 1, 1900, 00:00
   	UTC when the time window ends.  If this AVP is absent from the Time-
   	Of-Day-Condition AVP, then the time window is open-ended.
 */
@DiameterAvpDefinition(code = 568L, vendorId = -1L, name = "Absolute-End-Time")
public interface AbsoluteEndTime extends DiameterTime
{
}