package com.mobius.software.telco.protocols.diameter.commands.nas;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * <AS-Answer>  ::= < Diameter Header: 274, PXY >
                          < Session-Id >
                          { Result-Code }
                          { Origin-Host }
                          { Origin-Realm }
                          [ User-Name ]
                          [ Origin-AAA-Protocol ]
                          [ Origin-State-Id ]
                          [ State]
                          [ Error-Message ]
                          [ Error-Reporting-Host ]
                        * [ Failed-AVP ]
                        * [ Redirected-Host ]
                          [ Redirected-Host-Usage ]
                          [ Redirected-Max-Cache-Time ]
                        * [ Proxy-Info ]
                        * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 274, request = false, proxyable = true, name="Abort-Session-Answer")
public interface AbortSessionAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionAnswer
{
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum value);	
	
	ByteBuf getState();
	
	void setState(ByteBuf value);	
}