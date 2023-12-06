package com.mobius.software.telco.protocols.diameter.primitives.sy;
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
	5.3.4	SL-Request-Type AVP
	The SL-Request-Type AVP (AVP code 2904) is of type Enumerated, and informs the OCS whether the SLR command is being sent as part of the initial or intermediate spending limit report request procedure.
	The following values are defined:

	INITIAL_REQUEST (0)
	This value indicates that this is the first request in the Diameter session.

	INTERMEDIATE_REQUEST (1)
	This value indicates that this is the second or subsequent request in the Diameter session.
 */
@DiameterAvpDefinition(code = 2904L, vendorId = KnownVendorIDs.TGPP_ID, name = "SL-Request-Type")
public interface SLRequestType extends DiameterEnumerated<SLRequestTypeEnum>
{
}