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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.149	PoC-User-Role AVP
	The PoC-User-Role AVP (AVP code 1252) is of type Grouped. It specifies the role(s) related information of the PoC User that participating in the PoC Session.
	It has the following grammar:
	
	PoC-User-Role ::  =  <AVP header: 1252>
			[ PoC-User-Role-Ids ]
			[ PoC-User-Role-info-Units ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.POC_USER_ROLE, vendorId = VendorIDs.TGPP_ID, name = "PoC-User-Role")
public interface PoCUserRole extends DiameterAvp
{
	String getPoCUserRoleIDs();
	
	void setPoCUserRoleIDs(String value);
	
	PoCUserRoleInfoUnitsEnum getPoCUserRoleInfoUnits();
	
	void setPoCUserRoleInfoUnits(PoCUserRoleInfoUnitsEnum value);
}