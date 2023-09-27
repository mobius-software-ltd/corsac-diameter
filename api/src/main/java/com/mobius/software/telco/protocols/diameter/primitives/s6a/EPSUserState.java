package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.110	EPS-User-State
	The EPS-User-State AVP is of type Grouped. It shall contain the information related to the user state in the MME and/or the SGSN.
	AVP format

	EPS-User-State ::= <AVP header:1495 10415>
			 [MME-User-State]
			 [SGSN-User-State]
			*[AVP]
 */
@DiameterAvpDefinition(code = 1495L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "EPS-User-State")
public interface EPSUserState extends DiameterGroupedAvp
{
	MMEUserState getMMEUserState();
	
	void setMMEUserState(MMEUserState value);	
	
	SGSNUserState getSGSNUserState();
	
	void setSGSNUserState(SGSNUserState value);
}