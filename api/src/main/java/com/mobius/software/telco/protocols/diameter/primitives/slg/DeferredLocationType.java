package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.36	Deferred-Location-Type
	The Deferred-Location-Type AVP is of type Unsigned32 and it shall contain a bit mask. Each bit indicates a type of event, until when the location estimation is deferred. For details, please refer to 3GPP TS 23.271 [3] clause 4.4.2. The meaning of the bits shall be as defined in table 7.4.36/1:
	Table 7.4.36/1: Deferred-Location-Type

	Bit Event Type
	Description

	0 UE-Available
	Any event in which the SGSN has established a contact with the UE.

	1 Entering-Into-Area
	An event where the UE enters a pre-defined geographical area.

	2 Leaving-From-Area
	An event where the UE leaves a pre-defined geographical area.

	3 Being-Inside-Area
	An event where the UE is currently within the pre-defined geographical area.

	4 Periodic-LDR
	An event where a defined periodic timer expires in the UE and activates a location report or a location request.

	5 Motion-Event
	An event where the UE moves by more than a minimum linear distance. This event is applicable to a deferred EPC-MT-LR only.

	6 LDR-Activated
	An event where deferred location reporting has been activated in the UE. This event is applicable to a deferred EPC-MT-LR only.
	
	7 Maximum-Interval-Expiration
	An event where the maximum reporting interval has expired. This event is applicable to a deferred EPC-MT-LR only.
 */
@DiameterAvpDefinition(code = 2532L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Deferred-Location-Type")
public interface DeferredLocationType extends DiameterBitmask32
{
	public static final int UE_AVAILABLE_BIT = 0;
	public static final int ENTERING_INTO_AREA_BIT = 1;
	public static final int LEAVING_FROM_AREA_BIT = 2;
	public static final int BEING_INSIDE_AREA_BIT = 3;
	public static final int PERIOD_LDR_BIT = 4;
	public static final int MOTION_EVENT_BIT = 5;
	public static final int LDR_ACTIVATED_BIT = 6;
	public static final int MAXIMUM_INTERVAL_EXPIRATION_BIT = 7;
	
	public void setUEAvailableBit(boolean isOn);
	
	public boolean isUEAvailableBitSet();
	
	public void setEnteringIntoAreaBit(boolean isOn);
	
	public boolean isEnteringIntoAreaBitSet();
	
	public void setLeavingFromAreaBit(boolean isOn);
	
	public boolean isLeavingFromAreaBitSet();
	
	public void setBeingInsideAreaBit(boolean isOn);
	
	public boolean isBeingInsideAreaBitSet();
	
	public void setPeriodicLDRBit(boolean isOn);
	
	public boolean isPeriodicLDRBitSet();
	
	public void setMotionEventBit(boolean isOn);
	
	public boolean isMotionEventBitSet();
	
	public void setLDRActivatedBit(boolean isOn);
	
	public boolean isLDRActivatedBitSet();
	
	public void setMaximumIntervalExpirationBit(boolean isOn);
	
	public boolean isMaximumIntervalExpirationBitSet();
}