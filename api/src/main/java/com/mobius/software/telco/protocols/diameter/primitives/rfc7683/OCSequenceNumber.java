package com.mobius.software.telco.protocols.diameter.primitives.rfc7683;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/

/*
	7.4.  OC-Sequence-Number AVP

	   The OC-Sequence-Number AVP (AVP Code 624) is of type Unsigned64.  Its
	   usage in the context of overload control is described in Section 5.2.
	
	   From the functionality point of view, the OC-Sequence-Number AVP is
	   used as a nonvolatile increasing counter for a sequence of overload
	   reports between two DOIC nodes for the same overload occurrence.
	   Sequence numbers are treated in a unidirectional manner, i.e., two
	   sequence numbers in each direction between two DOIC nodes are not
	   related or correlated.
*/
@DiameterAvpDefinition(code = AvpCodes.OC_SEQUENCE_NUMBER, vendorId = -1L, must = false, name = "OC-Sequence-Number")
public interface OCSequenceNumber extends DiameterUnsigned64
{
}