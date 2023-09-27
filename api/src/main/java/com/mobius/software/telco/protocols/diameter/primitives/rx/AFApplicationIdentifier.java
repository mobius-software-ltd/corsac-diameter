package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 * 	5.3.5	AF-Application-Identifier AVP
	The AF-Application-identifier AVP (AVP code 504) is of type OctetString, and it contains information that identifies the particular service that the AF service session belongs to. This information may be used by the PCRF to differentiate QoS for different application services.
	For example the AF-Application-Identifier may be used as additional information together with the Media-Type AVP when the QoS class for the bearer authorization at the Gx interface is selected. The AF-Application-Identifier may be used also to complete the QoS authorization with application specific default settings in the PCRF if the AF does not provide full service information.
	The AF-Application-Identifier AVP may also be used to trigger the PCRF to indicate to the PCEF/TDF to perform the application detection based on the operator’s policy.
 */
@DiameterAvpDefinition(code = 504L, vendorId = KnownVendorIDs.TGPP_ID, name = "AF-Application-Identifier")
public interface AFApplicationIdentifier extends DiameterOctetString
{
}