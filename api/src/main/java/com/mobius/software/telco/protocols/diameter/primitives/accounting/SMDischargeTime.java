package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.206 SM-Discharge-Time AVP
	The SM-Discharge-Time AVP (AVP code 2012) is of type Time. It indicates the time associated with the event being
	reported in the SM-Status AVP. It is only used in scenarios in which the delivery of the Delivery-Report (more properly
	the Status-Report) is being charged.
	For example, if SM-Status has the value 0x00, then the SM-Discharge-Time indicates the time of the delivery of the
	original Short Message.
	The SMS Node shall ensure the correct encoding of this, as the other AVPs using the type Time, since the SMS
	messages use different formats. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SM_DISCHARGE_TIME, vendorId = VendorIDs.TGPP_ID, name = "SM-Discharge-Time")
public interface SMDischargeTime extends DiameterTime
{
}