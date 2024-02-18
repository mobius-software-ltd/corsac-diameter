package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
 * 8.6.  Check-Balance-Result AVP

   The Check-Balance-Result AVP (AVP Code 422) is of type Enumerated and
   contains the result of the balance check.  This AVP is applicable
   only when the Requested-Action AVP indicates CHECK_BALANCE in the
   Credit-Control-Request command.  The following values are defined for
   the Check-Balance-Result AVP:

   ENOUGH_CREDIT   0

   There is enough credit in the account to cover the requested service.

   NO_CREDIT       1

   There isn't enough credit in the account to cover the requested
   service.
 */
@DiameterAvpDefinition(code = AvpCodes.CHECK_BALANCE_RESUT, vendorId = -1L, name = "Check-Balance-Result")
public interface CheckBalanceResult extends DiameterEnumerated<CheckBalanceResultEnum>
{
}