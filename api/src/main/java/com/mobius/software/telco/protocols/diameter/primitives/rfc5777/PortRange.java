package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.7.15.  Port-Range AVP

   The Port-Range AVP (AVP Code 531) is of type Grouped and specifies an
   inclusive range of ports.  The type of the ports is indicated by the
   value of the Protocol AVP; i.e., if Protocol AVP value is 6 (TCP),
   then the Port-Range AVP represents an inclusive range of TCP ports.

   Port-Range ::= < AVP Header: 531 >
                  [ Port-Start ]
                  [ Port-End ]
                * [ AVP ]

   If the Port-Start AVP is omitted, then port 0 is assumed.  If the
   Port-End AVP is omitted, then port 65535 is assumed.
 */
@DiameterAvpDefinition(code = AvpCodes.PORT_RANGE, vendorId = -1L, name = "Port-Range")
public interface PortRange extends DiameterGroupedAvp
{
	Integer getPortStart();
	
	void setPortStart(Integer value);	
	
	Integer getPortEnd();
	
	void setPortEnd(Integer value);	
}