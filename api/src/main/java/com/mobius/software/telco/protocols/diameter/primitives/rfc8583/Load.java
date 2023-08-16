package com.mobius.software.telco.protocols.diameter.primitives.rfc8583;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 7.1.  Load AVP

   The Load AVP (AVP code 650) is of type Grouped and is used to convey
   load information between Diameter nodes.

    Load ::= < AVP Header: 650 >
             [ Load-Type ]
             [ Load-Value ]
             [ SourceID ]
           * [ AVP ]
 */
@DiameterAvpDefinition(code = 650L, vendorId = -1L, must = false, name = "Load")
public interface Load extends DiameterGroupedAvp
{
	LoadTypeEnum getLoadType();
	
	void setLoadType(LoadTypeEnum value);
	
	Long getLoadValue();
	
	void setLoadValue(Long value);	
	
	String getSourceID();
	
	void setSourceID(String value);	
}