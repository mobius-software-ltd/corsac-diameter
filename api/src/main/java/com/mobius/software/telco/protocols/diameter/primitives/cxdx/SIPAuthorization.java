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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.11	SIP-Authorization AVP
	The SIP-Authorization AVP is of type OctetString and contains specific parts of the data portion of the Authorization or Proxy-Authorization SIP 
	headers suitable for inclusion in a SIP request.
	When included in an Authentication Request, it shall contain the concatenation of RAND, as sent to the terminal, and AUTS, as received from the terminal. 
	RAND and AUTS shall both be binary encoded. See 3GPP TS 33.203 [3] for further details about RAND and AUTS. The Authorization Information has a fixed 
	length of 30 octets; the 16 most significant octets shall contain the RAND, the 14 least significant octets shall contain the AUTS.
	When included in an Authentication Request Response, it shall contain, binary encoded, the expected response XRES. See 3GPP TS 33.203 [3] for further 
	details about XRES.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SIP_AUTHORIZATION, vendorId = VendorIDs.TGPP_ID, name = "SIP-Authorization")
public interface SIPAuthorization extends DiameterOctetString
{
}