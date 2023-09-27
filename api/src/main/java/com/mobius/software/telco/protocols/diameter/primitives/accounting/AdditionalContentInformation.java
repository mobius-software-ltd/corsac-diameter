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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.5	Additional-Content-Information AVP
	The Additional-Content-Information AVP (AVPcode 1207) is of type Grouped and identifies any subsequent content types. It is used to identify each content (including re-occurences) within an MM when the Type-Number AVP or Additional-Type-Information AVP from the Content-Type AVP indicate a multi-part content.
	It has the following ABNF grammar:
	
	Additional-Content-Information:: = < AVP Header: 1207 >
			  [ Type-Number ]
			  [ Additional-Type-Information ]
			  [ Content-Size ]
 */
@DiameterAvpDefinition(code = 1207L, vendorId = KnownVendorIDs.TGPP_ID, name = "Additional-Content-Information")
public interface AdditionalContentInformation extends DiameterAvp
{
	TypeNumberEnum getTypeNumber();
	
	void setTypeNumber(TypeNumberEnum value);
	
	String getAdditionalTypeInformation();
	
	void setAdditionalTypeInformation(String value);
	
	Long getContentSize();
	
	void setContentSize(Long value);
}