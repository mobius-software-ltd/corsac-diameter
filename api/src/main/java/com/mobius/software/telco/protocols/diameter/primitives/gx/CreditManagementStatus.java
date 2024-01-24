package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.102 Credit-Management-Status AVP
	The Credit-Management-Status AVP is of type Unsigned32 and it shall contain a bit mask. The bit 0 shall be the least
	significant bit. For example, to get the value of bit 0, a bit mask of 0x0001 should be used. The meaning of the bits shall
	be as defined below:

	Table 5.3.102: Credit-Management-Status
	
	0 - End User Service Denied
	This bit, when set, indicates that the charging system denied the service request due to
	service restrictions (e.g. terminate rating group) or limitations related to the end-user, for
	example the end-user's account could not cover the requested service.

	1 - Credit Control Not Applicable
	This bit, when set, indicates that the charging system determined that the service can be
	granted to the end user but no further credit control is needed for the service (e.g.
	service is free of charge or is treated for offline charging).

	2 - Authorization Rejected
	This bit, when set, indicates that the charging system denied the service request in order
	to terminate the service for which credit is requested.

	3 User Unknown 
	This bit, when set, indicates that the specified end user could not be found in the charging system.

	4 Rating Failed 
	This bit, when set, indicates that the charging system cannot rate the service request
	due to insufficient rating input, incorrect AVP combination or an AVP value that is not
	recognized or supported in rating.

	5 No Gyn Session, service allowed
	This bit, when set, indicates that the Gyn session was terminated (e.g. network failure),
	but the OCS allowed the service to continue (NOTE).

	6 No Gyn Session,service not allowed
	This bit, when set, indicates that the Gyn session was terminated (e.g. network failure)
	and the OCS did not allow the service to continue (NOTE).

	NOTE: Applicable only over Sd reference point. 
 */
@DiameterAvpDefinition(code = 1082L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Credit-Management-Status")
public interface CreditManagementStatus extends DiameterBitmask32
{
	public static final int END_USER_SERVICE_DENIED_BIT = 0;	
	public static final int CREDIT_CONTROL_NOT_APPLICABLE_BIT = 1;	
	public static final int AUTHORIZATION_REJECTED_BIT = 2;	
	public static final int USER_UNKNOWN_BIT = 3;	
	public static final int RATING_FAILED_BIT = 4;	
	public static final int NO_GYN_SESSION_SERVICE_ALLOWED_BIT = 5;	
	public static final int NO_GYN_SESSION_SERVICE_NOT_ALLOWED_BIT = 6;	
	
	public void setEndUserServiceDeniedBit(boolean isOn);
	
	public boolean isEndUserServiceDeniedBitSet();
	
	public void setCreditControlNotApplicableBit(boolean isOn);
	
	public boolean isCreditControlNotApplicableBitSet();
	
	public void setAuthorizationRejectedBit(boolean isOn);
	
	public boolean isAuthorizationRejectedBitSet();
	
	public void setUserUnknownBit(boolean isOn);
	
	public boolean isUserUnknownBitSet();
	
	public void setRatingFailedBit(boolean isOn);
	
	public boolean isRatingFailedBitSet();
	
	public void setNoGynSessionServiceAllowedBit(boolean isOn);
	
	public boolean isNoGynSessionServiceAllowedBitSet();
	
	public void setNoGynSessionServiceNotAllowedBit(boolean isOn);
	
	public boolean isNoGynSessionServiceNotAllowedBitSet();
}