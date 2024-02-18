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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.2.11.  Timezone-Flag AVP

   The Timezone-Flag AVP (AVP Code 570) is of type Enumerated and
   indicates whether the time windows are specified in UTC, local time,
   at the managed terminal or as an offset from UTC.  If this AVP is
   absent from the Time-Of-Day-Condition AVP, then the time windows are
   in UTC.

   This document defines the following values:

     Value | Name and Semantic
     ------+--------------------------------------------------
       0   | UTC - The time windows are expressed in UTC.
       1   | LOCAL - The time windows are expressed in local
           | time at the managed terminal.
       2   | OFFSET - The time windows are expressed as an
           | offset from UTC (see Timezone-Offset AVP).
 */
@DiameterAvpDefinition(code = AvpCodes.TIMEZONE_FLAG, vendorId = -1L, name = "Timezone-Flag")
public interface TimezoneFlag extends DiameterEnumerated<TimezoneFlagEnum>
{
}