package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.64.  Redirect-Server-Extension AVP

   The Redirect-Server-Extension AVP (AVP Code 665) is of type Grouped
   and contains the address information of the redirect server (e.g.,
   HTTP redirect server, SIP Server) with which the end user is to be
   connected when the account cannot cover the service cost.  It MUST be
   present inside the QoS-Final-Unit-Indication AVP when the Final-Unit-
   Action AVP is set to REDIRECT.  If the type of the redirect server is
   one of the enumerated values of the Redirect-Address-Type AVP, then
   the credit-control server SHOULD send the information in the
   Redirect-Server AVP, in addition to or instead of the Redirect-
   Server-Extension AVP.  This is done in order to preserve backward
   compatibility with credit-control clients that support only
   [RFC4006].  Exactly one AVP MUST be included inside the Redirect-
   Server-Extension AVP.

   The Redirect-Server-Extension AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

        Redirect-Server-Extension ::= < AVP Header: 665 >
                                  [ Redirect-Address-IPAddress ]
                                  [ Redirect-Address-URL ]
                                  [ Redirect-Address-SIP-URI ]
                                  [ AVP ]
 */
@DiameterAvpDefinition(code = 665L, vendorId = -1, must = false, name = "Redirect-Server-Extension")
public interface RedirectServerExtension extends DiameterGroupedAvp 
{
	InetAddress getIPAddress();
	
	void setIPAddress(InetAddress address);
	
	String getURL();
	
	void setURL(String url);
	
	String getSIPURI();
	
	void setSIPURI(String sipURI);		
}