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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.28 QoS-Negotiation AVP (3GPP-GPRS Access Type only)
	The QoS-Negotiation AVP (AVP code 1029) is of type Enumerated. The value of the AVP indicates for a single PCC
	rule request if the PCRF is allowed to negotiate the QoS by supplying in the answer to this request an authorized QoS
	different from the requested QoS.

	NOTE: The indicated value of the QoS-Negotiation AVP has no significance for any later PCC rule request.The
	following values are defined:

	NO_QoS_NEGOTIATION (0)
 		This value indicates that a QoS negotiation is not allowed for the corresponding PCC rule request.
	QoS_NEGOTIATION_SUPPORTED (1)
 		This value indicates that a QoS negotiation is allowed for the corresponding PCC rule request. This is the default
		value applicable if this AVP is not supplied. 
 */
@DiameterAvpDefinition(code = 1029L, vendorId = KnownVendorIDs.TGPP_ID, name = "QoS-Negotiation")
public interface QoSNegotiation extends DiameterEnumerated<QoSNegotiationEnum>
{
}