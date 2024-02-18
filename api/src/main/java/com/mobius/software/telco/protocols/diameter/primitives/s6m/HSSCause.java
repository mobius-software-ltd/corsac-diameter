package com.mobius.software.telco.protocols.diameter.primitives.s6m;
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
	6.4.9	HSS-Cause
	The HSS-Cause AVP is of type Unsigned32 and it contains a bit mask. The meaning of the bits is defined in table 6.4.9/1:
	Table 6.4.9/1: HSS-Cause

	Bit Name
	Description
	
	0 Absent Subscriber
	This bit, when set, indicates that there is no serving node registered in the HSS over which the corresponding triggering method should be immediately attempted for the user. NOTE 1.

	1 Teleservice Not Provisioned
	This bit, when set, indicates that the required teleservice(s) for the corresponding triggering method are not provisioned in the HSS/HLR for the user.

	2 Call Barred
	This bit, when set, indicates that the user has an active barring condition which makes it impossible to deliver the corresponding triggering method.

	NOTE 1:	This may be caused because there is not any serving node currently registered in HSS for the user, or because the user is known to be absent in all suitable registered serving nodes (based on MNRF, MNRG and UNRI flags) and the trigger delivery is requested with "non-priority".

	NOTE 2:	Bits not defined in this table shall be cleared by the HSS and discarded by the receiving node, MTC-IWF.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.HSS_CAUSE, vendorId = VendorIDs.TGPP_ID, name = "HSS-Cause")
public interface HSSCause extends DiameterBitmask32
{
	public static final int ABSENT_SUBSCRIBER_BIT = 0;	
	public static final int TELESERVICE_NOT_PROVISIONED_BIT = 1;	
	public static final int CALL_BARRED_BIT = 2;	
	
	public void setAbsentSubscriberBit(boolean isOn);
	
	public boolean isAbsentSubscriberBitSet();
	
	public void setTeleserviceNotProvisionedBit(boolean isOn);
	
	public boolean isTeleserviceNotProvisionedBitSet();
	
	public void setCallBarredBit(boolean isOn);
	
	public boolean isCallBarredBitSet();
}