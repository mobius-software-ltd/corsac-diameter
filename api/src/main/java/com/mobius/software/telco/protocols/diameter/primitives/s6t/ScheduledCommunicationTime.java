package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DayOfWeekMask;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.30	Scheduled-communication-time
	The Scheduled-communication-time AVP is of type Grouped.
	AVP format
 
 	Scheduled-communication-time ::= <AVP header: 3118 10415>
			 [ Day-Of-Week-Mask ]
			 [ Time-Of-Day-Start ]
			 [ Time-Of-Day-End ]
			*[AVP]

	If Day-Of-Week-Mask is not provided this shall be interpreted as every day of the week.
	If Time-Of-Day-Start is not provided, starting time shall be set to start of the day(s) indicated by Day-Of-Week-Mask.
	If Time-Of-Day-End is not provided, ending time is end of the day(s) indicated by Day-Of-Week-Mask.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SCHEDULED_COMMUNICATION_TIME, vendorId = VendorIDs.TGPP_ID, name = "Scheduled-Communication-Time")
public interface ScheduledCommunicationTime extends DiameterGroupedAvp
{
	DayOfWeekMask getDayOfWeekMask();
	
	void setDayOfWeekMask(DayOfWeekMask value);
	
	Long getTimeOfDayStart();
	
	void setTimeOfDayStart(Long value);
	
	Long getTimeOfDayEnd();
	
	void setTimeOfDayEnd(Long value);	
}