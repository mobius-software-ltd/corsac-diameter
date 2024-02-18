package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.NIDDAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.RequestedValidityTime;

/**
*
* @author yulian oifa
*
*/
public class NIDDAuthorizationRequestImpl extends DiameterGroupedAvpImpl implements NIDDAuthorizationRequest
{
	private ServiceSelection serviceSelection;
	
	private RequestedValidityTime requestedValidityTime;
	
	public NIDDAuthorizationRequestImpl()
	{
		
	}
	
	public String getServiceSelection()
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value)
	{
		if(value==null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	public Date getRequestedValidityTime()
	{
		if(requestedValidityTime == null)
			return null;
		
		return requestedValidityTime.getDateTime();
	}
	
	public void setRequestedValidityTime(Date value)
	{
		if(value==null)
			this.requestedValidityTime = null;
		else
			this.requestedValidityTime = new RequestedValidityTimeImpl(value, null, null);
	}
}