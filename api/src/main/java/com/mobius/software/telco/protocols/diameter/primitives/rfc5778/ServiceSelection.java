package com.mobius.software.telco.protocols.diameter.primitives.rfc5778;
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
	6.2.  Service-Selection AVP

   	The Service-Selection AVP (AVP Code 493) is of type UTF8String and
   	contains the name of the service or the external network with which
   	the mobility service should be associated.  In the scope of this
   	specification, the value can be extracted from the IKEv2 IDr payload,
   	if available in the IKE_AUTH message sent by the IKE initiator.
   	Alternatively, if the Mobile IPv6 Authentication Protocol is used,
   	then the Service-Selection AVP contains the string extracted from the
   	Service Selection Mobility Option [RFC5149], if available in the
   	received BU.  Future specifications may define additional ways to
   	populate the Service-Selection AVP with the required information.

   	The AVP is also available to be used in messages sent from the
   	Diameter server to the Diameter client.  For example, if the request
   	message did not contain the Service-Selection AVP but the MN was
   	assigned with a default service, the Diameter server MAY return the
   	name of the assigned default service to the HA.

   	If the Service-Selection AVP is present in both the request and the
   	reply messages, it SHOULD contain the same service name.  If the
   	services differ, the HA MAY treat that as authorization failure.	   
 */
@DiameterAvpDefinition(code = AvpCodes.SERVICE_SELECTION, vendorId = -1, name = "Service-Selection")
public interface ServiceSelection extends DiameterUTF8String
{
}