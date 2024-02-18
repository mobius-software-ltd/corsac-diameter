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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterE164Address;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.111B MSC-Address AVP
	The MSC-Address AVP (AVP code 3417) is type OctetString and contains the international E.164 address of the MSC
	that generated the network call reference number. It is encoded as a TBCD-string. See TS 29.002 [232] for encoding of
	TBCD-strings. This AVP does not include leading indicators for the nature of address and the numbering plan; it
	contains only the TBCD-encoded digits of the address. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MSC_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "MSC-Address")
public interface MSCAddress extends DiameterE164Address
{
}