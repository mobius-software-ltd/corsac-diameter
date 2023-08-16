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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 12.17.  Tariff-Change-Usage AVP

   As defined in Section 8.27, the Tariff-Change-Usage AVP includes
   Enumerated type values 0-2.  IANA has created and is maintaining a
   namespace for this AVP.  The definition of new values is subject to
   the Specification Required policy [RFC8126] and conditions for
   enumerated values described in [RFC7423], Section 5.6.
 */
@DiameterAvpDefinition(code = 452L, vendorId = -1L, name = "Tariff-Change-Usage")
public interface TariffChangeUsage extends DiameterEnumerated<TariffChangeUsageEnum>
{
}