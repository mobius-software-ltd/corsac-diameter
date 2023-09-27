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
 * 	9.5.4.  SIP-Authorization AVP

   	The SIP-Authorization AVP (AVP Code 380) is of type Grouped and
   	contains a reconstruction of either the SIP Authorization or
   	Proxy-Authorization header fields specified in RFC 2617 [RFC2617] for
   	the HTTP Digest authentication scheme.

   	The SIP-Authorization AVP is defined as follows (per the
   	grouped-avp-def of RFC 3588 [RFC3588]):

      SIP-Authorization ::= < AVP Header: 380 >
                            { Digest-Username }
                            { Digest-Realm }
                            { Digest-Nonce }
                            { Digest-URI }
                            { Digest-Response }
                            [ Digest-Algorithm ]
                            [ Digest-CNonce ]
                            [ Digest-Opaque ]
                            [ Digest-QoP ]
                            [ Digest-Nonce-Count ]
                            [ Digest-Method]
                            [ Digest-Entity-Body-Hash ]
                          * [ Digest-Auth-Param ]
                          * [ AVP ]             
 */
@DiameterAvpDefinition(code = 380L, vendorId = -1L, name = "SIP-Authorization")
public interface SIPAuthorization extends DiameterGroupedAvp
{
	String getDigestUsername();
	
	void setDigestUsername(String value);	
	
	String getDigestRealm();
	
	void setDigestRealm(String value);	
	
	String getDigestNonce();
	
	void setDigestNonce(String value);	
	
	String getDigestURI();
	
	void setDigestURI(String value);	
	
	String getDigestResponse();
	
	void setDigestResponse(String value);	
	
	String getDigestAlgorithm();
	
	void setDigestAlgorithm(String value);		
	
	String getDigestCNonce();
	
	void setDigestCNonce(String value);		
	
	String getDigestOpaque();
	
	void setDigestOpaque(String value);		
	
	String getDigestQoP();
	
	void setDigestQoP(String value);		
	
	String getDigestNonceCount();
	
	void setDigestNonceCount(String value);		
	
	String getDigestMethod();
	
	void setDigestMethod(String value);		
	
	String getDigestEntityBodyHash();
	
	void setDigestEntityBodyHash(String value);		
	
	List<String> getDigestAuthParam();
	
	void setDigestAuthParam(List<String> value);		
}