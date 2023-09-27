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
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
	B.2.4	OC-OLR AVP
	The OC-OLR AVP (AVP code 623) is of type Grouped. It has been extended compared to the IETF RFC 7683 [403].
	It has the following ABNF grammar:
	OC-OLR :: = < AVP Header: 623 >

		   < OC-Sequence-Number >
		   < OC-Report-Type >
		   [ OC-Reduction-Percentage ]
		   [ OC-Validity-Duration ]
		*  [ 3GPP-OC-Specific-Reduction ]
		*  [ AVP ]
 */
@DiameterAvpDefinition(code = 623L, vendorId = -1, must = false, name = "OC-OLR")
public interface OCOLR extends DiameterGroupedAvp
{
	Long getOCSequenceNumber();
	
	void setOCSequenceNumber(Long value);
	
	OCReportTypeEnum getOCReportType();
	
	void setOCReportType(OCReportTypeEnum value);
	
	Long getOCReductionPercentage();
	
	void setOCReductionPercentage(Long value);
	
	Long getOCValidityDuration();
	
	void setOCValidityDuration(Long value);
	
	List<TGPPOCSpecificReduction> getTGPPOCSpecificReduction();
	
	void setTGPPOCSpecificReduction(List<TGPPOCSpecificReduction> value);	
}