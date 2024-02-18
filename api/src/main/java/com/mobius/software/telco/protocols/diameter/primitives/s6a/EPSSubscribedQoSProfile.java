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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.37	EPS-Subscribed-QoS-Profile
	The EPS-Subscribed-QoS-Profile AVP is of type Grouped. It shall contain the bearer-level QoS parameters (QoS Class Identifier and Allocation Retention Priority) associated to the default bearer for an APN (see 3GPP TS 23.401 [2], clause 4.7.3).
	AVP format
	
	EPS-Subscribed-QoS-Profile ::= <AVP header: 1431 10415>
			 { QoS-Class-Identifier }
			 { Allocation-Retention-Priority }
			*[AVP]

	NOTE:	QoS-Class-Identifier is defined in 3GPP TS 29.212 [10] as an Enumerated AVP. The values allowed for this AVP over the S6a/S6d interface are only those associated to non-GBR bearers, as indicated in 3GPP TS 23.008 [30]; e.g., values QCI_1, QCI_2, QCI_3 and QCI_4, which are associated to GBR bearers, cannot be sent over S6a/S6d.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.EPS_SUBSCRIBER_QOS_PROFILE, vendorId = VendorIDs.TGPP_ID, name = "EPS-Subscribed-QoS-Profile")
public interface EPSSubscribedQoSProfile extends DiameterGroupedAvp
{
	QoSClassIdentifierEnum getQoSClassIdentifier();
	
	void setQoSClassIdentifier(QoSClassIdentifierEnum value) throws MissingAvpException;	
	
	AllocationRetentionPriority getAllocationRetentionPriority();
	
	void setAllocationRetentionPriority(AllocationRetentionPriority value) throws MissingAvpException;
}