package com.mobius.software.telco.protocols.diameter.commands.rfc4740;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAccountingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserData;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.11.  Push-Profile-Request (PPR) Command

   	The Push-Profile-Request (PPR) command is indicated by the
   	Command-Code set to 288 and the Command Flags' 'R' bit set.  The
   	Diameter server sends this command to the Diameter client in a SIP
   	server to update either the user profile of an already registered
   	user in that SIP server or the SIP accounting information.  This
   	allows an operator to modify the data of a user profile or the
   	accounting information and push it to the SIP server where the user
   	is registered.

   	Each user has a user profile associated with him/her and other
   	accounting information.  The profile or the accounting information
   	may change with time, e.g., due to addition of new services to the
   	user.  When the user profile or the accounting information changes,
   	the Diameter server sends a Diameter Push-Profile-Request (PPR)
   	command to the Diameter client in a SIP server, in order to start
   	applying those new services.

   	A PPR command MAY contain a SIP-Accounting-Information AVP that
   	updates the addresses of the accounting servers.  Changes in the
   	addresses of the accounting servers take effect immediately.  The
   	Diameter client SHOULD close any existing accounting session with the
   	existing server and start providing accounting information to the
   	newly acquired accounting server.

   	A PPR command MAY contain zero or more SIP-User-Data AVP values
   	containing the new user profile.  On selecting the type of user data,
   	the Diameter server SHOULD take into account the supported formats at
   	the SIP server (SIP-Supported-User-Data-Type AVP sent in a previous
   	SAR message) and the local policy.

   	The User-Name AVP indicates the user to whom the profile is
   	applicable.

   	The Message Format of the PPR command is as follows:

    <PPR> ::= < Diameter Header: 288, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { User-Name }
               * [ SIP-User-Data ]
                 [ SIP-Accounting-Information ]
                 [ Destination-Host ]
                 [ Authorization-Lifetime ]
                 [ Auth-Grace-Period ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 6, commandCode = 288, request = true, proxyable = true, name="Push-Profile-Request")
public interface PushProfileRequest extends AuthenticationRequest
{
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
	
	List<SIPUserData> getSIPUserData();
	
	void setSIPUserData(List<SIPUserData> value);
	
	SIPAccountingInformation getSIPAccountingInformation();
	
	void setSIPAccountingInformation(SIPAccountingInformation value);
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);	
	
	Long getAuthGracePeriod();
	
	void setAuthGracePeriod(Long value);
}