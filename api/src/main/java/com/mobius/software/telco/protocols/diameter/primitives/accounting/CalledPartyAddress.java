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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.32 Called-Party-Address AVP
	The Called-Party-Address AVP (AVP code 832) is of type UTF8String. It holds the address (SIP URI, Tel URI or
	URN) of the party to whom the call is addressed.
	For IMS charging (except for SIP Register and SIP Subscription transactions), it holds the address of the party (Public
	User ID or Public Service ID) to whom the SIP transaction is posted. The Called-Party-Address AVP shall be populated
	with the SIP URI or Tel URI contained in the Request-URI of the outgoing request. For a registration procedure, this
	AVP holds the party (Public User ID) to be registered. In this case, the Called-Party-Address AVP is obtained from the
	"To" SIP header of the SIP Request. For a subscription procedure this AVP holds the address of the resource for which
	the originator wants to receive notifications of change of states. In this case, the Called-Party-Address AVP is obtained
	from the outgoing Request-URI of the SIP Request.
	For VCS charging, it holds the address (URN is not applicable) which identifies the party to which a voice call is
	destined after processing by the Proxy Function. It is converted from the circuit-switched Called Party Number as per
	TS 29.163 [234] for the Request-URI header. For a mobile originating call, this AVP contains the Called Party Number
	after processing by the Proxy Function (e.g. number normalization). 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CALLED_PARTY_ADDRESS, vendorId = VendorIDs.TGPP_ID, name = "Called-Party-Address")
public interface CalledPartyAddress extends DiameterUTF8String
{
}