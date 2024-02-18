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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.primitives.e4.InitialGateSettingDescription;
import com.mobius.software.telco.protocols.diameter.primitives.e4.MaximumAllowedBandwidthDL;
import com.mobius.software.telco.protocols.diameter.primitives.e4.MaximumAllowedBandwidthUL;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;

/**
*
* @author yulian oifa
*
*/
public class InitialGateSettingDescriptionImpl implements InitialGateSettingDescription
{
	private List<NASFilterRule> nasFilterRule;
	
	private MaximumAllowedBandwidthUL maximumAllowedBandwidthUL;
	
	private MaximumAllowedBandwidthDL maximumAllowedBandwidthDL;
	
	public InitialGateSettingDescriptionImpl()
	{
		
	}
	
	public List<NASFilterRule> getNASFilterRule()
	{
		return nasFilterRule;
	}
	
	public void setNASFilterRule(List<NASFilterRule> value)
	{
		this.nasFilterRule = value;
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
}