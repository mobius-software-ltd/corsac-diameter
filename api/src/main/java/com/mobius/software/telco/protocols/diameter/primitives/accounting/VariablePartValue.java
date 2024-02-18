package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
 * 	7.2.242aD Variable-Part-Value AVP
	The Variable-Part-Value AVP (AVP Code 3910) is of type UTF8String and holds the value of the variable part. 
	Table 7.2.242aD.1 describes the content of the Variable-Part-Value AVP for each of the standardized values of the VariablePart-Type AVP.

	Table 7.2.242aD.1: Variable-Part-Value AVP Contents
	Type Value
	
	Integer 
	String of digits, which shall be announced as a single number, up to 10 digits.
	
	Number 
	String of digits, which shall be announced as individual digits, up to 24 digits.
	
	Time 
	A string of digits in the form HHMM.

	Date 
	A string of digits in the form of YYYYMMDD.

	Currency 
	A string of digits in the form of AAAAAABB, where

	AAAAAA is the integral part and BB is the decimal part. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.VARIABLE_PART_VALUE, vendorId = VendorIDs.TGPP_ID, name = "Variable-Part-Value")
public interface VariablePartValue extends DiameterUTF8String
{
}