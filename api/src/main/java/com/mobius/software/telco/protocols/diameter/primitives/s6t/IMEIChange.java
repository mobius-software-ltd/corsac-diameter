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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/

/*
	8.4.22	IMEI-Change
	The IMEI-Change AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined in table 8.4.22-1:
	Table 8.4.22-1: IMEI-Change

	Bit Name
	Description

	0 IMEI
	This bit, when set, indicates that the IMEI has changed (regardless of whether the IMEI Software Version has changed or not).

	1 IMEISV
	This bit, when set, indicates that only the IMEI Software Version has changed but the IMEI has not changed.

	NOTE 1:	Bits not defined in this table shall be cleared by the sender and discarded by the receiver of the command.

	NOTE 2:	Bits 0 and 1 shall not be set simultaneously.

	When a change of IMEI(SV) is reported, the new IMEI(SV) values may be reported to the SCEF in the Terminal-Information AVP inside the Monitoring-Event-Report AVP (see clause 8.4.3).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMEI_CHANGE, vendorId = VendorIDs.TGPP_ID, name = "IMEI-Change")
public interface IMEIChange extends DiameterBitmask32
{
	public static final int IMEI_BIT = 0;
	public static final int IMEISV_BIT = 1;
	
	public void setIMEIBit(boolean isOn);
	
	public boolean isIMEIBitSet();
	
	public void setIMEISVBit(boolean isOn);
	
	public boolean isIMEISVBitSet();
}