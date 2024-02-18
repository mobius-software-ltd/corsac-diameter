package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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
	6.4.33	FEC‑Result AVP
	The FEC‑Result AVP (AVP code 3531) is of type Unsigned32 and it shall contain a bit mask with values as defined table 6.4.33-1. Several bits indicating errors may be set in combination.
	Table 6.4.33-1: FEC‑Result AVP

	Bit Name
	Description

	0 Success
	The requested FEC activation was successful.

	1 Trying
	The requested FEC activation is still ongoing, The final result will be reported separately.

	2 Authorization rejected
	The requested FEC activation failed because the BM‑SC did not authorize it.

	3 Resources exceeded
	The requested FEC activation or execution failed because the BM‑SC could not provide sufficient resources.

	4 Unknown Configuration
	The requested FEC activation failed because the BM‑SC does not support the requested FEC configuration.

	5 Invalid SDP
	The requested FEC activation failed because the SDP provided within the FEC‑Request AVP was invalid.

	6 System error
	The requested FEC activation or execution failed due to some internal system error in the BM-SC.	
	
	7 No Traffic
	The FEC execution was terminated because the BM-SC did not detect any user plane traffic for a longer period.
*/
@DiameterAvpDefinition(code = TgppAvpCodes.FEC_RESULT, vendorId = VendorIDs.TGPP_ID, must = false, name = "FEC‑Result")
public interface FECResult extends DiameterBitmask32
{
	public static final int SUCCESS_BIT = 0;
	public static final int TRYING_BIT = 1;
	public static final int AUTHORIZATION_BIT = 2;
	public static final int RESOURCES_EXCEEDED_BIT = 3;
	public static final int UNKOWN_CONFIGURATION_BIT = 4;
	public static final int INVALID_SDP_BIT = 5;
	public static final int SYSTEM_ERROR_BIT = 6;
	public static final int NO_TRAFFIC_BIT = 7;
	
	public void setSucessBit(boolean isOn);
	
	public boolean isSucessBitSet();
	
	public void setTryingBit(boolean isOn);
	
	public boolean isTryingBitSet();
	
	public void setAuthorizationBit(boolean isOn);
	
	public boolean isAuthorizationBitSet();
	
	public void setResouceExceededBit(boolean isOn);
	
	public boolean isResouceExceededSet();
	
	public void setUnknownConfigurationBit(boolean isOn);
	
	public boolean isUnknownConfigurationBitSet();
	
	public void setInvalidSDPBit(boolean isOn);
	
	public boolean isInvalidSDPBitSet();
	
	public void setSystemErrorBit(boolean isOn);
	
	public boolean isSystemErrorBitSet();
	
	public void setNoTrafficBit(boolean isOn);
	
	public boolean isNoTrafficBitSet();
}