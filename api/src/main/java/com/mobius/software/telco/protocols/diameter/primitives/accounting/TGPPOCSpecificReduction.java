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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	B.2.3	3GPP-OC-Specific-Reduction AVP
	The 3GPP-OC-Specific-Reduction AVP (AVP code 1320) is of type Grouped. It details the for which Rating Group, type of requests or both the reduction, due to overload, should be applied.
	It has the following ABNF grammar:

	3GPP-OC-Specific-Reduction :: = < AVP Header: 1320 >

		*  [ 3GPP-OC-Rating-Group ]
		*  [ 3GPP-OC-Request-Type ]
		   [ OC-Reduction-Percentage ]
		*  [ AVP ]
 */
@DiameterAvpDefinition(code = 1320L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "3GPP-OC-Specific-Reduction")
public interface TGPPOCSpecificReduction extends DiameterGroupedAvp
{
	List<Long> get3GPPOCRatingGroup();
	
	void set3GPPOCRatingGroup(List<Long> value);
	
	List<TGPPOCRequestTypeEnum> get3GPPOCRequestType();
	
	void set3GPPOCRequestType(List<TGPPOCRequestTypeEnum> value);
	
	Long getOCReductionPercentage();
	
	void setOCReductionPercentage(Long value);
}