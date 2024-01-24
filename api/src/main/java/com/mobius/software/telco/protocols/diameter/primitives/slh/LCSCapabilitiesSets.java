package com.mobius.software.telco.protocols.diameter.primitives.slh;
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
	6.4.6 LCS-Capabilities-Sets
	The LCS-Capabilities-Sets AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be
	as defined in 3GPP 29.002 [3]. 
	
	 * SupportedLCS-CapabilitySets ::= BIT STRING { lcsCapabilitySet1 (0), lcsCapabilitySet2 (1), lcsCapabilitySet3 (2),
	 * lcsCapabilitySet4 (3) , lcsCapabilitySet5 (4) } (SIZE (2..16)) -- Core network signalling capability set1 indicates LCS
	 * Release98 or Release99 version. -- Core network signalling capability set2 indicates LCS Release4. -- Core network signalling
	 * capability set3 indicates LCS Release5. -- Core network signalling capability set4 indicates LCS Release6. -- Core network
	 * signalling capability set5 indicates LCS Release7 or later version. -- A node shall mark in the BIT STRING all LCS capability
	 * sets it supports. -- If no bit is set then the sending node does not support LCS. -- If the parameter is not sent by an VLR
	 * then the VLR may support at most capability set1. -- If the parameter is not sent by an SGSN then no support for LCS is
	 * assumed. -- An SGSN is not allowed to indicate support of capability set1. -- Other bits than listed above shall be
	 * discarded.
 */
@DiameterAvpDefinition(code = 2404L, vendorId = KnownVendorIDs.TGPP_ID, name = "LCS-Capabilities-Sets")
public interface LCSCapabilitiesSets extends DiameterBitmask32
{
	public static final int REL98_99_BIT = 0;	
	public static final int REL4_BIT = 1;	
	public static final int REL5_BIT = 2;	
	public static final int REL6_BIT = 3;	
	public static final int REL7_BIT = 4;	
	
	public void setRel9899Bit(boolean isOn);
	
	public boolean isRel9899Set();
	
	public void setRel4Bit(boolean isOn);
	
	public boolean isRel4Set();
	
	public void setRel5Bit(boolean isOn);
	
	public boolean isRel5Set();
	
	public void setRel6Bit(boolean isOn);
	
	public boolean isRel6Set();
	
	public void setRel7Bit(boolean isOn);
	
	public boolean isRel7Set();
}