package com.mobius.software.telco.protocols.diameter.impl.primitives.swx;
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
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.swx.AccessAuthorizationFlags;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TWANAccessInfo;

/**
*
* @author yulian oifa
*
*/
public class TWANAccessInfoImpl extends DiameterGroupedAvpImpl implements TWANAccessInfo
{
	private AccessAuthorizationFlags accessAuthorizationFlags;
	
	private WLANIdentifier wlanIdentifier;
	
	public TWANAccessInfoImpl()
	{
		
	}
	
	public AccessAuthorizationFlags getAccessAuthorizationFlags()
	{
		return accessAuthorizationFlags;
	}
	
	public void setAccessAuthorizationFlags(AccessAuthorizationFlags value)
	{
		this.accessAuthorizationFlags = value;
	}
	
	public WLANIdentifier getWLANIdentifier()
	{
		return this.wlanIdentifier;
	}
	
	public void setWLANIdentifier(WLANIdentifier value)
	{
		this.wlanIdentifier = value;
	}
}