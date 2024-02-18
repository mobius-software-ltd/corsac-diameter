package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.32	Supported-Applications AVP
	The Supported-Applications AVP is of type Grouped and it contains the supported application identifiers of a Diameter node.
	AVP format

	Supported-Applications ::=	< AVP header: 631 10415 >
  		*[ Auth-Application-Id ]
  		*[ Acct-Application-Id ]
  		*[ Vendor-Specific-Application-Id ]
  		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SUPPORTED_APPLICATIONS, vendorId = VendorIDs.TGPP_ID, must = false, name = "Supported-Applications")
public interface SupportedApplications extends DiameterGroupedAvp
{
	List<Long> getAuthApplicationId();
	
	void setAuthApplicationId(List<Long> value);
	
	List<Long> getAcctApplicationId();
	
	void setAcctApplicationId(List<Long> value);
	
	List<VendorSpecificApplicationId> getVendorSpecificApplicationId();
	
	void setVendorSpecificApplicationId(List<VendorSpecificApplicationId> value);		
}