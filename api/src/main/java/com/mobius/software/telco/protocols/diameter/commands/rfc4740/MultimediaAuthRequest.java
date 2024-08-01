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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthDataItem;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.7.  Multimedia-Auth-Request (MAR) Command

   	The Multimedia-Auth-Request (MAR) command is indicated by the
   	Command-Code set to 286 and the Command Flags' 'R' bit set.  The
   	Diameter client in a SIP server sends this command to the Diameter
   	server to request that the Diameter server authenticate and authorize
   	a user attempt to use some SIP service (in this context, SIP service
   	can be something as simple as a SIP subscription or using the proxy
   	services for a SIP request).

   	The MAR command may also register the SIP server's own URI to the
   	Diameter server, so that future LIR/LIA messages can return this URI.
   	If the SIP server is acting as a SIP registrar (see examples in
   	Sections 6.2 and 6.3), its Diameter client MUST include a SIP-
   	Server-URI AVP in the MAR command.  In any other cases (see example
   	in Section 6.4), its Diameter client MUST NOT include a SIP-Server-
   	URI AVP in the MAR command.

   	The SIP-Method AVP MUST include the SIP method name of the SIP
   	request that triggered this Diameter MAR message.  The Diameter
   	server can use this AVP to authorize some SIP requests depending on
   	the method.

   	The Diameter MAR message MUST include a SIP-AOR AVP.  The SIP-AOR AVP
   	indicates the target of the SIP request.  The value of the AVP is
   	extracted from different places in SIP request, depending on the
   	semantics of the SIP request.  For SIP REGISTER messages the SIP-AOR
   	AVP value indicates the intended public user identity under
   	registration, and it is the SIP or SIPS URI populated in the To
   	header field value (addr-spec as per RFC 3261 [RFC3261]) of the SIP
   	REGISTER request.  For other types of SIP requests, such as INVITE,
   	SUBSCRIBE, MESSAGE, etc., the SIP-AOR AVP value indicates the
   	intended destination of the request.  This is typically populated in
   	the Request-URI of the SIP request.  Extracting the SIP-AOR AVP value
	from the proper SIP header field is the Diameter client's
   	responsibility.  Extensions to SIP (new SIP methods or new semantics)
   	may require the SIP-AOR to be extracted from other parts of the
   	request.

   	If the SIP request includes some sort of authentication information,
   	the Diameter client MUST include the user name, extracted from the
   	authentication information of the SIP request, in the User-Name AVP
   	value.

   	The Message Format of the MAR command is as follows:

    <MAR> ::= < Diameter Header: 286, REQ, PXY >
                 < Session-Id >
                 { Auth-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { SIP-AOR }
                 { SIP-Method }
                 [ Destination-Host ]
                 [ User-Name ]
                 [ SIP-Server-URI ]
                 [ SIP-Number-Auth-Items ]
                 [ SIP-Auth-Data-Item ]
               * [ Proxy-Info ]
               * [ Route-Record ]
               * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SIP_APPLICATION, commandCode = CommandCodes.MULTIMEDIA_AUTH, request = true, proxyable = true, name="Multimedia-Auth-Request")
public interface MultimediaAuthRequest extends Rfc4740Request
{
	String getSIPAOR();
	
	void setSIPAOR(String value) throws MissingAvpException;
	
	String getSIPMethod();
	
	void setSIPMethod(String value) throws MissingAvpException;
	
	String getSIPServerURI();
	
	void setSIPServerURI(String value);
	
	Long getSIPNumberAuthItems();
	
	void setSIPNumberAuthItems(Long value);
	
	SIPAuthDataItem getSIPAuthDataItem();
	
	void setSIPAuthDataItem(SIPAuthDataItem value);        			
}