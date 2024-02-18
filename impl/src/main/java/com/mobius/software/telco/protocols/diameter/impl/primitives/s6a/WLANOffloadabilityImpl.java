package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.s6a.WLANOffloadability;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.WLANOffloadabilityEUTRAN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.WLANOffloadabilityUTRAN;

/**
*
* @author yulian oifa
*
*/
public class WLANOffloadabilityImpl extends DiameterGroupedAvpImpl implements WLANOffloadability
{
	private WLANOffloadabilityEUTRAN wlanOffloadabilityEUTRAN;
	
	private WLANOffloadabilityUTRAN wlanOffloadabilityUTRAN;
	
	public WLANOffloadabilityImpl()
	{
		
	}
	
	public Long getWLANOffloadabilityEUTRAN()
	{
		if(wlanOffloadabilityEUTRAN==null)
			return null;
		
		return wlanOffloadabilityEUTRAN.getUnsigned();
	}
	
	public void setWLANOffloadabilityEUTRAN(Long value)
	{
		if(value == null)
			this.wlanOffloadabilityEUTRAN = null;
		else
			this.wlanOffloadabilityEUTRAN = new WLANOffloadabilityEUTRANImpl(value, null, null);
	}
	
	public Long getWLANOffloadabilityUTRAN()
	{
		if(wlanOffloadabilityUTRAN==null)
			return null;
		
		return wlanOffloadabilityUTRAN.getUnsigned();
	}
	
	public void setWLANOffloadabilityUTRAN(Long value)
	{
		if(value == null)
			this.wlanOffloadabilityUTRAN = null;
		else
			this.wlanOffloadabilityUTRAN = new WLANOffloadabilityUTRANImpl(value, null, null);
	}
}