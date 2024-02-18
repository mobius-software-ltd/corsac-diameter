package com.mobius.software.telco.protocols.diameter.primitives.gmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterOctetString;

/**
*
* @author yulian oifa
*
*/

/*
	17.7.14	MBMS-Time-To-Data-Transfer AVP
	The MBMS-Time-To-Data-Transfer AVP (AVP code 911) is of type OctetString. Its length is one octet. It indicates the expected time between reception of the MBMS Session Start  (RAR(Start) command) and the commencement of the MBMS Data flow. The coding is specified as per the Time to MBMS Data Transfer Value Part Coding of the Time to MBMS Data Transfer IE in 3GPP TS 48.018 [70].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_TIME_TO_DATA_TRANSFER, vendorId = VendorIDs.TGPP_ID, name = "MBMS-Time-To-Data-Transfer")
public interface MBMSTimeToDataTransfer extends DiameterOctetString
{
}