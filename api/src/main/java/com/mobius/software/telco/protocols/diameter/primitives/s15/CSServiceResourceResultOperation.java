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
 * E.6.3.4 CS-Service-Resource-Result-Operation
 * CS-Service-Resource-Result-Operation AVP (AVP code 2815) is type of Enumerated, 
 * and it indicates a resource result operation of the CS service in the Fixed Broadband Access network.
 * The following values are defined:
 * 
 *  DELETION (0)
 *	This value is used to indicate a result that the resources reserved for 
 *	the provided QoS request identifiers have been removed by the Fixed Broadband Access network.
 * 
 */

@DiameterAvpDefinition(code = TgppAvpCodes.CS_SERVICE_RESOURCE_RESULT_OPERATION , vendorId = VendorIDs.TGPP_ID, must = true, name = "CS-Service-Resource-Result-Operation")
public interface CSServiceResourceResultOperation extends DiameterEnumerated<CSServiceResourceResultOperationEnum>
{
	
}
