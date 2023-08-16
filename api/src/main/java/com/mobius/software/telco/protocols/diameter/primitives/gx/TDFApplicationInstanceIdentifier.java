package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.92 TDF-Application-Instance-Identifier AVP
	The TDF-Application-Instance-Identifier AVP (AVP Code 2802) is of type OctetString. It shall be dynamically
	assigned by the PCEF supporting ADC feature in order to allow correlation of application Start and Stop events to the
	specific service data flow description, if service data flow descriptions are deducible and shall be reported from the
	PCEF to the PCRF when the flow description is deducible along with the corresponding Event Trigger. 
 */
@DiameterAvpDefinition(code = 2802L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "TDF-Application-Instance-Identifier")
public interface TDFApplicationInstanceIdentifier extends DiameterOctetString
{
}