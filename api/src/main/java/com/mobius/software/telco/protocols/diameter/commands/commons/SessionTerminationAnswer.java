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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * The Session-Termination-Answer (STA), indicated by the Command Code
   set to 275 and the message flags' 'R' bit clear, is sent by the
   Diameter server to acknowledge the notification that the session has
   been terminated.  The Result-Code AVP MUST be present, and it MAY
   contain an indication that an error occurred while servicing the STR.

   Upon sending or receipt of the STA, the Diameter server MUST release
   all resources for the session indicated by the Session-Id AVP.  Any
   intermediate server in the Proxy-Chain MAY also release any
   resources, if necessary.

    Message Format

         <STA> ::= < Diameter Header: 275, PXY >
                    < Session-Id >
                    { Result-Code }
                    { Origin-Host }
                    { Origin-Realm }
                    [ User-Name ]
                  * [ Class ]
                    [ Error-Message ]
                    [ Error-Reporting-Host ]
                    [ Failed-AVP ]
                    [ Origin-State-Id ]
                  * [ Redirect-Host ]
                    [ Redirect-Host-Usage ]
                    [ Redirect-Max-Cache-Time ]
                  * [ Proxy-Info ]
                  * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.COMMON, commandCode = CommandCodes.SESSION_TERMINATION, request = false, proxyable = true, name="Session-Termination-Answer")
public interface SessionTerminationAnswer extends AuthenticationAnswer	
{  
	public List<ByteBuf> getDiameterClass();
	
	void setDiameterClass(List<ByteBuf> value);		
}