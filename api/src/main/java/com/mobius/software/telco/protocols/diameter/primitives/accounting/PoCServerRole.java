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
 * 	7.2.145 PoC-Server-Role AVP
	The PoC-Server-Role AVP (AVP code 883) is of type Enumerated and specifies the role of the PoC server. The
	identifier can be one of the following:
	
	0 Participating PoC Server
	1 Controlling PoC Server
	2 Interworking function
	3 Interworking selection function 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.POC_SERVER_ROLE, vendorId = VendorIDs.TGPP_ID, name = "PoC-Server-Role")
public interface PoCServerRole extends DiameterEnumerated<PoCServerRoleEnum>
{
}