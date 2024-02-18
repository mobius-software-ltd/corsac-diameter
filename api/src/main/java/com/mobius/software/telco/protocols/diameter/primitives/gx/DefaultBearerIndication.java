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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.132 Default-Bearer-Indication AVP
	The Default-Bearer-Indication AVP (AVP code 2844) is of type Enumerated and is used by the PCRF to indicate the
	related PCC rule shall be bound to the default bearer.
	The following values are defined:

	BIND_TO_DEF_BEARER (0)
 		This value indicates that the related PCC rule shall be bound to the default bearer.
	BIND_TO_APPLICABLE_BEARER (1)
 		This value indicates that the related PCC rule shall follow the bearer binding procedures by using the QCI/ARP
		within the QoS-Information AVP as defined in subclause 5.4 of 3GPP TS 29.213 [8]. This is the default value
		when the AVP has not yet been provided. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DEFAULT_BEARER_INDICATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "Default-Bearer-Indication")
public interface DefaultBearerIndication extends DiameterEnumerated<DefaultBearerIndicationEnum>
{
}