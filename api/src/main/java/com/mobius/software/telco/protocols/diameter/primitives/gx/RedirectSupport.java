package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.83 Redirect-Support AVP
	The Redirect-Support AVP (AVP Code 1086) is of type Enumerated.
	The following value is defined:

	REDIRECTION_DISABLED (0)
 		This value indicates that redirection is disabled for a detected application's traffic.
	REDIRECTION_ENABLED (1)
 		This value indicates that redirection is enabled for a detected application's traffic. This is the default value
		applicable if a Redirect-Information AVP is provided for the first time and if this AVP is not supplied. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.REDIRECT_SUPPORT, vendorId = VendorIDs.TGPP_ID, must = false, name = "Redirect-Support")
public interface RedirectSupport extends DiameterEnumerated<RedirectSupportEnum>
{
}