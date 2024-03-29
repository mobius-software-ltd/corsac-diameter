package com.mobius.software.telco.protocols.diameter.primitives.eap;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/
/*
 * 4.1.5.  Accounting-EAP-Auth-Method AVP

   The Accounting-EAP-Auth-Method AVP (AVP Code 465) is of type
   Unsigned64.  In case of expanded types [EAP, Section 5.7], this AVP
   contains the value ((Vendor-Id * 2^32) + Vendor-Type).

   The use of this AVP is described in Section 2.7.
 */
@DiameterAvpDefinition(code = AvpCodes.ACCOUNTING_EAP_AUTH_METHOD, vendorId = -1L, name = "Accounting-EAP-Auth-Method")
public interface AccountingEAPAuthMethod extends DiameterUnsigned64
{
}