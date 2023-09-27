package com.mobius.software.telco.protocols.diameter.primitives.pc4a;
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
	6.3.5	ProSe-Direct-Allowed
	The ProSe-Direct-Allowed AVP is of type Unsigned32 and it shall contain a bit mask that indicates the services the UE is authorised to use for ProSe Direct functionalities in a specific PLMN. The meaning of the bits shall be as defined in table 6.3.5-1:
	Table 6.3.5-1: ProSe-Direct-Allowed 

	Bit Name
	Description

	0 Announce
	This bit, when set, indicates that the user is allowed to announce in the corresponding PLMN for open ProSe Discovery.

	1 Monitor
	This bit, when set, indicates that the user is allowed to monitor in the corresponding PLMN for open ProSe Discovery.

	2 Communication
	This bit, when set, indicates that the user is allowed for ProSe direct one to many communication in the corresponding PLMN.

	3 One-to-one Communication
	This bit, when set, indicates that the user is allowed to perform one-to-one ProSe Direct Communication.

	4 Discoverer
	This bit, when set, indicates that the user is allowed to perform discoverer operation in the corresponding PLMN for ProSe Discovery Model B.

	5 Discoveree
	This bit, when set, indicates that the user is allowed to perform discoveree operation in the corresponding PLMN for ProSe Discovery Model B.

	6 Restricted-announce
	This bit, when set, indicates that the user is allowed to announce in the corresponding PLMN for restricted ProSe Discovery.

	7 Restricted-monitoring
	This bit, when set, indicates that the user is allowed to monitor in the corresponding PLMN for restricted ProSe Discovery.

	8 Application-controlled extension
	This bit, when set, indicates that the user is allowed to announce or monitor with application-controlled extension in the corresponding PLMN for restricted ProSe Discovery

	9 On-demand announcing
	This bit, when set, indicates that the user is allowed to perform on-demand announcing in the corresponding PLMN for restricted ProSe Discovery

	NOTE:	Bits not defined in this table shall be cleared by the HSS and discarded by the receiving ProSe Function.
 */
@DiameterAvpDefinition(code = 3704L, vendorId = KnownVendorIDs.TGPP_ID, name = "ProSe-Direct-Allowed")
public interface ProSeDirectAllowed extends DiameterUnsigned32
{
}