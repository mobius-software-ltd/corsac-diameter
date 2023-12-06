package com.mobius.software.telco.protocols.diameter.commands.slh;
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
 * 	6.2.3	LCS-Routing-Info-Request (RIR) Command
	The LCS-Routing-Info-Request (RIR) command, indicated by the Command-Code field set to 8388622 and the "R" bit set in the Command Flags field, is sent from GMLC to HSS. 
	Message Format

	< LCS-Routing-Info-Request> ::=	< Diameter Header: 8388622, REQ, PXY, 16777291 >
					 < Session-Id >
					 [ Vendor-Specific-Application-Id ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 [ Destination-Host ]
					 { Destination-Realm }
					 [ User-Name ]
					 [ MSISDN ]
					 [ GMLC-Number ]
					*[ Supported-Features ]
					*[ Proxy-Info ]
					*[ Route-Record ]
					*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777291, commandCode = 8388622, request = true, proxyable = true, name="LCS-Routing-Info-Request")
public interface LCSRoutingInfoRequest extends SlhRequest
{
	String getMSISDN();
	
	void setMSISDN(String value);
	
	String getGMLCNumber();
	 
	void setGMLCNumber(String value);
}