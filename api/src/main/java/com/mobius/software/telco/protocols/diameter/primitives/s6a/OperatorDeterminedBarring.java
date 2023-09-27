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
	7.3.30	Operator-Determined-Barring
	The Operator-Determined-Barring AVP is of type Unsigned32 and it shall contain a bit mask indicating the services of a subscriber that are barred by the operator. The meaning of the bits is the following:
	Table 7.3.30/1: Operator-Determined-Barring
	
	Bit Description

	0 All Packet Oriented Services Barred

	1 Roamer Access HPLMN-AP Barred

	2 Roamer Access to VPLMN-AP Barred

	3 Barring of all outgoing calls

	4 Barring of all outgoing international calls

	5 Barring of all outgoing international calls except those directed to the home PLMN country

	6 Barring of all outgoing inter-zonal calls

	7 Barring of all outgoing inter-zonal calls except those directed to the home PLMN country

	8 Barring of all outgoing international calls except those directed to the home PLMN country and Barring of all outgoing inter-zonal calls

 */
@DiameterAvpDefinition(code = 1425L, vendorId = KnownVendorIDs.TGPP_ID, name = "Operator-Determined-Barring")
public interface OperatorDeterminedBarring extends DiameterUnsigned32
{
}