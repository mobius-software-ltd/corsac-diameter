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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.3.14	SM-Delivery-Outcome
	The SM-Delivery-Outcome AVP is of type Grouped. This AVP contains the result of the SM delivery.
	AVP format:

	SM-Delivery-Outcome::= <AVP header: 3316 10415>
		 [ MME-SM-Delivery-Outcome ]
		 [ MSC-SM-Delivery-Outcome ]
		 [ SGSN-SM-Delivery-Outcome ]
		 [ IP-SM-GW-SM-Delivery-Outcome ]
		 [ SMSF-3GPP-SM-Delivery-Outcome ]
		 [ SMSF-Non-3GPP-SM-Delivery-Outcome ]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SM_DELIVERY_OUTCOME, vendorId = VendorIDs.TGPP_ID, name = "SM-Delivery-Outcome")
public interface SMDeliveryOutcome extends DiameterGroupedAvp
{
	MMESMDeliveryOutcome getMMESMDeliveryOutcome();
	
	void setMMESMDeliveryOutcome(MMESMDeliveryOutcome value);	
	
	MSCSMDeliveryOutcome getMSCSMDeliveryOutcome();
	
	void setMSCSMDeliveryOutcome(MSCSMDeliveryOutcome value);
	
	SGSNSMDeliveryOutcome getSGSNSMDeliveryOutcome();
	
	void setSGSNSMDeliveryOutcome(SGSNSMDeliveryOutcome value);
	
	IPSMGWSMDeliveryOutcome getIPSMGWSMDeliveryOutcome();
	
	void setIPSMGWSMDeliveryOutcome(IPSMGWSMDeliveryOutcome value);	
	
	SMSF3GPPSMDeliveryOutcome getSMSF3GPPSMDeliveryOutcome();
	
	void setSMSF3GPPSMDeliveryOutcome(SMSF3GPPSMDeliveryOutcome value);
	
	SMSFNon3GPPSMDeliveryOutcome getSMSFNon3GPPSMDeliveryOutcome();
	
	void setSMSFNon3GPPSMDeliveryOutcome(SMSFNon3GPPSMDeliveryOutcome value);
}