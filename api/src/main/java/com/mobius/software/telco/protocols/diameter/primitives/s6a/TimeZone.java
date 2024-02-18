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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.163	Time-Zone
	The Time-Zone AVP is of type UTF8String and shall contain the time zone of the location in the visited network where the UE is attached.
	It contains the offset from UTC (Coordinated Universal Time) in units of 15 minutes, as defined in 3GPP TS 22.042 [42]. It shall be expressed as positive (i.e. with the leading plus sign [+]) if the local time is ahead of or equal to UTC of day and as negative (i.e. with the leading minus sign [-]) if it is behind UTC of day.
	The value contained in the Time-Zone AVP shall take into account daylight saving time, such that when the sending entity changes from regular (winter) time to daylight saving (summer) time, there is a change to the value in the Time-Zone AVP.
	The contents of the Time-Zone AVP shall be formatted as a character string with the following format:
	Basic format: ±n, with "n" being the number of units of 15 minutes from UTC.
	For example, if the offset is +2h=+8x15mn, the value of the Time-Zone AVP will be: "+8".
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TIMEZONE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Time-Zone")
public interface TimeZone extends DiameterUTF8String
{
}