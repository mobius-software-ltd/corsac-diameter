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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/

/*
	8.4.6	SCEF-Reference-ID-for-Deletion
	The SCEF-Reference-ID-for-Deletion AVP is of type Unsigned32 and it shall contain the SCEF-Reference-ID (in combination with the SCEF identified by the SCEF-ID) for the event to be deleted.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SCEF_REFERENCE_ID_FOR_DELETION, vendorId = VendorIDs.TGPP_ID, name = "SCEF-Reference-ID-for-Deletion")
public interface SCEFReferenceIDForDeletion extends DiameterUnsigned32
{
}