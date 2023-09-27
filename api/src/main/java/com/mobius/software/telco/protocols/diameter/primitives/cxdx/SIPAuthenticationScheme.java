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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.9	SIP-Authentication-Scheme AVP
	The Authentication-Scheme AVP is of type UTF8String and indicates the authentication scheme used in the authentication of SIP messages. The following values are defined:

	- "Digest-AKAv1-MD5": it indicates IMS-AKA authentication scheme.

	NOTE 1:	The S-CSCF uses the "Digest-AKAv1-MD5" authentication scheme towards the HSS for Digest-AKAv1 and Digest-AKAv2 versions. E.g. digest algorithms "AKAv1-MD5" and "AKAv2-SHA-256" require from the HSS the same procedures i.e. the same authentication information: random number RAND, authentication token AUTN, expected response XRES, cipher key CK and integrity key IK.
	NOTE 2:	The "AKAv1-MD5" digest AKA algorithm is only supported for backward compatibility.

	- "SIP Digest":  it indicates SIP Digest authentication scheme.

	- "NASS-Bundled": it indicates NASS Bundled authentication scheme.

	- "Early‑IMS‑Security": it indicates GPRS-IMS-Bundled authentication scheme.
	
	- "Unknown": it indicates that the authentication scheme to be used is unknown at this point.
 */
@DiameterAvpDefinition(code = 608L, vendorId = KnownVendorIDs.TGPP_ID, name = "SIP-Authentication-Scheme")
public interface SIPAuthenticationScheme extends DiameterUTF8String
{
}