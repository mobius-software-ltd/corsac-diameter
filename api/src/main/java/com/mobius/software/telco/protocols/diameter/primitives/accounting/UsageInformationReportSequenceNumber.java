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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterInteger32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.240B Usage-Information-Report-Sequence-Number AVP
	The Usage-Information-Report-Sequence-Number AVP (AVP code 3439) is of type Integer32 and indicates the
	sequence number of usage information report, which is used to generate the container.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.USAGE_INFORMATION_REPORT_SEQUENCE_NUMBER, vendorId = VendorIDs.TGPP_ID, name = "Usage-Information-Report-Sequence-Number")
public interface UsageInformationReportSequenceNumber extends DiameterInteger32
{
}