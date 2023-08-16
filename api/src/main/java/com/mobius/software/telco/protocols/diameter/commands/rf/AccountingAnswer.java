package com.mobius.software.telco.protocols.diameter.commands.rf;
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

/**
*
* @author yulian oifa
*
*/

/*
 *  The ACA messages, indicated by the Command-Code field set to 271 is sent by the CDF to the CTF in order to reply to
	the ACR.
	The ACA message format is defined according to the Diameter Base Protocol in RFC 6733 [401] as follows:
 	<ACA> ::= < Diameter Header: 271, PXY >

			 < Session-Id >
			 { Result-Code }
			 [ Experimental-Result ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Accounting-Record-Type }
			 { Accounting-Record-Number }
			 [ Acct-Application-Id ]
			 [ User-Name ]			 
			 [ Error-Message ]
			 [ Error-Reporting-Host ]
			 [ Acct-Interim-Interval ]
			 [ Failed-AVP ]
			 [ Origin-State-Id ]
			 [ Event-Timestamp ]
			 * [ Proxy-Info ]
			 * [ AVP ] 
 */
@DiameterCommandDefinition(applicationId = 3, commandCode = 271, request = false, proxyable = true, name="Accounting-Answer")
public interface AccountingAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer
{
		
}