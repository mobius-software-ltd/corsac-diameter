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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.3	Access-Network-Charging-Identifier AVP
	The Access-Network-Charging-Identifier AVP (AVP code 502) is of type Grouped, and contains a charging identifier (e.g. GCID) within the Access-Network-Charging-Identifier-Value AVP along with information about the flows transported within the corresponding bearer within the Flows AVP. If no Flows AVP is provided, the Access‑Network‑Charging-Identifier-Value applies for all flows within the AF session.
	The Access-Network-Charging-Identifier AVP can be sent from the PCRF to the AF. The AF may use this information for charging correlation with session layer.
	AVP Format:
		
			Access-Network-Charging-Identifier ::= < AVP Header: 502 >
					  { Access-Network-Charging-Identifier-Value}
					 *[ Flows ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ACCESS_NETWORK_CHARGING_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, name = "Access-Network-Charging-Identifier")
public interface AccessNetworkChargingIdentifier extends DiameterAvp
{
	ByteBuf getAccessNetworkChargingIdentifierValue();
	
	void setAccessNetworkChargingIdentifierValue(ByteBuf value) throws MissingAvpException;
	
	List<Flows> getFlows();
	
	void setFlows(List<Flows> value);
}