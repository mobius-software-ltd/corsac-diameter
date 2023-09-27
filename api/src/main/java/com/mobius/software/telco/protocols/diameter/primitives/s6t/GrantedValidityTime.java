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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	8.4.56	Granted-Validity-Time
	The Granted-Validity-Time AVP is of type Time (see IETF RFC 6733 [23]), and contains the point of time after which the HSS removes a stored NIDD Authorization and after which the SCEF shall consider a granted NIDD authorization as being implicitly revoked.
	A value in the past indicates that the NIDD Authorization is explicitly revoked.
 */
@DiameterAvpDefinition(code = 3160L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Granted-Validity-Time")
public interface GrantedValidityTime extends DiameterTime
{
}