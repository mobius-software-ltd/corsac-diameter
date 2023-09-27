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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	B.2.2	3GPP-OC-Request-Type AVP
	The OC-Request-Type AVP (AVP code 1322), is of type Enumerated. It contains the CC-Request-Type (defined in IETF RFC 4006 [402]) that the overload control be applied to, i.e. which types of request that should be restricted. It has the following values:

	1	INITIAL_REQUEST
	2	UPDATE_REQUEST
	3	TERMINATION_REQUEST
	4	EVENT_REQUEST
 */
@DiameterAvpDefinition(code = 1322L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-OC-Request-Type")
public interface TGPPOCRequestType extends DiameterEnumerated<TGPPOCRequestTypeEnum>
{
}