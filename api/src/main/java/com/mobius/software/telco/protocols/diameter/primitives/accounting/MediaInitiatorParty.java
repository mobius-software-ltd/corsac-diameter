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
 * 	7.2.102 Media-Initiator-Party AVP
	The Media-Initiator-Party AVP (AVP code 1288) is of type UTF8String. Enumerated in IMS charging, it holds the
	address (SIP URI or Tel URI) of the party (Public User ID or Public Service ID) who initiates the media action, like
	adding/removing, connecting/disconnecting the media. The Media Initiator Party shall be populated with the SIP URI or
	Tel URI contained in the Request-URI of the outgoing request. It is use for PoC charging. 
 */
@DiameterAvpDefinition(code = 1288L, vendorId = KnownVendorIDs.TGPP_ID, name = "Media-Initiator-Party")
public interface MediaInitiatorParty extends DiameterUTF8String
{
}