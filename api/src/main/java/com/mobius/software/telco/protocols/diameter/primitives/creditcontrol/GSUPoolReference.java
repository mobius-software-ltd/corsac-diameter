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
 * 8.30.  G-S-U-Pool-Reference AVP

   The G-S-U-Pool-Reference AVP (AVP Code 457) is of type Grouped.  It
   is used in the Credit-Control-Answer message and associates the
   Granted-Service-Unit AVP within which it appears with a credit pool
   within the session.

   The G-S-U-Pool-Identifier AVP specifies the credit pool from which
   credit is drawn for this unit type.
   
   The CC-Unit-Type AVP specifies the type of units for which credit is
   pooled.

   The Unit-Value AVP specifies the multiplier, which converts between
   service units of type CC-Unit-Type and abstract service units within
   the credit pool (and thus to service units of any other services or
   rating-groups associated with the same pool).

   The G-S-U-Pool-Reference AVP is defined as follows (per
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