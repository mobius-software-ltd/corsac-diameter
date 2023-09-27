package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.24	LCS-Privacy-Check-Session
	The LCS-Privacy-Check-Session AVP is of type Grouped.
	AVP format:

	LCS-Privacy-Check-Session ::= <AVP header: 2522 10415>
		{ LCS-Privacy-Check }

	Default value if AVP is not present is that AVP LCS-Privacy-Check take value: NOT_ALLOWED (4).
 */
@DiameterAvpDefinition(code = 2522L, vendorId = KnownVendorIDs.TGPP_ID, name = "LCS-Privacy-Check-Session")
public interface LCSPrivacyCheckSession extends DiameterAvp
{
	LCSPrivacyCheckEnum getLCSPrivacyCheck();
	
	void setLCSPrivacyCheck(LCSPrivacyCheckEnum value);
}