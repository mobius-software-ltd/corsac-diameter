package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.9	UE-Reachability-Configuration
	The UE-Reachability-Configuration AVP is of type Grouped, and it shall contain the details for configuration for UE reachability.
	AVP format:

	UE-Reachability-Configuration::=	<AVP header: 3129 10415>
			 [ Reachability-Type ]
			 [ Maximum-Latency ]
			 [ Maximum-Response-Time ]
			 [ DL-Buffering-Suggested-Packet-Count ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 3129L, vendorId = KnownVendorIDs.TGPP_ID, name = "UE-Reachability-Configuration")
public interface UEReachabilityConfiguration extends DiameterGroupedAvp
{
	Long getReachabilityType();
	
	void setReachabilityType(Long value);
	
	Long getMaximumLatency();
	
	void setMaximumLatency(Long value);
	
	Long getMaximumResponseTime();
	
	void setMaximumResponseTime(Long value);	
	
	Integer getDLBufferingSuggestedPacketCount();
	
	void setDLBufferingSuggestedPacketCount(Integer value);
}