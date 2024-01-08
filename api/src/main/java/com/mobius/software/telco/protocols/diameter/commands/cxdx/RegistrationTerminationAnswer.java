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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.IdentityWithEmergencyRegistration;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.10	Registration-Termination-Answer (RTA) Command
	The Registration-Termination-Answer (RTA) command, indicated by the Command-Code field set to 304 and the 'R' bit cleared in the Command Flags field, is sent by a client in response to the Registration-Termination-Request command. The Experimental-Result AVP may contain one of the values defined in clause 6.2.
	Message Format

	<Registration-Termination-Answer> ::=	< Diameter Header: 304, PXY, 16777216 >
			 < Session-Id >
			 [ DRMP ]
			 { Vendor-Specific-Application-Id }
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ Associated-Identities ]
			*[ Supported-Features ]
			*[ Identity-with-Emergency-Registration ]
			*[ AVP ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777216, commandCode = 304, request = false, proxyable = true, name="Registration-Termination-Answer")
public interface RegistrationTerminationAnswer extends CxDxAnswer
{
	AssociatedIdentities getAssociatedIdentities();
	 
	void setAssociatedIdentities(AssociatedIdentities value);		
	
	List<IdentityWithEmergencyRegistration> getIdentityWithEmergencyRegistration();
	 
	void setIdentityWithEmergencyRegistration(List<IdentityWithEmergencyRegistration> value);	
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);	
}