package com.mobius.software.telco.protocols.diameter.primitives.e4;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.TrafficProfileEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.5 QoS-Profile-Description AVP
	The QoS-Profile-Description AVP (AVP code 304 13019) represent of QoS-Profile element and is of type Grouped.
	AVP Format:
 
 	QoS-Profile-Description ::= < AVP Header: 304 13019 >
		 *[Application-Class-ID]
		 *[Media-Type]
		  [Reservation-Priority]
		  [Maximum-Allowed-Bandwidth-UL]
		  [Maximum-Allowed-Bandwidth-DL]
		  [Transport-Class]

	Absence of the Application-Class-ID AVP indicates that the QoS Profile instance applies to any requestor.

	Absence of the Media-Type AVP indicates that the QoS Profile element applies to any media type.  
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.QOS_PROFILE_DESCRIPTION, vendorId = VendorIDs.ETSI_ID,must = false, name = "QoS-Profile-Description")
public interface QoSProfileDescription extends DiameterAvp
{
	List<String> getApplicationClassID();
	
	void setApplicationClassID(List<String> value);	
	
	List<MediaTypeEnum> getMediaType();
	
	void setMediaType(List<MediaTypeEnum> value);	
	
	ReservationPriorityEnum getReservationPriority();
	
	void setReservationPriority(ReservationPriorityEnum value);
	
	Long getMaximumAllowedBandwidthUL();
	
	void setMaximumAllowedBandwidthUL(Long value);
	
	Long getMaximumAllowedBandwidthDL();
	
	void setMaximumAllowedBandwidthDL(Long value);
	
	TrafficProfileEnum getTrafficProfile();
	
	void setTrafficProfile(TrafficProfileEnum value);
}