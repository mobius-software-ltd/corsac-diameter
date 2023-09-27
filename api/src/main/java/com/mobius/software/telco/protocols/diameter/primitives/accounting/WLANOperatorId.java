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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.251	WLAN-Operator-Id AVP
	The WLAN-Operator-Id AVP (AVP code 1306) is of type Grouped and holds the identity of the trusted or untrusted WLAN Operator.

	WLAN-Operator-Id :: = 	< AVP Header: 1306>
		[ WLAN-PLMN-Id ]
		[ WLAN-Operator-Name ]
 */
@DiameterAvpDefinition(code = 1306L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "WLAN-Operator-Id")
public interface WLANOperatorId extends DiameterAvp
{
	String getWLANPLMNId();
	
	void setWLANPLMNId(String value);
	
	String getWLANOperatorName();
	
	void setWLANOperatorName(String value);
}