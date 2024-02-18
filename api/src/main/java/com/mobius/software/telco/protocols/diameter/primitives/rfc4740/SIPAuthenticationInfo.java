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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.5.5.  SIP-Authentication-Info AVP

   	The SIP-Authentication-Info AVP (AVP Code 381) is of type Grouped and
   	contains a reconstruction of the SIP Authentication-Info header
   	specified in RFC 2617 [RFC2617] for the HTTP Digest authentication
   	scheme.

	The SIP-Authentication-Info AVP is defined as follows (per the
   	grouped-avp-def of RFC 3588 [RFC3588]):

      SIP-Authentication-Info ::= < AVP Header: 381 >
                                  [ Digest-Nextnonce ]
                                  [ Digest-QoP ]
                                  [ Digest-Response-Auth ]
                                  [ Digest-CNonce ]
                                  [ Digest-Nonce-Count ]
                                * [ AVP ]

   	Note that, in some cases, the Digest-Response-Auth AVP cannot be
   	calculated at the Diameter server, but has to be calculated at the
   	Diameter client (SIP server).  For example, if the value of the
   	quality of protection (qop) parameter in Digest is set to "auth-int",
   	then the response-digest (rspauth parameter value in Digest) is
   	calculated with the hash of the body of the SIP response, which is
   	not available at the Diameter server.  In this case, the Diameter
   	client (SIP server) must calculate the response-digest once the body
   	of the SIP response is calculated.

   	Therefore, a value of "auth-int" in the Digest-QoP AVP of the
   	SIP-Authentication-Info AVP indicates that the Diameter client (SIP
   	server) MUST compute the Digest "rspauth" parameter value at the
   	Diameter client (SIP server).                        
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_AUTHENTICATION_INFO, vendorId = -1L, name = "SIP-Authentication-Info")
public interface SIPAuthenticationInfo extends DiameterGroupedAvp
{
	String getDigestNextnonce();
	
	void setDigestNextnonce(String value);	
	
	String getDigestQoP();
	
	void setDigestQoP(String value);	
	
	String getDigestResponseAuth();
	
	void setDigestResponseAuth(String value);	
	
	String getDigestCNonce();
	
	void setDigestCNonce(String value);	
	
	String getDigestNonceCount();
	
	void setDigestNonceCount(String value);	
}