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
	4.2.7.  Absolute-Start-Time AVP

   	The Absolute-Start-Time AVP (AVP Code 566) is of type Time.  The
   	value of this AVP specifies the time in seconds since January 1,
   	1900, 00:00 UTC when the time window starts.  If this AVP is absent
   	from the Time-Of-Day-Condition AVP, the time window starts on January
   	1, 1900, 00:00 UTC.
 */
@DiameterAvpDefinition(code = 566L, vendorId = -1L, name = "Absolute-Start-Time")
public interface AbsoluteStartTime extends DiameterTime
{
}