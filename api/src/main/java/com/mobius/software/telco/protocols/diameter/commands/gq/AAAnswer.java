package com.mobius.software.telco.protocols.diameter.commands.gq;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.3.2	AA-Answer (AAA) command
	The AAA command, indicated by the Command-Code field set to 265 and the 'R' bit cleared in the Command Flags field, is sent by the PDF to the AF in response to the AAR command.
	Message Format:

	<AA-Answer> ::=  < Diameter Header: 265, PXY >
				 < Session-Id >
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ Authorization-Token ]
				*[ Access-Network-Charging-Identifier ]
				 [ Access-Network-Charging-Address ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				*[ Failed-AVP ]
				*[ Proxy-Info ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GQ, commandCode = CommandCodes.AAA, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends AuthenticationAnswer
{
	public ByteBuf getAuthorizationToken();
	
	void setAuthorizationToken(ByteBuf value);		
	
	List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier();	
	
	void setAccessNetworkChargingIdentifier(List<AccessNetworkChargingIdentifier> value);			
	
	InetAddress getAccessNetworkChargingAddress();		
	
	void setAccessNetworkChargingAddress(InetAddress value);
}