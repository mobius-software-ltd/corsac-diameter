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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.4.10	Radio-Frequency AVP
	The Radio-Frequency AVP (AVP code 3508) is of type Unsigned32. It is used by the BM‑SC to indicate radio frequencies, as defined in TS 26.346 [5], as MBMS bearer related configuration information to the GCS AS. The coding of this AVP shall be the same as defined for the radiofrequency child element of the infoBinding in TS 26.346 [5].
 */
@DiameterAvpDefinition(code = 3508L, vendorId = KnownVendorIDs.TGPP_ID, name = "Radio-Frequency")
public interface RadioFrequency extends DiameterUnsigned32
{
}