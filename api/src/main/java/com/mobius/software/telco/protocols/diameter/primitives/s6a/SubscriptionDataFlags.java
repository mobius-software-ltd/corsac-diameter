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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.3.165	Subscription-Data-Flags
	The Subscription-Data-Flags is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in 
	Table 7.3.165/1: Subscription-Data-Flags

	Bit Name
	Description

	0 PS-And-SMS-Only-Service-Provision-Indication
	This bit, when set, indicates that the subscription is for PS Only and permits CS service access only for SMS.

	1 SMS-In-SGSN-Allowed-Indication
	This bit, when set, indicates that SMS in SGSN for the user is allowed.

	2 User Plane Integrity Protection
	This bit, when set, indicates that the SGSN may decide to activate integrity protection of the user plane when GERAN is used (see 3GPP TS 43.020 [58]). The MME shall ignore it.

	3 PDN-Connection-Restricted
	This bit, when set, indicates to the MME that it shall not establish any non-emergency PDN connection for this user if the MME and the UE supports Attach without PDN connection. The SGSN shall ignore it.

	4 Acknowledgement-Of-Downlink-NAS-Data PDUs disabled
	This bit, when set, indicates to the MME that acknowledgement of downlink NAS data PDUs for Control Plane CIoT Optimization is disabled for this UE (even for APN configurations with RDS Indicator set to ENABLED (1)). When not set it indicated to the MME that acknowledgement of downlink NAS data PDUs for Control Plane CIoT Optimization is enabled (for APN configurations with RDS Indicator set to ENABLED (1)) for this UE, which is the default (see 3GPP TS 23.401 [2]).
	The SGSN shall ignore it.

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.
 */
@DiameterAvpDefinition(code = 1654L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Subscription-Data-Flags")
public interface SubscriptionDataFlags extends DiameterUnsigned32
{
}