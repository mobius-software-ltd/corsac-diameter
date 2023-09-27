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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.33 Calling-Party-Address AVP
	The Calling-Party-Address AVP (AVP code 831) is of type UTF8String and, for IMS charging, holds the address (SIP
	URI or Tel URI) which identifies the party (Public User Identity or Public Service Identity) initiating a SIP transaction.
	It is obtained from the P-Asserted-Identity header of any non-REGISTER SIP Request, either initiating a dialog or a
	standalone transaction. This AVP may appear several times when the P-Asserted-Identity header contains both a SIP
	URI and a Tel URI. In case no P-Asserted-Identity is known, this AVP list shall include one item with the value
	"unknown".
	For VCS charging, it holds the address (SIP URI or Tel URI) which identifies the party initiating a voice call. It is
	converted from the circuit-switched Calling Party Number as per TS 29.163 [234] for the P-Asserted-Identity header. 
 */
@DiameterAvpDefinition(code = 831L, vendorId = KnownVendorIDs.TGPP_ID, name = "Calling-Party-Address")
public interface CallingPartyAddress extends DiameterUTF8String
{
}