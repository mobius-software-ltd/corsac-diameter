package com.mobius.software.telco.protocols.diameter.primitives.s6c;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.3.15	MME-SM-Delivery-Outcome
	The MME-Delivery-Outcome AVP is of type grouped and shall indicate the outcome of the SM delivery for setting the message waiting data in the HSS when the SM delivery is with an MME.
	AVP format:

	MME-SM-Delivery-Outcome::= <AVP header: 3317 10415>>
		[ SM-Delivery-Cause ]
		[ Absent-User-Diagnostic-SM ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MME_SM_DELIVERY_OUTCOME, vendorId = VendorIDs.TGPP_ID, name = "MME-SM-Delivery-Outcome")
public interface MMESMDeliveryOutcome extends DiameterAvp
{
	SMDeliveryCauseEnum getSMDeliveryCause();
	
	void setSMDeliveryCause(SMDeliveryCauseEnum value);	
	
	Long getAbsentUserDiagnosticSM();
	
	void setAbsentUserDiagnosticSM(Long value);
}