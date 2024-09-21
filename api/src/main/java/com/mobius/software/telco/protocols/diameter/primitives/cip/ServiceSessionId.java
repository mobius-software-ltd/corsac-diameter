package com.mobius.software.telco.protocols.diameter.primitives.cip;
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

import com.mobius.software.telco.protocols.diameter.EricssonAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/*	
  	4.4.7 Service-Session-Id AVP
	The Service-Session-Id AVP (AVP code 1068) is used to identify a specific
	service session within an ongoing charging interrogation session. This AVP
	is always included in an MSCC AVP for session based charging. It is a
	local identifier used between CIP/IP Client and SDP. The Service-Session-Id
	is unique within a charging interrogation session which is identified by a
	Session-Id. The lifetime of a Service-Session-Id is from the start of a service
	until the service is terminated. If the same service is used later on within the
	same charging interrogation session, a new Service-Session-Id will be used.
	Service-Session-Id AVP is not used for One Time Events.
	The Service-Session-Id AVP is of type UTF8String.
*/

@DiameterAvpDefinition(code = EricssonAvpCodes.SERVICE_SESSION_ID, vendorId = VendorIDs.ERICSSON_ID, name = "Service-Session-Id")
public interface ServiceSessionId extends DiameterUTF8String
{
	
}