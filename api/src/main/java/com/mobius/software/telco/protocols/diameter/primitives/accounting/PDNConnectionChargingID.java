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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.136 PDN-Connection-Charging-ID AVP
	The PDN-Connection-Charging-ID AVP (AVP code 2050) is of type Unsigned32 and contains the charging identifier
	to identify different records belonging to same PDN connection. For a PDN connection that is limited to use a single
	access at a time this field includes Charging Id of first IP-CAN bearer activated. Together with P-GW address this
	uniquely identifies the PDN connection for charging.
	Coding of this AVP is same as 3GPP-Charging-Id coding described in TS 29.061 [207]. 
 */
@DiameterAvpDefinition(code = 2050L, vendorId = KnownVendorIDs.TGPP_ID, name = "PDN-Connection-Charging-ID")
public interface PDNConnectionChargingID extends DiameterUnsigned32
{
}