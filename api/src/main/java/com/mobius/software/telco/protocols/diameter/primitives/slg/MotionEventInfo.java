package com.mobius.software.telco.protocols.diameter.primitives.slg;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.4.64	Motion-Event-Info
	The Motion-Event-Info AVP is of type Grouped.
	AVP format:

	Motion-Event-Info ::= <AVP header: 2559 10415>
		 { Linear-Distance }
		 [ Occurrence-Info ]
		 [ Interval-Time ]
		 [ Maximum-Interval ]
		 [ Sampling-Interval ]
		 [ Reporting-Duration ]
		 [ Reporting-Location-Requirements ]
		*[ AVP ]

	If not included, the default value of Occurrence-Info shall be considered as "ONE_TIME_EVENT" (0). Interval-Time and Maximum-Interval AVPs are only applicable when the Occurrence-Info is set to "MULTIPLE_TIME_EVENT" (1). If not included, the default value of Interval-Time shall be considered as one and the default values of Maximum-Interval, Sampling-Interval and Reporting-Duration shall each be considered as the maximum value. The Motion-Event-Info AVP is only applicable to a deferred EPC-MT-LR.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MOTION_EVENT_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "Motion-Event-Info")
public interface MotionEventInfo extends DiameterGroupedAvp
{
	Long getLinearDistance();
	
	void setLinearDistance(Long value) throws MissingAvpException;
	
	OccurrenceInfoEnum getOccurrenceInfo();
	
	void setOccurrenceInfo(OccurrenceInfoEnum value);
	
	Long getIntervalTime();
	
	void setIntervalTime(Long value);
	
	Long getMaximumInterval();
	
	void setMaximumInterval(Long value);
	
	Long getSamplingInterval();
	
	void setSamplingInterval(Long value);
	
	Long getReportingDuration();
	
	void setReportingDuration(Long value);
	
	Long getReportingLocationRequirements();
	
	void setReportingLocationRequirements(Long value);
}