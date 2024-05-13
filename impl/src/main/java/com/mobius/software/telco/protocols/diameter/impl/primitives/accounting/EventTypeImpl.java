package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Event;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EventType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Expires;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SIPMethod;

/**
*
* @author yulian oifa
*
*/
public class EventTypeImpl extends DiameterAvpImpl implements EventType
{
	private SIPMethod sipMethod;
	private Event event;
	private Expires expires;
		
	public EventTypeImpl()
	{
		
	}
	
	public String getSIPMethod()
	{
		if(sipMethod==null)
			return null;
		
		return sipMethod.getString();
	}
	
	public void setSIPMethod(String value)
	{
		if(value==null)
			this.sipMethod = null;
		else
			this.sipMethod = new SIPMethodImpl(value, null, null);			
	}
	
	public String getEvent()
	{
		if(event==null)
			return null;
		
		return event.getString();
	}
	
	public void setEvent(String value)
	{
		if(value==null)
			this.event = null;
		else
			this.event = new EventImpl(value, null, null);			
	}
	
	public Long getExpires()
	{
		if(expires==null)
			return null;
		
		return expires.getUnsigned();
	}
	
	public void setExpires(Long value)
	{
		if(value==null)
			this.expires = null;
		else
			this.expires = new ExpiresImpl(value, null, null);			
	}
}