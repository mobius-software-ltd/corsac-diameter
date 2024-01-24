package com.mobius.software.telco.protocols.diameter.primitives.sy;
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
 * 	5.3.7	SN-Request-Type AVP
	The SN-Request-Type AVP (AVP code 2907) shall be of type Unsigned32 and shall contain a bit mask, and informs the PCRF about the type of the Spending-Status-Notification-Request (SNR). The bit 0 shall be the least significant bit. For example, to get the value of bit 0, a bit mask of 0x0001 should be used.
	The following values are defined, and multiple bits may be set in combination:

	Table 5.3.7-1: SN-Request-Type AVP
	Bit Name
	Description

	0 Normal Request 
	This bit, when set, indicates that the SNR is used only to convey a spending limit report as detailed in clause 4.5.2. This shall be the default value that applies when the SN-Request-Type AVP is not included in an SNR.

	1 Abort Session Request 
	This bit, when set, indicates that the SNR is used to request the termination of the Sy session as detailed in clause 4.5.4
 */
@DiameterAvpDefinition(code = 2907L, vendorId = KnownVendorIDs.TGPP_ID, name = "SN-Request-Type")
public interface SNRequestType extends DiameterBitmask32
{
	public static final int NORMAL_REQUEST_BIT = 0;	
	public static final int ABORT_SESSION_REQUEST_BIT = 1;	
	
	public void setNormalRequestBit(boolean isOn);
	
	public boolean isNormalRequestSet();
	
	public void setAbortSessionRequestBit(boolean isOn);
	
	public boolean isAbortSessionRequestSet();
}