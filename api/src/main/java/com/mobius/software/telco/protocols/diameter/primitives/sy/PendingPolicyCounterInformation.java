package com.mobius.software.telco.protocols.diameter.primitives.sy;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.5	Pending-Policy-Counter-Information AVP
	The Pending-Policy-Counter-Information AVP (AVP code 2905) is of type Grouped, which contains the pending policy counter status and the active time. If multiple pending policy counter AVPs are included,  they shall be sorted in order of change time.
	AVP Format:

	Pending-Policy-Counter-Information ::= < AVP Header: 2905 >
                                { Policy-Counter-Status }
                                { Pending-Policy-Counter-Change-Time }
                               *[ AVP ]

	NOTE:	The valid values for the Pending-Policy-Counter-Information AVP are specific for each Policy-Counter-Identifier value.
 */
@DiameterAvpDefinition(code = 2905L, vendorId = KnownVendorIDs.TGPP_ID, name = "Pending-Policy-Counter-Information")
public interface PendingPolicyCounterInformation extends DiameterGroupedAvp
{
	String getPolicyCounterStatus();
	
	void setPolicyCounterStatus(String value);
	
	Date getPendingPolicyCounterChangeTime();
	
	void setPendingPolicyCounterChangeTime(Date value);
}