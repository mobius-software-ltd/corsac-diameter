package com.mobius.software.telco.protocols.diameter.primitives.swx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLANIdentifier;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.2.3.19	TWAN-Access-Info
	The TWAN-Access-Info AVP is of type Grouped.
	If no WLAN-Identifier AVP is included in the TWAN-Access-Info AVP, the allowed access methods shall apply to any arbitrary Trusted WLAN. See clause 5.1.2.1.2.
	If the Access-Authorization-Flags AVP is not present in the TWAN-Access-Info AVP, EPC access and Non-Seamless WLAN Offload shall be considered to be not allowed.

	A specific Trusted-WLAN shall appear in at most one TWAN-Access-Info AVP.
	There shall be at most one TWAN-Access-Info AVP not including any WLAN-Identifier.
	AVP Format:

	TWAN-Access-Info::=	< AVP Header: 1510 10415 >
			 [ Access-Authorization-Flags ]
			 [ WLAN-Identifier ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = 1510L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "TWAN-Access-Info")
public interface TWANAccessInfo extends DiameterGroupedAvp
{
	AccessAuthorizationFlags getAccessAuthorizationFlags();
	
	void setAccessAuthorizationFlags(AccessAuthorizationFlags value);	
	
	WLANIdentifier getWLANIdentifier();
	
	void setWLANIdentifier(WLANIdentifier value);
}