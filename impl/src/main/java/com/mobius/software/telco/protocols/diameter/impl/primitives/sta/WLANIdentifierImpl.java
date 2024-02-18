package com.mobius.software.telco.protocols.diameter.impl.primitives.sta;
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
import com.mobius.software.telco.protocols.diameter.primitives.sta.HESSID;
import com.mobius.software.telco.protocols.diameter.primitives.sta.SSID;
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLANIdentifier;

/**
*
* @author yulian oifa
*
*/
public class WLANIdentifierImpl extends DiameterGroupedAvpImpl implements WLANIdentifier
{
	private SSID ssid;
	
	private HESSID hessid;
	
	public WLANIdentifierImpl()
	{
		
	}
	
	public String getSSID()
	{
		if(ssid==null)
			return null;
		
		return ssid.getString();
	}
	 
	public void setSSID(String value)
	{
		if(value == null)
			this.ssid = null;
		else
			this.ssid = new SSIDImpl(value, null, null);
	}
	
	public String getHESSID()
	{
		if(hessid==null)
			return null;
		
		return hessid.getString();
	}
	
	public void setHESSID(String value)
	{
		if(value == null)
			this.hessid = null;
		else
			this.hessid = new HESSIDImpl(value, null, null);
	}
}