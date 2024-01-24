package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
 * 	5.3.51	Pre-emption-Control-Info AVP
	The Pre-emption-Control-Info (AVP code 553) is of type Unsigned32, it shall contain a bit mask and indicate that how the PCRF to perform pre-emption among multiple potential media flow candidates of same priority. Pre-emption-Control-Info AVP is provided at the AAR command level and the latest provided value within the Pre-emption-Control-Info AVP shall be applied to all potential media flow candidates. The bit 0 shall be the least significant bit. For example, to get the value of bit 0, a bit mask of 0x0001 should be used. The meaning of the bits shall be as defined below:
	
	The following values are defined, only one bit shall be set at the same time:
	Table 5.3.51: Pre-emption-Control-Info 
	Bit Name
	Description

	0 Most recent added flow 
	This bit, when set, indicates that the most recent added flow is to be pre-empted.

	1 Least recent added flow 
	This bit, when set, indicates that the least recent added flow is to be pre-empted.

	2 Highest bandwidth flow 
	This bit, when set, indicates that the highest bandwidth flow is to be pre-empted.
*/
@DiameterAvpDefinition(code = 553L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Pre-Emption-Control-Info")
public interface PreEmptionControlInfo extends DiameterBitmask32
{
	public static final int MOST_RECENT_ADDED_FLOW_BIT = 0;	
	public static final int LEAST_RECENT_ADDED_FLOW_BIT = 1;	
	public static final int HIGHEST_BANDWIDTH_FLOW_BIT = 2;	
	
	public void setMostRecentAddedFlowBit(boolean isOn);
	
	public boolean isMostRecentAddedFlowBitSet();
	
	public void setLeastRecentAddedFlowBit(boolean isOn);
	
	public boolean isLeastRecentAddedFlowBitSet();
	
	public void setHighestBandwidthFlowBit(boolean isOn);
	
	public boolean isHighestBandwidthFlowBitSet();
}