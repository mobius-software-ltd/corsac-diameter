package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 * 	5.3.31	Rx-Request-Type AVP
	The Rx-Request-Type AVP (AVP code 533) is of type Enumerated, and contains the reason for sending the AA-Request message.
	The following values are defined:

	INITIAL_REQUEST (0)
		An initial request is used to initiate an Rx session and contains information that is relevant to initiation.

	UPDATE_REQUEST (1)
		An update request is used to update an existing Rx session.

	PCSCF_RESTORATION (2)
		A P-CSCF Restoration is requested. This value is only applicable to the PCSCF-Restoration-Enhancement feature defined in clause 5.4.1.
 */
@DiameterAvpDefinition(code = 533L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Rx-Request-Type")
public interface RxRequestType extends DiameterEnumerated<RxRequestTypeEnum>
{
}