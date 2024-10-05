package com.mobius.software.telco.protocols.diameter.impl.primitives.cip;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cip.AccessInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginRealm;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;

public class AccessInformationImpl extends DiameterGroupedAvpImpl implements AccessInformation
{
	private AuthApplicationId authApplicationId;
	private OriginHost originHost;
	private CcRequestNumber ccRequestNumber;
	private CcRequestType ccRequestType;
	private EventTimestamp  eventTimestamp;
	private OriginRealm originRealm;
	
	public AccessInformationImpl()
	{
	
	}
	
	public Long getAuthApplicationId()
	{
		if(authApplicationId == null)
			return null;
		
		return authApplicationId.getUnsigned();
	}
	
	public void setAuthApplicationId(Long value) 
	{
		if(value==null)
		
		this.authApplicationId = new AuthApplicationIdImpl(value, null, null);		
	}
	
	public String getOriginHost()
	{
		if(originHost == null)
			return null;
		
		return originHost.getIdentity();
	}
	
	public void setOriginHost(String value) 
	{
		if(value==null)
		
		this.originHost = new OriginHostImpl(value, null, null);		
	}

	@Override
	public Long getCcRequestNumber() 
	{
		if(ccRequestNumber == null)
			return null;
		
		return ccRequestNumber.getUnsigned();
	}

	@Override
	public void setCcRequestNumber(Long value) 
	{
		if(value==null)
			
		this.ccRequestNumber = new CcRequestNumberImpl(value, null, null);
	}

	@Override
	public CcRequestTypeEnum getCcRequestType() 
	{
		if(ccRequestType == null)
			return null;
		
		return ccRequestType.getEnumerated(CcRequestTypeEnum.class);
	}

	@Override
	public void setCcRequestType(CcRequestTypeEnum value) 
	{
		if(value==null)
			
		this.ccRequestType = new CcRequestTypeImpl(value, null, null);
		
	}
	
	@Override
	public Date getEventTimestamp()
	{
		if(eventTimestamp==null)
			return null;
		
		return eventTimestamp.getDateTime();
	}
	
	@Override
	public void setEventTimestamp(Date value)
	{
		if(value==null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);			
	}
	
	@Override
	public String getOriginRealm()
	{
		if(originRealm == null)
			return null;
		
		return originRealm.getIdentity();
	}
	
	@Override
	public void setOriginRealm(String value)
	{
		if(value==null)
			
		this.originRealm = new OriginRealmImpl(value, null, null);
	}	
	
}