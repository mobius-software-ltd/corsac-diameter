package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	8.4.39	CIR-Flags
	The CIR-Flags AVP is of type AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.4.39-1:
	
	Table 8.4.39-1: CIR-Flags
	Bit Name
	Description

	0 Delete all Monitoring events
	This bit shall be set if the SCEF wants to delete all Monitoring events for a subscriber stored in the HSS.

	1 Enhanced Coverage Query
	This bit shall be set if the SCEF wants to query the current settings of the Enhanced-Coverage-Restriction.

	2 IMSI Group Id retrieval
	This bit shall be set if the SCEF wants to retrieve the IMSI Group Id that corresponds to the provided External Group Identifier.

	3 Delete all Communication Pattern
	This bit shall be set if the SCEF wants to delete all Communication Pattern for a subscriber stored in the HSS.

	4 Delete all Network Parameter Configurations
	This bit shall be set if the SCEF wants to delete all Suggested Network Configuration for a subscriber stored in the HSS.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = 3145L, vendorId = KnownVendorIDs.TGPP_ID, name = "CIR-Flags")
public interface CIRFlags extends DiameterBitmask32
{
	public static final int DELETED_ALL_MONITORING_EVENTS_BIT = 0;
	public static final int ENHANCED_COVERAGE_QUERY_BIT = 1;
	public static final int IMSI_GROUP_ID_RETRIEVAL_BIT = 2;
	public static final int DELETE_ALL_COMMUNICATION_PATTERN_BIT = 3;
	public static final int DELETE_ALL_NETWORK_PARAMETER_CONFIGURATIONS_BIT = 4;
	
	public void setDeleteAllMonitoringEventsBit(boolean isOn);
	
	public boolean isDeleteAllMonitoringEventsBitSet();
	
	public void setEnhancedCoverageQueryBit(boolean isOn);
	
	public boolean isEnhancedCoverageQueryBitSet();
	
	public void setIMSIGroupIdRetrievalBit(boolean isOn);
	
	public boolean isIMSIGroupIdRetrievalBitSet();
	
	public void setDeleteAllCommunicationPatternBit(boolean isOn);
	
	public boolean isDeleteAllCommunicationPatternBitSet();
	
	public void setDeleteAllNetworkParameterConfigurationsBit(boolean isOn);
	
	public boolean isDeleteAllNetworkParameterConfigurationsBitSet();
}