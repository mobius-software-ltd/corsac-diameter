package com.mobius.software.telco.protocols.diameter.primitives.swx;
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
 * 	8.2.3.27	ERP-Authorization
	The ERP-Authorization AVP is of type Unsigned32 and it indicates whether the subscriber is authorized, or not, to make use of the EAP Reauthentication Protocol. The following values are defined:

	ERP_NOT_AUTHORIZED (0)

	ERP_AUTHORIZED (1)
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ERP_AUTHORIZATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "ERP-Authorization")
public interface ERPAuthorization extends DiameterEnumerated<ERPAuthorizationEnum>
{
}