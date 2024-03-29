package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerIdList;

/**
*
* @author yulian oifa
*
*/
public class WLANLinkLayerIdListImpl extends DiameterGroupedAvpImpl implements WLANLinkLayerIdList
{
	private List<WLANLinkLayerId> wlanLinkLayerId;
	
	public WLANLinkLayerIdListImpl()
	{
		
	}
	
	public List<WLANLinkLayerId> getWLANLinkLayerId()
	{
		return this.wlanLinkLayerId;
	}
	
	public void setWLANLinkLayerId(List<WLANLinkLayerId> value)
	{
		this.wlanLinkLayerId = value;
	}
}