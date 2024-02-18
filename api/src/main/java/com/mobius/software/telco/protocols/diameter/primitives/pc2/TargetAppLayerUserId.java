package com.mobius.software.telco.protocols.diameter.primitives.pc2;
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
	6.4.3	Target-App-Layer-User-Id AVP
	The Target-App-Layer-User-Id AVP (AVP code 3601) is of type UTF8String, and it contains an identity identifying a target user within the context of a specific application (e.g. tommy@social.net).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TARGET_APP_LAYER_USER_ID, vendorId = VendorIDs.TGPP_ID, name = "Target-App-Layer-User-Id")
public interface TargetAppLayerUserId extends DiameterUTF8String
{
}