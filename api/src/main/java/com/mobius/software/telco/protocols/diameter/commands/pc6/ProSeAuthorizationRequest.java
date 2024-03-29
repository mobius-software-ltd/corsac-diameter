package com.mobius.software.telco.protocols.diameter.commands.pc6;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.3	ProSe-Authorization-Request (PAR) Command
	The ProSe-Authorization-Request (PAR) Command, indicated by the Command-Code field set to 8388668 and the "R" bit set in the Command Flags field, is sent from the ProSe Function in the HPLMN to the ProSe Function in Local PLMN/VPLMN. 
	Message Format
	
	< ProSe-Authorization-Request > ::=	< Diameter Header: 8388668, REQ, PXY, 16777340 >
		 < Session-Id >
		 [ DRMP ] 
		 [ Vendor-Specific-Application-Id ]
		 { Auth-Session-State }
		 { Origin-Host }
		 { Origin-Realm }
		 [ Destination-Host ]
		 { Destination-Realm }
		*[ Supported-Features ]
		 [ OC-Supported-Features ]
		 { User-Identity }
		 { Visited-PLMN-Id }
		*[ AVP ]
		*[ Proxy-Info ]
		*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.PC6, commandCode = CommandCodes.PROSE_AUTHORiZATION, request = true, proxyable = true, name="ProSe-Authorization-Request")
public interface ProSeAuthorizationRequest extends Pc6Request
{
	UserIdentity getUserIdentity();
	
	void setUserIdentity(UserIdentity value) throws MissingAvpException;
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value) throws MissingAvpException;
}