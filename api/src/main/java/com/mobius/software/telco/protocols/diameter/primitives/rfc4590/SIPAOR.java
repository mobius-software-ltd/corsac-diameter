package com.mobius.software.telco.protocols.diameter.primitives.rfc4590;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/

/*
	3.20.  SIP-AOR Attribute

   	Description
         This attribute is used for the authorization of SIP messages.
         The SIP-AOR attribute identifies the URI, the use of which must
         be authenticated and authorized.  The RADIUS server uses this
         attribute to authorize the processing of the SIP request.  The
         SIP-AOR can be derived from, for example, the To header field
         in a SIP REGISTER request (user under registration), or the
         From header field in other SIP requests.  However, the exact
         mapping of this attribute to SIP can change due to new
         developments in the protocol.  This attribute MUST only be used
         when the RADIUS client wants to authorize SIP users and MUST
         only be used in Access-Request packets.
   
   	Type
         122 for SIP-AOR
   
   	Length
         >=3
   
   	Text
         The syntax of this attribute corresponds either to a SIP URI
         (with the format defined in [RFC3261] or a tel URI (with the
         format defined in [RFC3966]).

         The SIP-AOR attribute holds the complete URI, including
         parameters and other parts.  It is up to the RADIUS server what
         components of the URI are regarded in the authorization
         decision.
 */
@DiameterAvpDefinition(code = AvpCodes.SIP_AOR, vendorId = -1, name = "SIP-AOR")
public interface SIPAOR extends DiameterUTF8String
{
}