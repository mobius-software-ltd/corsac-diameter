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
	5.3.3.26	SMSF-Non-3GPP-Absent-User-Diagnostic-SM
	The SMSF-Non-3GPP-Absent-User-Diagnostic-SM AVP is of type Unsigned32 and shall indicate the diagnostic explaining the absence of the user given by the SMSF registered for Non-3GPP access. The values are defined in 3GPP TS 23.040 [3] clause 3.3.2.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SMSF_NON_3GPP_ABSCENT_USER_DIAGNOSTIC_SM, vendorId = VendorIDs.TGPP_ID, must = false, name = "SMSF-Non-3GPP-Absent-User-Diagnostic-SM")
public interface SMSFNon3GPPAbsentUserDiagnosticSM extends DiameterUnsigned32
{
}