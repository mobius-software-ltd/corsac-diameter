package com.mobius.software.telco.protocols.diameter.primitives.sgmb;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	20.5a.8	MBMS-Data-Transfer-Stop AVP
	The MBMS-Data-Transfer-Stop AVP (AVP code 930) is of type Unsigned64. 
	This value indicates the time in seconds for the release of resources relative to 00:00:00 on 1 January 1900 (calculated as continuous time without leap seconds and traceable to a common time reference) where binary encoding of the integer part is in the first 32 bits and binary encoding of the fraction part in the last 32 bits. The fraction part is expressed with a granularity of 1 /2**32 second.
	This AVP is only valid for E-UTRAN access type.
 */
@DiameterAvpDefinition(code = 930L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "MBMS-Data-Transfer-Stop")
public interface MBMSDataTransferStop extends DiameterUnsigned64
{
}