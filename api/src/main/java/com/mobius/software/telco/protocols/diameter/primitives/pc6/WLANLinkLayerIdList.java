package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.33	WLAN-Link-Layer-Id-List
	The WLAN-Link-Layer-Id-List AVP is of type Grouped. It shall contain a list of WLAN Link Layer IDs provided to a UE implementing the Group Owner functionality in a Wi-Fi P2P group.
	The AVP format shall conform to:
		
	WLAN-Link-Layer-Id-List ::=	<AVP header: 3822 10415>
 		*[ WLAN-Link-Layer-Id ]
 		*AVP
 */
@DiameterAvpDefinition(code = 3822L, vendorId = KnownVendorIDs.TGPP_ID, name = "WLAN-Link-Layer-Id-List")
public interface WLANLinkLayerIdList extends DiameterGroupedAvp
{
	List<WLANLinkLayerId> getWLANLinkLayerId();
	
	void setWLANLinkLayerId(List<WLANLinkLayerId> value);
}