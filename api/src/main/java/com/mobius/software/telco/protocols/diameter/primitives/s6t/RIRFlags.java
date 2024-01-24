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
	8.4.63	RIR-Flags
	The RIR-Flags AVP is of type AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.4.63-1:

	Table 8.4.63-1: RIR-Flags
	
	Bit Name
	Description

	0 Group-Configuration-In-Progress
	This bit is set when the HSS indicates that the HSS is processing the Group Monitoring configuration and will report further status/reports for the group using additional RIR command(s).

	1 All-Monitoring-Events-Cancelled
	This bit is set when the HSS indicates that all existing events (if any) are cancelled, e.g. due to subscription removal
	
	2 Change-Of-Authorized-Monitoring-Events
	This bit is set when the HSS indicates that the SCEF authorization for one or more monitoring events has changed.

	3 All-Communication-Pattern-Cancelled
	This bit is set when the HSS indicates that all existing communication pattern (if any) are cancelled, e.g. due to subscription removal

	4 All-Suggested-Network-Configuration-Cancelled
	This bit is set when the HSS indicates that all existing Network Parameter Configurations (if any) are cancelled, e.g. due to subscription removal

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = 3167L, vendorId = KnownVendorIDs.TGPP_ID,must = false, name = "RIR-Flags")
public interface RIRFlags extends DiameterBitmask32
{
	public static final int GROUP_CONFIGURATION_IN_PROGRESS_BIT = 0;
	public static final int ALL_MONITORING_EVENTS_CANCELLED_BIT = 1;
	public static final int CHANGE_OF_AUTHORIZED_MONITORING_EVENTS_BIT = 2;
	public static final int ALL_COMMUNICATION_PATTERN_CANCELLED_BIT = 3;
	public static final int ALL_SUGGESTED_NETWORK_CONFIGURATION_CANCELLED_BIT = 4;
	
	public void setGroupConfigurationInProgressBit(boolean isOn);
	
	public boolean isGroupConfigurationInProgressBitSet();
	
	public void setAllMonitoringEventsCancelledBit(boolean isOn);
	
	public boolean isAllMonitoringEventsCancelledBitSet();
	
	public void setChangeOfAuthorizedMonitoringEventsBit(boolean isOn);
	
	public boolean isChangeOfAuthorizedMonitoringEventsBitSet();
	
	public void setAllCommunicationPatternCancelledBit(boolean isOn);
	
	public boolean isAllCommunicationPatternCancelledBitSet();
	
	public void setAllSuggestedNetworkConfigurationCancelledBit(boolean isOn);
	
	public boolean isAllSuggestedNetworkConfigurationCancelledBitSet();
	
}