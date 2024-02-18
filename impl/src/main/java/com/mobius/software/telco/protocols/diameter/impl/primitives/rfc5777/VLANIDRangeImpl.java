package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.CVIDEnd;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.CVIDStart;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.SVIDEnd;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.SVIDStart;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.VLANIDRange;

/**
*
* @author yulian oifa
*
*/

public class VLANIDRangeImpl extends DiameterGroupedAvpImpl implements VLANIDRange
{
	private SVIDStart svidStart;
	
	private SVIDEnd svidEnd;
	
	private CVIDStart cvidStart;
	
	private CVIDEnd cvidEnd;
	
	public VLANIDRangeImpl()
	{
		
	}
	
	public Long getSVIDStart()
	{
		if(this.svidStart==null)
			return null;
		
		return this.svidStart.getUnsigned();
	}
	
	public void setSVIDStart(Long value)
	{
		if(value==null)
			this.svidStart = null;
		else
			this.svidStart = new SVIDStartImpl(value, null, null);
	}
	
	public Long getSVIDEnd()
	{
		if(this.svidEnd==null)
			return null;
		
		return this.svidEnd.getUnsigned();
	}
	
	public void setSVIDEnd(Long value)
	{
		if(value==null)
			this.svidEnd = null;
		else
			this.svidEnd = new SVIDEndImpl(value, null, null);
	}
	
	public Long getCVIDStart()
	{
		if(this.cvidStart==null)
			return null;
		
		return this.cvidStart.getUnsigned();
	}
	
	public void setCVIDStart(Long value)
	{
		if(value==null)
			this.cvidStart = null;
		else
			this.cvidStart = new CVIDStartImpl(value, null, null);
	}
	
	public Long getCVIDEnd()
	{
		if(this.cvidEnd==null)
			return null;
		
		return this.cvidEnd.getUnsigned();
	}
	
	public void setCVIDEnd(Long value)
	{
		if(value==null)
			this.cvidEnd = null;
		else
			this.cvidEnd = new CVIDEndImpl(value, null, null);
	}
}