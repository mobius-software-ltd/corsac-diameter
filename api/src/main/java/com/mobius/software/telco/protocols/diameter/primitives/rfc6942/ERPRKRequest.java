package com.mobius.software.telco.protocols.diameter.primitives.rfc6942;
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
 * 8.1.  ERP-RK-Request AVP

   The ERP-RK-Request AVP (AVP Code 618) is of type Grouped AVP.  This
   AVP is used by the ER server to indicate its willingness to act as
   the ER server for a particular session.

   This AVP has the 'M' and 'V' bits cleared.

         ERP-RK-Request ::= < AVP Header: 618 >
                            { ERP-Realm }
                          * [ AVP ]
 */
@DiameterAvpDefinition(code = 618L, vendorId = -1L, must = false, name = "ERP-RK-Request")
public interface ERPRKRequest extends DiameterGroupedAvp
{
	String getERPRealm();
	
	void setERPRealm(String value);
}