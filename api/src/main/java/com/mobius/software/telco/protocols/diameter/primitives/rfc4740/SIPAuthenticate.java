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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.5.3.  SIP-Authenticate AVP

   	The SIP-Authenticate AVP (AVP Code 379) is of type Grouped and
   	contains a reconstruction of either the SIP WWW-Authenticate or
   	Proxy-Authentication header fields specified in RFC 2617 [RFC2617]
   	for the HTTP Digest authentication scheme.  Additionally, the AVP may
   	include a Digest-HA1 AVP that contains H(A1) (as defined in RFC 2617
   	[RFC2617]).  H(A1) allows the Diameter client to create an expected
   	response and compare it with the Digest response received from the
   	SIP UA.

   	The SIP-Authenticate AVP is defined as follows (per the
   	grouped-avp-def of RFC 3588 [RFC3588]):

      SIP-Authenticate ::= < AVP Header: 379 >
                           { Digest-Realm }
                           { Digest-Nonce }
                           [ Digest-Domain ]
                           [ Digest-Opaque ]
                           [ Digest-Stale ]
                           [ Digest-Algorithm ]
                           [ Digest-QoP ]
                           [ Digest-HA1]
                         * [ Digest-Auth-Param ]
                         * [ AVP ]            
 */
@DiameterAvpDefinition(code = 379L, vendorId = -1L, name = "SIP-Authenticate")
public interface SIPAuthenticate extends DiameterGroupedAvp
{
	String getDigestRealm();
	
	void setDigestRealm(String value);	
	
	String getDigestNonce();
	
	void setDigestNonce(String value);	
	
	String getDigestDomain();
	
	void setDigestDomain(String value);	
	
	String getDigestOpaque();
	
	void setDigestOpaque(String value);	
	
	String getDigestStale();
	
	void setDigestStale(String value);		
	
	String getDigestAlgorithm();
	
	void setDigestAlgorithm(String value);
	
	String getDigestQoP();
	
	void setDigestQoP(String value);		
	
	String getDigestHA1();
	
	void setDigestHA1(String value);		
	
	List<String> getDigestAuthParam();
	
	void setDigestAuthParam(List<String> value);	
}