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

import com.mobius.software.telco.protocols.diameter.OneM2MAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/

/*
	A.4.13. M2M-Event-Record-Timestamp AVP
	The M2M-Event-Record-Timestamp AVP (AVP code 1010) is of type Time and represents the time for recording 
	the M2M event record.
 */
@DiameterAvpDefinition(code = OneM2MAvpCodes.M2M_EVENT_RECORD_TIMESTAMP, vendorId = VendorIDs.ONEM2M_ID, name = "M2M-Event-Record-Timestamp")
public interface M2MEventRecordTimestamp extends DiameterTime
{
}