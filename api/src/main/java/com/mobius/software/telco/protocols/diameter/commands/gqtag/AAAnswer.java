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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.gq.BindingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;

/**
*
* @author yulian oifa
*
*/

/*
 *  7.1.2 AA-Answer (AAA) command
	The AAA command, indicated by the Command-Code field set to 265 and the "R" bit cleared in the Command Flags
	field, is sent by the SPDF to the AF in response to the AAR command.
	
	Message Format:
	<AA-Answer> ::= < Diameter Header: 265, PXY >
			  < Session-Id >
			  { Auth-Application-Id }
			  { Origin-Host }
			  { Origin-Realm }
			  [ Result-Code ]
			  [ Experimental-Result ]
			  [ Binding-Information ]
			  [ Reservation-Priority ]
			  [ Error-Message ]
			  [ Error-Reporting-Host ]
			  [ Authorization-Lifetime ]
			  [ Auth-Grace-Period ]
			 *[ Failed-AVP ]
			 *[ Proxy-Info ]
			 *[ AVP ] 
 */
@DiameterCommandDefinition(applicationId = 16777222, commandCode = 265, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends AuthenticationAnswer
{
	BindingInformation getBindingInformation();
	
	void setBindingInformation(BindingInformation value);	
	
	ReservationPriorityEnum getReservationPriority();
	
	void setReservationPriority(ReservationPriorityEnum value);	
	
	public Long getAuthorizationLifetime(); 
	
	public void setAuthorizationLifetime(Long value); 
	
	public Long getAuthGracePeriod();
	
	public void setAuthGracePeriod(Long value); 
	
	
}