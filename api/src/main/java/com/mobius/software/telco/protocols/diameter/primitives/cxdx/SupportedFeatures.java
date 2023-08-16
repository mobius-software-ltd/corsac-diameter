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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.29	Supported-Features AVP
	The Supported-Features AVP is of type Grouped. If this AVP is present it may inform the destination host about the features that the origin host supports for the application. The Feature-List AVP contains a list of supported features of the origin host. The Vendor-Id AVP and the Feature-List-ID AVP shall together identify which feature list is carried in the Supported-Features AVP for the Application-ID present in the command header.
	Where a Supported-Features AVP is used to identify features that have been defined by 3GPP, the Vendor-Id AVP shall contain the vendor ID of 3GPP. Vendors may define proprietary features, but it is strongly recommended that the possibility is used only as the last resort. Where the Supported-Features AVP is used to identify features that have been defined by a vendor other than 3GPP, it shall contain the vendor ID of the specific vendor in question.
	If there are multiple feature lists defined by the same vendor and the same application, the Feature-List-ID AVP shall differentiate those lists from one another. The destination host shall use the value of the Feature-List-ID AVP to identify the feature list.
	AVP format
	
	Supported-Features ::=	< AVP header: 628 10415 >
		{ Vendor-Id }
		{ Feature-List-ID }
		{ Feature-List }
 	   *[AVP]
 */
@DiameterAvpDefinition(code = 628L, vendorId = KnownVendorIDs.TGPP_ID, name = "Supported-Features")
public interface SupportedFeatures extends DiameterGroupedAvp
{
	Long getVendorId();
	
	void setVendorId(Long value);
	
	Long getFeatureListID();
	
	void setFeatureListID(Long value);	
	
	Long getFeatureList();
	
	void setFeatureList(Long value);	
}