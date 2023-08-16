package com.mobius.software.telco.protocols.diameter.primitives.nas;

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
 * 4.4.1.  Service-Type AVP

   The Service-Type AVP (AVP Code 6) is of type Enumerated and contains
   the type of service the user has requested or the type of service to
   be provided.  One such AVP MAY be present in an authentication and/or
   authorization request or response.  A NAS is not required to
   implement all of these service types.  It MUST treat unknown or
   unsupported Service-Type AVPs received in a response as a failure and
   end the session with a DIAMETER_INVALID_AVP_VALUE Result-Code.

   When used in a request, the Service-Type AVP SHOULD be considered a
   hint to the server that the NAS believes the user would prefer the
   kind of service indicated.  The server is not required to honor the
   hint.  Furthermore, if the service specified by the server is
   supported, but not compatible with the current mode of access, the
   NAS MUST fail to start the session.  The NAS MUST also generate the
   appropriate error message(s).

   The complete list of defined values that the Service-Type AVP can
   take can be found in [RFC2865] and the relevant IANA registry
   [RADIUSAttrVals], but the following values require further
   qualification here:

      Login (1)

         The user should be connected to a host.  The message MAY
         include additional AVPs as defined in Sections 4.4.11.4 or
         4.4.11.5.

      Framed (2)

         A Framed Protocol, such as PPP or SLIP, should be started for
         the user.  The message MAY include additional AVPs defined in
         Sections 4.4.10 or 4.5 for tunneling services.

      Callback Login (3)

         The user should be disconnected and called back, then connected
         to a host.  The message MAY include additional AVPs defined in
         this section.
         
	  Callback Framed (4)

         The user should be disconnected and called back, and then a
         Framed Protocol, such as PPP or SLIP, should be started for the
         user.  The message MAY include additional AVPs defined in
         Sections 4.4.10 or 4.5 for tunneling services.
 */
public enum ServiceTypeEnum implements IntegerEnum
{
	LOGIN(1),FRAMED(2),CALLBACK_LOGIN(3),CALLBACK_FRAMED(4);

	private static final Map<Integer, ServiceTypeEnum> intToTypeMap = new HashMap<Integer, ServiceTypeEnum>();
	static 
	{
	    for (ServiceTypeEnum type : ServiceTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ServiceTypeEnum fromInt(Integer value) 
	{
		ServiceTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ServiceTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
