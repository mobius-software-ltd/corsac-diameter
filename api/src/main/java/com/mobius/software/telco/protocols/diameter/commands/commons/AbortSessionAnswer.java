package com.mobius.software.telco.protocols.diameter.commands.commons;
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

import java.text.ParseException;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.RedirectHostUsageEnum;

/**
*
* @author yulian oifa
*
*/

/*The Abort-Session-Answer (ASA), indicated by the Command Code set to
   274 and the message flags' 'R' bit clear, is sent in response to the
   ASR.  The Result-Code AVP MUST be present and indicates the
   disposition of the request.

   If the session identified by Session-Id in the ASR was successfully
   terminated, the Result-Code is set to DIAMETER_SUCCESS.  If the
   session is not currently active, the Result-Code is set to
   DIAMETER_UNKNOWN_SESSION_ID.  If the access device does not stop the
   session for any other reason, the Result-Code is set to
   DIAMETER_UNABLE_TO_COMPLY.

   Message Format

         <ASA>  ::= < Diameter Header: 274, PXY >
                    < Session-Id >
                    { Result-Code }
                    { Origin-Host }
                    { Origin-Realm }
                    [ User-Name ]
                    [ Origin-State-Id ]
                    [ Error-Message ]
                    [ Error-Reporting-Host ]
                    [ Failed-AVP ]
                  * [ Redirect-Host ]
                    [ Redirect-Host-Usage ]
                    [ Redirect-Max-Cache-Time ]
                  * [ Proxy-Info ]
                  * [ AVP ]
*/

@DiameterCommandDefinition(applicationId = -1, commandCode = 274, request = false, proxyable = true, name="Abort-Session-Answer")
public interface AbortSessionAnswer extends DiameterAnswer
{    		   
	public String getUsername();
	
	void setUsername(String value);
	
	public List<String> getRedirectHost();
	
	void setRedirectHost(List<String> value) throws ParseException;

	public RedirectHostUsageEnum getRedirectHostUsage();
	
	void setRedirectHostUsage(RedirectHostUsageEnum value);
	
	public Long getRedirectMaxCacheTime();
	
	void setRedirectMaxCacheTime(Long value);
}