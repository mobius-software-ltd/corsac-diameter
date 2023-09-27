package com.mobius.software.telco.protocols.diameter.primitives.s6m;
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
	6.4.11	External-Identifier
	The External-Identifier AVP is of type UTF8String. For S6m/S6n interface it shall contain an external identifier of the UE. 
	See 3GPP TS 23.003 [11] for the definition and formatting of the External Identifier. For S6t interface, it shall contain an 
	external identifier for an individual UE or a group of UEs, as indicated by Type-Of-External-Identifier AVP. See 3GPP TS 23.003 [11] 
	for the definition and formatting of the External Group Identifier. 
 */
@DiameterAvpDefinition(code = 3111L, vendorId = KnownVendorIDs.TGPP_ID, name = "External-Identifier")
public interface ExternalIdentifier extends DiameterUTF8String
{
}