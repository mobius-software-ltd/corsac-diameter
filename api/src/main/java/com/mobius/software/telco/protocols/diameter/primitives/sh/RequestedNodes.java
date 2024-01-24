package com.mobius.software.telco.protocols.diameter.primitives.sh;
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
	6.3.7A Requested-Nodes AVP
	The Requested-Nodes AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as
	defined in table 6.3.7A/1:

	Table 6.3.7A/1: Requested-Nodes
	Bit Name Description
	0 MME The requested data apply to the MME
	1 SGSN The requested data apply to the SGSN
	2 3GPP-AAASERVER-TWAN
	  The requested data apply to the 3GPP AAA Server for TWAN
	3 AMF The requested data apply to the AMF (for 3GPP access) 
 */
@DiameterAvpDefinition(code = 713L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Requested-Nodes")
public interface RequestedNodes extends DiameterBitmask32
{
	public static final int MME_BIT = 0;	
	public static final int SGSN_BIT = 1;	
	public static final int TGPP_AAASERVER_TWAN_BIT = 2;	
	public static final int AMF_BIT = 3;	
	
	public void setMMEBit(boolean isOn);
	
	public boolean isMMEBitSet();
	
	public void setSGSNBit(boolean isOn);
	
	public boolean isSGSNBitSet();
	
	public void set3GPPAAASERVERTWANBit(boolean isOn);
	
	public boolean is3GPPAAASERVERTWANBitSet();
	
	public void setAMFBit(boolean isOn);
	
	public boolean isAMFBitSet();
}