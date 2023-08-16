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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned64;

/**
*
* @author yulian oifa
*
*/

/*
	7.2.  OC-Feature-Vector AVP

	   The OC-Feature-Vector AVP (AVP Code 622) is of type Unsigned64 and
	   contains a 64-bit flags field of announced capabilities of a DOIC
	   node.  The value of zero (0) is reserved.
	
	   The OC-Feature-Vector sub-AVP is used to announce the DOIC features
	   supported by the DOIC node, in the form of a flag-bits field in which
	   each bit announces one feature or capability supported by the node.
	   The absence of the OC-Feature-Vector AVP in request messages
	   indicates that only the default traffic abatement algorithm described
	   in this specification is supported.  The absence of the OC-Feature-
	   Vector AVP in answer messages indicates that the default traffic
	   abatement algorithm described in this specification is selected
	   (while other traffic abatement algorithms may be supported), and no
	   features other than abatement algorithms are supported.
   
	   The following capability is defined in this document:
	
	   OLR_DEFAULT_ALGO (0x0000000000000001)
	
	      When this flag is set by the a DOIC reacting node, it means that
	      the default traffic abatement (loss) algorithm is supported.  When
	      this flag is set by a DOIC reporting node, it means that the loss
	      algorithm will be used for requested overload abatement.
 */
@DiameterAvpDefinition(code = 622L, vendorId = -1L, must = false, name = "OC-Feature-Vector")
public interface OCFeatureVector extends DiameterUnsigned64
{
}