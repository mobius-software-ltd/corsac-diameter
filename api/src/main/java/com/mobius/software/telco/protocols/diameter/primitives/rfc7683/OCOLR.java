package com.mobius.software.telco.protocols.diameter.primitives.rfc7683;
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
 * 7.3.  OC-OLR AVP

   The OC-OLR AVP (AVP Code 623) is of type Grouped and contains the
   information necessary to convey an overload report on an overload
   condition at the reporting node.  The application the OC-OLR AVP
   applies to is identified by the Application-ID found in the Diameter
   message header.  The host or realm the OC-OLR AVP concerns is
   determined from the Origin-Host AVP and/or Origin-Realm AVP found in
   the encapsulating Diameter command.  The OC-OLR AVP is intended to be
   sent only by a reporting node.

      OC-OLR ::= < AVP Header: 623 >
                 < OC-Sequence-Number >
                 < OC-Report-Type >
                 [ OC-Reduction-Percentage ]
                 [ OC-Validity-Duration ]
               * [ AVP ]
 */
@DiameterAvpDefinition(code = 623L, vendorId = -1L, must = false, name = "OC-OLR")
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
}