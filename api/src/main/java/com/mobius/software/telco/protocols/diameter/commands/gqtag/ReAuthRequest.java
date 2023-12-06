package com.mobius.software.telco.protocols.diameter.commands.gqtag;
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
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gq.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *	7.1.3 Re-Auth-Request (RAR) command
	The RAR command, indicated by the Command-Code field set to 258 and the 'R' bit set in the Command Flags field, is
	sent by the SPDF to the AF in order to indicate a specific action.
	However, application-specific authentication and/or authorization messages are not mandated for the Gq application in
	response to an RAR command.
	The values INDICATION_OF_RELEASE_OF_BEARER, INDICATION_OF_SUBSCRIBER_DETACHMENT,
	INDICATION_OF_RESERVATION_EXPIRATION and INDICATION_OF_LOSS_OF_BEARER,
	INDICATION_OF_RECOVERY_OF_BEARER and INDICATION_OF_RELEASE_OF_BEARER of the
	Specific-Action AVP shall not be combined with each other in an Re-Auth-Request.
	Message Format:
	<RA-Request> ::= < Diameter Header: 258, REQ, PXY >
			  < Session-Id >
			  { Origin-Host }
			  { Origin-Realm }
			  { Destination-Realm }
			  { Destination-Host }
			  { Auth-Application-Id }
			 *{ Specific-Action }
			 *[ Flow-Description ]
			  [ Globally-Unique-Address ]
			  [ Logical-Access-Id ]
			 *[ Flows ]
			  [ Abort-Cause ]
			  [ Origin-State-Id ]
			 *[ Proxy-Info ]
			 *[ Route-Record ]
			 *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777222, commandCode = 258, request = false, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest
{
	List<SpecificActionEnum> getSpecificAction();
	
	void setSpecificAction(List<SpecificActionEnum> value);
	
	List<FlowDescription> getFlowDescription();
	
	void setFlowDescription(List<FlowDescription> value);
	
	GloballyUniqueAddress getGloballyUniqueAddress();
	
	void setGloballyUniqueAddress(GloballyUniqueAddress value);	
	
	ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);	
	
	List<Flows> getFlows();
	
	void setFlows(List<Flows> value);
	
	AbortCauseEnum getAbortCause();		
	
	void setAbortCause(AbortCauseEnum value);	
}