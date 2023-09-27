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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.231	Time-Stamps AVP
	The Time-Stamps AVP (AVP code 833) is of type Grouped and holds the time stamp of the SIP REQUEST and the time stamp of the response to the SIP REQUEST.
	It has the following ABNF grammar:
	
	Time-Stamps ::=	< AVP Header: 833 >
		[ SIP-Request-Timestamp ]
		[ SIP-Response-Timestamp ]
		[ SIP-Request-Timestamp-Fraction ]
		[ SIP-Response-Timestamp-Fraction ]
 */
@DiameterAvpDefinition(code = 833L, vendorId = KnownVendorIDs.TGPP_ID, name = "Time-Stamps")
public interface TimeStamps extends DiameterAvp
{
	Date getSIPRequestTimestamp();
	
	void setSIPRequestTimestamp(Date value);
	
	Date getSIPResponseTimestamp();
	
	void setSIPResponseTimestamp(Date value);
	
	Long getSIPRequestTimestampFraction();
	
	void setSIPRequestTimestampFraction(Long value);
	
	Long getSIPResponseTimestampFraction();
	
	void setSIPResponseTimestampFraction(Long value);
}