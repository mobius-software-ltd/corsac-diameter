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
 * 6.13.  Redirect-Host-Usage AVP

   The Redirect-Host-Usage AVP (AVP Code 261) is of type Enumerated.
   This AVP MAY be present in answer messages whose 'E' bit is set and
   the Result-Code AVP is set to DIAMETER_REDIRECT_INDICATION.

   When present, this AVP provides hints about how the routing entry
   resulting from the Redirect-Host is to be used.  The following values
   are supported:
   
   DONT_CACHE 0

      The host specified in the Redirect-Host AVP SHOULD NOT be cached.
      This is the default value.

   ALL_SESSION 1

      All messages within the same session, as defined by the same value
      of the Session-ID AVP SHOULD be sent to the host specified in the
      Redirect-Host AVP.

   ALL_REALM 2

      All messages destined for the realm requested SHOULD be sent to
      the host specified in the Redirect-Host AVP.

   REALM_AND_APPLICATION 3

      All messages for the application requested to the realm specified
      SHOULD be sent to the host specified in the Redirect-Host AVP.

   ALL_APPLICATION 4

      All messages for the application requested SHOULD be sent to the
      host specified in the Redirect-Host AVP.

   ALL_HOST 5

      All messages that would be sent to the host that generated the
      Redirect-Host SHOULD be sent to the host specified in the
      Redirect-Host AVP.

   ALL_USER 6

      All messages for the user requested SHOULD be sent to the host
      specified in the Redirect-Host AVP.

   When multiple cached routes are created by redirect indications and
   they differ only in redirect usage and peers to forward requests to
   (see Section 6.1.8), a precedence rule MUST be applied to the
   redirect usage values of the cached routes during normal routing to
   resolve contentions that may occur.  The precedence rule is the order
   that dictate which redirect usage should be considered before any
   other as they appear.  The order is as follows:
   
   1.  ALL_SESSION

   2.  ALL_USER

   3.  REALM_AND_APPLICATION

   4.  ALL_REALM

   5.  ALL_APPLICATION

   6.  ALL_HOST
 */
public enum RedirectHostUsageEnum implements IntegerEnum
{
	DONT_CACHE(0),ALL_SESSION(1),ALL_REALM(2),REALM_AND_APPLICATION(3),ALL_APPLICATION(4),ALL_HOST(5),ALL_USER(6);

	private static final Map<Integer, RedirectHostUsageEnum> intToTypeMap = new HashMap<Integer, RedirectHostUsageEnum>();
	static 
	{
	    for (RedirectHostUsageEnum type : RedirectHostUsageEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static RedirectHostUsageEnum fromInt(Integer value) 
	{
		RedirectHostUsageEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private RedirectHostUsageEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
