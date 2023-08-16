package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.8.  Unit-Value AVP

   The Unit-Value AVP is of type Grouped (AVP Code 445) and specifies
   the cost as a floating-point value.  The Unit-Value is a significand
   with an exponent; i.e., Unit-Value = Value-Digits AVP * 10^Exponent.
   This representation avoids unwanted rounding off.  For example, the
   value of 2,3 is represented as Value-Digits = 23 and Exponent = -1.
   The absence of the exponent part MUST be interpreted as an exponent
   equal to zero.

   The Unit-Value AVP is defined as follows (per grouped-avp-def as
   defined in [RFC6733]):

                       Unit-Value ::= < AVP Header: 445 >
                                      { Value-Digits }
                                      [ Exponent ]
 */
@DiameterAvpDefinition(code = 445L, vendorId = -1, name = "Unit-Value")
public interface UnitValue extends DiameterAvp 
{
	Long getValueDigits();
	
	void setValueDigits(Long valueDigits);
	
	Long getExponent();
	
	void setExponent(Long exponent);	
}