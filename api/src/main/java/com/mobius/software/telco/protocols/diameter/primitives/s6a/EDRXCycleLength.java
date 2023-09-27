package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.215	eDRX-Cycle-Length
	The eDRX-Cycle-Length AVP is of type Grouped. This AVP shall contain an eDRX cycle length, along with the RAT type for which this cycle length is applicable to (e.g. E-UTRAN and NB-IOT).
	AVP format:

	eDRX-Cycle-Length ::= <AVP header: 1691 10415>
			 { RAT-Type }
			 { eDRX-Cycle-Length-Value }
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 1691L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "eDRX-Cycle-Length")
public interface EDRXCycleLength extends DiameterGroupedAvp
{
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	ByteBuf getEDRXCycleLengthValue();
	
	void setEDRXCycleLengthValue(ByteBuf value);
}