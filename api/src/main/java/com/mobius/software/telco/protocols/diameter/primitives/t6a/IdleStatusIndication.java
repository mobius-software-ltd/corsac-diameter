package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EDRXCycleLength;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.32	Idle-Status-Indication
	The Idle-Status-Indication AVP is of type Grouped, and it shall contain the details when the UE transitions into idle mode.
	AVP format:

	Idle-Status-Indication::=	<AVP header: 4322 10415>
			 [ Idle-Status-Timestamp ]
			 [ Active-Time ]
			 [ Subscribed-Periodic-RAU-TAU-Timer ]
			 [ eDRX-Cycle-Length ]
			 [ DL-Buffering-Suggested-Packet-Count ]
			*[AVP]

	The Subscribed-Periodic-RAU-TAU-Timer AVP shall contain the periodic TAU/RAU time granted to the UE by the MME/SGSN.
	The eDRX-Cycle-Length AVP shall contain the eDRX cycle length granted to the UE by the MME/SGSN.
	The DL-Buffering-Suggested-Packet-Count AVP shall contain the suggested number of downlink packets sent to the S-GW by the MME/SGSN.
 */
@DiameterAvpDefinition(code = 4322L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Idle-Status-Indication")
public interface IdleStatusIndication extends DiameterGroupedAvp
{
	Date getIdleStatusTimestamp();
	
	void setIdleStatusTimestamp(Date value);
	
	Long getActiveTime();
	
	void setActiveTime(Long value);
	
	Long getSubscribedPeriodicRAUTAUTimer();
	
	void setSubscribedPeriodicRAUTAUTimer(Long value);
	
	EDRXCycleLength getEDRXCycleLength();
	
	void setEDRXCycleLength(EDRXCycleLength value);
	
	Integer getDLBufferingSuggestedPacketCount();
	
	void setDLBufferingSuggestedPacketCount(Integer value);
}