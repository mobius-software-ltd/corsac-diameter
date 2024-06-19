package com.mobius.software.telco.protocols.diameter.primitives.s15;

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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/*
 * E.6.3.3	CS-Service-QoS-Request-Operation
 * CS-Service-QoS-Request-Operation AVP (AVP code 2808) is type of Enumerated, 
 * and it indicates a resource request operation of the CS service. 
 * The following values are defined:
 * 
 * DELETION (0)
 *  This value is used to request that the resources reserved for 
 *  the provided QoS request identifiers are to be deleted and no longer used by CS service.
 *  
 *  MODIFICATION (1)
 *   This value is used to request that the reserved resources for 
 *   the provided QoS request identifiers are to be modified.
 * 
 */

@DiameterAvpDefinition(code = TgppAvpCodes.CS_SERVICE_QOS_REQUEST_OPERATION , vendorId = VendorIDs.TGPP_ID, must = true, name = "CS-Service-QoS-Request-Operation")
public interface CSServiceQoSRequestOperation extends DiameterEnumerated<CSServiceQoSRequestOperationEnum>
{
	
}
