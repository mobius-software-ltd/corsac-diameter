package com.mobius.software.telco.protocols.diameter.primitives.gy;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ReportingReasonEnum;

/*
 		3.2.4 Diameter Gy CCR – Used-Service-Unit grouped AVP
		Grouped AVP format as defined in RFC 4006. Strikethough formatted AVPs are not included in CCR.
		
 					Used-Service-Unit ::= < AVP Header: 446 >
 						[ CC-Time ]
 						[ CC-Money ]
 						[ CC-Total-Octets ]
 						[ CC-Input-Octets ]
 						[ CC-Output-Octets ]
 								
 */

@DiameterAvpDefinition(code = AvpCodes.USED_SERVICE_UNIT, vendorId = -1, name = "Used-Service-Unit")
public interface UsedServiceUnit extends RequestedServiceUnit 
{
	List<ReportingReasonEnum> getReportingReason();

	void setReportingReason(List<ReportingReasonEnum> value);  
	
	Date getCCTime();
	
	void setCCTime(Date value);	
	
	Long getCCTotalOctets();
	
	void setCCTotalOctets(Long value);
	
	Long getCCInputOctets();
	
	void setCCInputOctets(Long value);
	
	Long getCCOutputOctets();
	
	void setCCOutputOctets(Long value);
}