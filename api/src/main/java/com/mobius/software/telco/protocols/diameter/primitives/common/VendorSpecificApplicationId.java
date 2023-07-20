package com.mobius.software.telco.protocols.diameter.primitives.common;
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
 * The Vendor-Specific-Application-Id AVP SHOULD be placed as close to
   the Diameter header as possible.

      AVP Format

      <Vendor-Specific-Application-Id> ::= < AVP Header: 260 >
                                           { Vendor-Id }
                                           [ Auth-Application-Id ]
                                           [ Acct-Application-Id ]
   
   A Vendor-Specific-Application-Id AVP MUST contain exactly one of
   either Auth-Application-Id or Acct-Application-Id.  If a Vendor-
   Specific-Application-Id is received without one of these two AVPs,
   then the recipient SHOULD issue an answer with a Result-Code set to
   DIAMETER_MISSING_AVP.  The answer SHOULD also include a Failed-AVP,
   which MUST contain an example of an Auth-Application-Id AVP and an
   Acct-Application-Id AVP.
 */
@DiameterAvpDefinition(code = 260L, vendorId = -1L, position = 8, name = "Vendor-Specific-Application-Id")
public interface VendorSpecificApplicationId extends DiameterAvp 
{
	Long getVendorId();
	
	void setVendorId(Long vendorId);
	
	Long getAuthApplicationId();
	
	void setAuthApplicationId(Long authApplicationId);
	
	Long getAcctApplicationId();
	
	void setAcctApplicationId(Long acctApplication);
}