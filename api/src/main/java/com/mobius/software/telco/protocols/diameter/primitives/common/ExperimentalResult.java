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
 * 7.6.  Experimental-Result AVP

   The Experimental-Result AVP (AVP Code 297) is of type Grouped, and
   indicates whether a particular vendor-specific request was completed
   successfully or whether an error occurred.  This AVP has the
   following structure:

   AVP Format

         Experimental-Result ::= < AVP Header: 297 >
                                 { Vendor-Id }
                                 { Experimental-Result-Code }

   The Vendor-Id AVP (see Section 5.3.3) in this grouped AVP identifies
   the vendor responsible for the assignment of the result code that
   follows.  All Diameter answer messages defined in vendor-specific
   applications MUST include either one Result-Code AVP or one
   Experimental-Result AVP.
 */

@DiameterAvpDefinition(code = 297L, position = 3, vendorId = -1L, name = "Experimental-Result")
public interface ExperimentalResult extends DiameterAvp 
{
	Long getVendorId();
	
	void setVendorId(Long vendorId);
	
	Long getExperimentalResultCode();
	
	void setExperimentalResultCode(Long experimentalResultCode);	
}