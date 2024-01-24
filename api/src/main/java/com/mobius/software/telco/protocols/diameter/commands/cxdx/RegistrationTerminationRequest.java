package com.mobius.software.telco.protocols.diameter.commands.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RTRFlags;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.9	Registration-Termination-Request (RTR) Command
	The Registration-Termination-Request (RTR) command, indicated by the Command-Code field set to 304 and the 'R' bit set in the Command Flags field, is sent by a Diameter Multimedia server to a Diameter Multimedia client in order to request the de-registration of a user.
	Message Format

	<Registration-Termination-Request> ::=	< Diameter Header: 304, REQ, PXY, 16777216 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 { User-Name }
			 [ Associated-Identities ]
			*[ Supported-Features ]
			*[ Public-Identity ]
			 { Deregistration-Reason }
			 [ RTR-Flags ]
			*[ AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777216, commandCode = 304, request = true, proxyable = true, name="Registration-Termination-Request")
public interface RegistrationTerminationRequest extends CxDxRequest
{
	AssociatedIdentities getAssociatedIdentities();
	 
	void setAssociatedIdentities(AssociatedIdentities value);		
	
	List<String> getPublicIdentity();
			
	void setPublicIdentity(List<String> value);
					
	DeregistrationReason getDeregistrationReason();
	
	void setDeregistrationReason(DeregistrationReason value);	
	
	RTRFlags getRTRFlags();
	
	void setRTRFlags(RTRFlags value);		
}