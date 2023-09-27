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

import java.util.Date;
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
 * 	8.4.26	Communication-Pattern-Set
	The Communication-Pattern-Set AVP is of type Grouped, and it shall contain a set of Communication-Pattern.
	AVP format

	Communication-Pattern-Set ::= <AVP header: 3114 10415>
			 [ Periodic-Communication-Indicator ]
			 [ Communication-Duration-Time ]
			 [ Periodic-Time ]
			*[ Scheduled-Communication-Time ]
			 [ Stationary-Indication ]
			 [ Reference-ID-Validity-Time ]
			 [ Traffic-Profile ]
			 [ Battery-Indicator ]
			*[ AVP ]

	Communication-duration-time and Periodic-Time shall be only provided when the Periodic-Communication-Indicator is set to PERIODICALLY.
	If the Reference-ID-Validity-Time AVP is absent, it indicates that there is no expiration time defined for the Communication-Pattern-Set.
 */
@DiameterAvpDefinition(code = 3114L, vendorId = KnownVendorIDs.TGPP_ID, name = "Communication-Pattern-Set")
public interface CommunicationPatternSet extends DiameterGroupedAvp
{
	PeriodicCommunicationIndicatorEnum getPeriodicCommunicationIndicator();
	
	void setPeriodicCommunicationIndicator(PeriodicCommunicationIndicatorEnum value);
	
	Long getCommunicationDurationTime();
	
	void setCommunicationDurationTime(Long value);
	
	Long getPeriodicTime();
	
	void setPeriodicTime(Long value);	
	
	List<ScheduledCommunicationTime> getScheduledCommunicationTime();
	
	void setScheduledCommunicationTime(List<ScheduledCommunicationTime> value);
	
	StationaryIndicationEnum getStationaryIndication();
	
	void setStationaryIndication(StationaryIndicationEnum value);
	
	Date getReferenceIDValidityTime();
	
	void setReferenceIDValidityTime(Date value);
	
	TrafficProfileEnum getTrafficProfile();
	
	void setTrafficProfile(TrafficProfileEnum value);
	
	Long getBatteryIndicator();
	
	void setBatteryIndicator(Long value);
}