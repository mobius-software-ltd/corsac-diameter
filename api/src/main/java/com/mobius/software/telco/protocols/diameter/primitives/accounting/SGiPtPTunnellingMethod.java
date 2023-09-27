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
 * 	7.2.198A SGi-PtP-Tunnelling-Method AVP
	The SGi-PtP-Tunnelling-Method AVP (AVP Code 3931) is of type Enumerated and indicates whether SGi PtP
	tunnelling method is based on UDP/IP or other methods for a non-IP PDN type PDN connection.The following values
	are defined:
	
	0 UDP_IP_based
	1 Others
 */
@DiameterAvpDefinition(code = 3931L, vendorId = KnownVendorIDs.TGPP_ID, name = "SGi-PtP-Tunnelling-Method")
public interface SGiPtPTunnellingMethod extends DiameterEnumerated<SGiPtPTunnellingMethodEnum>
{
}