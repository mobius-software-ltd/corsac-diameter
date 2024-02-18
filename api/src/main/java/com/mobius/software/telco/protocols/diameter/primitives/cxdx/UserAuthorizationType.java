package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.24	User-Authorization-Type AVP
	The User-Authorization-Type AVP is of type Enumerated, and indicates the type of user authorization being performed in a User Authorization operation, i.e. UAR command. The following values are defined:

	REGISTRATION (0)
    	• 	This value is used in case of the initial registration or re-registration. I-CSCF determines this from the Expires field or expires parameter in Contact field in the SIP REGISTER method if it is not equal to zero.
    	• 	This is the default value.

	DE_REGISTRATION (1)
    	• 	This value is used in case of the de-registration. I-CSCF determines this from the Expires field or expires parameter in Contact field in the SIP REGISTER method if it is equal to zero.

	REGISTRATION_AND_CAPABILITIES (2)
    	• 	This value is used when the I-CSCF explicitly requests S-CSCF capability information from the HSS. The I-CSCF shall use this value when the user's current S-CSCF, which is stored in the HSS, cannot be contacted and a new S-CSCF needs to be selected
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USER_AUTHORIZATION_TYPE, vendorId = VendorIDs.TGPP_ID, name = "User-Authorization-Type")
public interface UserAuthorizationType extends DiameterEnumerated<UserAuthorizationTypeEnum>
{
}