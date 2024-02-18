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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;

/**
*
* @author yulian oifa
*
*/
/*
 * 
   8.27.  Tariff-Change-Usage AVP

   The Tariff-Change-Usage AVP (AVP Code 452) is of type Enumerated and
   defines whether units are used before or after a tariff change, or
   whether the units straddled a tariff change during the reporting
   period.  Omission of this AVP means that no tariff change has
   occurred.

   In addition, when present in Answer messages as part of the Multiple-
   Services-Credit-Control AVP, this AVP defines whether units are
   allocated to be used before or after a tariff change event.

   When the Tariff-Time-Change AVP is present, omission of this AVP in
   Answer messages means that the single-quota mechanism applies.

   Tariff-Change-Usage can be set to one of the following values:

   UNIT_BEFORE_TARIFF_CHANGE   0

   When present in the Multiple-Services-Credit-Control AVP, this value
   indicates the amount of units allocated for use before a tariff
   change occurs.

   When present in the Used-Service-Unit AVP, this value indicates the
   amount of resource units used before a tariff change had occurred.
   
    UNIT_AFTER_TARIFF_CHANGE    1

   When present in the Multiple-Services-Credit-Control AVP, this value
   indicates the amount of units allocated for use after a tariff change
   occurs.

   When present in the Used-Service-Unit AVP, this value indicates the
   amount of resource units used after a tariff change had occurred.

   UNIT_INDETERMINATE          2

   This value is to be used only in the Used-Service-Unit AVP and
   indicates the amount of resource units that straddle the tariff
   change (e.g., the metering process reports to the credit-control
   client in blocks of n octets, and one block straddled the tariff
   change).
 */
@DiameterAvpDefinition(code = AvpCodes.TARIFF_TIME_CHANGE, vendorId = -1L, name = "Tariff-Time-Change")
public interface TariffTimeChange extends DiameterTime
{
}