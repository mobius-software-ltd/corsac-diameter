package com.mobius.software.telco.protocols.diameter.primitives.s6c;
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
	5.3.3.23	SMS-GMSC-Alert-Event
	The SMS-GMSC-Alert-Event AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 5.3.3.23/1:
	Table 5.3.3.23/1: SMS-GMSC-Alert-Event
	
	Bit Name
	Description

	0 UE-Available-For-MT-SMS
	This bit, when set, shall indicate that the UE is now available for MT SMS

	1 UE-Under-New-Serving-Node
	This bit, when set, shall indicate that the UE has moved under the coverage of another MME or SGSN.

	NOTE 1:	Bits not defined in this table shall be cleared by the sending entity and discarded by the receiving entity.
 */
@DiameterAvpDefinition(code = 3333L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "SMS-GMSC-Alert-Event")
public interface SMSGMSCAlertEvent extends DiameterUnsigned32
{
}