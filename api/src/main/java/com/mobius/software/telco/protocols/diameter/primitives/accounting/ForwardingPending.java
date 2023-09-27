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
 * 	7.2.67aA Forwarding-Pending AVP
	The Forwarding-Pending AVP (AVP code 3415) is of type Enumerated and indicates that a forwarded-to-number has
	been received and the voice call will be forwarded. When it is not present, the voice call is not expected to be
	forwarded. The values are:

	0 Forwarding not pending
	1 Forwarding pending
 */
@DiameterAvpDefinition(code = 3415L, vendorId = KnownVendorIDs.TGPP_ID, name = "Forwarding-Pending")
public interface ForwardingPending extends DiameterEnumerated<ForwardingPendingEnum>
{
}