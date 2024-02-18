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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.229	eDRX-Related-RAT
	The eDRX-Related-RAT AVP is of type Grouped. This AVP shall contain the RAT type to which the eDRX Cycle Length is related:
	AVP format
	
	eDRX-Related-RAT ::= <AVP header: 1705 10415>
			1 * { RAT-Type }
			*	[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.EDRX_RELATED_RAT, vendorId = VendorIDs.TGPP_ID, must = false, name = "eDRX-Related-RAT")
public interface EDRXRelatedRAT extends DiameterGroupedAvp
{
	List<RATTypeEnum> getRATType();
	
	void setRATType(List<RATTypeEnum> value) throws MissingAvpException;
}