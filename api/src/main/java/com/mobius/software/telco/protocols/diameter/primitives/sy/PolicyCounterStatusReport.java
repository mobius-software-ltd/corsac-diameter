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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.3	Policy-Counter-Status-Report AVP
	The Policy-Counter-Status-Report AVP (AVP code 2903) is of type Grouped. It is used by the OCS to report the status of a specific policy counter.
	Associated pending policy counter statuses shall always be provided within Pending-Policy-Counter-Information AVPs if the pending policy counter statuses are applicable to the policy counter identifier. If there are no Pending-Policy-Counter-Information AVPs provided within the Policy-Counter-Status-Report AVP, previously provided pending counter statuses are removed. In addition, newly provided pending policy counter statuses overwrite previously provided ones.
	AVP Format:
	Policy-Counter-Status-Report ::=         < AVP Header: 2903 >
                                        { Policy-Counter-Identifier }
                                        { Policy-Counter-Status }
                                       *[ Pending-Policy-Counter-Information ]
                                       *[ AVP ]
 */
@DiameterAvpDefinition(code = 2903L, vendorId = KnownVendorIDs.TGPP_ID, name = "Policy-Counter-Status-Report")
public interface PolicyCounterStatusReport extends DiameterGroupedAvp
{
	String getPolicyCounterIdentifier();
	
	void setPolicyCounterIdentifier(String value);
	
	String getPolicyCounterStatus();
	
	void setPolicyCounterStatus(String value);
	
	List<PendingPolicyCounterInformation> getPendingPolicyCounterInformation();
	
	void setPendingPolicyCounterInformation(List<PendingPolicyCounterInformation> value);
}