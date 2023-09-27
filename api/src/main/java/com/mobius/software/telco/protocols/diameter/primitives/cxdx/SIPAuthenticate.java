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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.10	SIP-Authenticate AVP
	The SIP-Authenticate AVP is of type OctetString and contains specific parts of the data portion of the WWW-Authenticate or Proxy-Authenticate 
	SIP headers that are to be present in a SIP response.
	It shall contain, binary encoded, the concatenation of the authentication challenge RAND and the token AUTN. See 3GPP TS 33.203 [3] for further 
	details about RAND and AUTN. The Authentication Information has a fixed length of 32 octets; the 16 most significant octets shall contain the RAND, 
	the 16 least significant octets shall contain the AUTN.
 */
@DiameterAvpDefinition(code = 609L, vendorId = KnownVendorIDs.TGPP_ID, name = "SIP-Authenticate")
public interface SIPAuthenticate extends DiameterOctetString
{
}