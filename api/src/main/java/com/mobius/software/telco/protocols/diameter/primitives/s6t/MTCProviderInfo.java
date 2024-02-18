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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.74	MTC-Provider-Info
	The MTC-Provider-Info AVP is of type Grouped and it contains the information associated to the MTC Service Provider and/or MTC Application (see 3GPP TS 23.682 [2], clause 5.6).
	AVP format:

	MTC-Provider-Info ::= <AVP header: 3178 10415>
			 [ MTC-Provider-ID ]
			*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MTC_PROVIDER_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "MTC-Provider-Info")
public interface MTCProviderInfo extends DiameterGroupedAvp
{
	String getMTCProviderID();
	
	void setMTCProviderID(String value);
}