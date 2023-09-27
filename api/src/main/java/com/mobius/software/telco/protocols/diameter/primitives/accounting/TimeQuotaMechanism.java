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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.228	Time-Quota-Mechanism
	The Time-Quota-Mechanism AVP (AVP code 1270) is of type Grouped.
	It has the following syntax:

	Time-Quota-Mechanism ::= < AVP Header: 1270>
		{ Time-Quota-Type }
		{ Base-Time-Interval }

	The OCS may include this AVP in a Multiple-Services-Credit-Control AVP, when granting time quota. 
 */
@DiameterAvpDefinition(code = 1270L, vendorId = KnownVendorIDs.TGPP_ID, name = "Time-Quota-Mechanism")
public interface TimeQuotaMechanism extends DiameterAvp
{
	TimeQuotaTypeEnum getTimeQuotaType();
	
	void setTimeQuotaType(TimeQuotaTypeEnum value);
	
	Long getBaseTimeInterval();
	
	void setBaseTimeInterval(Long value);
}