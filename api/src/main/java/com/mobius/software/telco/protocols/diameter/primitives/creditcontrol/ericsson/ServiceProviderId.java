package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.1.7 Service-Provider-Id AVP
	The Service-Provider-Id AVP (AVP code 1081) is of type UTF8String and
	holds an identifier of the service provider. The use of the service provider is
	operator specific.
	The AVP is in this service context defined as ‘static’ and ‘cached’.
 */
@DiameterAvpDefinition(code = 1081L, vendorId = KnownVendorIDs.ERICSSON_ID, name = "Service-Provider-Id")
public interface ServiceProviderId extends DiameterUTF8String
{
}