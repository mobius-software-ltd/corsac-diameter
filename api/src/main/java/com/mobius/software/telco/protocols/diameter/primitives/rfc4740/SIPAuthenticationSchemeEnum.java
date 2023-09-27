package com.mobius.software.telco.protocols.diameter.primitives.rfc4740;

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
/**
*
* @author yulian oifa
*
*/

/*
 * 	9.5.1.  SIP-Authentication-Scheme AVP

   	The SIP-Authentication-Scheme AVP (AVP Code 377) is of type
   	Enumerated and indicates the authentication scheme used in the
   	authentication of SIP services.  RFC 2617 identifies this value as an
   	"auth-scheme" (see Section 1.2 of RFC 2617 [RFC2617]).  The only
   	currently defined value is:

   	o  	DIGEST (0) to indicate HTTP Digest authentication as specified in
      	RFC 2617 [RFC2617] Section 3.2.1.  Derivative work is also
      	considered Digest authentication scheme, as long as the
      	"auth-scheme" is identified as Digest in the SIP headers carrying
      	the HTTP authentication.  This includes, e.g., the HTTP Digest
      	authentication using AKA [RFC3310].

   	Each HTTP Digest directive (parameter) is transported in a
   	corresponding AVP, whose name follows the pattern Digest-*.  The
   	Digest-* AVPs are RADIUS attributes imported from the RADIUS
   	Extension for Digest Authentication [RFC4590] namespace, allowing a
   	smooth transition between RADIUS and Diameter applications supporting
   	SIP.  The Diameter SIP application goes a step further by grouping
   	the Digest-* AVPs into the SIP-Authenticate, SIP-Authorization, and

   	SIP-Authentication-Info grouped AVPs that correspond to the SIP WWW-
   	Authenticate/Proxy-Authentication, Authorization/Proxy-Authorization,
   	and Authentication-Info headers fields, respectively.

    Note: Due to the fact that HTTP Digest authentication [RFC2617] is
    the only mandatory authentication mechanism in SIP, this memo only
    provides support for HTTP Digest authentication and derivative
    work such as HTTP Digest authentication using AKA [RFC3310].
    Extensions to this memo can register new values and new AVPs to
    provide support for other authentication schemes or extensions to
    HTTP Digest authentication.

    Note: Although RFC 2617 [RFC2617] defines the Basic and Digest
    schemes for authenticating HTTP requests, RFC 3261 [RFC3261] only
    imports HTTP Digest as a mechanism to provide authentication in
    SIP.

   	Due to syntactic requirements, HTTP Digest authentication has to
   	escape quote characters in contents of HTTP Digest directives.  When
   	translating directives into Digest-* AVPs, the Diameter client or
   	server removes the surrounding quotes where present, as required by
   	the syntax of the Digest-* attributes defined in the "RADIUS
   	Extension for Digest Authentication" [RFC4590].
 */
public enum SIPAuthenticationSchemeEnum implements IntegerEnum
{
	DIGEST(0);

	private static final Map<Integer, SIPAuthenticationSchemeEnum> intToTypeMap = new HashMap<Integer, SIPAuthenticationSchemeEnum>();
	static
	{
	    for (SIPAuthenticationSchemeEnum type : SIPAuthenticationSchemeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static SIPAuthenticationSchemeEnum fromInt(Integer value) 
	{
		SIPAuthenticationSchemeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private SIPAuthenticationSchemeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
