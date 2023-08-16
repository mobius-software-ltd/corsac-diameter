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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.6.7.  Accounting-Auth-Method AVP

   The Accounting-Auth-Method AVP (AVP Code 406) is of type Enumerated.
   A NAS MAY include this AVP in an Accounting-Request message to
   indicate the method used to authenticate the user.  (Note that this
   AVP is semantically equivalent, and the supported values are
   identical, to the Microsoft MS-Acct-Auth-Type vendor-specific RADIUS
   attribute [RFC2548]).
 */
@DiameterAvpDefinition(code = 406L, vendorId = -1L, name = "Accounting-Auth-Method")
public interface AccountingAuthMethod extends DiameterEnumerated<AccountingAuthMethodEnum>
{
}