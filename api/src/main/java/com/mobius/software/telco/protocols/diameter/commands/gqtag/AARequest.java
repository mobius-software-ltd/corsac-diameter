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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.e4.GloballyUniqueAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gq.LatchingIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gq.OverbookingIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.1.1 AA-Request (AAR) command
	The AAR command, indicated by the Command-Code field set to 265 and the "R" bit set in the Command Flags field,
	is sent by an AF to the SPDF in order to request the authorization for the bearer usage for the AF session.
	Message Format:

	<AA-Request> ::= < Diameter Header: 265, REQ, PXY >
			  < Session-Id >
			  { Auth-Application-Id }
			  { Origin-Host }
			  { Origin-Realm }
			  { Destination-Realm }
			  [ Destination-Host ]
			 *[ Media-Component-Description ]
			 *[ Flow-Grouping ]
			  [ AF-Charging-Identifier ]
			  [ SIP-Forking-Indication ]
			 *[ Specific-Action ]
			  [ User-Name ]
			  [ Binding-Information ]
			  [ Latching-Indication ]
			  [ Reservation-Priority ]
			  [ Globally-Unique-Address ]
			  [ Service-Class ]
			  [ Authorization-Lifetime ]
			 *[ Proxy-Info ]
			 *[ Route-Record ]
			  [ Overbooking-indicator]
			* [ Authorization-Package-Id ]
			 *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.GQ, commandCode = CommandCodes.AAA, request = true, proxyable = true, name="AA-Request")
public interface AARequest extends com.mobius.software.telco.protocols.diameter.commands.gq.AARequest
{	
	BindingInformation getBindingInformation();
	
	void setBindingInformation(BindingInformation value);	
	
	LatchingIndicationEnum getLatchingIndication();
	
	void setLatchingIndication(LatchingIndicationEnum value);	
	
	ReservationPriorityEnum getReservationPriority();
	
	void setReservationPriority(ReservationPriorityEnum value);	
	
	GloballyUniqueAddress getGloballyUniqueAddress();
	
	void setGloballyUniqueAddress(GloballyUniqueAddress value);	
	
	String getServiceClass();
	
	void setServiceClass(String value);
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	OverbookingIndicatorEnum getOverbookingIndicator();
	
	void setOverbookingIndicator(OverbookingIndicatorEnum value);
	
	List<String> getAuthorizationPackageId();
	
	void setAuthorizationPackageId(List<String> value);
}