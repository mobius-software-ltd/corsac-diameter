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
	7.4.69	Reporting-Location-Requirements
	The Reporting-Location-Requirements AVP is of type Unsigned32 and it shall contain a bit string indicating requirements on location provision for a deferred EPC-MT-LR. When a bit is set to one, the corresponding requirement is present. When a bit is set to zero or when the AVP is omitted, the corresponding requirement is not present. For support of backward compatibility, a receiver shall ignore any bits that are set to one but are not supported
	The meaning of the bits shall be as defined in table 7.4.69/1:
	Table 7.4.69/1: Reporting-Location-Requirements

	Bit Requirement
	Description

	0 Location-Estimate
	A location estimate is required for each area event, motion event report or expiration of the maximum time interval between event reports.

	1-31 None
	Spare
 */
@DiameterAvpDefinition(code = 2564L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Reporting-Location-Requirements")
public interface ReportingLocationRequirements extends DiameterUnsigned32
{
}