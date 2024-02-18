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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.238A UNI-PDU-CP-Only-Flag AVP
	The UNI-PDU-CP-Only-Flag AVP (AVP code 3932) is of type Enumerated, and indicates whether this PDN
	connection is applied with "Control Plane Only flag", i.e. using only S11-U from S-GW when Control Plane CIoT EPS
	Optimization is enabled. If this AVP is not present, this means both user plane and control plane can be used in UNI for
	PDU transfer, i.e. S1-U and S11-U respectively from S-GW, when Control Plane CIoT EPS Optimization is enabled.
	The following values are defined:

	0 UNI-PDU-both-UP-CP
	1 UNI-PDU-CP-Only
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UNI_PDU_CP_ONLY_FLAG, vendorId = VendorIDs.TGPP_ID, name = "UNI-PDU-CP-Only-Flag")
public interface UNIPDUCPOnlyFlag extends DiameterEnumerated<UNIPDUCPOnlyFlagEnum>
{
}