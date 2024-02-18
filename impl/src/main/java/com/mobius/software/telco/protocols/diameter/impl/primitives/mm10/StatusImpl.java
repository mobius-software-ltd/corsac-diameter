package com.mobius.software.telco.protocols.diameter.impl.primitives.mm10;
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

import com.mobius.software.telco.protocols.diameter.primitives.mm10.Status;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.StatusCode;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.StatusText;

/**
*
* @author yulian oifa
*
*/
public class StatusImpl implements Status
{
	private StatusCode statusCode;
	private StatusText statusText;
			
	public StatusImpl()
	{
		
	}
	
	public String getStatusCode()
	{
		if(statusCode==null)
			return null;
		
		return statusCode.getString();
	}
	
	public void setStatusCode(String value)
	{
		if(value==null)
			this.statusCode = null;
		else
			this.statusCode = new StatusCodeImpl(value, null, null);			
	}
	
	public String getStatusText()
	{
		if(statusText==null)
			return null;
		
		return statusText.getString();
	}
	
	public void setStatusText(String value)
	{
		if(value==null)
			this.statusText = null;
		else
			this.statusText = new StatusTextImpl(value, null, null);			
	}
}