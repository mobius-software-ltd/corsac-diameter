package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
	7.3.32	APN-OI-Replacement
	The APN-OI-Replacement AVP is of type UTF8String. This AVP shall indicate the domain name to replace the APN OI for the non-roaming case and the home routed roaming case when constructing the APN, and the APN-FQDN upon which to perform a DNS resolution. See 3GPP TS 23.003 [3] and 3GPP TS 29.303 [38].
	The contents of the APN-OI-Replacement AVP shall be formatted as a character string composed of one or more labels separated by dots (".").
 */
@DiameterAvpDefinition(code = 1427L, vendorId = KnownVendorIDs.TGPP_ID, name = "APN-OI-Replacement")
public interface APNOIReplacement extends DiameterUTF8String
{
}