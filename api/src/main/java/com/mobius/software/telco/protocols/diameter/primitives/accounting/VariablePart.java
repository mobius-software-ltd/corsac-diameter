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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.242aA	Variable-Part AVP
	The Variable-Part AVP (AVP code 3907) is of type Grouped and specifies the order, type, and value of a variable to be played back within the announcement.
	It has the following ABNF grammar:

	Variable-Part :: =  < AVP Header: 3907 >
		[ Variable-Part-Order ]
		{ Variable-Part-Type }
		{ Variable-Part-Value }
 */
@DiameterAvpDefinition(code = TgppAvpCodes.VARIABLE_PART, vendorId = VendorIDs.TGPP_ID, name = "Variable-Part")
public interface VariablePart extends DiameterAvp
{
	Long getVariablePartOrder();
	
	void setVariablePartOrder(Long value) throws MissingAvpException;
	
	Long getVariablePartType();
	
	void setVariablePartType(Long value) throws MissingAvpException;
	
	String getVariablePartValue();
	
	void setVariablePartValue(String value);
}