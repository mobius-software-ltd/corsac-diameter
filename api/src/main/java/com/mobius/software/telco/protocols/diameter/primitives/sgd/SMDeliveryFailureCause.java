package com.mobius.software.telco.protocols.diameter.primitives.sgd;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.3.5	SM-Delivery-Failure-Cause
	The SM-Delivery-Failure-Cause AVP is of type Grouped. It shall contain information about the cause of the failure of a SM delivery with an optional Diagnostic information.
	The AVP format shall conform to:

	SM-Delivery-Failure-Cause ::= <AVP header: 3303 10415>
		 { SM-Enumerated-Delivery-Failure-Cause }
		 [ SM-Diagnostic-Info ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 3303L, vendorId = KnownVendorIDs.TGPP_ID, name = "SM-Delivery-Failure-Cause")
public interface SMDeliveryFailureCause extends DiameterGroupedAvp
{
	SMEnumeratedDeliveryFailureCauseEnum getSMEnumeratedDeliveryFailureCause();
	
	void setSMEnumeratedDeliveryFailureCause(SMEnumeratedDeliveryFailureCauseEnum value);	
	
	ByteBuf getSMDiagnosticInfo();
	
	void setSMDiagnosticInfo(ByteBuf value);
}