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
 * 	7.2.80F ISUP-Location-Number AVP
	The ISUP-Location-Number AVP (AVP code 3414) is type OctetString and contains the international E.164 indicating
	the location number of the served user. It contains an E.164 number as transported in ISUP and is encoded as a TBCDstring. See TS 29.002 [232] for encoding of TBCD-strings. This AVP does not include leading indicators for the nature
	of address and the numbering plan; it contains only the TBCD-encoded digits of the address. 
 */
@DiameterAvpDefinition(code = 3414L, vendorId = KnownVendorIDs.TGPP_ID, name = "ISUP-Location-Number")
public interface ISUPLocationNumber extends DiameterE164Address
{
}