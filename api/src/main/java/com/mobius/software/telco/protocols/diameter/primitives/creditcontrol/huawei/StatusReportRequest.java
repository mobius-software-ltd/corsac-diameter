package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.2.162  Status_Report_Request AVP
	
	AVP Name
	Status_Report_Request

	AVP Code
	20415

	AVP Data Type
	Unsigned32

	Vendor ID
	2011

	Description
	Indicates whether the SM status report is required.
    	- 0: no
    	- 1: yes
    	- 2: indicates to enable the SM status report function. If the SMC fails to send an SM status report, only the fee for sending the SM status report is refunded.
 */
@DiameterAvpDefinition(code = 20415L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Status-Report-Request")
public interface StatusReportRequest extends DiameterUnsigned32
{
}