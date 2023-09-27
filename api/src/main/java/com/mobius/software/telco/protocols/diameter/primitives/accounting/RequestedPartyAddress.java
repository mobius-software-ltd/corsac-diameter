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
 * 	7.2.176 Requested-Party-Address AVP
	The Requested-Party-Address AVP (AVP code 1251) is of type UTF8 String. It holds the address (SIP URI, Tel URI or
	URN) of the party to whom the call was originaly addressed.
	For IMS charging, it holds the address of the party (Public User ID or Public Service ID) to whom the SIP transaction
	was originally posted. The Requested--Party-Address AVP shall be populated with the SIP URI, Tel URI or URN
	contained in the Request-URI of the incoming request. This AVP is only present if different from the Called-PartyAddress AVP.
	For VCS charging, it holds the address (URN is not applicable) which identifies the party to which a voice call is
	destined before processing by the Proxy Function. It is converted from the circuit-switched Called Party BCD Number
	as per TS 29.163 [234] for the Request-URI header. This is included only for a mobile originating call. 
 */
@DiameterAvpDefinition(code = 1251L, vendorId = KnownVendorIDs.TGPP_ID, name = "Requested-Party-Address")
public interface RequestedPartyAddress extends DiameterUTF8String
{
}