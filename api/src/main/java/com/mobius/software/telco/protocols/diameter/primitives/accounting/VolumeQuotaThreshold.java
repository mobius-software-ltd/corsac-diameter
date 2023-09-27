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
 * 	7.2.243 Volume-Quota-Threshold AVP
	The Volume-Quota-Threshold AVP (AVP code 869) is of type Unsigned32 and contains a threshold value in octets.
	This AVP may be included within the Multiple-Services-Credit-Control AVP when this AVP also contains a GrantedService-Units AVP containing a CC-Total-Octets AVP, CC-Input-Octets AVP or CC-Output-Octets AVP (i.e. when the
	granted quota is a volume quota).
	If received, the Credit-Control client shall seek re-authorization from the server for the quota when the quota contents
	fall below the supplied threshold. The client shall allow service to continue whilst the re-authorization is progress, up to
	the volume indicated in the original quota. 
 */
@DiameterAvpDefinition(code = 869L, vendorId = KnownVendorIDs.TGPP_ID, name = "Volume-Quota-Threshold")
public interface VolumeQuotaThreshold extends DiameterUnsigned32
{
}