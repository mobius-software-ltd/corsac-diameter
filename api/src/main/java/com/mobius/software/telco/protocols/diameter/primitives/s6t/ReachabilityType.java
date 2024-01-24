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
	8.4.12	Reachability-Type
	The Reachability-Type AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.4.12-1:
	Table 8.4.12-1: Reachability-Type

	Bit Name
	Description

	0 Reachability for SMS
	This bit, when set, indicates that the monitoring for reachability for SMS of the UE is to be configured

	1 Reachability for Data
	This bit, when set, indicates that the monitoring for reachability for data of the UE is to be configured

	NOTE 1:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.

	NOTE 2:	Bit 0 and 1 shall not be set simultaneously.

	The default value, when this AVP is not included, is Reachability for SMS (bit 0 set).
 */
@DiameterAvpDefinition(code = 3132L, vendorId = KnownVendorIDs.TGPP_ID, name = "Reachability-Type")
public interface ReachabilityType extends DiameterBitmask32
{
	public static final int REACHABILITY_FOR_SMS_BIT = 0;
	public static final int REACHABILITY_FOR_DATA_BIT = 1;
	
	public void setReachabilityForSMSBit(boolean isOn);
	
	public boolean isReachabilityForSMSBitSet();
	
	public void setReachabilityForDataBit(boolean isOn);
	
	public boolean isReachabilityForDataBitSet();
}