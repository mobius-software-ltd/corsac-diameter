package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.193 Service-Mode AVP
	The Service-Mode AVP (AVP Code 2032) is of type Unsigned32 and provides the mode for CDIV, CB and ECT
	MMTel supplementary services. The following values are defined:

	0 Communication Forwarding Unconditional (CFU)
	1 Communication Forwarding Busy (CFB)
	2 Communication Forwarding No Reply (CRNR)
	3 Communication Forwarding on Not Logged-In (CFNL)
	4 Communication Deflection (CD
	5 Communication Forwarding on Subscriber Not Reachable (CFNRc)
	6 Incoming Call Barring (ICB)
	7 Outgoing Call Barring (OCB)
	8 Anonymous Communication Rejection (ACR)
	9 Blind Transfer
	10 Consultative Transfer
	11 Three-Party (3PTY)
	12 Advice of Charge -S (AoC-S)
	13 Advice of Charge -D (AoC-D)
	14 Advice of Charge -E (AoC-E)

	Values ≥ 1024 are reserved for specific Network/Manufacturer variants 
 */
@DiameterAvpDefinition(code = 2032L, vendorId = KnownVendorIDs.TGPP_ID, name = "Service-Mode")
public interface ServiceMode extends DiameterEnumerated<ServiceModeEnum>
{
}