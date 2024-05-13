package com.mobius.software.telco.protocols.diameter.impl.primitives.slg;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.slg.HorizontalAccuracy;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoS;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoSClass;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoSClassEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ResponseTime;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ResponseTimeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VerticalAccuracy;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VerticalRequested;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VerticalRequestedEnum;

/**
*
* @author yulian oifa
*
*/
public class LCSQoSImpl extends DiameterAvpImpl implements LCSQoS
{
	private LCSQoSClass lcsQoSClass;
	
	private HorizontalAccuracy horizontalAccuracy;
	
	private VerticalAccuracy verticalAccuracy;
	
	private VerticalRequested verticalRequested;
	
	private ResponseTime responseTime;
	
	public LCSQoSImpl()
	{
		
	}
	
	public LCSQoSClassEnum getLCSQoSClass()
	{
		if(lcsQoSClass==null)
			return null;
		
		return lcsQoSClass.getEnumerated(LCSQoSClassEnum.class);
	}
	
	public void setLCSQoSClass(LCSQoSClassEnum value)
	{
		if(value==null)
			this.lcsQoSClass = null;
		else
			this.lcsQoSClass = new LCSQoSClassImpl(value, null, null);			
	}
	
	public Long getHorizontalAccuracy()
	{
		if(horizontalAccuracy==null)
			return null;
		
		return horizontalAccuracy.getUnsigned();
	}
	
	public void setHorizontalAccuracy(Long value)
	{
		if(value==null)
			this.horizontalAccuracy = null;
		else
			this.horizontalAccuracy = new HorizontalAccuracyImpl(value, null, null);			
	}
	
	public Long getVerticalAccuracy()
	{
		if(verticalAccuracy==null)
			return null;
		
		return verticalAccuracy.getUnsigned();
	}
	
	public void setVerticalAccuracy(Long value)
	{
		if(value==null)
			this.verticalAccuracy = null;
		else
			this.verticalAccuracy = new VerticalAccuracyImpl(value, null, null);			
	}
	
	public VerticalRequestedEnum getVerticalRequested()
	{
		if(verticalRequested==null)
			return null;
		
		return verticalRequested.getEnumerated(VerticalRequestedEnum.class);
	}
	
	public void setVerticalRequested(VerticalRequestedEnum value)
	{
		if(value==null)
			this.verticalRequested = null;
		else
			this.verticalRequested = new VerticalRequestedImpl(value, null, null);			
	}
	
	public ResponseTimeEnum getResponseTime()
	{
		if(responseTime==null)
			return null;
		
		return responseTime.getEnumerated(ResponseTimeEnum.class);
	}
	
	public void setResponseTime(ResponseTimeEnum value)
	{
		if(value==null)
			this.responseTime = null;
		else
			this.responseTime = new ResponseTimeImpl(value, null, null);			
	}
}