package com.mobius.software.telco.protocols.diameter.primitives.pc4a;
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
	6.3.3	ProSe-Permission
	The ProSe-Permission AVP is of type Unsigned32 and it shall contain a bit mask that indicates the permissions for ProSe subscribed by the user. The meaning of the bits shall be as defined in table 6.3.3/1:
	Table 6.3.3-1: ProSe-Permission

	Bit Name
	Description

	0 ProSe Direct Discovery
	This bit, when set, indicates that the user is allowed to use ProSe Direct Discovery.
	
	1 EPC-level ProSe Discovery
	This bit, when set, indicates that the user is allowed to use EPC-level ProSe Discovery.

	2 EPC support WLAN Direct Discovery and Communication
	This bit, when set, indicates that the user is allowed to use EPC support WLAN Direct Discovery and Communication.

	3 one-to-many ProSe Direct Communication
	This bit, when set, indicates that the user is allowed to use one-to-many ProSe Direct Communication.

	4 one-to-one ProSe Direct Communication
	This bit, when set, indicates that the user is allowed to use one-to-one ProSe Direct Communication.

	5 UE-to-Network Relay
	This bit, when set, indicates that the user is allowed to act as a UE-to-Network relay.

	6 Remote-UE-access
	This bit, when set, indicates that the user is allowed to act as a Remote-UE.

	7 Restricted ProSe Direct Discovery
	This bit, when set, indicates that the user is allowed to use restricted ProSe Direct Discovery.

	NOTE:	Bits not defined in this table shall be cleared by the HSS and discarded by the receiving ProSe Function.
 */
@DiameterAvpDefinition(code = 3702L, vendorId = KnownVendorIDs.TGPP_ID, name = "ProSe-Permission")
public interface ProSePermission extends DiameterBitmask32
{
	public static final int PROSE_DIRECT_DISCOVERY_BIT = 0;	
	public static final int EPC_LEVEL_PROSE_DISCOVERY_BIT = 1;	
	public static final int EPC_SUPPORT_WLAN_DIRECT_DISCOVERY_AND_COMMUNICATION_BIT = 2;	
	public static final int ONE_TO_MANY_PROSE_DIRECT_COMMUNICATION_BIT = 3;	
	public static final int ONE_TO_ONE_PROSE_DIRECT_COMMUNICATION_BIT = 4;	
	public static final int UE_TO_NETWORK_RELAY_BIT = 5;	
	public static final int REMOTE_UE_ACCESS_BIT = 6;	
	public static final int RESTRICTED_PROSE_DIRECT_DISCOVERY_BIT = 7;
	
	public void setProSeDirectDiscoveryBit(boolean isOn);
	
	public boolean isProSeDirectDiscoverySet();	
	
	public void setEPCLevelProSeDiscoveryBit(boolean isOn);
	
	public boolean isEPCLevelProSeDiscoveryBitSet();	
	
	public void setEPCSupportWLANDirectDiscoveryAndCommunicationBit(boolean isOn);
	
	public boolean isEPCSupportWLANDirectDiscoveryAndCommunicationBitSet();
	
	public void setOneToManyProSeDirectCommunicationBit(boolean isOn);
	
	public boolean isOneToManyProSeDirectCommunicationBitSet();
	
	public void setOneToOneProSeDirectCommunicationBit(boolean isOn);
	
	public boolean isOneToOneProSeDirectCommunicationBitSet();	
	
	public void setUEToNetworkRelayBit(boolean isOn);
	
	public boolean isUEToNetworkRelayBitSet();	
	
	public void setRemoteUEAccessBit(boolean isOn);
	
	public boolean isRemoteUEAccessBitSet();
	
	public void setRestrictedProSeDirectDiscoveryBit(boolean isOn);
	
	public boolean isRestrictedProSeDirectDiscoveryBitSet();
}