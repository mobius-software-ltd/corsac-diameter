package com.mobius.software.telco.protocols.diameter.primitives.t6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.27	RRC-Cause-Counter
	The RRC-Cause-Counter AVP is of type Grouped and shall contain the number of receptions of "MO Exception data" and the time when the cause " MO Exception Data" is received for the first time.
	The AVP format shall conform to:
	
	RRC-Cause-Counter::=	<AVP header: 4318 10415>
		 [ Counter-Value ]
		 [ RRC-Counter-Timestamp ]
		*[AVP]
 */
@DiameterAvpDefinition(code = 4318L, vendorId = KnownVendorIDs.TGPP_ID, name = "RRC-Cause-Counter")
public interface RRCCauseCounter extends DiameterGroupedAvp
{
	Long getCounterValue();
	
	void setCounterValue(Long value);
	
	Date getRRCCounterTimestamp();
	
	void setRRCCounterTimestamp(Date value);
}