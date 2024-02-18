package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.5.1.  Tunneling AVP

   The Tunneling AVP (AVP Code 401) is of type Grouped and contains the
   following AVPs, used to describe a compulsory tunnel service
   [RFC2868] [RFC2867].  Its data field has the following ABNF grammar:
   
   Tunneling     ::= < AVP Header: 401 >
                     { Tunnel-Type }
                     { Tunnel-Medium-Type }
                     { Tunnel-Client-Endpoint }
                     { Tunnel-Server-Endpoint }
                     [ Tunnel-Preference ]
                     [ Tunnel-Client-Auth-Id ]
                     [ Tunnel-Server-Auth-Id ]
                     [ Tunnel-Assignment-Id ]
                     [ Tunnel-Password ]
                     [ Tunnel-Private-Group-Id ]
 */
@DiameterAvpDefinition(code = AvpCodes.TUNNELING, vendorId = -1L, name = "Tunneling")
public interface Tunneling extends DiameterAvp
{
	TunnelTypeEnum getTunnelType();
	
	void setTunnelType(TunnelTypeEnum tunnelType) throws MissingAvpException;
	
	TunnelMediumTypeEnum getTunnelMediumType();
	
	void setTunnelMediumType(TunnelMediumTypeEnum tunnelMediumType) throws MissingAvpException;
	
	String getTunnelClientEndpoint();
	
	void setTunnelClientEndpoint(String value) throws MissingAvpException;	
	
	String getTunnelServerEndpoint();
	
	void setTunnelServerEndpoint(String value) throws MissingAvpException;	
	
	Long getTunnelPreference();
	
	void setTunnelPreference(Long value);
	
	String getTunnelClientAuthId();
	
	void setTunnelClientAuthId(String value);	
	
	String getTunnelServerAuthId();
	
	void setTunnelServerAuthId(String value);
	
	ByteBuf getTunnelAssignmentId();
	
	void setTunnelAssignmentId(ByteBuf value);
	
	ByteBuf getTunnelPassword();
	
	void setTunnelPassword(ByteBuf value);
	
	ByteBuf getTunnelPrivateGroupId();
	
	void setTunnelPrivateGroupId(ByteBuf value);
}