package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.BSSIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LogicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PhysicalAccessIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.SSIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.BSSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PhysicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.SSID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class FixedUserLocationInfoImpl extends DiameterGroupedAvpImpl implements FixedUserLocationInfo
{
	private SSID ssid;
	private BSSID bssid;
	private LogicalAccessID logicalAccessID;
	private PhysicalAccessID physicalAccessID;
		
	public FixedUserLocationInfoImpl()
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
		if(value==null)
			this.ssid = null;
		else
			this.ssid = new SSIDImpl(value, null, null);			
	}
	
	public String getBSSID()
	{
		if(bssid==null)
			return null;
		
		return bssid.getString();
	}
	
	public void setBSSID(String value)
	{
		if(value==null)
			this.bssid = null;
		else
			this.bssid = new BSSIDImpl(value, null, null);			
	}
	
	public ByteBuf getLogicalAccessID()
	{
		if(logicalAccessID==null)
			return null;
		
		return logicalAccessID.getValue();
	}
	
	public void setLogicalAccessID(ByteBuf value)
	{
		if(value==null)
			this.logicalAccessID = null;
		else
			this.logicalAccessID = new LogicalAccessIDImpl(value, null, null);			
	}
	
	public String getPhysicalAccessID()
	{
		if(physicalAccessID==null)
			return null;
		
		return physicalAccessID.getString();
	}
	
	public void setPhysicalAccessID(String value)
	{
		if(value==null)
			this.physicalAccessID = null;
		else
			this.physicalAccessID = new PhysicalAccessIDImpl(value, null, null);			
	}
}