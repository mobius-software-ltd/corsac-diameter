package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.40	Allocation-Retention-Priority
	The Allocation-Retention-Priorit AVP is of typeGrouped and is defined in 3GPP TS 29.212 [10]. It shall indicate the Priority of Allocation and Retention for the corresponding APN configuration.
	AVP format
 	
 	Allocation-Retention-Priority ::= <AVP header: 1034 10415>
			{ Priority-Level }
			[ Pre-emption-Capability ]
			[ Pre-emption-Vulnerability ]
	
	If the Pre-emption-Capability AVP is not present in the Allocation-Retention-Priority AVP, the default value shall be PRE-EMPTION_CAPABILITY_DISABLED (1).

	If the Pre-emption-Vulnerability AVP is not present in the Allocation-Retention-Priority AVP, the default value shall be PRE-EMPTION_VULNERABILITY_ENABLED (0).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ALLOCATION_RETENTION_PRIORITY, vendorId = VendorIDs.TGPP_ID, must = false, name = "Allocation-Retention-Priority")
public interface AllocationRetentionPriority extends DiameterAvp
{
	Long getPriorityLevel();
	
	void setPriorityLevel(Long value) throws MissingAvpException;	
	
	PreEmptionCapabilityEnum getPreEmptionCapability();
	
	void setPreEmptionCapability(PreEmptionCapabilityEnum value);
	
	PreEmptionVulnerabilityEnum getPreEmptionVulnerability();
	
	void setPreEmptionVulnerability(PreEmptionVulnerabilityEnum value);	
}