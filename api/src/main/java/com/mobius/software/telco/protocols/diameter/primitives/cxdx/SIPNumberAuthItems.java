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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.8	SIP-Number-Auth-Items AVP
	The SIP-Number-Auth-Items AVP is of type Unsigned32.
	When used in a request, the SIP-Number-Auth-Items indicates the number of authentication vectors the S-CSCF is requesting. 
	This can be used, for instance, when the client is requesting several pre-calculated authentication vectors. In the answer 
	message, the SIP-Number-Auth-Items AVP indicates the actual number of SIP-Auth-Data-Item AVPs provided by the Diameter server.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SIP_NUMBER_AUTH_ITEMS, vendorId = VendorIDs.TGPP_ID, name = "SIP-Number-Auth-Items")
public interface SIPNumberAuthItems extends DiameterUnsigned32
{
}