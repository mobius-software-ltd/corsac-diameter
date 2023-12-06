package com.mobius.software.telco.protocols.diameter.primitives.nt;
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
 * 	5.3.4	Transfer-Request-Type AVP
	The Transfer-Request-Type AVP (AVP code 4203) is of type Unsigned32, it contains the reason for sending the BT-Request message.
	The following values are defined:

	0 (TRANSFER_POLICY_REQUEST)
	The BT-Request message is sent to initiate a transfer policy request procedure.

	1 (TRANSFER_POLICY_NOTIFICATION)
	The BT-Request message is sent to initiate a transfer policy notification procedure.  
 */
@DiameterAvpDefinition(code = 4203L, vendorId = KnownVendorIDs.TGPP_ID, name = "Transfer-Request-Type")
public interface TransferRequestType extends DiameterEnumerated<TransferRequestTypeEnum>
{
}