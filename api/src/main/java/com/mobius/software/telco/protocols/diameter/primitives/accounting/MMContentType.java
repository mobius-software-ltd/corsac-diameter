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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.108	MM-Content-Type AVP
	The MM-Content-Type AVP (AVP code 1203) is of type Grouped and indicates the overall content type of the MM content and includes information about all the contents of an MM.
	It has the following ABNF grammar:

	MM-Content-Type :: = 	< AVP Header: 1203 >
			[ Type-Number ]
			[ Additional-Type-Information ]
			[ Content-Size ]
		* 	[ Additional-Content-Information ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MM_CONTENT_TYPE, vendorId = VendorIDs.TGPP_ID, name = "MM-Content-Type")
public interface MMContentType extends DiameterAvp
{
	TypeNumberEnum getTypeNumber();
	
	void setTypeNumber(TypeNumberEnum value);
	
	String getAdditionalTypeInformation();
	
	void setAdditionalTypeInformation(String value);
	
	Long getContentSize();
	
	void setContentSize(Long value);
	
	List<AdditionalContentInformation> getAdditionalContentInformation();
	
	void setAdditionalContentInformation(List<AdditionalContentInformation> value);
}