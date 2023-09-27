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
 * 	9.3.  SIP-Server-Capabilities AVP

   	The SIP-Server-Capabilities AVP (AVP Code 372) is of type Grouped.
   	The Diameter indicates in this AVP the requirements for a particular
   	SIP capability, so that the Diameter client (SIP server) is able to
   	select another appropriate SIP server to serve the user.

   	The SIP-Server-Capabilities AVP allows a Diameter client (SIP server)
   	to select another SIP server for triggering or executing services to
   	the user.  A user may have enabled some services that require the
   	implementation of certain capabilities in the SIP server that
   	triggers or executes those services.  For example, the SIP server
   	that triggers or executes services to this user may need to implement
   	SIP servlets [JSR-000116], Call Processing Language (CPL) [RFC3880],
   	or any other kind of capability.  Or perhaps that user belongs to a
   	premium users group that has a certain stringent quality-of-service
   	agreement that requires a fast SIP server.  The capabilities required
   	or recommended to a given user are conveyed in the
   	SIP-Server-Capabilities AVP.  When it receives them, the Diameter
   	client (SIP server) that does the SIP server selection needs to have
   	the means to find out available SIP servers that meet the required or
   	optional capabilities.  Such means are outside the scope of this
   	specification.

   	Note that the SIP-Server-Capabilities AVP assists the Diameter client
   	(SIP server) to produce a subset of all the available SIP servers to
   	be allocated to the user in the Home Realm; this is the subset that
   	conforms the requirements of capabilities on a per-user basis.
   	Typically this subset will be formed of more than a single SIP	

   	server, so once the subset of those SIP servers is identified, it is
   	possible that several instances of these SIP servers exist, in which
   	case the Diameter client (SIP server) should choose one particular
   	SIP server to execute and trigger services to this user.  It is
   	expected that at this point the SIP server (Diameter client) will
   	follow the procedures of RFC 3263 [RFC3263] to allocate one SIP
   	server to the user.

   	The SIP-Server-Capabilities AVP is defined as follows (per the
   	grouped-avp-def of RFC 3588 [RFC3588]):

      SIP-Server-Capabilities ::= < AVP Header: 372 >
                                * [ SIP-Mandatory-Capability ]
                                * [ SIP-Optional-Capability ]
                                * [ SIP-Server-URI ]
                                * [ AVP ]             
 */
@DiameterAvpDefinition(code = 372L, vendorId = -1L, name = "SIP-Server-Capabilities")
public interface SIPServerCapabilities extends DiameterGroupedAvp
{
	List<Long> getSIPMandatoryCapability();
	
	void setSIPMandatoryCapability(List<Long> value);	
	
	List<Long> getSIPOptionalCapability();
	
	void setSIPOptionalCapability(List<Long> value);	
	
	List<String> getSIPServerURI();
	
	void setSIPServerURI(List<String> value);	
}