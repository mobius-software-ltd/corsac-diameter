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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.1.6 Other-Party-Id-Type AVP
	The Other-Party-Id-Type AVP (AVP code 1078) is of type Enumerated and it is
	used to determine which type of identifier is carried by the Other-Party-Id AVP.

	0 END_USER_E164 
	The identifier is in E.164 format. Other-Party-Id-Nature
	AVP defines the nature of address that is used.

	1 END_USER_IMSI
	The identifier is in international IMSI format.
	
	2 END_USER_SIP_URI
	The identifier is in the form of a SIP URI.

	3 END_USER_NAI
	The identifier is in the form of a Network Access Identifier.
	The only supported value is END_USER_E164 in the SCAPv2 service context.
 */
@DiameterAvpDefinition(code = 1078L, vendorId = KnownVendorIDs.ERICSSON_ID, name = "Other-Party-Id-Type")
public interface OtherPartyIdType extends DiameterEnumerated<OtherPartyIdTypeEnum>
{
}