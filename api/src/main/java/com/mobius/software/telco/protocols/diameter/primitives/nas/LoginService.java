package com.mobius.software.telco.protocols.diameter.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.4.11.3.  Login-Service AVP

   The Login-Service AVP (AVP Code 15) is of type Enumerated and
   contains the service that should be used to connect the user to the
   login host.  This AVP SHOULD only be present in authorization
   responses.  The supported values are listed in RFC 2869.
 */
@DiameterAvpDefinition(code = AvpCodes.LOGIN_SERVICE, vendorId = -1L, name = "Login-Service")
public interface LoginService extends DiameterEnumerated<LoginServiceEnum>
{
}