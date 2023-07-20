package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

/**
*
* @author yulian oifa
*
*/

/*
 * The G-S-U-Pool-Reference AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

           G-S-U-Pool-Reference ::= < AVP Header: 457 >
                                    { G-S-U-Pool-Identifier }
                                    { CC-Unit-Type }
                                    { Unit-Value }
 */
@DiameterAvpDefinition(code = 457L, vendorId = -1, name = "G-S-U-Pool-Reference")
public interface GSUPoolReference extends DiameterAvp 
{
	Long getGSUPoolIdentifier();
	
	void setGSUPoolIdentifier(Long gsuPoolIdentifier);
	
	CcUnitTypeEnum getCCUnitType();
	
	void setCCUnitType(CcUnitTypeEnum ccUnitType);
	
	UnitValue getUnitValue();
	
	void setUnitValue(UnitValue unitValue);	
}