package com.mobius.software.telco.protocols.diameter.primitives.rfc5778;
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
 * 	6.20.  MIP6-Auth-Mode AVP

   	The MIP6-Auth-Mode (AVP Code 494) is of type Enumerated and contains
   	information of the used Mobile IPv6 Authentication Protocol mode.
   	This specification defines only one value MIP6_AUTH_MN_AAA and the
   	corresponding AAA interactions when MN-AAA security association is
   	used to authenticate the Binding Update as described in [RFC4285].
   	When the MIP6-Auth_Mode AVP is set to the value of MIP6_AUTH_MN_AAA,
   	the Auth-Request-Type AVP MUST be set to the value of
   	AUTHORIZE_AUTHENTICATE.
 */
@DiameterAvpDefinition(code = AvpCodes.MIP6_AUTH_MODE, vendorId = -1L, name = "MIP6-Auth-Mode")
public interface MIP6AuthMode extends DiameterEnumerated<MIP6AuthModeEnum>
{
}