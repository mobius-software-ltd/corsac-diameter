package com.mobius.software.telco.protocols.diameter.primitives.common;

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
 * 8.7.  Auth-Request-Type AVP

   The Auth-Request-Type AVP (AVP Code 274) is of type Enumerated and is
   included in application-specific auth requests to inform the peers
   whether a user is to be authenticated only, authorized only, or both.
   Note any value other than both MAY cause RADIUS interoperability
   issues.  The following values are defined:

   AUTHENTICATE_ONLY 1

      The request being sent is for authentication only, and it MUST
      contain the relevant application-specific authentication AVPs that
      are needed by the Diameter server to authenticate the user.

   AUTHORIZE_ONLY 2

      The request being sent is for authorization only, and it MUST
      contain the application-specific authorization AVPs that are
      necessary to identify the service being requested/offered.

   AUTHORIZE_AUTHENTICATE 3

      The request contains a request for both authentication and
      authorization.  The request MUST include both the relevant
      application-specific authentication information and authorization
      information necessary to identify the service being requested/
      offered.
 */
public enum AuthRequestTypeEnum implements IntegerEnum
{
	AUTHENTICATE_ONLY(1),AUTHORIZE_ONLY(2),AUTHORIZE_AUTHENTICATE(3);

	private static final Map<Integer, AuthRequestTypeEnum> intToTypeMap = new HashMap<Integer, AuthRequestTypeEnum>();
	static 
	{
	    for (AuthRequestTypeEnum type : AuthRequestTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AuthRequestTypeEnum fromInt(Integer value) 
	{
		AuthRequestTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AuthRequestTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
