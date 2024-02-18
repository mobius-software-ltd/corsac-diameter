package com.mobius.software.telco.protocols.diameter.primitives.rfc5779;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.9.  Service-Configuration AVP

   The Service-Configuration AVP (AVP Code 507) is of type Grouped and
   contains a service and an LMA pair.  The HAAA can use this AVP to
   inform the MAG of the MN's subscribed services and LMAs where those
   services are hosted in.

       Service-Configuration ::= < AVP-Header: 507 >
                                 [ MIP6-Agent-Info ]
                                 [ Service-Selection ]
                               * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.SERVICE_CONFIGURATION, vendorId = -1L, name = "Service-Configuration")
public interface ServiceConfiguration extends DiameterGroupedAvp
{
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);
			
	String getServiceSelection();
	
	void setServiceSelection(String value);		
}