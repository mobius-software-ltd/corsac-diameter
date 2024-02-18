package com.mobius.software.telco.protocols.diameter.commands.rx;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.8	Abort-Session-Answer (ASA) command
	The ASA command, indicated by the Command-Code field set to 274 and the ‘R’ bit cleared in the Command Flags field, is sent by the AF to the PCRF in response to the ASR command.
	Message Format:
	
	<AS-Answer>  ::=  < Diameter Header: 274, PXY >
				  < Session-Id >
				  [ DRMP ]
				  { Origin-Host }
				  { Origin-Realm }
				  [ Result-Code ]
				  [ OC-Supported-Features ]
				  [ OC-OLR ]
				  [ Origin-State-Id ]
				  [ Error-Message ]
				  [ Error-Reporting-Host ]
				  [ Failed-AVP ]
				 *[ Redirect-Host ]
				  [ Redirect-Host-Usage ]
				  [ Redirect-Max-Cache-Time ]
				 *[ Proxy-Info ]
				 *[ AVP ]

	The Experimental-Result AVP contains an Experimental-Result-Code AVP and will signal to the Diameter server that the IP-CAN bearer (e.g. PDP context) has been succesfully terminated as requested. See subclause 16a.6 for the description of the Experimental-Result-Code AVP.
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.RX, commandCode = CommandCodes.ABORT_SESSION, request = false, proxyable = true, name="Abort-Session-Answer")
public interface AbortSessionAnswer extends RxAnswer
{	
}