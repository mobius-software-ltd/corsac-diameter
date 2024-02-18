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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.65	WebRTC-Authentication-Function-Name AVP
	The WebRTC-Authentication-Function-Name AVP is of type UTF8String and contains the address of a WAF allowed for the subscription. 
	For the format of the string see IETF draft-holmberg-sipcore-auth-id-01 [25].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.WEBRTC_AUTHENTICATION_FUNCTION_NAME, vendorId = VendorIDs.TGPP_ID, must = false, name = "WebRTC-Authentication-Function-Name")
public interface WebRTCAuthenticationFunctionName extends DiameterUTF8String
{
}