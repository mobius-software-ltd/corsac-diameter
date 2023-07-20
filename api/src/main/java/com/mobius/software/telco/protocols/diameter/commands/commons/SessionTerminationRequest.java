package com.mobius.software.telco.protocols.diameter.commands.commons;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * The Session-Termination-Request (STR), indicated by the Command Code
   set to 275 and the Command Flags' 'R' bit set, is sent by a Diameter
   client or by a Diameter proxy to inform the Diameter server that an
   authenticated and/or authorized session is being terminated.

    Message Format

        <STR>  ::= < Diameter Header: 275, REQ, PXY >
                   < Session-Id >
                   { Origin-Host }
                   { Origin-Realm }
                   { Destination-Realm }
                   { Auth-Application-Id }
                   { Termination-Cause }
                   [ User-Name ]
                   [ Destination-Host ]
                 * [ Class ]
                   [ Origin-State-Id ]
                 * [ Proxy-Info ]
                 * [ Route-Record ]
                 * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = -1, commandCode = 275, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends DiameterRequest
{  
	public Long getAuthApplicationId();
	
	void setAuthApplicationIds(Long value);
	
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	public String getUsername();
	
	void setUsername(String value);
	
	public List<ByteBuf> getDiameterClass();
	
	void setDiameterClass(List<ByteBuf> value);
	
	public Long getOriginStateId();
	
	void setOriginStateId(Long value);			
	
	public List<ProxyInfo> getProxyInfo();
	
	void setProxyInfo(List<ProxyInfo> value);

	public List<String> getRouteRecords();
	
	void setRouteRecords(List<String> value);
}