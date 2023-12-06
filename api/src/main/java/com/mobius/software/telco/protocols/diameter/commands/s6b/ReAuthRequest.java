package com.mobius.software.telco.protocols.diameter.commands.s6b;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.2.2.6.1	Re-Auth-Request (RAR) Command
	The Diameter Re-Auth-Request (RAR) command shall be indicated by the Command-Code field set to 258 and the "R" bit set in the Command Flags field and is sent from a 3GPP AAA Server or 3GPP AAA Proxy to a PDN-GW. The ABNF for the RAR command shall be as follows:

	< Re-Auth-Request >  ::=	< Diameter Header: 258, REQ, PXY, 16777272 >
			 < Session-Id >
			 [ DRMP ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Destination-Realm }
			 { Destination-Host }
			 { Auth-Application-Id }
			 { Re-Auth-Request-Type }
			 [ User-Name ]
			 [RAR-Flags ]
			...
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777272, commandCode = 258, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends S6bRequest
{	
	public ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value);
	
	Long getRARFlags();
	
	void setRARFlags(Long value);
}