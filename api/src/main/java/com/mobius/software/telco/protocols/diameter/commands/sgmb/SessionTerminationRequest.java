package com.mobius.software.telco.protocols.diameter.commands.sgmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.DiagnosticInfo;

/**
*
* @author yulian oifa
*
*/

/*
 * 	20.4.3		Session-Termination-Request Command
	A DIAMETER session may be terminated by the MBMS GW in exceptional cases.
	The relevant AVPs that are of use for the SGmb interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for SGmb purposes and should be ignored by the receiver or processed according to the relevant specifications.
	Message Format:

	<ST-Request> ::= < Diameter Header: 275, REQ, PXY >
                      	< Session-Id >
                      	{ Origin-Host }
                      	{ Origin-Realm }
                      	{ Destination-Realm }
                      	{ Auth-Application-Id }
                      	{ Termination-Cause }
                      	[ Destination-Host ]
                      *	[ Class ]
                      	[ Origin-State-Id ]
                      *	[ Proxy-Info ]
                      *	[ Route-Record ]
                      	[ Diagnostic-Info ]
	                 	[ Restart-Counter ]
 */
@DiameterCommandDefinition(applicationId = 16777292, commandCode = 275, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.SessionTerminationRequest
{
	DiagnosticInfo getDiagnosticInfo();
	
	void setDiagnosticInfo(DiagnosticInfo value);
	
	Long getRestartCounter();
	
	void setRestartCounter(Long value);	
}