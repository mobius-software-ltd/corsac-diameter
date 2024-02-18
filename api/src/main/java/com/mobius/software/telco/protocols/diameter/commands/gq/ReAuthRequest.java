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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.gq.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 6.3.3	Re-Auth-Request (RAR) command
	The RAR command, indicated by the Command-Code field set to 258 and the 'R' bit set in the Command Flags field, is sent by the PDF to the AF in order to indicate a specific action.
	As an option, the AF may send an AAR command to the PDF to update the service information when receiving an RAA command. However, application-specific authentication and/or authorization messages are not mandated for the Gq application in response to an RAR command.
	The values INDICATION_OF_LOSS_OF_BEARER, INDICATION_OF_RECOVERY_OF_BEARER and INDICATION_OF_RELEASE_OF_BEARER of the Specific-Action AVP shall not be combined with each other in an Re-Auth-Request.
	
	Message Format:
	<RA-Request> ::= < Diameter Header: 258, REQ, PXY >
				 < Session-Id >
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Destination-Host }
				 { Auth-Application-Id }
				*{ Specific-Action }
				*[ Access-Network-Charging-Identifier ]
				 [ Access-Network-Charging-Address ]
                *[ Flows ]
				 [ Abort-Cause ]
				 [ Origin-State-Id ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]

 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GQ, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthRequest
{
	List<SpecificActionEnum> getSpecificAction();
	
	void setSpecificAction(List<SpecificActionEnum> value) throws MissingAvpException;
	
	List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier();	
	
	void setAccessNetworkChargingIdentifier(List<AccessNetworkChargingIdentifier> value);			
	
	InetAddress getAccessNetworkChargingAddress();		
	
	void setAccessNetworkChargingAddress(InetAddress value);
	
	List<Flows> getFlows();
	
	void setFlows(List<Flows> value);
	
	AbortCauseEnum getAbortCause();		
	
	void setAbortCause(AbortCauseEnum value);	
}