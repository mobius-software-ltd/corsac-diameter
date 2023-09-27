package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.105	Conditional-APN-Aggregate-Max-Bitrate (All access types)
	The Conditional‑APN‑Aggregate‑Max‑Bitrate AVP (AVP code 2818) is of type Grouped, and it defines the conditional APN policy info.
	The APN‑Aggregate‑Max‑Bitrate‑UL defines the total bandwidth usage in bps for the uplink direction of non-GBR QCIs at the APN.
	The APN‑Aggregate‑Max‑Bitrate‑DL defines the total bandwidth usage in bps for the downlink direction of non-GBR QCIs at the APN.
	The Extended-APN‑AMBR‑UL defines the total bandwidth usage in kbps for the uplink direction of non-GBR QCIs at the APN.
	The Extended-APN‑AMBR‑DL defines the total bandwidth usage in kbps for the downlink direction of non-GBR QCIs at the APN.
	When maximum bandwidth values are lower or equal to 2^32-1 bps, one of the APN‑Aggregate‑Max‑Bitrate‑UL AVP and APN‑Aggregate‑Max‑Bitrate‑DL AVP shall be present.
	For maximum bandwidth values higher than 2^32 bps and when the Extended-BW-NR feature is supported, one of the Extended-APN‑AMBR‑UL AVP and Extended-APN‑AMBR‑DL AVP shall be present.
	The IP‑CAN‑Type and the RAT‑Type AVP(s) specify the condition, in terms of IP Connectivity Access Network type and the Radio Access Technology type of the UE, respectively, when the APN‑Aggregate‑Max‑Bitrate‑UL/DL shall be enforced.
	At least one of the RAT‑Type and IP‑CAN‑Type shall be present.
	
	Conditional-APN-Aggregate-Max-Bitrate ::= 	 < AVP Header: 2818 >
		 [ APN-Aggregate-Max-Bitrate-UL ]
		 [ APN-Aggregate-Max-Bitrate-DL ]
		 [ Extended-APN-AMBR-UL ]
		 [ Extended-APN-AMBR-DL ]
		*[ IP-CAN-Type ]
		*[ RAT-Type ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = 2818L, vendorId = KnownVendorIDs.TGPP_ID, must=false, name = "Conditional-APN-Aggregate-Max-Bitrate")
public interface ConditionalAPNAggregateMaxBitrate extends DiameterGroupedAvp
{
	Long getAPNAggregateMaxBitrateUL();
	
	void setAPNAggregateMaxBitrateUL(Long value);	
	
	Long getAPNAggregateMaxBitrateDL();
	
	void setAPNAggregateMaxBitrateDL(Long value);	
	
	Long getExtendedAPNAMBRUL();
	
	void setExtendedAPNAMBRUL(Long value);	
	
	Long getExtendedAPNAMBRDL();
	
	void setExtendedAPNAMBRDL(Long value);	
	
	List<IPCANTypeEnum> getIPCANType();
	
	void setIPCANType(List<IPCANTypeEnum> value);
	
	List<RATTypeEnum> getRATType();
	
	void setRATType(List<RATTypeEnum> value);
}