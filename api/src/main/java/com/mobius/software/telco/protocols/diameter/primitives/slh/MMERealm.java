package com.mobius.software.telco.protocols.diameter.primitives.slh;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIdentity;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.12 MME-Realm
	The MME-Realm AVP is of type DiameterIdentity and it shall contain the Diameter Realm Identity of the serving
	MME. For further details on the encoding of this AVP, see IETF RFC 6733 [17].  
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MME_REALM, vendorId = VendorIDs.TGPP_ID, must = false, name = "MME-Realm")
public interface MMERealm extends DiameterIdentity
{
}