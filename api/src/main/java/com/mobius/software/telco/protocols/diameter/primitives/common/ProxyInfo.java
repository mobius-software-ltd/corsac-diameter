package com.mobius.software.telco.protocols.diameter.primitives.common;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 6.7.2.  Proxy-Info AVP

   The Proxy-Info AVP (AVP Code 284) is of type Grouped.  This AVP
   contains the identity and local state information of the Diameter
   node that creates and adds it to a message.  The Grouped Data field
   has the following CCF grammar:

         Proxy-Info ::= < AVP Header: 284 >
                        { Proxy-Host }
                        { Proxy-State }
                      * [ AVP ]
 */
@DiameterAvpDefinition(code = 284L, vendorId = -1L, name = "Proxy-Info")
public interface ProxyInfo extends DiameterGroupedAvp 
{
	String getProxyHost();
	
	void setProxyHost(String proxyHost);
	
	ByteBuf getProxyState();
	
	void setProxyState(ByteBuf proxyState);	
}