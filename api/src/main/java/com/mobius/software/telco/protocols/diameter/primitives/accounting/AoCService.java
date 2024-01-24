package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.17	AoC-Service AVP
	The AoC-Service AVP (AVP code 2311) is of type Grouped and holds the pair of AoC Service type and AoC Service obligatory type.
	It has the following ABNF grammar:
	
	AoC-Service :: =          < AVP Header: 2311 >
       [ AoC-Service-Obligatory-Type ]
       [ AoC-Service-Type ]
 */
@DiameterAvpDefinition(code = 2311L, vendorId = KnownVendorIDs.TGPP_ID, name = "AoC-Service")
public interface AoCService extends DiameterAvp
{
	AoCServiceObligatoryTypeEnum getAoCServiceObligatoryType();
	
	void setAoCServiceObligatoryType(AoCServiceObligatoryTypeEnum value);
	
	AoCServiceTypeEnum getAoCServiceType();
	
	void setAoCServiceType(AoCServiceTypeEnum value);
}