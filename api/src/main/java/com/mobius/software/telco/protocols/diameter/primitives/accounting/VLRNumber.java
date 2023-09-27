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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterE164Address;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.242B VLR-Number AVP
	The VLR-Number AVP (AVP code 3420) is type OctetString and identifies the international E.164 address of the VLR
	serving the user. It is encoded as a TBCD-string. See TS 29.002 [232] for encoding of TBCD-strings.
	This AVP does not include leading indicators for the nature of address and the numbering plan; it contains only the
	TBCD-encoded digits of the address. 
 */
@DiameterAvpDefinition(code = 3420L, vendorId = KnownVendorIDs.TGPP_ID, name = "VLR-Number")
public interface VLRNumber extends DiameterE164Address
{
}