package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AcceptableServiceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ExtendedMaxRequestedBWUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MaxRequestedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentDescription;

/**
*
* @author yulian oifa
*
*/
public class AcceptableServiceInfoImpl extends DiameterGroupedAvpImpl implements AcceptableServiceInfo
{
	private List<MediaComponentDescription> mediaComponentDescription;
	
	private MaxRequestedBandwidthDL maxRequestedBandwidthDL;
	
	private MaxRequestedBandwidthUL maxRequestedBandwidthUL;
	
	private ExtendedMaxRequestedBWDL extendedMaxRequestedBWDL;
	
	private ExtendedMaxRequestedBWUL extendedMaxRequestedBWUL;
	
	public AcceptableServiceInfoImpl()
	{
		
	}
	
	public List<MediaComponentDescription> getMediaComponentDescription()
	{
		return this.mediaComponentDescription;
	}
	
	public void setMediaComponentDescription(List<MediaComponentDescription> value)
	{
		this.mediaComponentDescription = value;
	}
	
	public Long getMaxRequestedBandwidthDL()
	{
		if(maxRequestedBandwidthDL == null)
			return null;
		
		return maxRequestedBandwidthDL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthDL(Long value)
	{
		if(value == null)
			this.maxRequestedBandwidthDL = null;
		else
			this.maxRequestedBandwidthDL = new MaxRequestedBandwidthDLImpl(value, null, null);
	}
	
	public Long getMaxRequestedBandwidthUL()
	{
		if(maxRequestedBandwidthUL == null)
			return null;
		
		return maxRequestedBandwidthUL.getUnsigned();
	}
	
	public void setMaxRequestedBandwidthUL(Long value)
	{
		if(value == null)
			this.maxRequestedBandwidthUL = null;
		else
			this.maxRequestedBandwidthUL = new MaxRequestedBandwidthULImpl(value, null, null);
	}	
	
	public Long getExtendedMaxRequestedBandwidthDL()
	{
		if(extendedMaxRequestedBWDL == null)
			return null;
		
		return extendedMaxRequestedBWDL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBandwidthDL(Long value)
	{
		if(value == null)
			this.extendedMaxRequestedBWDL = null;
		else
			this.extendedMaxRequestedBWDL = new ExtendedMaxRequestedBWDLImpl(value, null, null);
	}
	
	public Long getExtendedMaxRequestedBandwidthUL()
	{
		if(extendedMaxRequestedBWUL == null)
			return null;
		
		return extendedMaxRequestedBWUL.getUnsigned();
	}
	
	public void setExtendedMaxRequestedBandwidthUL(Long value)
	{
		if(value == null)
			this.extendedMaxRequestedBWUL = null;
		else
			this.extendedMaxRequestedBWUL = new ExtendedMaxRequestedBWULImpl(value, null, null);
	}	
}