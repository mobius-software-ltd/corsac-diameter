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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.148	MDT-User-Consent
	The MDT-User-Consent AVP is of type Enumerated. It shall indicate whether the user has given his consent for MDT activation or not (see 3GPP TS 32.422 [23]). The following values are defined:

	CONSENT_NOT_GIVEN (0)

	CONSENT_GIVEN (1)

	The default value when this AVP is not present in ULA is CONSENT_NOT_GIVEN (0). Absence of this AVP in IDR shall be interpreted as the MDT-User-Consent has not been modified.
	The presence of this subscription parameter in ULA or IDR shall be independent of the support of the Trace Function by the MME/SGSN (see clause 7.3.10).
 */
@DiameterAvpDefinition(code = 1634L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MDT-User-Consent")
public interface MDTUserConsent extends DiameterEnumerated<MDTUserConsentEnum>
{
}