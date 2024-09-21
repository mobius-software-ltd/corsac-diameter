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
  	4.4.3 Charging-Context-Id AVP
	The Charging-Context-Id AVP (AVP code 1065) contains a unique identifier of
	the service specification that applies to the request. Charging-Context can not
	be changed during an ongoing charging interrogation session.
	The Charging-Context-Id AVP is of type UTF8String.
*/

@DiameterAvpDefinition(code = EricssonAvpCodes.CHARGING_CONTEXT_ID, vendorId = VendorIDs.ERICSSON_ID, name = "Charging-Context-Id")
public interface ChargingContextId extends DiameterUTF8String
{
	
}