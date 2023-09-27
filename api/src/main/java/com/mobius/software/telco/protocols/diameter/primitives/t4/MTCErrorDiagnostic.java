package com.mobius.software.telco.protocols.diameter.primitives.t4;
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
 * 	6.3.7	MTC-Error-Diagnostic
	The MTC-Error-Diagnostic AVP is of type Unsigned32. The following values are defined:

	-	ORIGINAL_MESSAGE_NOT_DELETED (0)
	This cause should be sent if the replace failed due to the fact that the old message is pending but could not be deleted in the SMS-SC.

	-	NEW_MESSAGE_NOT_STORED (1)
	This cause should be sent if the replace failed due to the fact that the new message could not be stored in the SMS-SC e.g. no resource available.
 */
@DiameterAvpDefinition(code = 3203L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MTC-Error-Diagnostic")
public interface MTCErrorDiagnostic extends DiameterEnumerated<MTCErrorDiagnosticEnum>
{
}