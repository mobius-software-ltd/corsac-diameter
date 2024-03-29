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
 * 	7.2.240A	User-CSG-Information AVP
	The User-CSG-Information AVP (AVP code 2319) is of type Grouped and holds the user "Closed Subscriber Group" information associated to CSG cell access: it comprises CSG ID within the PLMN, access mode and indication on CSG membership for the user when hybrid access applies, as defined in TS 29.060 [225] for GPRS case, and in TS 29.274 [226] for EPC case.  
	It has the following ABNF grammar:

	User-CSG-Information :: = 	< AVP Header: 2319>
		 	{ CSG-Id }
		 	{ CSG-Access-Mode } 
			[ CSG-Membership-Indication ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USER_CSG_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "User-CSG-Information")
public interface UserCSGInformation extends DiameterAvp
{
	Long getCSGId();
	
	void setCSGId(Long value) throws MissingAvpException;
	
	CSGAccessModeEnum getCSGAccessMode();
	
	void setCSGAccessMode(CSGAccessModeEnum value) throws MissingAvpException;
	
	CSGMembershipIndicationEnum getCSGMembershipIndication();
	
	void setCSGMembershipIndication(CSGMembershipIndicationEnum value);
}