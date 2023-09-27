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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.159 Quota-Consumption-Time AVP
	The Quota-Consumption-Time AVP (AVP code 881) is of type Unsigned32 and contains an idle traffic threshold time
	in seconds. This AVP may be included within the Multiple-Services-Credit-Control AVP when this AVP also contains
	a Granted-Service-Units AVP containing a CC-Time AVP (i.e. when the granted quota is a time quota). 
 */
@DiameterAvpDefinition(code = 881L, vendorId = KnownVendorIDs.TGPP_ID, name = "Quota-Consumption-Time")
public interface QuotaConsumptionTime extends DiameterUnsigned32
{
}