package com.mobius.software.telco.protocols.diameter.impl.primitives.e4;
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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.gq.ReservationPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MediaTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.TrafficProfileImpl;
import com.mobius.software.telco.protocols.diameter.primitives.e4.ApplicationClassID;
import com.mobius.software.telco.protocols.diameter.primitives.e4.MaximumAllowedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.e4.MaximumAllowedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.e4.QoSProfileDescription;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gq.ReservationPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaType;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.TrafficProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.TrafficProfileEnum;

/**
*
* @author yulian oifa
*
*/
public class QoSProfileDescriptionImpl implements QoSProfileDescription
{
	private List<ApplicationClassID> applicationClassID;
	
	private List<MediaType> mediaType;
	
	private ReservationPriority reservationPriority;
	
	private MaximumAllowedBandwidthUL maximumAllowedBandwidthUL;
	
	private MaximumAllowedBandwidthDL maximumAllowedBandwidthDL;
	
	private TrafficProfile trafficProfile;
	
	public QoSProfileDescriptionImpl()
	{
		
	}
	
	public List<String> getApplicationClassID()
	{
		if(applicationClassID==null)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ApplicationClassID curr:applicationClassID)
			result.add(curr.getString());
		
		return result;
	}
	
	public void setApplicationClassID(List<String> value)
	{
		if(value == null)
			this.applicationClassID = null;
		else
		{
			this.applicationClassID = new ArrayList<ApplicationClassID>();
			for(String curr : value)
				this.applicationClassID.add(new ApplicationClassIDImpl(curr, null, null));
		}
	}
	
	public List<MediaTypeEnum> getMediaType()
	{
		if(mediaType==null)
			return null;
		
		List<MediaTypeEnum> result = new ArrayList<MediaTypeEnum>();
		for(MediaType curr:mediaType)
			result.add(curr.getEnumerated(MediaTypeEnum.class));
		
		return result;
	}
	
	public void setMediaType(List<MediaTypeEnum> value)
	{
		if(value == null)
			this.mediaType = null;
		else
		{
			this.mediaType = new ArrayList<MediaType>();
			for(MediaTypeEnum curr : value)
				this.mediaType.add(new MediaTypeImpl(curr, null, null));
		}
	}
	
	public ReservationPriorityEnum getReservationPriority()
	{
		if(reservationPriority==null)
			return null;
		
		return reservationPriority.getEnumerated(ReservationPriorityEnum.class);
	}
	
	public void setReservationPriority(ReservationPriorityEnum value)
	{
		if(value == null)
			this.reservationPriority = null;
		else
			this.reservationPriority = new ReservationPriorityImpl(value, null, null);
	}
	
	public Long getMaximumAllowedBandwidthUL()
	{
		if(maximumAllowedBandwidthUL==null)
			return null;
		
		return maximumAllowedBandwidthUL.getUnsigned();
	}
	
	public void setMaximumAllowedBandwidthUL(Long value)
	{
		if(value == null)
			this.maximumAllowedBandwidthUL = null;
		else
			this.maximumAllowedBandwidthUL = new MaximumAllowedBandwidthULImpl(value, null, null);
	}
	
	public Long getMaximumAllowedBandwidthDL()
	{
		if(maximumAllowedBandwidthDL==null)
			return null;
		
		return maximumAllowedBandwidthDL.getUnsigned();
	}
	
	public void setMaximumAllowedBandwidthDL(Long value)
	{
		if(value == null)
			this.maximumAllowedBandwidthDL = null;
		else
			this.maximumAllowedBandwidthDL = new MaximumAllowedBandwidthDLImpl(value, null, null);
	}
	
	public TrafficProfileEnum getTrafficProfile()
	{
		if(trafficProfile==null)
			return null;
		
		return trafficProfile.getEnumerated(TrafficProfileEnum.class);
	}
	
	public void setTrafficProfile(TrafficProfileEnum value)
	{
		if(value == null)
			this.trafficProfile = null;
		else
			this.trafficProfile = new TrafficProfileImpl(value, null, null);
	}
}