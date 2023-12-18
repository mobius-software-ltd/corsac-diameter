package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson;
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
 * 	3.1.5 Other-Party-Id-Data AVP
	The Other-Party-Id-Data AVP (AVP code 1077) is of type UTF8String and holds
	the E.164 number of the other party involved in a session. Other-Party-Id-Type
	AVP and Other-Party-Id-Nature AVP define the type and nature of address
	that is used.
 */
@DiameterAvpDefinition(code = 1077L, vendorId = KnownVendorIDs.ERICSSON_ID, name = "Other-Party-Id-Data")
public interface OtherPartyIdData extends DiameterUTF8String
{
}