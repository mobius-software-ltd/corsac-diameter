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
 * 	7.2.31 Called-Asserted-Identity AVP
	The Called-Asserted-Identity AVP (AVP code 1250) is of type UTF8String and holds the address (Public User ID: SIP
	URI, E.164, etc.) of the finally asserted called party.
	The address is obtained from the P-Asserted-Identity SIP header field of the 2xx responses corresponding to a SIP
	request either initiating a dialog or a standalone transaction. This field may appear several times in the request when the
	P-Asserted-Identity contains both a SIP URI and a Tel URI.
	This field shall be present when the P-Asserted-Identity SIP header field is available in the SIP 2xx response. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CALLED_ASSERTED_IDENTITY, vendorId = VendorIDs.TGPP_ID, name = "Called-Asserted-Identity")
public interface CalledAssertedIdentity extends DiameterUTF8String
{
}