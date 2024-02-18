package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.120 Default-Access AVP
	The Default-Access AVP (AVP code 2829) is of type Enumerated. When it is sent from the PCEF to the PCRF, it
	indicates the default access selected by the UE. When it is sent from the PCRF to the PCEF, it indicates the default
	access determined by the PCRF. The values defined in the Default-Access AVP are the same as the ones defined in IPCAN-Type AVP.
	NOTE: Only the 3GPP-EPS and Non-3GPP-EPS IP-CAN type values are applicable in this release. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DEFAULT_ACCESS, vendorId = VendorIDs.TGPP_ID, must = false, name = "Default-Access")
public interface DefaultAccess extends DiameterEnumerated<IPCANTypeEnum>
{
}