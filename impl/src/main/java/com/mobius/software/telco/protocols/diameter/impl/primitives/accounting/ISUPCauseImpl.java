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

import com.mobius.software.telco.protocols.diameter.primitives.accounting.ISUPCause;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ISUPCauseDiagnostics;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ISUPCauseLocation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ISUPCauseValue;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ISUPCauseImpl implements ISUPCause
{
	private ISUPCauseLocation isupCauseLocation;
	private ISUPCauseValue isupCauseValue;
	private ISUPCauseDiagnostics isupCauseDiagnostics;
			
	public ISUPCauseImpl()
	{
		
	}
	
	public Long getISUPCauseLocation()
	{
		if(isupCauseLocation==null)
			return null;
		
		return isupCauseLocation.getUnsigned();
	}
	
	public void setISUPCauseLocation(Long value)
	{
		if(value==null)
			this.isupCauseLocation = null;
		else
			this.isupCauseLocation = new ISUPCauseLocationImpl(value, null, null);			
	}
	
	public Long getISUPCauseValue()
	{
		if(isupCauseValue==null)
			return null;
		
		return isupCauseValue.getUnsigned();
	}
	
	public void setISUPCauseValue(Long value)
	{
		if(value==null)
			this.isupCauseValue = null;
		else
			this.isupCauseValue = new ISUPCauseValueImpl(value, null, null);			
	}
	
	public ByteBuf getISUPCauseDiagnostics()
	{
		if(isupCauseDiagnostics==null)
			return null;
		
		return isupCauseDiagnostics.getValue();
	}
	
	public void setISUPCauseDiagnostics(ByteBuf value)
	{
		if(value==null)
			this.isupCauseDiagnostics = null;
		else
			this.isupCauseDiagnostics = new ISUPCauseDiagnosticsImpl(value, null, null);			
	}
}