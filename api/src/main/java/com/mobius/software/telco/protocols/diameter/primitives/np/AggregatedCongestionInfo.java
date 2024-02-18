package com.mobius.software.telco.protocols.diameter.primitives.np;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.2	Aggregated-Congestion-Info AVP
	The Aggregated-Congestion-Info AVP (AVP code 4000) is of type Grouped. It contains a list of user ids identified by IMSI and optionally the congestion location id in which the list of user ids are located.
	Aggregated-Congestion-Info ::= < AVP Header: 4000 >
			[ Congestion-Location-Id ]
			[ IMSI-List ]
 		   *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AGGREGATED_CONGESTION_INFO, vendorId = VendorIDs.TGPP_ID, name = "Aggregated-Congestion-Info")
public interface AggregatedCongestionInfo extends DiameterGroupedAvp
{
	CongestionLocationId getCongestionLocationId();
	
	void setCongestionLocationId(CongestionLocationId value);
	
	ByteBuf getIMSIList();
	
	void setIMSIList(ByteBuf value);
}