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
 * 	7.2.128A Outgoing-Session-Id AVP
	The Outgoing-Session-Id AVP (AVP code 2320) is of type UTF8String and holds the outgoing session identifier for an
	AS acting as B2BUA. For a SIP session the Outgoing-Session-Id AVP contains the SIP Call ID of the outgoing leg, as
	defined in RFC 3261 [405]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.OUTGOING_SESSION_ID, vendorId = VendorIDs.TGPP_ID, name = "Outgoing-Session-Id")
public interface OutgoingSessionId extends DiameterUTF8String
{
}