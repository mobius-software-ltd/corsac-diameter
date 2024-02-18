package com.mobius.software.telco.protocols.diameter.primitives.sh;
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

/**
*
* @author yulian oifa
*
*/

/*
	6.3.5 Service-Indication AVP
	The Service-Indication AVP is of type OctetString. This AVP contains the Service Indication that identifies a service or
	a set of services in an AS and the related repository data in the HSS. Standardized values of Service-Indication
	identifying a standardized service or set of services in the AS and standardized format of the related repository data are
	defined in 3GPP TS 29.364 [10]. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_INDICATION, vendorId = VendorIDs.TGPP_ID, name = "Service-Indication")
public interface ServiceIndication extends DiameterOctetString
{
}