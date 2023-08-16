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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;

/**
*
* @author yulian oifa
*
*/

/*
 * 	The ACR messages, indicated by the Command-Code field set to 271 is sent by the CTF to the CDF in order to send
	charging information for the requested bearer / subsystem /service.
	The ACR message format is defined according to the Diameter Base Protocol in RFC 6733 [401] as follows:
 	<ACR> ::= < Diameter Header: 271, REQ, PXY >
 
			 < Session-Id >
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 { Accounting-Record-Type }
			 { Accounting-Record-Number }
			 [ Acct-Application-Id ]
			 [ User-Name ]
			 [ Destination-Host ]			 
			 [ Acct-Interim-Interval ]
			 [ Origin-State-Id ]
			 [ Event-Timestamp ]
			 * [ Proxy-Info ]
			 * [ Route-Record ]
			 [ Service-Context-Id ]
			 [ Service-Information ]
			 * [ AVP ] 
 */
@DiameterCommandDefinition(applicationId = 3, commandCode = 271, request = true, proxyable = true, name="Accounting-Request")
public interface AccountingRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.AccountingRequest
{
	String getServiceContextId();
	
	void setServiceContextId(String serviceContextId);
	
	ServiceInformation getServiceInformation();
	
	void setServiceInformation(ServiceInformation serviceInformation);
}