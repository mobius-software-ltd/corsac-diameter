package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.68	Reporting-Duration
	The Reporting-Duration AVP is of type Unsigned32 and it contains the maximum duration of event reporting, in seconds. Its minimum value shall be 1 and maximum value shall be 8640000. The Reporting-Duration AVP is only applicable to a deferred EPC-MT-LR. 
 */
@DiameterAvpDefinition(code = 2563L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Reporting-Duration")
public interface ReportingDuration extends DiameterUnsigned32
{
}