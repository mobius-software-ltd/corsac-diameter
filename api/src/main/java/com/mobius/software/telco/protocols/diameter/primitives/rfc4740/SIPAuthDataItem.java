package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.5.  SIP-Auth-Data-Item AVP

   	The SIP-Auth-Data-Item (AVP Code 376) is of type Grouped and contains
   	the authentication and/or authorization information pertaining to a
   	user.

   	When the Diameter server uses the grouped SIP-Auth-Data-Item AVP to
   	include a SIP-Authenticate AVP, the Diameter server MUST send a
   	maximum of one authentication data item (e.g., in case the SIP
   	request contained several credentials).  Section 11 contains a
   	detailed discussion and normative text of the case when a SIP request
   	contains several credentials.

   	The SIP-Auth-Data-Item AVP is defined as follows (per the
   	grouped-avp-def of RFC 3588 [RFC3588]):

      SIP-Auth-Data-Item ::= < AVP Header: 376 >
                             { SIP-Authentication-Scheme }
                             [ SIP-Item-Number ]
                             [ SIP-Authenticate ]
                             [ SIP-Authorization ]
                             [ SIP-Authentication-Info ]
                           * [ AVP ]          
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_AUTH_DATA_ITEM, vendorId = -1L, name = "SIP-Auth-Data-Item")
public interface SIPAuthDataItem extends DiameterGroupedAvp
{
	SIPAuthenticationSchemeEnum getSIPAuthenticationScheme();
	
	void setSIPAuthenticationScheme(SIPAuthenticationSchemeEnum value) throws MissingAvpException;	
	
	Long getSIPItemNumber();
	
	void setSIPItemNumber(Long value);
	
	SIPAuthenticate getSIPAuthenticate();
	
	void setSIPAuthenticate(SIPAuthenticate value);
	
	SIPAuthorization getSIPAuthorization();
	
	void setSIPAuthorization(SIPAuthorization value);
	
	SIPAuthenticationInfo getSIPAuthenticationInfo();
	
	void setSIPAuthenticationInfo(SIPAuthenticationInfo value);
}