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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.240 Unit-Quota-Threshold AVP
	The Unit-Quota-Threshold AVP (AVP code 1226) is of type Unsigned32 and contains a threshold value in service
	specific units. This AVP may be included within the Multiple-Services-Credit-Control AVP when this AVP also
	contains a Granted-Service-Units AVP containing CC-Service-Specific-Units AVP (i.e. when the granted quota is
	service specific) or within Rate-Element AVP..
	If received in the context of Multiple-Service-Credit-Control AVP, the Credit-Control client shall seek re-authorization
	from the server for the quota when the quota contents fall below the supplied threshold.
	The client shall allow service to continue whilst the re-authorization is in progress, up to the volume indicated in the
	original quota.
	In the context of the Rating-Element AVP it denotes the durability of a Rating Element within a Tariff. I.e. if the service
	consumed Unit-Quota-Threshold number of Unit-Types, the next Rating element becomes in effect. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.UNIT_QUOTA_THRESHOLD, vendorId = VendorIDs.TGPP_ID, name = "Unit-Quota-Threshold")
public interface UnitQuotaThreshold extends DiameterUnsigned32
{
}