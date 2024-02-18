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
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	4.2.6.  Month-Of-Year-Mask AVP

   The Month-Of-Year-Mask AVP (AVP Code 565) is of type Unsigned32.  The
   value is a bit mask that specifies the months of the year for the
   time window to match.  This document specifies the following bits:

      Bit  | Name
     ------+-----------
       0   | JANUARY
       1   | FEBRUARY
       2   | MARCH
       3   | APRIL
       4   | MAY
       5   | JUNE
       6   | JULY
       7   | AUGUST
       8   | SEPTEMBER
       9   | OCTOBER
       10  | NOVEMBER
       11  | DECEMBER

   	The bit MUST be set for the time window to match on the corresponding
   	month of the year.  Bit 0 is the least significant bit and unused
   	bits MUST be cleared.  If this AVP is absent from the Time-Of-Day-
   	Condition AVP, the time windows match during all months of the year.
 */
@DiameterAvpDefinition(code = AvpCodes.MONTH_OF_YEAR_MASK, vendorId = -1L, name = "Month-Of-Year-Mask")
public interface MonthOfYearMask extends DiameterBitmask32
{
	public static final int JANUARY = 1;
	public static final int FEBRUARY = 2;
	public static final int MARCH = 3;
	public static final int APRIL = 4;
	public static final int MAY = 5;
	public static final int JUNE = 6;
	public static final int JULY = 7;
	public static final int AUGUST = 8;
	public static final int SEPTEMBER = 9;
	public static final int OCTOBER = 10;
	public static final int NOVEMBER = 11;
	public static final int DECEMBER = 12;
	
	public void setMonthBit(int dow, boolean isOn) throws InvalidAvpValueException;
	
	public boolean isMonthBitSet(int dow) throws InvalidAvpValueException;
}