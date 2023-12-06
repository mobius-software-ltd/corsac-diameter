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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.gq.FlowGrouping;
import com.mobius.software.telco.protocols.diameter.primitives.gq.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SIPForkingIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.1	AA-Request (AAR) command
	The AAR command, indicated by the Command-Code field set to 265 and the 'R' bit set in the Command Flags field, is sent by an AF to the PDF in order to request the authorization for the bearer usage for the AF session.
	Message Format:

	<AA-Request> ::= < Diameter Header: 265, REQ, PXY >
				 < Session-Id >
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				*[ Media-Component-Description ]
                *[ Flow-Grouping ]
				 [ AF-Charging-Identifier ]
				 [ SIP-Forking-Indication ]
				*[ Specific-Action ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777222, commandCode = 265, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends AuthenticationRequest
{	
	List<MediaComponentDescription> getMediaComponentDescription();
	
	void setMediaComponentDescription(List<MediaComponentDescription> value);	
	
	List<FlowGrouping> getFlowGrouping();
	
	void setFlowGrouping(List<FlowGrouping> value);	
	
	ByteBuf getAFChargingIdentifier();
	
	void setAFChargingIdentifier(ByteBuf value);	
	
	SIPForkingIndicationEnum getSIPForkingIndication();
	
	void setSIPForkingIndication(SIPForkingIndicationEnum value);	
	
	List<SpecificActionEnum> getSpecificAction();
	
	void setSpecificAction(List<SpecificActionEnum> value);
}