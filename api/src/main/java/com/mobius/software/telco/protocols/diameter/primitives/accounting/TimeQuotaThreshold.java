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
 * 	7.2.229 Time-Quota-Threshold AVP
	The Time-Quota-Threshold AVP (AVP code 868) is of type Unsigned32 and contains a threshold value in seconds.
	This AVP may be included within the Multiple-Services-Credit-Control AVP when this AVP also contains a GrantedService-Units AVP containing a CC-Time AVP (i.e. when the granted quota is a time quota).
	If received, the Credit-Control client shall seek re-authorization from the server for the quota when the quota contents
	fall below the supplied threshold. The client shall allow service to continue whilst the re-authorization is progress, until
	the time at which the original quota would have been consumed. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TIME_QUOTA_THRESHOLD, vendorId = VendorIDs.TGPP_ID, name = "Time-Quota-Threshold")
public interface TimeQuotaThreshold extends DiameterUnsigned32
{
}