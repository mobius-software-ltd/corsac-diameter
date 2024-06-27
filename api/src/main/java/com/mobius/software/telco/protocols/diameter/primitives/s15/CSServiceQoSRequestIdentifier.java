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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/*
 * E.6.3.2	CS-Service-QoS-Request-Identifier
 * The CS-Service-QoS-Requset-Identifier (AVP code 2807) is of type OctetString,
 * and it identifies the QoS request instance request by the HNB GW for the CS-Service.
 * QoS request identifier is assigned by the HNB GW and within the scope of the HNB GW is unique per PCRF.
 */

@DiameterAvpDefinition(code = TgppAvpCodes.CS_SERVICE_QOS_REQUEST_INDENTIFIER , vendorId = VendorIDs.TGPP_ID, must = true, name = "CS-Service-QoS-Request-Identifier")
public interface CSServiceQoSRequestIdentifier extends DiameterOctetString
{
	
}
