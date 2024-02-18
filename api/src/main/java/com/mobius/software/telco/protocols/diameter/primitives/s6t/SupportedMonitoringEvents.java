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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask64;

/**
*
* @author yulian oifa
*
*/

/*
	8.4.41	Supported-Monitoring-Events
	The Supported-Monitoring-Events AVP is of type Unsigned64 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.4.41-1:
	
	Table 8.4.41-1: Supported-Monitoring-Events
	Bit Name
	Description

	0 UE and UICC and/or new IMSI-IMEI-SV association
	This bit shall be set if Monitoring the association of the UE and UICC and/or new IMSI-IMEI-SV association monitoring event is supported in the HSS

	1 UE-reachability
	This bit shall be set if UE reachability monitoring event is supported in the HSS/MME/SGSN

	2 Location-of-the-UE
	This bit shall be set if Location of the UE and change in location of the UE monitoring event is supported in the HSS/MME/SGSN

	3 Loss-of-connectivity
	This bit shall be set if Loss of connectivity monitoring event is supported in the HSS/MME/SGSN
	
	4 Communication-failure
	This bit shall be set if Communication failure monitoring event is supported in the HSS/MME/SGSN

	5 Roaming-status
	This bit shall be set if Roaming status (i.e. Roaming or No Roaming) of the UE, and change in roaming status of the UE monitoring event is supported in the HSS
	
	6 Availability after DDN failure
	This bit shall be set if Availability after DDN failure monitoring event is supported in the HSS/MME/SGSN

	7 Idle Status Indication
	This bit shall be set if Idle Status Indication monitoring event is supported in the HSS/MME/SGSN in addition to Availability after DDN failure and UE reachability

	8 PDN Connectivity Status
	This bit shall be set if PDN Connectivity Status monitoring event is supported in the HSS/MME/SGSN

	NOTE:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.

	Absence of this AVP shall have the same meaning as all bits cleared (i.e. serving node does not support MONTE).
	If RIR-flags is included in Reporting-Information-Request to indicate a change of authorized monitoring events, each bit in Supported-Monitoring-Events AVP, if cleared, shall indicate the SCEF that associated monitoring event is not authorized.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SUPPORTED_MONITORING_EVENTS, vendorId = VendorIDs.TGPP_ID, name = "Supported-Monitoring-Events")
public interface SupportedMonitoringEvents extends DiameterBitmask64
{
	public static final int UE_AND_UICC_BIT = 0;
	public static final int UE_REACHABILITY_BIT = 1;
	public static final int LOCATION_OF_UE_BIT = 2;
	public static final int LOSS_OF_CONNECTIVITY_BIT = 3;
	public static final int COMMUNICATION_FAILURE_BIT = 4;
	public static final int ROAMING_STATUS_BIT = 5;
	public static final int AVAILABILITY_AFTER_DDN_FAILURE_BIT = 6;
	public static final int IDLE_STATUS_INDICATION_BIT = 7;
	public static final int PDN_CONNECTIVITY_STATUS_BIT = 8;
	
	public void setUEAndUICCBit(boolean isOn);
	
	public boolean isUEAndUICCBitSet();
	
	public void setUEReachabilityBit(boolean isOn);
	
	public boolean isUEReachabilityBitSet();
	
	public void setLocationOfUEBit(boolean isOn);
	
	public boolean isLocationOfUEBitSet();
	
	public void setLossOfConnectivityBit(boolean isOn);
	
	public boolean isLossOfConnectivityBitSet();
	
	public void setCommunicationFailureBit(boolean isOn);
	
	public boolean isCommunicationFailureBitSet();
	
	public void setRoamingStatusBit(boolean isOn);
	
	public boolean isRoamingStatusBitSet();
	
	public void setAvailabilityAfterDDNFailureBit(boolean isOn);
	
	public boolean isAvailabilityAfterDDNFailureBitSet();
	
	public void setIdleStatusIndicationBit(boolean isOn);
	
	public boolean isIdleStatusIndicationBitSet();
	
	public void setPDNConnectivityStatusBit(boolean isOn);
	
	public boolean isPDNConnectivityStatusBitSet();	
}