package com.mobius.software.telco.protocols.diameter.primitives.rfc6942;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIdentity;

/**
*
* @author yulian oifa
*
*/

/*
	8.2.  ERP-Realm AVP

   	The ERP-Realm AVP (AVP Code 619) is of type DiameterIdentity.  It
   	contains the name of the realm in which the ER server is located.

   	This AVP has the 'M' and 'V' bits cleared.
*/
@DiameterAvpDefinition(code = AvpCodes.ERP_REALM, vendorId = -1L, must = false, name = "ERP-Realm")
public interface ERPRealm extends DiameterIdentity
{
}